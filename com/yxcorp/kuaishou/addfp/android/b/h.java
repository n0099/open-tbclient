package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f14391a = "iphonesubinfo";
    private /* synthetic */ f qca;

    public h(f fVar) {
        this.qca = fVar;
    }

    private String a(String str, String str2) {
        String a2;
        Parcel a3;
        Context context;
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str3 = "";
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        a2 = this.qca.a(str2);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        obtain.writeInterfaceToken(a2);
        if (Build.VERSION.SDK_INT >= 23) {
            context = f.d;
            obtain.writeString(context.getPackageName());
        }
        a3 = this.qca.a(str2, str, obtain, obtain2);
        if (a3 != null) {
            try {
                obtain2.readException();
                str3 = obtain2.readString();
            } catch (SecurityException e) {
                return "";
            }
        }
        obtain2.recycle();
        obtain.recycle();
        return str3;
    }

    public final String a() {
        return a("TRANSACTION_getDeviceId", "iphonesubinfo");
    }

    public final String b() {
        return a("TRANSACTION_getIccSerialNumber", "iphonesubinfo");
    }
}
