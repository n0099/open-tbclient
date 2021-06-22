package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes7.dex */
public interface o extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements o {

        /* renamed from: com.ss.android.socialbase.downloader.depend.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0497a implements o {

            /* renamed from: a  reason: collision with root package name */
            public static o f39759a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f39760b;

            public C0497a(IBinder iBinder) {
                this.f39760b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (!this.f39760b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                        a.b().a();
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
                return this.f39760b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static o a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof o)) {
                return (o) queryLocalInterface;
            }
            return new C0497a(iBinder);
        }

        public static o b() {
            return C0497a.f39759a;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            a();
            parcel2.writeNoException();
            return true;
        }
    }

    void a() throws RemoteException;
}
