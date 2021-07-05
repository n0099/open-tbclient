package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Window;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, context, z) == null) {
            try {
                Activity f2 = f(context);
                if (z) {
                    if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                        f2.getWindow().getDecorView().setSystemUiVisibility(8);
                    } else if (Build.VERSION.SDK_INT >= 19) {
                        f2.getWindow().getDecorView().setSystemUiVisibility(1792);
                    }
                } else if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    f2.getWindow().getDecorView().setSystemUiVisibility(0);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    f2.getWindow().getDecorView().setSystemUiVisibility(3846);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Activity f2 = f(context);
            if (f2 != null) {
                Window window = f2.getWindow();
                r0 = (window.getAttributes().flags & 1024) == 1024;
                window.setFlags(1024, 1024);
            }
            return r0;
        }
        return invokeL.booleanValue;
    }

    public static void b(Context context) {
        Activity f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || (f2 = f(context)) == null) {
            return;
        }
        f2.getWindow().clearFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void c(Context context) {
        Activity f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || (f2 = f(context)) == null) {
            return;
        }
        f2.setRequestedOrientation(0);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void d(Context context) {
        Activity f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, context) == null) || (f2 = f(context)) == null) {
            return;
        }
        f2.setRequestedOrientation(1);
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (!(context instanceof Activity)) {
                return context.getResources().getConfiguration().orientation != 2;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels > displayMetrics.widthPixels;
        }
        return invokeL.booleanValue;
    }

    public static Activity f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                return activity.getParent() != null ? activity.getParent() : activity;
            } else if (context instanceof ContextWrapper) {
                return f(((ContextWrapper) context).getBaseContext());
            } else {
                return null;
            }
        }
        return (Activity) invokeL.objValue;
    }
}
