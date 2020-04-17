package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.eu;
import com.xiaomi.push.service.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class aj extends ag.a {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(int i, String str, Context context) {
        super(i, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.ag.a
    protected void a() {
        eu.m264a(this.a);
    }
}
