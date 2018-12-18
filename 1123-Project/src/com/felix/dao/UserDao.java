package com.felix.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.felix.domain.User;

public class UserDao extends HibernateDaoSupport{
	/**
	 * 1.hibernate 最原生的方式     session.get
	 * 2.HQL 语句进行    from com.shop.domain.User where id=?
	 * 3.criteria 纯面向对象方式进行操作
	 * 4.原生SQL语句 
	 */
	public User getUser(final Integer id)
	{
		
		//HQL语句
		User user = getHibernateTemplate().execute(new HibernateCallback<User>() {

			public User doInHibernate(Session session) throws HibernateException {

				//1.编写hql语句
				String hql = "from com.felix.domain.User where id=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, id);
				User user = (User) query.uniqueResult();
				
				return user;
			}
		});
		
		return user;
	}
	
	public User getUser2()
	{
		
		DetachedCriteria dcriteria = DetachedCriteria.forClass(User.class);
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dcriteria);
		
		//判断list是否为null  list中元素个数>0
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
}
