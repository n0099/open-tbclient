package com.win.opensdk;

import android.os.IBinder;
import android.os.Parcel;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes7.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f40774a;

    public a(IBinder iBinder) {
        this.f40774a = iBinder;
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
            this.f40774a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f40774a;
    }

    public boolean b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
            this.f40774a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
