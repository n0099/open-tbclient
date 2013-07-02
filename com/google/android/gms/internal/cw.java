package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.cl;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* loaded from: classes.dex */
public class cw {
    private static Context a;
    private static cl b;

    public static cl a(Context context) {
        x.a(context);
        b(context);
        if (b == null) {
            d(context);
        }
        if (b != null) {
            return b;
        }
        b = cl.a.a((IBinder) a(e(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        c(context);
        return b;
    }

    private static Object a(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        }
    }

    private static Object a(ClassLoader classLoader, String str) {
        try {
            return a(((ClassLoader) x.a(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    public static boolean a() {
        return b() != null;
    }

    private static Class b() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static void b(Context context) {
        int a2;
        if (!a() && (a2 = GooglePlayServicesUtil.a(context)) != 0) {
            throw new GooglePlayServicesNotAvailableException(a2);
        }
    }

    private static void c(Context context) {
        try {
            b.a(bd.a(e(context).getResources()), 3136100);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void d(Context context) {
        Class b2 = b();
        if (b2 != null) {
            Log.i(cw.class.getSimpleName(), "Making Creator statically");
            b = (cl) a(b2);
            c(context);
        }
    }

    private static Context e(Context context) {
        if (a == null) {
            if (b() != null) {
                a = context;
            } else {
                a = GooglePlayServicesUtil.b(context);
            }
        }
        return a;
    }
}
