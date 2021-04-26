package com.google.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f31576a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31577b;

    public a(IBinder iBinder, String str) {
        this.f31576a = iBinder;
        this.f31577b = str;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f31577b);
        return obtain;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f31576a;
    }

    public final void b(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f31576a.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel a(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f31576a.transact(i2, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }
}
