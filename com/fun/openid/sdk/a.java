package com.fun.openid.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: com.fun.openid.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractBinderC0344a extends Binder implements a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f30828a = 0;

        /* renamed from: com.fun.openid.sdk.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0345a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f30829a;

            public C0345a(IBinder iBinder) {
                this.f30829a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30829a;
            }
        }
    }
}
