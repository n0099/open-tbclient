package com.kwad.components.core.l;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, view2) == null) {
            a(view2);
            b(context, view2);
        }
    }

    public static void a(Context context, Window window) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, window) == null) || window == null) {
            return;
        }
        View decorView = window.getDecorView();
        a(decorView);
        b(context, decorView);
    }

    public static synchronized void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, view2) == null) {
            synchronized (i.class) {
                if (view2 == null) {
                    return;
                }
                if (view2 instanceof WebView) {
                    try {
                        ((WebView) view2).destroy();
                    } catch (Throwable unused) {
                    }
                } else if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        a(viewGroup.getChildAt(i));
                    }
                }
            }
        }
    }

    public static void b(Context context, View view2) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, view2) == null) || context == null || view2 == null || Build.VERSION.SDK_INT >= 29 || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 3; i++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (!(obj instanceof View)) {
                    continue;
                } else if (!context.equals(((View) obj).getContext())) {
                    return;
                } else {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
