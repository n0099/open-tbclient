package com.kwad.sdk.core.f.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
/* loaded from: classes5.dex */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0388a implements a {
        public IBinder Zy;

        public C0388a(IBinder iBinder) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.Zy;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.Zy.transact(3, obtain, obtain2, 0);
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
    }
}
