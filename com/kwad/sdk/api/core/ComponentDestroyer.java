package com.kwad.sdk.api.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class ComponentDestroyer {
    public static final String TAG = "ComponentDestroyer";

    public static void destroyActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        destroyWebViewInTree(decorView);
        fixInputMethodManagerLeak(activity, decorView);
    }

    public static void destroyFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        View view = fragment.getView();
        destroyWebViewInTree(fragment.getView());
        fixInputMethodManagerLeak(fragment.getContext(), view);
    }

    public static synchronized void destroyWebViewInTree(View view) {
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

    public static void fixInputMethodManagerLeak(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
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
