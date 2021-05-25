package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0367a implements a {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f32213a;

        public C0367a(IBinder iBinder) {
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.f32213a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
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
            return this.f32213a;
        }
    }
}
