package com.huawei.android.hms.pps.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes5.dex */
public interface b extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class a {

        /* renamed from: com.huawei.android.hms.pps.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0990a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4062a;

            public C0990a(IBinder iBinder) {
                this.f4062a = iBinder;
            }

            @Override // com.huawei.android.hms.pps.a.b
            public final String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f4062a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4062a;
            }

            @Override // com.huawei.android.hms.pps.a.b
            public final boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f4062a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    String a();

    boolean b();
}
