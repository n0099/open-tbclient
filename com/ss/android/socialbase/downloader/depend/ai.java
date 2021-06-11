package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes7.dex */
public interface ai extends IInterface {
    long a(int i2, int i3) throws RemoteException;

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements ai {

        /* renamed from: com.ss.android.socialbase.downloader.depend.ai$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0485a implements ai {

            /* renamed from: a  reason: collision with root package name */
            public static ai f39638a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f39639b;

            public C0485a(IBinder iBinder) {
                this.f39639b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ai
            public long a(int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.f39639b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(i2, i3);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39639b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static ai a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ai)) {
                return (ai) queryLocalInterface;
            }
            return new C0485a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long a2 = a(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(a2);
            return true;
        }

        public static ai a() {
            return C0485a.f39638a;
        }
    }
}
