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
/* loaded from: classes6.dex */
public interface c extends IInterface {

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: a  reason: collision with root package name */
        public static String f38631a = "";

        /* renamed from: com.ss.android.downloadlib.a.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0474a implements c {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f38632a;

            public C0474a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.f38631a)) {
                    JSONObject s = n.s();
                    String unused = a.f38631a = d.o.a.e.a.h.b.b(s.optString(r.f7663a), s.optString("s"));
                }
                this.f38632a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.c.c
            public void a(b bVar, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f38631a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f38632a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38632a;
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(f38631a);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(f38631a);
            a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null, d.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f38631a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0474a(iBinder);
        }
    }

    void a(b bVar, d dVar) throws RemoteException;
}
