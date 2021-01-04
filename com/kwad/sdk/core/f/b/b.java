package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes5.dex */
public interface b extends IInterface {

    /* loaded from: classes5.dex */
    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f9448a;

        public a(IBinder iBinder) {
            this.f9448a = iBinder;
        }

        public String a() {
            String str = null;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f9448a.transact(1, obtain, obtain2, 0);
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
            return this.f9448a;
        }

        public boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f9448a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    boolean z = obtain2.readInt() == 0;
                    obtain.recycle();
                    obtain2.recycle();
                    return z;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(e);
                    obtain.recycle();
                    obtain2.recycle();
                    return false;
                }
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }
    }
}
