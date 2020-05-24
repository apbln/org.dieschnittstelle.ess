package org.dieschnittstelle.ess.jrs;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.ess.entities.GenericCRUDExecutor;
import org.dieschnittstelle.ess.entities.erp.AbstractProduct;
import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/*
UE JRS2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDServiceImpl implements IProductCRUDService {

	protected static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ProductCRUDServiceImpl.class);

	private GenericCRUDExecutor<AbstractProduct> productCRUD;

	public ProductCRUDServiceImpl(@Context ServletContext servletContext, @Context HttpServletRequest request) {
		logger.info("<constructor>: " + servletContext + "/" + request);
		// read out the dataAccessor
		this.productCRUD = (GenericCRUDExecutor<AbstractProduct>)servletContext.getAttribute("productCRUD");

		logger.debug("read out the productCRUD from the servlet context: " + this.productCRUD);
	}

	@Override
	public AbstractProduct createProduct(
			AbstractProduct prod) {
		return (AbstractProduct)this.productCRUD.createObject(prod);
	}

	@Override
	public List<AbstractProduct> readAllProducts() {
		return (List)this.productCRUD.readAllObjects();
	}

	@Override
	public AbstractProduct updateProduct(long id,
										 AbstractProduct update) {
		return (AbstractProduct)this.productCRUD.updateObject(update);
	}

	@Override
	public boolean deleteProduct(long id) {
		return this.productCRUD.deleteObject(id);
	}

	@Override
	public AbstractProduct readProduct(long id) {
		return (AbstractProduct)this.productCRUD.readObject(id);
	}
	
}
