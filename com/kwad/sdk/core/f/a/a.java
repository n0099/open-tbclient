package com.kwad.sdk.core.f.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
/* loaded from: classes5.dex */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0307a implements a {
        public IBinder a;

        public C0307a(IBinder iBinder) {
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(e);
                    obtain.recycle();
                    obtain2.recycle();
                    return null;
                }
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }
    }
}
