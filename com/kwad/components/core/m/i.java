package com.kwad.components.core.m;

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

    public static void destroyActivity(Context context, Window window) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, context, window) == null) || window == null) {
            return;
        }
        View decorView = window.getDecorView();
        destroyWebViewInTree(decorView);
        fixInputMethodManagerLeak(context, decorView);
    }

    public static void destroyFragment(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, view2) == null) {
            destroyWebViewInTree(view2);
            fixInputMethodManagerLeak(context, view2);
        }
    }

    public static synchronized void destroyWebViewInTree(View view2) {
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
                        destroyWebViewInTree(viewGroup.getChildAt(i));
                    }
                }
            }
        }
    }

    public static void fixInputMethodManagerLeak(Context context, View view2) {
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
