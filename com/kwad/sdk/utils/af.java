package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, context, z) == null) {
            try {
                Activity f2 = f(context);
                if (f2 == null) {
                    return;
                }
                if (z) {
                    if (Build.VERSION.SDK_INT < 19) {
                        f2.getWindow().getDecorView().setSystemUiVisibility(8);
                    } else {
                        f2.getWindow().getDecorView().setSystemUiVisibility(1792);
                    }
                } else if (Build.VERSION.SDK_INT < 19) {
                    f2.getWindow().getDecorView().setSystemUiVisibility(0);
                } else {
                    f2.getWindow().getDecorView().setSystemUiVisibility(3846);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            return context == null || Wrapper.unwrapContextIfNeed(context).getApplicationContext().getResources().getConfiguration().orientation == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || (f2 = f(context)) == null) {
            return;
        }
        f2.getWindow().clearFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void c(Context context) {
        Activity f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || (f2 = f(context)) == null) {
            return;
        }
        f2.setRequestedOrientation(0);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void d(Context context) {
        Activity f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, context) == null) || (f2 = f(context)) == null) {
            return;
        }
        f2.setRequestedOrientation(1);
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? Wrapper.unwrapContextIfNeed(KsAdSDKImpl.get().getContext()).getResources().getConfiguration().orientation != 2 : invokeL.booleanValue;
    }

    @Nullable
    public static Activity f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            HashSet hashSet = new HashSet();
            do {
                hashSet.add(context);
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Activity) {
                    return (Activity) context;
                } else {
                    context = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : ((ContextWrapper) context).getBaseContext();
                }
            } while (!hashSet.contains(context));
            return null;
        }
        return (Activity) invokeL.objValue;
    }
}
