package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f extends ak.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f8229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, String str) {
        super(i, str);
        this.f8229a = eVar;
    }

    @Override // com.xiaomi.push.service.ak.a
    protected void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.f8229a.f72a;
        boolean a2 = com.xiaomi.push.service.ak.a(context).a(hr.AggregatePushSwitch.a(), true);
        z = this.f8229a.f75a;
        if (z != a2) {
            this.f8229a.f75a = a2;
            context2 = this.f8229a.f72a;
            h.b(context2);
        }
    }
}
