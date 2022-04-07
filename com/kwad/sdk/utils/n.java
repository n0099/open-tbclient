package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class n {
    public static void a(Context context, View view2) {
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

    public static void a(Context context, Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        a(decorView);
        a(context, decorView);
    }

    public static synchronized void a(View view2) {
        synchronized (n.class) {
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
        View view2 = dVar.getView();
        a(dVar.getView());
        a(dVar.getContext(), view2);
    }
}
