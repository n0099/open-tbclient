package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.openid.IOpenID;
/* loaded from: classes5.dex */
public interface d extends IInterface {

    /* loaded from: classes5.dex */
    public static final class a implements d {
        public IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // com.kwad.sdk.core.e.a.d
        public final String a(String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
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

    String a(String str, String str2, String str3);
}
