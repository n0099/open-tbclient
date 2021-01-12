package com.ss.android.socialbase.downloader.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.p;
/* loaded from: classes4.dex */
public interface q extends IInterface {
    boolean a(long j, long j2, p pVar) throws RemoteException;

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements q {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static q a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof q)) {
                return (q) queryLocalInterface;
            }
            return new C1242a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    boolean a2 = a(parcel.readLong(), parcel.readLong(), p.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.d.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private static class C1242a implements q {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13118a;

            C1242a(IBinder iBinder) {
                this.f13118a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13118a;
            }

            @Override // com.ss.android.socialbase.downloader.d.q
            public boolean a(long j, long j2, p pVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    this.f13118a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
