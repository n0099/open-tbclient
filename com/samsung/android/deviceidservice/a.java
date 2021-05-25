package com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes7.dex */
public interface a extends IInterface {

    /* renamed from: com.samsung.android.deviceidservice.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractBinderC0422a extends Binder implements a {

        /* renamed from: com.samsung.android.deviceidservice.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0423a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f35540a;

            public C0423a(IBinder iBinder) {
                this.f35540a = iBinder;
            }

            @Override // com.samsung.android.deviceidservice.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f35540a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.samsung.android.deviceidservice.a
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    this.f35540a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35540a;
            }

            @Override // com.samsung.android.deviceidservice.a
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    this.f35540a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0422a() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0423a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String a2;
            if (i2 == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                a2 = a();
            } else if (i2 == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                a2 = a(parcel.readString());
            } else if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            } else {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                a2 = b(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }
    }

    String a();

    String a(String str);

    String b(String str);
}
