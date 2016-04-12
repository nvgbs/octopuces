package metier.advert;

import java.util.List;

import base.dao.DaoAdvert;
import base.dao.DaoFactory;
import ihm.tableaubord.Test;
import model.advert.Advert;

public class AdvertRequest 
{
	
	public static void validateAdvert (Advert advert) throws Exception
	{
		advert.setState(Advert.VALIDATE_STATE);
		
		DaoFactory.getDaoAdvert().saveOrUpdate(advert);		
	}
	
	
	public static void unvalidateAdvert (Advert advert) throws Exception
	{
		advert.setState(Advert.UNVALIDATE_STATE);
		
		DaoFactory.getDaoAdvert().saveOrUpdate(advert);		
	}
	
	
	
	public static List <Advert> getListWaitAdvert () throws Exception
	{
		return DaoFactory.getDaoAdvert().readByState(Advert.WAIT_STATE);
		
	}
	
	public static List <Advert> getListUnvalidateAdvert () throws Exception
	{
		return DaoFactory.getDaoAdvert().readByState(Advert.UNVALIDATE_STATE);	

	}
	
	public static List <Advert> getListValidateAdvert () throws Exception
	{
		return DaoFactory.getDaoAdvert().readByState(Advert.VALIDATE_STATE);		
	}
	
	
	public static List<Advert> test() throws Exception
	{
		DaoAdvert daoAdvert = new DaoAdvert(); 
		
		return (List<Advert>) daoAdvert.readAll(Advert.class);
	}
	
	
	
	
}//END
