package com.google.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f30821a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30822b;

    public a(IBinder iBinder, String str) {
        this.f30821a = iBinder;
        this.f30822b = str;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f30822b);
        return obtain;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f30821a;
    }

    public final void b(int i2, Parcel parcel) {
        try {
            this.f30821a.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel a(int i2, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f30821a.transact(i2, parcel, obtain, 0);
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
