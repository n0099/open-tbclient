package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface g extends IInterface {
    void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements g {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (queryLocalInterface != null && (queryLocalInterface instanceof g)) {
                return (g) queryLocalInterface;
            }
            return new C1241a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.a.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.d.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private static class C1241a implements g {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13113a;

            C1241a(IBinder iBinder) {
                this.f13113a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13113a;
            }

            @Override // com.ss.android.socialbase.downloader.d.g
            public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f13113a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
