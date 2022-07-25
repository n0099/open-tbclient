package com.ss.android.downloadlib.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface d extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements d {
        public static String a = "";

        /* renamed from: com.ss.android.downloadlib.a.b.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0646a implements d {
            public IBinder a;

            public C0646a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.a)) {
                    JSONObject i = j.i();
                    String unused = a.a = com.ss.android.socialbase.appdownloader.f.c.a(i.optString("t"), i.optString("s"));
                }
                this.a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.b.d
            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(a);
                return true;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0646a(iBinder);
        }
    }

    void a(b bVar) throws RemoteException;
}
