package com.kwad.sdk.core.f.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.deviceidservice.IDeviceIdService;
/* loaded from: classes7.dex */
public interface e extends IInterface {

    /* loaded from: classes7.dex */
    public static class a implements e {
        public IBinder Zz;

        public a(IBinder iBinder) {
            this.Zz = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.Zz;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDeviceIdService.Stub.DESCRIPTOR);
                this.Zz.transact(1, obtain, obtain2, 0);
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
