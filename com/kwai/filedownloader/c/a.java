package com.kwai.filedownloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: com.kwai.filedownloader.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractBinderC0457a extends Binder implements a {

        /* renamed from: com.kwai.filedownloader.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0458a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f37180a;

            public C0458a(IBinder iBinder) {
                this.f37180a = iBinder;
            }

            @Override // com.kwai.filedownloader.c.a
            public void a(MessageSnapshot messageSnapshot) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        obtain.writeInt(1);
                        messageSnapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f37180a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f37180a;
            }
        }

        public AbstractBinderC0457a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0458a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                a(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                return true;
            }
        }
    }

    void a(MessageSnapshot messageSnapshot);
}
