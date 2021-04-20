package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public interface f extends IInterface {

    /* loaded from: classes6.dex */
    public static final class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f33917a;

        public a(IBinder iBinder) {
            this.f33917a = iBinder;
        }

        @Override // com.kwad.sdk.core.f.b.f
        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f33917a.transact(1, obtain, obtain2, 0);
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
            return this.f33917a;
        }
    }

    String a();
}
