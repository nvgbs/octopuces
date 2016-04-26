package metier.advert;

import java.util.List;


import base.dao.DaoFactory;
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
	
	
	
	public static List <Advert> getListAdvert (Integer stateValue) throws Exception
	{
		return DaoFactory.getDaoAdvert().readByState(stateValue.intValue());
		
	}
	
	
	
	public static void disableAdvertFromUser (Integer idValue) throws Exception
	{
		List <Advert> listAdvert = DaoFactory.getDaoAdvert().getAdvertFromUser(idValue);
		
		for (Advert advert : listAdvert) 
		{			
			advert.setState(Advert.UNVALIDATE_STATE);
			
			DaoFactory.getDaoAdvert().saveOrUpdate(advert);	
		}
	}
	
	
	
	
	
	
	
}//END
