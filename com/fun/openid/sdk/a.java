package com.fun.openid.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.fun.openid.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC1073a extends Binder implements a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f5241a = 0;

        /* renamed from: com.fun.openid.sdk.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C1074a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f5242a;

            public C1074a(IBinder iBinder) {
                this.f5242a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5242a;
            }
        }
    }
}
