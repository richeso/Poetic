package com.ricston.transformers;
 
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
 
import java.util.Collection;
 
public class CollectionToStringTransformer extends AbstractTransformer{
 
   protected static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
   protected static final String PEOPLE1 = "<people>";
   protected static final String PEOPLE2 = "</people>";
 
   public String collectionToString(Collection<String> collection){
      StringBuilder builder = new StringBuilder(XML_HEADER + "\n" + PEOPLE1);
 
      for(String s : collection){
         builder.append(s.replace(XML_HEADER, "") + "\n");
      }
      builder.append(PEOPLE2);
      return builder.toString();
   }
 
   @Override
   protected Object doTransform(Object payload, String encoding) throws TransformerException {
      return collectionToString((Collection<String>)payload);
   }
}
