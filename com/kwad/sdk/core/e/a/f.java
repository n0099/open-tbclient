package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bun.lib.MsaIdInterface;
/* loaded from: classes5.dex */
public interface f extends IInterface {

    /* loaded from: classes5.dex */
    public static final class a implements f {
        public IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // com.kwad.sdk.core.e.a.f
        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(MsaIdInterface.Stub.DESCRIPTOR);
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception unused) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
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
