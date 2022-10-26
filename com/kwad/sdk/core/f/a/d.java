package com.kwad.sdk.core.f.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.openid.IOpenID;
/* loaded from: classes7.dex */
public interface d extends IInterface {

    /* loaded from: classes7.dex */
    public final class a implements d {
        public IBinder Zy;

        public a(IBinder iBinder) {
            this.Zy = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.Zy;
        }

        @Override // com.kwad.sdk.core.f.a.d
        public final String getSerID(String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
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

    String getSerID(String str, String str2, String str3);
}
