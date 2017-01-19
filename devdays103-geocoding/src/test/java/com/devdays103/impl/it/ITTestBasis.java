package com.devdays103.impl.it;

import com.devdays103.impl.TestUtil;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.karaf.options.LogLevelOption;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.MavenUrlReference;

import java.io.File;

import static com.devdays103.impl.TestUtil.copyITConf;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;

public class ITTestBasis {

	@Configuration
	public Option[] config() {

		MavenArtifactUrlReference karafUrl = maven()
				.groupId("org.apache.karaf")
				.artifactId("apache-karaf")
				.version(TestUtil.karafVersion())
				.type("zip");

		MavenUrlReference karafStandardRepo = maven()
				.groupId("org.apache.karaf.features")
				.artifactId("standard")
				.version(TestUtil.karafVersion())
				.classifier("features")
				.type("xml");

		MavenUrlReference projectFeaturesRepo = maven()
				.groupId("com.eurodyn.devdays103")
				.artifactId("devdays103-features")
				.version(TestUtil.projectVersion())
				.classifier("features")
				.type("xml");

		return new Option[]{
				karafDistributionConfiguration()
						.frameworkUrl(karafUrl)
						.unpackDirectory(new File("target", "exam"))
						.useDeployFolder(false),
				keepRuntimeFolder(),
				copyITConf("etc/com.eurodyn.qlack2.util.liquibase.cfg"),
				copyITConf("etc/org.ops4j.datasource-devdays103.cfg"),
				logLevel(LogLevelOption.LogLevel.INFO),
				configureConsole().ignoreLocalConsole(),
				configureConsole().ignoreRemoteShell(),
				features(projectFeaturesRepo, "devdays103-geocoding-deps"),
				features(projectFeaturesRepo, "pax-jdbc-mysql"),
				features(projectFeaturesRepo, "devdays103-geocoding")
		};
	}
}
