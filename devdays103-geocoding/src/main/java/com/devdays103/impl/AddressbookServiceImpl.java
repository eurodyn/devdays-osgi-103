package com.devdays103.impl;

import com.devdays103.api.AddressbookService;
import com.devdays103.model.Business;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Singleton
@Transactional
@OsgiServiceProvider(classes = {AddressbookService.class})
public class AddressbookServiceImpl implements AddressbookService {
	@PersistenceContext(unitName = "devdays103PU")
	private EntityManager em;

	@Override
	public String getAddress(String businessName) {
		Business business = (Business)em.createQuery(
				"select b from Business b where b.name = :name")
				.setParameter("name", businessName)
				.getSingleResult();

		return business != null ? business.getAddress() : "Not found!";
	}
}
