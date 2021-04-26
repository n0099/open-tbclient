package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface h extends IInterface {

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements h {

        /* renamed from: com.ss.android.socialbase.downloader.depend.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0451a implements h {

            /* renamed from: a  reason: collision with root package name */
            public static h f36795a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f36796b;

            public C0451a(IBinder iBinder) {
                this.f36796b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.h
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.f36796b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f36796b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (queryLocalInterface != null && (queryLocalInterface instanceof h)) {
                return (h) queryLocalInterface;
            }
            return new C0451a(iBinder);
        }

        public static h b() {
            return C0451a.f36795a;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean a2 = a();
            parcel2.writeNoException();
            parcel2.writeInt(a2 ? 1 : 0);
            return true;
        }
    }

    boolean a() throws RemoteException;
}
