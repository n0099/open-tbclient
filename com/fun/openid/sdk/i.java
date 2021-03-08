package com.fun.openid.sdk;

import android.content.Context;
import android.content.Intent;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.h;
import com.fun.openid.sdk.v;
/* loaded from: classes3.dex */
public class i implements h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5246a = false;

    /* loaded from: classes3.dex */
    public class a implements v.a<String> {
        public final /* synthetic */ h.a pRg;

        public a(h.a aVar) {
            this.pRg = aVar;
        }
    }

    @Override // com.fun.openid.sdk.h
    public void a(Context context, h.a aVar) {
        if (this.f5246a) {
            return;
        }
        v vVar = new v();
        a aVar2 = new a(aVar);
        vVar.f5254a = context;
        vVar.pRp = aVar2;
        vVar.c = new u(vVar);
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        char c = vVar.f5254a.bindService(intent, vVar.c, 1) ? (char) 1 : (char) 65535;
        this.f5246a = true;
        if (c != 1) {
            ((g.a) aVar).a(true, null);
        }
    }
}
