package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.u;
/* loaded from: classes6.dex */
public interface v extends IInterface {
    boolean a(u uVar) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements v {

        /* renamed from: com.ss.android.socialbase.downloader.depend.v$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0514a implements v {

            /* renamed from: a  reason: collision with root package name */
            public static v f39219a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f39220b;

            public C0514a(IBinder iBinder) {
                this.f39220b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a(u uVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.f39220b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(uVar);
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
                return this.f39220b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static v a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof v)) {
                return (v) queryLocalInterface;
            }
            return new C0514a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean a2 = a(u.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(a2 ? 1 : 0);
            return true;
        }

        public static v a() {
            return C0514a.f39219a;
        }
    }
}
