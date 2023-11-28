package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bun.lib.MsaIdInterface;
/* loaded from: classes10.dex */
public interface f extends IInterface {
    String getOAID();

    /* loaded from: classes10.dex */
    public static final class a implements f {
        public IBinder avb;

        public a(IBinder iBinder) {
            this.avb = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.avb;
        }

        @Override // com.kwad.sdk.core.f.b.f
        public final String getOAID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(MsaIdInterface.Stub.DESCRIPTOR);
                this.avb.transact(1, obtain, obtain2, 0);
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
}
