package com.qq.e.comm.plugin.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes3.dex */
public interface s extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements s {

        /* renamed from: com.qq.e.comm.plugin.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static class C1160a implements s {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11946a;

            C1160a(IBinder iBinder) {
                this.f11946a = iBinder;
            }

            @Override // com.qq.e.comm.plugin.a.s
            public int a(c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11946a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.a.s
            public int a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeString(str);
                    this.f11946a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.a.s
            public List<c> a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    this.f11946a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(c.f11902a);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.a.s
            public boolean a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i);
                    this.f11946a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.a.s
            public boolean a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f11946a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.a.s
            public boolean a(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.f11946a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.a.s
            public boolean a(int i, String str, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.f11946a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11946a;
            }

            @Override // com.qq.e.comm.plugin.a.s
            public List<c> b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    this.f11946a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(c.f11902a);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.qq.e.comm.plugin.apkmanager.IDownloadService");
        }

        public static s a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof s)) ? new C1160a(iBinder) : (s) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    int a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    List<c> a3 = a();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    List<c> b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(b2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    int a4 = a(parcel.readInt() != 0 ? c.f11902a.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(a4);
                    return true;
                case 5:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    boolean a5 = a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a5 ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    boolean a6 = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a6 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    boolean a7 = a(parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a7 ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    boolean a8 = a(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(a8 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a(c cVar) throws RemoteException;

    int a(String str) throws RemoteException;

    List<c> a() throws RemoteException;

    boolean a(int i) throws RemoteException;

    boolean a(int i, int i2) throws RemoteException;

    boolean a(int i, int i2, long j) throws RemoteException;

    boolean a(int i, String str, int i2) throws RemoteException;

    List<c> b() throws RemoteException;
}
