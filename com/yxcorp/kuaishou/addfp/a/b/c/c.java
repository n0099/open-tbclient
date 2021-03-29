package com.yxcorp.kuaishou.addfp.a.b.c;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes7.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f41093a;

    public c(IBinder iBinder) {
        this.f41093a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f41093a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } finally {
            try {
                return str;
            } finally {
            }
        }
        return str;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String a(String str) {
        String str2;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            obtain.writeString(str);
            this.f41093a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            str2 = obtain2.readString();
        } finally {
            try {
                return str2;
            } finally {
            }
        }
        return str2;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f41093a;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String b() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f41093a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } finally {
            try {
                return str;
            } finally {
            }
        }
        return str;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String b(String str) {
        String str2;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            obtain.writeString(str);
            this.f41093a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            str2 = obtain2.readString();
        } finally {
            try {
                return str2;
            } finally {
            }
        }
        return str2;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final boolean c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f41093a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            r2 = obtain2.readInt() != 0;
            obtain2.recycle();
            obtain.recycle();
            return r2;
        } catch (Throwable unused) {
            obtain2.recycle();
            obtain.recycle();
            return r2;
        }
    }
}
