package com.yxcorp.kuaishou.addfp.a.b.c;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes3.dex */
final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f14349a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IBinder iBinder) {
        this.f14349a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f14349a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                str = "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
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
            this.f14349a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            str2 = obtain2.readString();
        } catch (Throwable th) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                str2 = "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
        return str2;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f14349a;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String b() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            this.f14349a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                str = "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
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
            this.f14349a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            str2 = obtain2.readString();
        } catch (Throwable th) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                str2 = "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
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
            this.f14349a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            r0 = obtain2.readInt() != 0;
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
        return r0;
    }
}
