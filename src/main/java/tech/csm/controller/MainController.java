package tech.csm.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Simple;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tech.csm.entity.Book;
import tech.csm.entity.Citizen;
import tech.csm.entity.Country;
import tech.csm.entity.Emp;

@Controller
public class MainController {

	@Autowired
	private DataSource dataSource;
	
	
	
	@GetMapping("/test")
	public String getForm() throws SQLException {
		
		
		/*simple jdbc call*/
		
		
		SimpleJdbcCall simpleJdbcCall=new SimpleJdbcCall(dataSource)
				.withProcedureName("book_crud_proc");
				
		
	//	Map<String,Object> output=simpleJdbcCall.execute("in_book", null, "php", 234.54, "author-2","pub_1", "2025-02-09"); //positional params, order must be perfect
		
		Map<String,Object> output=simpleJdbcCall.execute(new MapSqlParameterSource()  //Spring sends parameters to MySQL by name, not by position.order doesnt matter
					.addValue("p_status", "in_book")
					.addValue("p_book_id", null)
					.addValue("p_title", "Bible")
					.addValue("p_price", 544.75)
					.addValue("p_author_name", "ludwig krapf")
					.addValue("p_publication_name", "MS")
					.addValue("p_publication_date", "2025-01-21")
					);
		
		System.out.println(output.get("o_msg"));
		
		/*NOTE
		 * You never pass OUT parameters as input
		Spring discovers them automatically*/
		
		
		
		
		
//		SimpleJdbcCall simpleJdbcCall=new SimpleJdbcCall(dataSource)
//				.withProcedureName("book_crud_proc")
//				.returningResultSet("u_books", new RowMapper<Book>() {
//
//					@Override
//					public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Book b=new Book();
//						
//						b.setBookId(rs.getInt(1));
//						b.setTitle(rs.getString(2));
//						b.setPrice(rs.getDouble(3));
//						b.setAuthorName(rs.getString(4));
//						b.setPublicationName(rs.getString(5));
//						b.setPublicationDate(rs.getDate(6));
//						
//						return b;
//						
//					}
//
//				
//				});
//		
//		
//		
//		Map<String,Object> output=simpleJdbcCall.execute(new MapSqlParameterSource()
//					.addValue("p_status", "books")
//					.addValue("p_book_id", null)
//					.addValue("o_msg", Types.VARCHAR)
//					.addValue("p_title", null)
//					.addValue("p_price", null)
//					.addValue("p_author_name", null)
//					.addValue("p_publication_name", null)
//					.addValue("p_publication_date", null)
//					);
//		
//		System.out.println(output.get("u_books"));
		
		
		
		
		
//		SimpleJdbcCall simpleJdbcCall=new SimpleJdbcCall(dataSource)
//				.withProcedureName("book_crud_proc")
//				.returningResultSet("u_books", new RowMapper<Map<String,Object>>() {
//
//					@Override
//					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Map<String,Object> dl=new HashMap<>();						
//						dl.put("book_id", rs.getInt(1));
//						dl.put("title", rs.getString(2));
//						dl.put("price", rs.getDouble(3));
//						
//						return dl;
//					}
//				});
//		
//		
//		
//		Map<String,Object> output=simpleJdbcCall.execute(new MapSqlParameterSource()
//					.addValue("p_status", "books")
//					.addValue("p_book_id", null)
//					.addValue("o_msg", Types.VARCHAR)
//					.addValue("p_title", null)
//					.addValue("p_price", null)
//					.addValue("p_author_name", null)
//					.addValue("p_publication_name", null)
//					.addValue("p_publication_date", null)
//					);
//		
//		System.out.println(output);
		
		
		
		
		
		
		
		
		/*named parameter jdbc template*/
		
		
		
		
		
		
//		NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
//		
//		SqlParameterSource params=new MapSqlParameterSource().addValue("d_id",50).addValue("sal", 8000);
//		
//		List<Emp> eList=namedParameterJdbcTemplate.query("select employee_id, last_name, salary, department_id from employees where department_id=:d_id and salary>=:sal",params, BeanPropertyRowMapper.newInstance(Emp.class));
//		
//		eList.forEach(System.out::println);
		
		
		
		
//		List<String> empList=namedParameterJdbcTemplate.queryForList("select last_name from employees where department_id=:d_id", Map.of("d_id",50), String.class);
//		
//		System.out.println(empList);
		
		
		
		
//		final String qr="select employee_id, last_name, salary, department_id from employees where employee_id=:e_id";
//		Map<String,Object> paramMap=new HashMap<>();
//		paramMap.put("e_id", Integer.valueOf(110));
//		
//		
//		Emp emp=namedParameterJdbcTemplate.queryForObject(qr, paramMap, new RowMapper<Emp>() {
//
//			@Override
//			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Emp e=new Emp();	
//				
//				if(rs.next()) {
//					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" ***");
//					e.setEmployeeId(rs.getInt(1));
//					e.setLastName(rs.getString(2));
//					e.setSalary(rs.getDouble(3));
//					e.setDepartmentId(rs.getInt(4));
//				}
//				return e;
//			}	
//		
//		});
//		System.out.println(emp);
		
		
		
		
		
		
		
		
		
		
		
		/*jdbc template*/
		
		
//		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		
//		KeyHolder kh=new GeneratedKeyHolder();
//	
//		
//		
//		Integer rc=jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps=con.prepareStatement("insert into book(title, price, author_name, publication_name, publication_date) values (?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS );
//				ps.setString(1, "TestBook");
//				ps.setDouble(2, 543.12);
//				ps.setString(3, "XYZ1");
//				ps.setString(4, "OReally");
//				ps.setDate(5, new java.sql.Date(new Date().getTime()));
//				
//				return ps;
//			}
//		}, kh);
//		
//		System.out.println(kh.getKey());
		
		
//		List<SqlParameter> paramList=new ArrayList<>();
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlOutParameter("msg", Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.INTEGER));
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.DOUBLE));
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.DATE));
//		
//		Map<String,Object> res=jdbcTemplate.call(new CallableStatementCreator() {
//			
//			
//			
//			
//			@Override
//			public CallableStatement createCallableStatement(Connection con) throws SQLException {
//				CallableStatement cs=con.prepareCall("{call book_crud_proc(?,?,?,?,?,?,?,?)}");
//				cs.setString(1, "in_book");
//				cs.registerOutParameter(2, Types.VARCHAR);
//				cs.setInt(3, Types.NULL);
//				cs.setString(4, "PL/SQL");
//				cs.setDouble(5, 543.12);
//				cs.setString(6, "XYZ");
//				cs.setString(7, "OReally");
//				cs.setDate(8, new java.sql.Date(new Date().getTime()));
//				return cs;
//			}
//		},paramList);
//		
//		System.out.println(res.get("msg"));
		
		
		
		
		
//		List<SqlParameter> paramList=new ArrayList<>();
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlOutParameter("msg", Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.INTEGER));
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.DOUBLE));
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.VARCHAR));
//		paramList.add(new SqlParameter(Types.DATE));
//		
//		Map<String,Object> res=jdbcTemplate.call(new CallableStatementCreator() {
//			
//			
//			
//			
//			@Override
//			public CallableStatement createCallableStatement(Connection con) throws SQLException {
//				CallableStatement cs=con.prepareCall("{call book_crud_proc(?,?,?,?,?,?,?,?)}");
//				cs.setString(1, "books");
//				cs.registerOutParameter(2, Types.VARCHAR);
//				cs.setInt(3, Types.NULL);
//				cs.setString(4, null);
//				cs.setDouble(5, Types.NULL);
//				cs.setString(6, null);
//				cs.setString(7, null);
//				cs.setDate(8, null);
//				return cs;
//			}
//		},paramList);
//		
//		System.out.println(res.get("#result-set-1"));
		
		
//		List<Map<String, Object>> res = jdbcTemplate.execute(new CallableStatementCreator() {
//			
//			@Override
//			public CallableStatement createCallableStatement(Connection con) throws SQLException {
//				CallableStatement cs=con.prepareCall("{call book_crud_proc(?,?,?,?,?,?,?,?)}");
//				cs.setString(1, "books");
//				cs.registerOutParameter(2, Types.VARCHAR);
//				cs.setInt(3, Types.NULL);
//				cs.setString(4, null);
//				cs.setDouble(5, Types.NULL);
//				cs.setString(6, null);
//				cs.setString(7, null);
//				cs.setDate(8, null);
//				return cs;
//			}
//		}, new CallableStatementCallback<List<Map<String,Object>>>() {
//
//			@Override
//			public List<Map<String,Object>> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
//				ResultSet rs=cs.executeQuery();
//				List<Map<String,Object>> oj=new ArrayList<>();
//				while(rs.next()) {
//					Map<String,Object> m=new HashMap<>();
//					m.put("book_id", rs.getInt(1));
//					m.put("title", rs.getString(2));
//					m.put("price", rs.getDouble(3));
//					oj.add(m);
//				}
//				return oj;
//			}
//		});
//		
//		System.out.println(res);
		
		
		
		
//		List<Map<String,Object>> r=jdbcTemplate.query(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps=con.prepareStatement("select * from citizen_form where country_id =? and state_id=?");
//				ps.setInt(1, 1);
//				ps.setInt(2, 1);
//				
//				
//				return ps;
//			}
//		}, new ResultSetExtractor<List<Map<String,Object>>>() {
//
//			@Override
//			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				
//				List<Map<String,Object>> listOfMap=new ArrayList<>();
//				while(rs.next()) {
//					Map<String, Object> m=new HashMap<>();
//					m.put("c_id", rs.getInt(1));
//					m.put("c_name", rs.getString(2));
//					m.put("c_email", rs.getString(3));
//					listOfMap.add(m);
//				}
//				
//				return listOfMap;
//				
//			}
//		});
//		
//		for(Map<String,Object> o:r)
//			System.out.println(o);
		
		
//		List<Map<String,Object>> r1=jdbcTemplate.query(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps=con.prepareStatement("select * from citizen_form where country_id =? and state_id=?");
//				ps.setInt(1, 1);
//				ps.setInt(2, 1);
//				
//				
//				return ps;
//			}
//		}, new RowMapper<Map<String,Object>>() {
//
//			@Override
//			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Map<String, Object> m=new HashMap<>();
//				m.put("c_id", rs.getInt(1));
//				m.put("c_name", rs.getString(2));
//				m.put("c_email", rs.getString(3));
//				return m;
//			}
//		});
//		
//		for(Map<String,Object> o:r1)
//			System.out.println(o);
		
		
//	List<Citizen> r1=jdbcTemplate.query(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps=con.prepareStatement("select id,name,email from citizen_form where country_id =? and state_id=?");
//				ps.setInt(1, 1);
//				ps.setInt(2, 1);
//				
//				
//				return ps;
//			}
//		}, new BeanPropertyRowMapper<Citizen>(Citizen.class));
//
//		System.out.println(r1);
		
		
		
//		List<Integer> sl=jdbcTemplate.queryForList("select id from country", Integer.class);
//		System.out.println(sl);
		
//		Long rc=jdbcTemplate.queryForObject("select count(*) from country", Long.class);  
//		
//		System.out.println(rc+" ------------------");
//		
		
		
		//List<Map<String, Object>> rcs = jdbcTemplate.queryForList("select id, name from country");
//		List<Map<String, Object>> rcs=jdbcTemplate.queryForList("select * from citizen_form where country_id =? and state_id=?", new Object[] {Integer.valueOf(1), Integer.valueOf(1)}, new int[] {Types.INTEGER, Types.INTEGER});
//		
//		for(Map<String,Object> o:rcs) {
//			System.out.println(o);
//		}
		
		
		//List<Country> cList=jdbcTemplate.query("select id, name from country", new BeanPropertyRowMapper(Country.class));
		
		
//		Country country= jdbcTemplate.queryForObject("select id, name from country where id=1", new RowMapper<Country>() {
//
//			@Override
//			public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Country c=new Country();
//				c.setId(rs.getInt(1));
//				c.setName(rs.getString(2));
//				return c;
//			}
//			
//		});
		
		//jdbcTemplate.up
		
		//System.out.println(cList);
		
		return "demo";
	}
	
}
