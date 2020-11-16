package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class f extends ak.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f4766a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, String str) {
        super(i, str);
        this.f4766a = eVar;
    }

    @Override // com.xiaomi.push.service.ak.a
    protected void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.f4766a.f75a;
        boolean a2 = com.xiaomi.push.service.ak.a(context).a(hr.AggregatePushSwitch.a(), true);
        z = this.f4766a.f78a;
        if (z != a2) {
            this.f4766a.f78a = a2;
            context2 = this.f4766a.f75a;
            h.b(context2);
        }
    }
}
