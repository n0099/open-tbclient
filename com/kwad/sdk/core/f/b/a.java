package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1095a implements a {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f9150a;

        public C1095a(IBinder iBinder) {
        }

        public String a() {
            String str = null;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f9150a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
            return str;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9150a;
        }
    }
}
