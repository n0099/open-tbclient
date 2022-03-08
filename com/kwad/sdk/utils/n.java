package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class n {
    public static void a(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || Build.VERSION.SDK_INT >= 29 || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
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

    public static void a(Context context, Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        a(decorView);
        a(context, decorView);
    }

    public static synchronized void a(View view) {
        synchronized (n.class) {
            if (view == null) {
                return;
            }
            if (view instanceof WebView) {
                try {
                    ((WebView) view).destroy();
                } catch (Throwable unused) {
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public static void a(com.kwad.sdk.h.a aVar) {
        if (aVar == null) {
            return;
        }
        a(aVar.getActivity(), aVar.getWindow());
    }

    public static void a(com.kwad.sdk.h.b bVar) {
        if (bVar == null) {
            return;
        }
        a(bVar.getActivity(), bVar.getWindow());
    }

    public static void a(com.kwad.sdk.h.d dVar) {
        if (dVar == null) {
            return;
        }
        View view = dVar.getView();
        a(dVar.getView());
        a(dVar.getContext(), view);
    }
}
