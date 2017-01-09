package com.devdays103.bootstrap;

import com.eurodyn.qlack2.util.liquibase.api.LiquibaseBootMigrationsDoneService;
import org.ops4j.pax.cdi.api.OsgiService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Bootstrap {
	@Inject
	@OsgiService
	LiquibaseBootMigrationsDoneService liquibaseBootMigrationsDoneService;
}
