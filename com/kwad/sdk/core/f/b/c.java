package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes4.dex */
public interface c extends IInterface {

    /* loaded from: classes4.dex */
    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f9150a;

        public a(IBinder iBinder) {
            this.f9150a = iBinder;
        }

        @Override // com.kwad.sdk.core.f.b.c
        public String a() {
            String str = null;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.f9150a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return str;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9150a;
        }
    }

    String a();
}
