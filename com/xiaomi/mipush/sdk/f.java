package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f extends ak.a {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, String str) {
        super(i, str);
        this.a = eVar;
    }

    @Override // com.xiaomi.push.service.ak.a
    protected void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.a.f77a;
        boolean a = com.xiaomi.push.service.ak.a(context).a(hr.AggregatePushSwitch.a(), true);
        z = this.a.f80a;
        if (z != a) {
            this.a.f80a = a;
            context2 = this.a.f77a;
            h.b(context2);
        }
    }
}
