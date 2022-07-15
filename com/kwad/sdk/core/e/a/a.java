package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
/* loaded from: classes5.dex */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0541a implements a {
        public IBinder a;

        public C0541a(IBinder iBinder) {
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.a.transact(3, obtain, obtain2, 0);
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
    }
}
