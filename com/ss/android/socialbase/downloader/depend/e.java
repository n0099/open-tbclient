package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface e extends IInterface {
    int a(long j) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements e {

        /* renamed from: com.ss.android.socialbase.downloader.depend.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0504a implements e {

            /* renamed from: a  reason: collision with root package name */
            public static e f39199a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f39200b;

            public C0504a(IBinder iBinder) {
                this.f39200b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.e
            public int a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    obtain.writeLong(j);
                    if (!this.f39200b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(j);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39200b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C0504a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int a2 = a(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(a2);
            return true;
        }

        public static e a() {
            return C0504a.f39199a;
        }
    }
}
