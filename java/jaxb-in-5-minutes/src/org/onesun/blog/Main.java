package org.onesun.blog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.onesun.blog.jaxb.*;

public class Main {
	public static void main(String[] args) {
		EmailListManager xmgr = new EmailListManager("org.onesun.blog.jaxb");
		File file = new File("etc/data.xml");
		List rtList = new ArrayList();
		try {
			FileInputStream fis = new FileInputStream(file);
			
			if(fis == null) {
				return;
			}
			rtList = xmgr.loadXML(fis);
			Iterator rtItr = rtList.iterator();
			while (rtItr.hasNext()) {
				ItemType item = (ItemType) rtItr.next();
				System.out.println("First Name = " + item.getFirstname().trim()
						+ "\t\tLast Name = " + item.getLastname().trim()
						+ "\t\tEmail = " + item.getEmail().trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}