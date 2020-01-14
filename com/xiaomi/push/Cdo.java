package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes6.dex */
class Cdo implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f245a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dn f246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dn dnVar, Context context, Intent intent) {
        this.f246a = dnVar;
        this.a = context;
        this.f245a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f246a.b(this.a, this.f245a);
    }
}
