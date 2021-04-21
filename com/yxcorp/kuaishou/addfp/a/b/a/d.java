package com.yxcorp.kuaishou.addfp.a.b.a;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes7.dex */
public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f41468a;

    public d(IBinder iBinder) {
        this.f41468a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final boolean a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f41468a.transact(1, obtain, obtain2, 0);
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

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f41468a;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String b() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f41468a.transact(2, obtain, obtain2, 0);
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

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String c() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f41468a.transact(3, obtain, obtain2, 0);
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

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String d() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f41468a.transact(4, obtain, obtain2, 0);
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

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String e() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f41468a.transact(5, obtain, obtain2, 0);
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
}
