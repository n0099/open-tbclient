package com.sina.sso;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface RemoteSSO extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements RemoteSSO {
        public Stub() {
            attachInterface(this, "com.sina.sso.RemoteSSO");
        }

        public static RemoteSSO a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof RemoteSSO)) ? new a(iBinder) : (RemoteSSO) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.sina.sso.RemoteSSO");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a();

    String b();
}
