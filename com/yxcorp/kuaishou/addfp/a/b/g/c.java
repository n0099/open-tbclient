package com.yxcorp.kuaishou.addfp.a.b.g;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes7.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f41104a;

    public c(IBinder iBinder) {
        this.f41104a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.g.a
    public final String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            this.f41104a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f41104a;
    }
}
