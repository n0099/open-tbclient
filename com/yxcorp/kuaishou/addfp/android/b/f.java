package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class f {
    private static Context d;
    private final Class c;
    private String[] e;
    private String[] f;
    public h qbW;
    public i qbX;

    private f() {
        this.e = null;
        this.f = null;
        this.c = b();
        this.qbW = new h(this);
        this.qbX = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Parcel a(String str, String str2, Parcel parcel, Parcel parcel2) {
        Object obj;
        Object obj2;
        String a2 = a(str);
        int i = -1;
        if (a2 == null || str2 == null) {
            return null;
        }
        try {
            obj = this.c.getDeclaredMethod("getService", String.class).invoke(null, str);
        } catch (Throwable th) {
            th = th;
            obj = null;
        }
        try {
            Field declaredField = Class.forName(a2 + "$Stub").getDeclaredField(str2);
            declaredField.setAccessible(true);
            i = declaredField.getInt(null);
            obj2 = obj;
        } catch (Throwable th2) {
            th = th2;
            b.a(th);
            obj2 = obj;
            if (obj2 != null) {
            }
            return null;
        }
        if (obj2 != null || i < 0) {
            return null;
        }
        try {
            ((IBinder) obj2).transact(i, parcel, parcel2, 0);
            return parcel2;
        } catch (Throwable th3) {
            b.a(th3);
            return parcel2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            ((IBinder) this.c.getDeclaredMethod("getService", String.class).invoke(null, str)).transact(1598968902, obtain, obtain2, 0);
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                b.a(th);
                return null;
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
    }

    private static Class b() {
        try {
            return Class.forName("android.os.ServiceManager");
        } catch (ClassNotFoundException e) {
            b.a(e);
            return null;
        }
    }

    public static f je(Context context) {
        f fVar;
        d = context;
        fVar = g.qbY;
        return fVar;
    }
}
