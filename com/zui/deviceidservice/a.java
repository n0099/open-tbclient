package com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes7.dex */
public interface a extends IInterface {

    /* renamed from: com.zui.deviceidservice.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractBinderC0473a extends Binder implements a {

        /* renamed from: com.zui.deviceidservice.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0474a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f38253a;

            public C0474a(IBinder iBinder) {
                this.f38253a = iBinder;
            }

            @Override // com.zui.deviceidservice.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f38253a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.a
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f38253a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38253a;
            }

            @Override // com.zui.deviceidservice.a
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f38253a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.a
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f38253a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.a
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f38253a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0473a() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0474a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String a2;
            if (i2 == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                a2 = a();
            } else if (i2 == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                a2 = b();
            } else if (i2 == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean c2 = c();
                parcel2.writeNoException();
                parcel2.writeInt(c2 ? 1 : 0);
                return true;
            } else if (i2 == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                a2 = a(parcel.readString());
            } else if (i2 != 5) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            } else {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                a2 = b(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }
    }

    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();
}
