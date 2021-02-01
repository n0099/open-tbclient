package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.ai;
import com.ss.android.socialbase.downloader.d.am;
import com.ss.android.socialbase.downloader.d.h;
import com.ss.android.socialbase.downloader.d.j;
import com.ss.android.socialbase.downloader.g.a;
import java.util.List;
/* loaded from: classes6.dex */
public interface j extends IInterface {
    int a(String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.g.c> a(String str) throws RemoteException;

    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(int i, int i2, int i3, int i4) throws RemoteException;

    void a(int i, int i2, int i3, long j) throws RemoteException;

    void a(int i, int i2, long j) throws RemoteException;

    void a(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z) throws RemoteException;

    void a(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z, boolean z2) throws RemoteException;

    void a(int i, long j) throws RemoteException;

    void a(int i, Notification notification) throws RemoteException;

    void a(int i, ac acVar) throws RemoteException;

    void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) throws RemoteException;

    void a(int i, boolean z) throws RemoteException;

    void a(am amVar) throws RemoteException;

    void a(com.ss.android.socialbase.downloader.g.a aVar) throws RemoteException;

    void a(com.ss.android.socialbase.downloader.g.b bVar) throws RemoteException;

    void a(List<String> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException;

    com.ss.android.socialbase.downloader.g.c b(String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.g.c> b(String str) throws RemoteException;

    void b(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z) throws RemoteException;

    void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) throws RemoteException;

    void b(int i, boolean z) throws RemoteException;

    void b(List<String> list) throws RemoteException;

    boolean b() throws RemoteException;

    boolean b(int i) throws RemoteException;

    boolean b(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException;

    List<com.ss.android.socialbase.downloader.g.c> c(String str) throws RemoteException;

    void c(int i) throws RemoteException;

    void c(int i, boolean z) throws RemoteException;

    boolean c() throws RemoteException;

    List<com.ss.android.socialbase.downloader.g.c> d(String str) throws RemoteException;

    void d() throws RemoteException;

    void d(int i) throws RemoteException;

    void d(int i, boolean z) throws RemoteException;

    long e(int i) throws RemoteException;

    List<com.ss.android.socialbase.downloader.g.c> e(String str) throws RemoteException;

    boolean e() throws RemoteException;

    int f(int i) throws RemoteException;

    boolean g(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.g.c h(int i) throws RemoteException;

    List<com.ss.android.socialbase.downloader.g.b> i(int i) throws RemoteException;

    void j(int i) throws RemoteException;

    boolean k(int i) throws RemoteException;

    void l(int i) throws RemoteException;

    int m(int i) throws RemoteException;

    boolean n(int i) throws RemoteException;

    void o(int i) throws RemoteException;

    boolean p(int i) throws RemoteException;

    ac q(int i) throws RemoteException;

    ai r(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.d.h s(int i) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements j {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof j)) {
                return (j) queryLocalInterface;
            }
            return new C1249a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(a.AbstractBinderC1251a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean b2 = b(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(b2 ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    c(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    long e = e(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(e);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int f = f(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(f);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean g = g(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(g ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.g.c h = h(parcel.readInt());
                    parcel2.writeNoException();
                    if (h != null) {
                        parcel2.writeInt(1);
                        h.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.g.c> a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a2);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.g.b> i3 = i(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int a3 = a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.g.c b3 = b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (b3 != null) {
                        parcel2.writeInt(1);
                        b3.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.g.c> b4 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(b4);
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.g.c> c = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(c);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.g.c> d = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(d);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    b(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    b(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    c(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    j(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt(), j.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    b(parcel.readInt(), parcel.readInt(), j.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt(), j.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean a4 = a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(a4 ? 1 : 0);
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt() != 0);
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean b5 = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b5 ? 1 : 0);
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.g.c> e2 = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(e2);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean k = k(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(k ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    l(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    d(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int m = m(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(m);
                    return true;
                case 37:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.g.b.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean b6 = b(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(b6 ? 1 : 0);
                    return true;
                case 39:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean n = n(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(n ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    o(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean p = p(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(p ? 1 : 0);
                    return true;
                case 45:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.g.b.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    b(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.g.b.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(am.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ac q = q(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(q != null ? q.asBinder() : null);
                    return true;
                case 51:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ai r = r(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(r != null ? r.asBinder() : null);
                    return true;
                case 52:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), ac.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 53:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.d.h s = s(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(s != null ? s.asBinder() : null);
                    return true;
                case 54:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean e3 = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e3 ? 1 : 0);
                    return true;
                case 55:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.downloader.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private static class C1249a implements j {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13140a;

            C1249a(IBinder iBinder) {
                this.f13140a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13140a;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(com.ss.android.socialbase.downloader.g.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f13140a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f13140a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    this.f13140a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public long e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public int f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean g(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public com.ss.android.socialbase.downloader.g.c h(int i) throws RemoteException {
                com.ss.android.socialbase.downloader.g.c cVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        cVar = com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(obtain2);
                    } else {
                        cVar = null;
                    }
                    return cVar;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public List<com.ss.android.socialbase.downloader.g.c> a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f13140a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public List<com.ss.android.socialbase.downloader.g.b> i(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.g.b.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public int a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f13140a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public com.ss.android.socialbase.downloader.g.c b(String str, String str2) throws RemoteException {
                com.ss.android.socialbase.downloader.g.c cVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f13140a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        cVar = com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(obtain2);
                    } else {
                        cVar = null;
                    }
                    return cVar;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public List<com.ss.android.socialbase.downloader.g.c> b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f13140a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public List<com.ss.android.socialbase.downloader.g.c> c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f13140a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public List<com.ss.android.socialbase.downloader.g.c> d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f13140a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    this.f13140a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void b(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    this.f13140a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void b(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f13140a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void c(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f13140a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void j(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f13140a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void b(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f13140a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, int i2, com.ss.android.socialbase.downloader.d.j jVar, int i3, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f13140a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean a(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13140a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13140a.transact(28, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f13140a.transact(29, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    this.f13140a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public List<com.ss.android.socialbase.downloader.g.c> e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f13140a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean k(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void l(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    this.f13140a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void d(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f13140a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public int m(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(com.ss.android.socialbase.downloader.g.b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13140a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean b(com.ss.android.socialbase.downloader.g.c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13140a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean n(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void o(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.f13140a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.f13140a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.f13140a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean p(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    this.f13140a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    this.f13140a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    this.f13140a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(am amVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
                    this.f13140a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f13140a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public ac q(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return ac.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public ai r(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    return ai.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f13140a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public com.ss.android.socialbase.downloader.d.h s(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f13140a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                    return h.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public boolean e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    this.f13140a.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.j
            public void a(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f13140a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
