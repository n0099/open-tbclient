package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes12.dex */
class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4864a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f225a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f226a = dsVar;
        this.f4864a = context;
        this.f225a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f226a.b(this.f4864a, this.f225a);
    }
}
