package org.onesun.blog;

import java.io.InputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.onesun.blog.jaxb.*;

public class EmailListManager {
	private ItemsType items = null;
	private JAXBContext jaxbContext = null;
	private Unmarshaller unmarshaller = null;

	public EmailListManager(String packageName) {
		try {
			jaxbContext = JAXBContext.newInstance(packageName);
			unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
		}
	}

	@SuppressWarnings("unchecked")
	public List loadXML(InputStream istrm) {
		try {
			Object o = unmarshaller.unmarshal(istrm);
			if (items == null) {
				items = (ItemsType) (((JAXBElement) o).getValue());
				return (items.getItem());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}