package com.mcal.uidesigner.proxy.material;

import android.content.res.ColorStateList;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProxyBottomNavigationView {
  private final BottomNavigationView bottomNavigationView;

  public ProxyBottomNavigationView(Object obj) {
    bottomNavigationView = (BottomNavigationView) obj;
  }

  public void setMenu(String menuPath) {
  }

  public void setItemIconTint(int color) {
    bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(color));
  }

  public void setItemTextColor(int color) {
    bottomNavigationView.setItemTextColor(ColorStateList.valueOf(color));
  }
}
