package com.kwad.sdk.api.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class ComponentDestroyer {
    public static final String TAG = "ComponentDestroyer";

    public static void destroyActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        destroyActivity(activity, activity.getWindow());
    }

    public static void destroyActivity(Context context, Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        destroyWebViewInTree(decorView);
        fixInputMethodManagerLeak(context, decorView);
    }

    public static void destroyFragment(Context context, View view2) {
        destroyWebViewInTree(view2);
        fixInputMethodManagerLeak(context, view2);
    }

    public static void destroyFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        View view2 = fragment.getView();
        destroyWebViewInTree(fragment.getView());
        fixInputMethodManagerLeak(fragment.getContext(), view2);
    }

    public static synchronized void destroyWebViewInTree(View view2) {
        synchronized (ComponentDestroyer.class) {
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

    public static void fixInputMethodManagerLeak(Context context, View view2) {
        InputMethodManager inputMethodManager;
        if (context == null || view2 == null || Build.VERSION.SDK_INT >= 29 || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
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
