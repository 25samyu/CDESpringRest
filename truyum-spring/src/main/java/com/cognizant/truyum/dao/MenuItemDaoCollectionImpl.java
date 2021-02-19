package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	private List<MenuItem> menuItemList;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
		System.out.println(menuItemList);
	}

	public MenuItemDaoCollectionImpl() {
		LOGGER.debug("Inside MenuItemDaoCollectionImpl constructor");
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		this.menuItemList = (ArrayList<MenuItem>) context.getBean("menuItems");

	}

	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("START");
		LOGGER.info("END");
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("START");
		List<MenuItem> list = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			if (((menuItem.getDateOfLaunch()).equals(new Date()))
					|| (menuItem.getDateOfLaunch()).before(new Date()) && menuItem.isActive()) {
				list.add(menuItem);
			}
		}
		LOGGER.info("END");
		return list;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("START");
		for (MenuItem menuItemInList : menuItemList) {
			if (menuItem.equals(menuItemInList)) {
				menuItemList.remove(menuItemInList);
				menuItemList.add(menuItem);
				break;
			}
		}
		LOGGER.info("END");

	}

	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("START");
		for (MenuItem menuItemInList : menuItemList) {
			if (menuItemId == menuItemInList.getId()) {
				LOGGER.info("END");
				return menuItemInList;}
		}
		LOGGER.info("END");
		return null;
	}

}
