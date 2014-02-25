package com.compatible.smartbarutil;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class SmartBarUtils {

    /* loaded from: classes.dex */
    public interface OnActionTabSelectionChanged {
        void onTabSelectionChanged(int i, boolean z);
    }

    public static boolean hasSmartBar() {
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            if (Build.DEVICE.equals("mx2")) {
                return true;
            }
            return (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) ? false : false;
        }
    }

    public static void addActionBar(Activity activity, View view, final OnActionTabSelectionChanged onActionTabSelectionChanged) {
        ActionBar actionBar = activity.getActionBar();
        actionBar.addTab(actionBar.newTab().setCustomView(view).setTabListener(new ActionBar.TabListener() { // from class: com.compatible.smartbarutil.SmartBarUtils.1
            @Override // android.app.ActionBar.TabListener
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }

            @Override // android.app.ActionBar.TabListener
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                OnActionTabSelectionChanged.this.onTabSelectionChanged(tab.getPosition(), true);
            }

            @Override // android.app.ActionBar.TabListener
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }
        }));
    }

    public static void addActionBar(Activity activity, int i, final OnActionTabSelectionChanged onActionTabSelectionChanged) {
        ActionBar actionBar = activity.getActionBar();
        actionBar.addTab(actionBar.newTab().setIcon(i).setTabListener(new ActionBar.TabListener() { // from class: com.compatible.smartbarutil.SmartBarUtils.2
            @Override // android.app.ActionBar.TabListener
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }

            @Override // android.app.ActionBar.TabListener
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                OnActionTabSelectionChanged.this.onTabSelectionChanged(tab.getPosition(), true);
            }

            @Override // android.app.ActionBar.TabListener
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }
        }));
    }

    public static void initActionBar(Activity activity) {
        activity.setTheme(16974123);
        activity.getWindow().setUiOptions(1);
    }

    public static void setActionBarTabsShowAtBottom(Activity activity, boolean z) {
        try {
            ActionBar actionBar = activity.getActionBar();
            try {
                Class.forName("android.app.ActionBar").getMethod("setTabsShowAtBottom", Boolean.TYPE).invoke(actionBar, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (SecurityException e6) {
            e6.printStackTrace();
        }
    }

    public static void setActionBarViewCollapsable(Activity activity, boolean z) {
        try {
            ActionBar actionBar = activity.getActionBar();
            try {
                Class.forName("android.app.ActionBar").getMethod("setActionBarViewCollapsable", Boolean.TYPE).invoke(actionBar, Boolean.valueOf(z));
                actionBar.setDisplayOptions(0);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (SecurityException e6) {
            e6.printStackTrace();
        }
    }

    public static void setActionModeHeaderHidden(Activity activity, boolean z) {
        try {
            ActionBar actionBar = activity.getActionBar();
            try {
                Class.forName("android.app.ActionBar").getMethod("setActionModeHeaderHidden", Boolean.TYPE).invoke(actionBar, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (SecurityException e6) {
            e6.printStackTrace();
        }
    }

    public static void setEmbeddedTabsWhenNarrow(Activity activity, boolean z) {
        try {
            ActionBar actionBar = activity.getActionBar();
            try {
                Class.forName("android.app.ActionBar").getMethod("setEmbeddedTabsWhenNarrow", Boolean.TYPE).invoke(actionBar, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (SecurityException e6) {
            e6.printStackTrace();
        }
    }

    public static void setBackIcon(Activity activity, Drawable drawable) {
        try {
            try {
                Class.forName("android.app.ActionBar").getMethod("setBackButtonDrawable", Drawable.class).invoke(activity.getActionBar(), drawable);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        }
    }

    public static void removeTabAt(Activity activity, int i) {
        activity.getActionBar().removeTabAt(i);
    }

    public static void removeAllTabs(Activity activity) {
        activity.getActionBar().removeAllTabs();
    }

    public static void fixMenuItem(MenuItem menuItem) {
        menuItem.setShowAsAction(2);
    }

    public static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }
}
