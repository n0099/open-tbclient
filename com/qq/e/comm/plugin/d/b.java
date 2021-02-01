package com.qq.e.comm.plugin.d;

import android.content.Context;
import android.view.ContextThemeWrapper;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Class f11984a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f11985b;
    private final Context c;
    private Method d;

    static {
        f11984a = null;
        f11985b = null;
        try {
            f11984a = Class.forName("androidx.appcompat.app.AppCompatActivity");
        } catch (ClassNotFoundException e) {
            f11984a = null;
        }
        try {
            f11985b = Class.forName("androidx.appcompat.app.AppCompatActivity");
        } catch (ClassNotFoundException e2) {
            f11985b = null;
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
        if (f11984a == null || !f11984a.isInstance(context)) {
            if (f11985b == null || !f11985b.isInstance(context)) {
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
