package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public interface c extends IInterface {

    /* loaded from: classes6.dex */
    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f33914a;

        public a(IBinder iBinder) {
            this.f33914a = iBinder;
        }

        @Override // com.kwad.sdk.core.f.b.c
        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f33914a.transact(1, obtain, obtain2, 0);
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
            return this.f33914a;
        }
    }

    String a();
}
