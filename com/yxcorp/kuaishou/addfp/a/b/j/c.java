package com.yxcorp.kuaishou.addfp.a.b.j;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes7.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f41994a;

    public c(IBinder iBinder) {
        this.f41994a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.j.a
    public final String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            this.f41994a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f41994a;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.j.a
    public final boolean b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            this.f41994a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.j.a
    public final void c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            this.f41994a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
