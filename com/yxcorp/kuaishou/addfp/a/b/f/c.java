package com.yxcorp.kuaishou.addfp.a.b.f;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes3.dex */
final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f8608a;

    public c(IBinder iBinder) {
        this.f8608a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.f.a
    public final String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f8608a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f8608a;
    }
}
