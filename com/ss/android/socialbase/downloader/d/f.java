package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface f extends IInterface {
    int a(long j) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements f {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                return (f) queryLocalInterface;
            }
            return new C1240a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    int a2 = a(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.d.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private static class C1240a implements f {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13112a;

            C1240a(IBinder iBinder) {
                this.f13112a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13112a;
            }

            @Override // com.ss.android.socialbase.downloader.d.f
            public int a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    obtain.writeLong(j);
                    this.f13112a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
