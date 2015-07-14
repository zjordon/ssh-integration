/**
 * 
 */
package com.jason.sshIntegration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jason.sshIntegration.entity.User;

/**
 * @author jasonzhang
 *
 */
@Repository("userDao")
public class UserDao {

	/**
	 * ע��һ��sessionFactory����
	 * **/
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * �����û�id��ѯ�û�
	 */
	public User getUser(String id) {

		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);

		return (User) query.uniqueResult();
	}

	/**
	 * ��ѯ�����û�
	 */
	public List<User> getAllUser() {

		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	/**
	 * ����û�
	 */
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/**
	 * �����û�idɾ���û�
	 */
	public boolean delUser(String id) {

		String hql = "delete User u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		query.executeUpdate();
		//return (query.executeUpdate() > 0);
		return true;
	}

	/**
	 * �༭�û�
	 */
	public boolean updateUser(User user) {

		String hql = "update User u set u.userName = ?,u.age=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getAge());
		query.setString(2, user.getId());

		return (query.executeUpdate() > 0);
	}
}
