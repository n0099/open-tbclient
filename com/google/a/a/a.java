package com.google.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f30641a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30642b;

    public a(IBinder iBinder, String str) {
        this.f30641a = iBinder;
        this.f30642b = str;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f30642b);
        return obtain;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f30641a;
    }

    public final void b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f30641a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f30641a.transact(i, parcel, obtain, 0);
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
