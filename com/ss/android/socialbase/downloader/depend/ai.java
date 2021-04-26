package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface ai extends IInterface {
    long a(int i2, int i3) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements ai {

        /* renamed from: com.ss.android.socialbase.downloader.depend.ai$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0446a implements ai {

            /* renamed from: a  reason: collision with root package name */
            public static ai f36785a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f36786b;

            public C0446a(IBinder iBinder) {
                this.f36786b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ai
            public long a(int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.f36786b.transact(1, obtain, obtain2, 0) && a.a() != null) {
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
                return this.f36786b;
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
            return new C0446a(iBinder);
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
            return C0446a.f36785a;
        }
    }
}
