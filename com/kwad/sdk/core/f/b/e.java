package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes7.dex */
public interface e extends IInterface {

    /* loaded from: classes7.dex */
    public static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f34350a;

        public a(IBinder iBinder) {
            this.f34350a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f34350a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f34350a;
        }
    }
}
