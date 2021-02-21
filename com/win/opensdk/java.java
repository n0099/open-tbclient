package com.win.opensdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes3.dex */
public interface java extends IInterface {
    String java();

    /* renamed from: java  reason: collision with other method in class */
    boolean m77java();

    /* renamed from: com.win.opensdk.java$java  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC1279java extends Binder implements java {
        public static java java(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof java)) {
                return (java) queryLocalInterface;
            }
            return new C1280java(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    String java = java();
                    parcel2.writeNoException();
                    parcel2.writeString(java);
                    return true;
                case 2:
                    parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean java2 = java();
                    parcel2.writeNoException();
                    parcel2.writeInt(java2 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.win.opensdk.java$java$java  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static class C1280java implements java {
            private IBinder java;

            C1280java(IBinder iBinder) {
                this.java = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.java;
            }

            @Override // com.win.opensdk.java
            public final String java() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.java.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.win.opensdk.java
            public final boolean java() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.java.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
