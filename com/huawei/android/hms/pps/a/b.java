package com.huawei.android.hms.pps.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public interface b extends IInterface {

    /* loaded from: classes6.dex */
    public static abstract class a {

        /* renamed from: com.huawei.android.hms.pps.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C1034a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f8205a;

            public C1034a(IBinder iBinder) {
                this.f8205a = iBinder;
            }

            @Override // com.huawei.android.hms.pps.a.b
            public final String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f8205a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f8205a;
            }

            @Override // com.huawei.android.hms.pps.a.b
            public final boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f8205a.transact(2, obtain, obtain2, 0);
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
