package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes8.dex */
class dt implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f226a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f227a = dsVar;
        this.a = context;
        this.f226a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f227a.b(this.a, this.f226a);
    }
}
