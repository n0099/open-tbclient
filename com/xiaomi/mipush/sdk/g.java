package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hk;
import com.xiaomi.push.service.aq;
/* loaded from: classes7.dex */
public class g extends aq.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f40483a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, String str) {
        super(i, str);
        this.f40483a = fVar;
    }

    @Override // com.xiaomi.push.service.aq.a
    public void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.f40483a.f86a;
        boolean a2 = com.xiaomi.push.service.aq.a(context).a(hk.AggregatePushSwitch.a(), true);
        z = this.f40483a.f89a;
        if (z != a2) {
            this.f40483a.f89a = a2;
            context2 = this.f40483a.f86a;
            i.b(context2);
        }
    }
}
