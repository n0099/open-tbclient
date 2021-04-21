package com.fun.openid.sdk;

import android.content.Context;
import android.content.Intent;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import com.fun.openid.sdk.u;
/* loaded from: classes6.dex */
public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public boolean f30612a = false;

    /* loaded from: classes6.dex */
    public class a implements u.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f.a f30613a;

        public a(f.a aVar) {
            this.f30613a = aVar;
        }
    }

    @Override // com.fun.openid.sdk.f
    public void a(Context context, f.a aVar) {
        if (this.f30612a) {
            return;
        }
        u uVar = new u();
        a aVar2 = new a(aVar);
        uVar.f30636a = context;
        uVar.f30639d = aVar2;
        uVar.f30638c = new t(uVar);
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        char c2 = uVar.f30636a.bindService(intent, uVar.f30638c, 1) ? (char) 1 : (char) 65535;
        this.f30612a = true;
        if (c2 != 1) {
            ((e.a) aVar).a(true, null);
        }
    }
}
