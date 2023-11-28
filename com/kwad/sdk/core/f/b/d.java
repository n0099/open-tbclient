package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.openid.IOpenID;
/* loaded from: classes10.dex */
public interface d extends IInterface {
    String getSerID(String str, String str2, String str3);

    /* loaded from: classes10.dex */
    public static final class a implements d {
        public IBinder avb;

        public a(IBinder iBinder) {
            this.avb = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.avb;
        }

        @Override // com.kwad.sdk.core.f.b.d
        public final String getSerID(String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
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
