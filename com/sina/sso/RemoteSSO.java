package com.sina.sso;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface RemoteSSO extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements RemoteSSO {

        /* loaded from: classes.dex */
        class a implements RemoteSSO {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.sina.sso.RemoteSSO
            public String getActivityName() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sina.sso.RemoteSSO
            public String getPackageName() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.sina.sso.RemoteSSO");
        }

        public static RemoteSSO asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof RemoteSSO)) ? new a(iBinder) : (RemoteSSO) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    String packageName = getPackageName();
                    parcel2.writeNoException();
                    parcel2.writeString(packageName);
                    return true;
                case 2:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    String activityName = getActivityName();
                    parcel2.writeNoException();
                    parcel2.writeString(activityName);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.sina.sso.RemoteSSO");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getActivityName();

    String getPackageName();
}
