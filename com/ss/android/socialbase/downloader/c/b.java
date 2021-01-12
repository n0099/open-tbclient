package com.ss.android.socialbase.downloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;
/* loaded from: classes4.dex */
public interface b extends IInterface {
    void a(Map map, Map map2) throws RemoteException;

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C1228a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    ClassLoader classLoader = getClass().getClassLoader();
                    a(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private static class C1228a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13083a;

            C1228a(IBinder iBinder) {
                this.f13083a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13083a;
            }

            @Override // com.ss.android.socialbase.downloader.c.b
            public void a(Map map, Map map2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    obtain.writeMap(map);
                    obtain.writeMap(map2);
                    this.f13083a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
