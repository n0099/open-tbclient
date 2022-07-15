package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes5.dex */
public interface b extends IInterface {

    /* loaded from: classes5.dex */
    public static final class a implements b {
        public IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception unused) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.a;
        }

        public final boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
            obtain.recycle();
            obtain2.recycle();
            return z;
        }
    }
}
