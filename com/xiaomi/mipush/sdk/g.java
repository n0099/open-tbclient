package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hm;
import com.xiaomi.push.service.ba;
/* loaded from: classes10.dex */
public class g extends ba.a {
    public final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, String str) {
        super(i, str);
        this.a = fVar;
    }

    @Override // com.xiaomi.push.service.ba.a
    public void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.a.f76a;
        boolean a = ba.a(context).a(hm.AggregatePushSwitch.a(), true);
        z = this.a.f79a;
        if (z != a) {
            this.a.f79a = a;
            context2 = this.a.f76a;
            i.b(context2);
        }
    }
}
