package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes8.dex */
class Cdo implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f242a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dn f243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dn dnVar, Context context, Intent intent) {
        this.f243a = dnVar;
        this.a = context;
        this.f242a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f243a.b(this.a, this.f242a);
    }
}
