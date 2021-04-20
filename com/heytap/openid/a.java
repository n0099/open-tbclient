package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: com.heytap.openid.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractBinderC0361a extends Binder implements a {

        /* renamed from: com.heytap.openid.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0362a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f31377a;

            public C0362a(IBinder iBinder) {
                this.f31377a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f31377a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f31377a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0362a(iBinder) : (a) queryLocalInterface;
        }
    }
}
