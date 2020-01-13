package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes6.dex */
class Cdo implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f244a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dn f245a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dn dnVar, Context context, Intent intent) {
        this.f245a = dnVar;
        this.a = context;
        this.f244a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f245a.b(this.a, this.f244a);
    }
}
