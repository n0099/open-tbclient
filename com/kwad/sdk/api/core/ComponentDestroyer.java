package com.kwad.sdk.api.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class ComponentDestroyer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ComponentDestroyer";
    public transient /* synthetic */ FieldHolder $fh;

    public ComponentDestroyer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void destroyActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, activity) == null) || activity == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        destroyWebViewInTree(decorView);
        fixInputMethodManagerLeak(activity, decorView);
    }

    public static void destroyFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, fragment) == null) || fragment == null) {
            return;
        }
        View view = fragment.getView();
        destroyWebViewInTree(fragment.getView());
        fixInputMethodManagerLeak(fragment.getContext(), view);
    }

    public static synchronized void destroyWebViewInTree(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, view) == null) {
            synchronized (ComponentDestroyer.class) {
                if (view == null) {
                    return;
                }
                if (view instanceof WebView) {
                    ((WebView) view).destroy();
                } else if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        destroyWebViewInTree(viewGroup.getChildAt(i2));
                    }
                }
            }
        }
    }

    public static void fixInputMethodManagerLeak(Context context, View view) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, context, view) == null) || context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
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
