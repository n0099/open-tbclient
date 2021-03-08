package com.kwai.filedownloader.c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.c.a;
/* loaded from: classes3.dex */
public interface b extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.kwai.filedownloader.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static class C1177a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f7186a;

            C1177a(IBinder iBinder) {
                this.f7186a = iBinder;
            }

            @Override // com.kwai.filedownloader.c.b
            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    this.f7186a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public void a(int i, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7186a.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public void a(com.kwai.filedownloader.c.a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f7186a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z3 ? 1 : 0);
                    this.f7186a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public void a(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f7186a.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public boolean a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f7186a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public boolean a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f7186a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7186a;
            }

            @Override // com.kwai.filedownloader.c.b
            public void b(com.kwai.filedownloader.c.a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f7186a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    this.f7186a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public boolean b(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f7186a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public long c(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f7186a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public void c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    this.f7186a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public long d(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f7186a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public byte e(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f7186a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.c.b
            public boolean f(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f7186a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCService");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C1177a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    a(a.AbstractBinderC1175a.a(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    b(a.AbstractBinderC1175a.a(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean a2 = a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    a(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.kwai.filedownloader.d.b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean a3 = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean b = b(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    long c = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(c);
                    return true;
                case 9:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    long d = d(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(d);
                    return true;
                case 10:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    byte e = e(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByte(e);
                    return true;
                case 11:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b2 ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    a(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    a(parcel.readInt() != 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean f = f(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(f ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a();

    void a(int i, Notification notification);

    void a(com.kwai.filedownloader.c.a aVar);

    void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3);

    void a(boolean z);

    boolean a(int i);

    boolean a(String str, String str2);

    void b(com.kwai.filedownloader.c.a aVar);

    boolean b();

    boolean b(int i);

    long c(int i);

    void c();

    long d(int i);

    byte e(int i);

    boolean f(int i);
}
