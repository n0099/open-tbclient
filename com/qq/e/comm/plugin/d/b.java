package com.qq.e.comm.plugin.d;

import android.content.Context;
import android.view.ContextThemeWrapper;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Class f11982a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f11983b;
    private final Context c;
    private Method d;

    static {
        f11982a = null;
        f11983b = null;
        try {
            f11982a = Class.forName("androidx.appcompat.app.AppCompatActivity");
        } catch (ClassNotFoundException e) {
            f11982a = null;
        }
        try {
            f11983b = Class.forName("androidx.appcompat.app.AppCompatActivity");
        } catch (ClassNotFoundException e2) {
            f11983b = null;
        }
    }

    private b(Context context) {
        this.c = context;
        try {
            this.d = this.c.getClass().getMethod("getSupportActionBar", new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static b a(Context context) {
        if (context == null) {
            return null;
        }
        if (f11982a == null || !f11982a.isInstance(context)) {
            if (f11983b == null || !f11983b.isInstance(context)) {
                if (context instanceof ContextThemeWrapper) {
                    return a(((ContextThemeWrapper) context).getBaseContext());
                }
                return null;
            }
            return new b(context);
        }
        return new b(context);
    }

    public a a() {
        try {
            return new a(this.d.invoke(this.c, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
