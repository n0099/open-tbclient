package com.ss.android.downloadlib.a.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import d.p.a.d.f.n;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface d extends IInterface {

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements d {

        /* renamed from: a  reason: collision with root package name */
        public static String f39018a = "";

        /* renamed from: com.ss.android.downloadlib.a.c.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0493a implements d {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f39019a;

            public C0493a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.f39018a)) {
                    JSONObject s = n.s();
                    String unused = a.f39018a = d.p.a.e.a.h.b.b(s.optString("t"), s.optString("s"));
                }
                this.f39019a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.c.d
            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f39018a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f39019a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39019a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f39018a);
                a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(f39018a);
                return true;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f39018a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0493a(iBinder);
        }
    }

    void a(b bVar) throws RemoteException;
}
