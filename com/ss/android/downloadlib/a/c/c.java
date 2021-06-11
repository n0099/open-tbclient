package com.ss.android.downloadlib.a.c;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.ss.android.downloadlib.a.c.d;
import d.o.a.d.f.n;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface c extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: a  reason: collision with root package name */
        public static String f39454a = "";

        /* renamed from: com.ss.android.downloadlib.a.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0475a implements c {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f39455a;

            public C0475a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.f39454a)) {
                    JSONObject s = n.s();
                    String unused = a.f39454a = d.o.a.e.a.h.b.b(s.optString(r.f7715a), s.optString("s"));
                }
                this.f39455a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.c.c
            public void a(b bVar, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f39454a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f39455a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39455a;
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f39454a);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(f39454a);
            a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null, d.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f39454a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0475a(iBinder);
        }
    }

    void a(b bVar, d dVar) throws RemoteException;
}
