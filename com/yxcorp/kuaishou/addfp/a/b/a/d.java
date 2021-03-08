package com.yxcorp.kuaishou.addfp.a.b.a;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes3.dex */
final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f8597a;

    public d(IBinder iBinder) {
        this.f8597a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final boolean a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f8597a.transact(1, obtain, obtain2, 0);
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

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f8597a;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String b() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f8597a.transact(2, obtain, obtain2, 0);
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

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String c() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f8597a.transact(3, obtain, obtain2, 0);
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

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String d() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f8597a.transact(4, obtain, obtain2, 0);
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

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String e() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f8597a.transact(5, obtain, obtain2, 0);
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
}
