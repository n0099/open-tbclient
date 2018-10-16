package com.compatible.menukey;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
/* loaded from: classes.dex */
public class MenuKeyUtils {
    public static boolean hasSmartBar() {
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public static void hideSmartBarMenu(Activity activity) {
        if (hasSmartBar()) {
            activity.setTheme(16974123);
            activity.getWindow().setUiOptions(1);
            setActionBarViewCollapsable(activity, true);
        }
    }

    private static void setActionBarViewCollapsable(Activity activity, boolean z) {
        try {
            ActionBar actionBar = activity.getActionBar();
            Class.forName("android.app.ActionBar").getMethod("setActionBarViewCollapsable", Boolean.TYPE).invoke(actionBar, Boolean.valueOf(z));
            actionBar.setDisplayOptions(0);
        } catch (Exception e) {
        }
    }

    public static void hideSoftMenuKey(Window window) {
        if (Build.VERSION.SDK_INT > 10) {
            window.clearFlags(AiAppsFileUtils.GB);
        }
    }
}
