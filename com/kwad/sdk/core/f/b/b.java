package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes7.dex */
public interface b extends IInterface {

    /* loaded from: classes7.dex */
    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f34347a;

        public a(IBinder iBinder) {
            this.f34347a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    this.f34347a.transact(1, obtain, obtain2, 0);
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
            return this.f34347a;
        }

        public boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    this.f34347a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = true;
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                return z;
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
    }
}
