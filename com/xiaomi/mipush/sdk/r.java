package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ek;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class r extends ag.a {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i, String str, Context context) {
        super(i, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.ag.a
    protected void a() {
        ek.a(this.a).a(com.xiaomi.push.service.ag.a(this.a).a(hl.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
