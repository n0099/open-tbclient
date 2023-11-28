package com.kwad.framework.filedownloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
/* loaded from: classes10.dex */
public interface a extends IInterface {
    void q(MessageSnapshot messageSnapshot);

    /* renamed from: com.kwad.framework.filedownloader.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractBinderC0680a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: com.kwad.framework.filedownloader.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0681a implements a {
            public static a agU;
            public IBinder mRemote;

            public C0681a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwad.framework.filedownloader.c.a
            public final void q(MessageSnapshot messageSnapshot) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        obtain.writeInt(1);
                        messageSnapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, null, 1) && AbstractBinderC0680a.vK() != null) {
                        AbstractBinderC0680a.vK().q(messageSnapshot);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0680a() {
            attachInterface(this, "com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a vK() {
            return C0681a.agU;
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0681a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            MessageSnapshot messageSnapshot;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                return true;
            }
            parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
            if (parcel.readInt() != 0) {
                messageSnapshot = MessageSnapshot.CREATOR.createFromParcel(parcel);
            } else {
                messageSnapshot = null;
            }
            q(messageSnapshot);
            return true;
        }
    }
}
