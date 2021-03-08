package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes5.dex */
class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8329a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f227a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f228a = dsVar;
        this.f8329a = context;
        this.f227a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f228a.b(this.f8329a, this.f227a);
    }
}
