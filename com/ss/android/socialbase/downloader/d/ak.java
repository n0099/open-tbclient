package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface ak extends IInterface {
    long a(int i, int i2) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements ak {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static ak a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ak)) {
                return (ak) queryLocalInterface;
            }
            return new C1238a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    long a2 = a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.d.ak$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private static class C1238a implements ak {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13110a;

            C1238a(IBinder iBinder) {
                this.f13110a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13110a;
            }

            @Override // com.ss.android.socialbase.downloader.d.ak
            public long a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f13110a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
