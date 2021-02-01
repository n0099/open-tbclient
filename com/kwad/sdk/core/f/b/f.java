package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes3.dex */
public interface f extends IInterface {

    /* loaded from: classes3.dex */
    public static final class a implements f {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f9155a;

        public a(IBinder iBinder) {
            this.f9155a = iBinder;
        }

        @Override // com.kwad.sdk.core.f.b.f
        public String a() {
            String str = null;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                this.f9155a.transact(1, obtain, obtain2, 0);
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
            return this.f9155a;
        }
    }

    String a();
}
