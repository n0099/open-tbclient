package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface j extends IInterface {
    String a() throws RemoteException;

    void a(String str) throws RemoteException;

    int[] b() throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements j {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (queryLocalInterface != null && (queryLocalInterface instanceof j)) {
                return (j) queryLocalInterface;
            }
            return new C0506a(iBinder);
        }

        public static j c() {
            return C0506a.f39114a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                return true;
            } else {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                int[] b2 = b();
                parcel2.writeNoException();
                parcel2.writeIntArray(b2);
                return true;
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.depend.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0506a implements j {

            /* renamed from: a  reason: collision with root package name */
            public static j f39114a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f39115b;

            public C0506a(IBinder iBinder) {
                this.f39115b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    obtain.writeString(str);
                    if (!this.f39115b.transact(1, obtain, obtain2, 0) && a.c() != null) {
                        a.c().a(str);
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
                return this.f39115b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public int[] b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f39115b.transact(3, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().b();
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f39115b.transact(2, obtain, obtain2, 0) && a.c() != null) {
                        return a.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
