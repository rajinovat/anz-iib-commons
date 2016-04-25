package com.anz.common.ioc.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.anz.common.dataaccess.daos.IIFXCodeDao;
import com.anz.common.dataaccess.daos.ILookupDao;
import com.anz.common.dataaccess.daos.IOperationDao;
import com.anz.common.dataaccess.daos.iib.IFXCodeDao;
import com.anz.common.dataaccess.daos.iib.LookupDao;
import com.anz.common.dataaccess.daos.iib.OperationDao;

@Configuration
@EnableJpaRepositories(basePackages={"com.anz.common.dataaccess.daos.iib.repos"})
public class SpringConfig extends AbstractSpringConfig {

	@Bean(name="dataSource")
	public DataSource dataSource() {

		/*EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL).build();*/
		return IIBJdbc4DataSource.getDataSource();
	}
	
	@Bean
	public ILookupDao lookupDao() {
		return new LookupDao();
	}
	
	@Bean
	public IOperationDao operationDao() {
		return new OperationDao();
	}	

	@Bean
	public IIFXCodeDao iFXCodeDao() {
		return new IFXCodeDao();
	}
}
