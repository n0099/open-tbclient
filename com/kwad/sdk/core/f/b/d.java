package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes4.dex */
public interface d extends IInterface {

    /* loaded from: classes4.dex */
    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f9151a;

        public a(IBinder iBinder) {
            this.f9151a = iBinder;
        }

        @Override // com.kwad.sdk.core.f.b.d
        public String a(String str, String str2, String str3) {
            String str4 = null;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                this.f9151a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str4 = obtain2.readString();
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
            return str4;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9151a;
        }
    }

    String a(String str, String str2, String str3);
}
