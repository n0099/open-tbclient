package com.huawei.android.hms.pps.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes6.dex */
public interface b extends IInterface {

    /* loaded from: classes6.dex */
    public static abstract class a {

        /* renamed from: com.huawei.android.hms.pps.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0366a implements b {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f31484a;

            public C0366a(IBinder iBinder) {
                this.f31484a = iBinder;
            }

            @Override // com.huawei.android.hms.pps.a.b
            public final String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    this.f31484a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f31484a;
            }

            @Override // com.huawei.android.hms.pps.a.b
            public final boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    this.f31484a.transact(2, obtain, obtain2, 0);
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
