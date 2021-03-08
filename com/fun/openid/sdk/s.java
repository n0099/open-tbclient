package com.fun.openid.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes3.dex */
public interface s extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements s {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f5251a = 0;

        /* renamed from: com.fun.openid.sdk.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C1075a implements s {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f5252a;

            public C1075a(IBinder iBinder) {
                this.f5252a = iBinder;
            }

            @Override // com.fun.openid.sdk.s
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f5252a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5252a;
            }

            @Override // com.fun.openid.sdk.s
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f5252a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    boolean a();

    String b();
}
