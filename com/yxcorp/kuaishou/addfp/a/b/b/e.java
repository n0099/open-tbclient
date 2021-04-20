package com.yxcorp.kuaishou.addfp.a.b.b;

import android.os.IBinder;
import android.os.Parcel;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes7.dex */
public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f41381a;

    public e(IBinder iBinder) {
        this.f41381a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b.d
    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
            this.f41381a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } finally {
            try {
                return str;
            } finally {
            }
        }
        return str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f41381a;
    }
}
