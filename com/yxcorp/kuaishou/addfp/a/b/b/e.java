package com.yxcorp.kuaishou.addfp.a.b.b;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes5.dex */
public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f14646a;

    public e(IBinder iBinder) {
        this.f14646a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b.d
    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            this.f14646a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                str = "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
        return str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f14646a;
    }
}
