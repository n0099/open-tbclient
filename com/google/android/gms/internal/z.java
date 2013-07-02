package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.v;
/* loaded from: classes.dex */
public final class z {
    private static Context a;
    private static v b;

    /* loaded from: classes.dex */
    public class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static View a(Context context, int i, int i2) {
        try {
            return (View) bd.a(a(context).a(bd.a(context), i, i2));
        } catch (Exception e) {
            throw new a("Could not get button with size " + i + " and color " + i2);
        }
    }

    private static v a(Context context) {
        x.a(context);
        if (b == null) {
            if (a == null) {
                a = GooglePlayServicesUtil.b(context);
                if (a == null) {
                    throw new a("Could not get remote context.");
                }
            }
            try {
                b = v.a.a((IBinder) a.getClassLoader().loadClass("com.google.android.gms.common.ui.SignInButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new a("Could not load creator class.");
            } catch (IllegalAccessException e2) {
                throw new a("Could not access creator.");
            } catch (InstantiationException e3) {
                throw new a("Could not instantiate creator.");
            }
        }
        return b;
    }
}
