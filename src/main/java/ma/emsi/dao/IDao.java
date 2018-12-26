package ma.emsi.dao;

import java.util.List;

import org.apache.log4j.Logger;

public interface IDao<T> {
	
	public static Logger log = Logger.getLogger(IDao.class);

	boolean create(T o);

	boolean update(T o);

	boolean delete(T o);

	T findById(Long id);

	List<T> findAll();
}
