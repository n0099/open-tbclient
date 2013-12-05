package com.sina.sso;

import android.os.IBinder;
import android.os.Parcel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements RemoteSSO {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f2894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(IBinder iBinder) {
        this.f2894a = iBinder;
    }

    @Override // com.sina.sso.RemoteSSO
    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
            this.f2894a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2894a;
    }

    @Override // com.sina.sso.RemoteSSO
    public String b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
            this.f2894a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
