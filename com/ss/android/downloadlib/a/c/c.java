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
import d.p.a.d.f.n;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface c extends IInterface {

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: a  reason: collision with root package name */
        public static String f39016a = "";

        /* renamed from: com.ss.android.downloadlib.a.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0492a implements c {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f39017a;

            public C0492a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.f39016a)) {
                    JSONObject s = n.s();
                    String unused = a.f39016a = d.p.a.e.a.h.b.b(s.optString(r.f7699a), s.optString("s"));
                }
                this.f39017a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.c.c
            public void a(b bVar, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f39016a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f39017a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39017a;
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(f39016a);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(f39016a);
            a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null, d.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f39016a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0492a(iBinder);
        }
    }

    void a(b bVar, d dVar) throws RemoteException;
}
