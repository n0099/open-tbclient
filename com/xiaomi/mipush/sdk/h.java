package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class h extends ag.a {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i, String str) {
        super(i, str);
        this.a = gVar;
    }

    @Override // com.xiaomi.push.service.ag.a
    protected void a() {
        Context context;
        boolean z;
        Context context2;
        context = this.a.f73a;
        boolean a = com.xiaomi.push.service.ag.a(context).a(hl.AggregatePushSwitch.a(), true);
        z = this.a.f76a;
        if (z != a) {
            this.a.f76a = a;
            context2 = this.a.f73a;
            j.b(context2);
        }
    }
}
