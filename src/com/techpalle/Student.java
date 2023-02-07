package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student 
{
	public static String url = "jdbc:mysql://localhost:3306/palle";
	public static String username = "root";
	public static String password = "admin12345";
	
	public static Connection con = null;
	public static Statement s = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	//For creating table
	public void creating() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
			s.executeUpdate("create table student(sno int primary key auto_increment, sname varchar(50) not null, sub varchar(50) not null, email varchar(80) unique)");
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(s!=null) 
				{
					s.close();
				}
				if(con!=null) 
				{
					con.close();
				}
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	// For inserting values into table
	public void inserting(String name, String subject, String mail) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("insert into student(sname,sub,email) values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, subject);
			ps.setString(3, mail);
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(ps!=null) 
				{
					ps.close();
				}
				if(con!=null) 
				{
					con.close();
				}
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	//For updating values 
	public void update(int no, String subject, String mail) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("update student set sub=?, email=? where sno=?");
			ps.setString(1, subject);
			ps.setString(2, mail);
			ps.setInt(3, no);
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(ps!=null) 
				{
					ps.close();
				}
				if(con!=null) 
				{
					con.close();
				}
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	//For deleting table row
	public void delete(int no) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("delete from student where sno=?");
			ps.setInt(1, no);
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(ps!=null) 
				{
					ps.close();
				}
				if(con!=null) 
				{
					con.close();
				}
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	//For reading all table values
	public void reading() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url, username, password);
		    
			s = con.createStatement();
			
			rs = s.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email"));
				System.out.println("*********************");
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{ 
				if(rs != null) 
				{
					rs.close();
				}
				if(s != null) 
				{
					s.close();
				}
				if(con!=null) 
				{
					con.close();
				}
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

}
