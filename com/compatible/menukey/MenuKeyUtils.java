package com.compatible.menukey;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class MenuKeyUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean hasSmartBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void hideSmartBarMenu(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, activity) == null) && hasSmartBar()) {
            activity.setTheme(16974123);
            activity.getWindow().setUiOptions(1);
            setActionBarViewCollapsable(activity, true);
        }
    }

    public static void hideSoftMenuKey(Window window) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, window) == null) || Build.VERSION.SDK_INT <= 10) {
            return;
        }
        window.clearFlags(1073741824);
    }

    public static void setActionBarViewCollapsable(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                Class.forName("android.app.ActionBar").getMethod("setActionBarViewCollapsable", Boolean.TYPE).invoke(actionBar, Boolean.valueOf(z));
                actionBar.setDisplayOptions(0);
            } catch (Exception unused) {
            }
        }
    }
}
