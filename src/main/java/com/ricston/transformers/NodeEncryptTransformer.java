package com.ricston.transformers;
 
import org.mule.api.EncryptionStrategy;
import org.mule.api.security.CryptoFailureException;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
 
import java.util.List;
 
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;
 
public class NodeEncryptTransformer extends AbstractTransformer {
 
   private EncryptionStrategy encryptionStrategy;
 
   @Override
   protected Object doTransform(Object payload, String encoding) throws TransformerException {
 
      DefaultDocument document = (DefaultDocument)payload;
      List<DefaultElement> elementList = document.getRootElement().elements();
      try {
         for(DefaultElement element : elementList) {
 
            element.setText(new String(encryptionStrategy.encrypt(element.getText().getBytes(), "UTF-8")));
 
         }
      }
      catch(CryptoFailureException e) {
         throw new TransformerException(this, e);
      }
      return payload;
   }
 
   public EncryptionStrategy getEncryptionStrategy() {
      return encryptionStrategy;
   }
 
   public void setEncryptionStrategy(EncryptionStrategy encryptionStrategy) {
      this.encryptionStrategy = encryptionStrategy;
   }
 
}
