package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes4.dex */
public interface ac extends IInterface {
    String a() throws RemoteException;

    void a(int i, com.ss.android.socialbase.downloader.g.c cVar, String str, String str2) throws RemoteException;

    boolean a(boolean z) throws RemoteException;

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements ac {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static ac a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ac)) {
                return (ac) queryLocalInterface;
            }
            return new C1230a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            com.ss.android.socialbase.downloader.g.c cVar;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        cVar = com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel);
                    } else {
                        cVar = null;
                    }
                    a(readInt, cVar, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    boolean a2 = a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    String a3 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.d.ac$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private static class C1230a implements ac {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13106a;

            C1230a(IBinder iBinder) {
                this.f13106a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13106a;
            }

            @Override // com.ss.android.socialbase.downloader.d.ac
            public void a(int i, com.ss.android.socialbase.downloader.g.c cVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    obtain.writeInt(i);
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f13106a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.ac
            public boolean a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    obtain.writeInt(z ? 1 : 0);
                    this.f13106a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.ac
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    this.f13106a.transact(3, obtain, obtain2, 0);
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
