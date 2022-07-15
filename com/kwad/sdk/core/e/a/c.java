package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.zui.deviceidservice.IDeviceidInterface;
/* loaded from: classes5.dex */
public interface c extends IInterface {

    /* loaded from: classes5.dex */
    public static final class a implements c {
        public IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // com.kwad.sdk.core.e.a.c
        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDeviceidInterface.Stub.DESCRIPTOR);
                this.a.transact(1, obtain, obtain2, 0);
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

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.a;
        }
    }

    String a();
}
