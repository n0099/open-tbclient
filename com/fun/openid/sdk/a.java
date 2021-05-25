package com.fun.openid.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: com.fun.openid.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractBinderC0330a extends Binder implements a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f30704a = 0;

        /* renamed from: com.fun.openid.sdk.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0331a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f30705a;

            public C0331a(IBinder iBinder) {
                this.f30705a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30705a;
            }
        }
    }
}
