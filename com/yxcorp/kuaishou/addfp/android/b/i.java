package com.yxcorp.kuaishou.addfp.android.b;

import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final String f14691a = "wifi";
    private /* synthetic */ f qeS;

    public i(f fVar) {
        this.qeS = fVar;
    }

    public final String a() {
        String a2;
        Parcel a3;
        String str;
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        a2 = this.qeS.a("wifi");
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        obtain.writeInterfaceToken(a2);
        a3 = this.qeS.a("wifi", "TRANSACTION_getConnectionInfo", obtain, obtain2);
        if (a3 != null) {
            try {
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    try {
                        Class<?> cls = Class.forName("android.net.wifi.WifiInfo");
                        Object obj = cls.getDeclaredField("CREATOR").get(cls);
                        Object invoke = obj.getClass().getMethod("createFromParcel", Parcel.class).invoke(obj, obtain2);
                        Field declaredField = cls.getDeclaredField("mMacAddress");
                        declaredField.setAccessible(true);
                        str = (String) declaredField.get(invoke);
                    } catch (Throwable th) {
                        b.a(th);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return str;
                }
            } catch (SecurityException e) {
                return "";
            }
        }
        str = "";
        obtain2.recycle();
        obtain.recycle();
        return str;
    }
}
