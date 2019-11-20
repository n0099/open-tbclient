package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes3.dex */
class Cdo implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f241a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dn f242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dn dnVar, Context context, Intent intent) {
        this.f242a = dnVar;
        this.a = context;
        this.f241a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f242a.b(this.a, this.f241a);
    }
}
