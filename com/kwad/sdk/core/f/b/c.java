package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.zui.deviceidservice.IDeviceidInterface;
/* loaded from: classes10.dex */
public interface c extends IInterface {
    String getOaid();

    /* loaded from: classes10.dex */
    public static final class a implements c {
        public IBinder avb;

        public a(IBinder iBinder) {
            this.avb = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.avb;
        }

        @Override // com.kwad.sdk.core.f.b.c
        public final String getOaid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDeviceidInterface.Stub.DESCRIPTOR);
                this.avb.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception unused) {
                obtain2.recycle();
                obtain.recycle();
                return null;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
    }
}
