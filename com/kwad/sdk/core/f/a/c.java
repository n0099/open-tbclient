package com.kwad.sdk.core.f.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.zui.deviceidservice.IDeviceidInterface;
/* loaded from: classes5.dex */
public interface c extends IInterface {

    /* loaded from: classes5.dex */
    public static final class a implements c {
        public IBinder Zy;

        public a(IBinder iBinder) {
            this.Zy = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.Zy;
        }

        @Override // com.kwad.sdk.core.f.a.c
        public final String getOaid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDeviceidInterface.Stub.DESCRIPTOR);
                this.Zy.transact(1, obtain, obtain2, 0);
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

    String getOaid();
}
