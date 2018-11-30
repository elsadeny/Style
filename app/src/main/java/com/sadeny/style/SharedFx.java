package com.sadeny.style;

import android.util.Log;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class SharedFx {
    //String text;

    //this function will validate some input criteria in the EditText
    public boolean validate(EditText editText)
    {
      String text = editText.getText().toString();
       if(text.equals(" "))
       {
           editText.setError("can't be blank");
           return false;
       }else if(text.length()<6)
       {
           editText.setError("Must reach 6 character minimum");
           return false;
       }
       else
       {
           return true;
       }
    }

    //this function will handle the comparison of the string from
    //EditText directly
   public boolean validate(EditText editText1,EditText editText2)
   {
      String string1=editText1.getText().toString();
      String string2=editText2.getText().toString();
      if(string1.equals(string2))
      {
          //Log.d("Debug Sharedfx ", text);
          //new UserModel(text,string2);
          return true;
      }else
      {
          editText1.setError("Password is not the same");
          return false;
      }
   }

   //this function will do the final checking using the first two
    //and pass data to the user object
  public boolean validate(EditText edit1,EditText edit2,EditText edit3)
  {
      if(validate(edit2,edit3))
      {
          new UserModel(edit1.getText().toString(),edit2.getText().toString());
          return true;
      }else
      {
          return false;
      }
  }

}
