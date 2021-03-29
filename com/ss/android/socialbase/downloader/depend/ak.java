package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes7.dex */
public interface ak extends IInterface {
    void a(int i, int i2) throws RemoteException;

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements ak {

        /* renamed from: com.ss.android.socialbase.downloader.depend.ak$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0486a implements ak {

            /* renamed from: a  reason: collision with root package name */
            public static ak f38813a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f38814b;

            public C0486a(IBinder iBinder) {
                this.f38814b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ak
            public void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f38814b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38814b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static ak a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ak)) {
                return (ak) queryLocalInterface;
            }
            return new C0486a(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            a(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static ak a() {
            return C0486a.f38813a;
        }
    }
}
