package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes4.dex */
public interface aj extends IInterface {
    void a(int i2, int i3) throws RemoteException;

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements aj {

        /* renamed from: com.ss.android.socialbase.downloader.depend.aj$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C2209a implements aj {
            public static aj a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f59974b;

            public C2209a(IBinder iBinder) {
                this.f59974b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.aj
            public void a(int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.f59974b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(i2, i3);
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
                return this.f59974b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static aj a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof aj)) {
                return (aj) queryLocalInterface;
            }
            return new C2209a(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            a(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static aj a() {
            return C2209a.a;
        }
    }
}
