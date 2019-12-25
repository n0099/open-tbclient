package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes5.dex */
class Cdo implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f246a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dn f247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dn dnVar, Context context, Intent intent) {
        this.f247a = dnVar;
        this.a = context;
        this.f246a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f247a.b(this.a, this.f246a);
    }
}
