package com.mcal.example;
import android.app.Application;
import com.google.android.material.color.DynamicColors;

public class App extends Application {
  
  @Override
  public void onCreate() {
    super.onCreate();
    // TODO: Implement this method
    if(DynamicColors.isDynamicColorAvailable()) {
    	DynamicColors.applyToActivitiesIfAvailable(this);
    }
  }
  
}
