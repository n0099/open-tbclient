package com.kwad.sdk.core.f.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bun.lib.MsaIdInterface;
/* loaded from: classes9.dex */
public interface f extends IInterface {

    /* loaded from: classes9.dex */
    public static final class a implements f {
        public IBinder Zy;

        public a(IBinder iBinder) {
            this.Zy = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.Zy;
        }

        @Override // com.kwad.sdk.core.f.a.f
        public final String getOAID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(MsaIdInterface.Stub.DESCRIPTOR);
                this.Zy.transact(1, obtain, obtain2, 0);
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
    }

    String getOAID();
}
