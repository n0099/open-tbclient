package com.kwai.filedownloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes7.dex */
public interface a extends IInterface {

    /* renamed from: com.kwai.filedownloader.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractBinderC0446a extends Binder implements a {

        /* renamed from: com.kwai.filedownloader.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0447a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f37748a;

            public C0447a(IBinder iBinder) {
                this.f37748a = iBinder;
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
                    this.f37748a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f37748a;
            }
        }

        public AbstractBinderC0446a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0447a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                a(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                return true;
            }
        }
    }

    void a(MessageSnapshot messageSnapshot);
}
