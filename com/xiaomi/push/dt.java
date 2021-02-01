package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes6.dex */
class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f13956a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f306a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f307a = dsVar;
        this.f13956a = context;
        this.f306a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f307a.b(this.f13956a, this.f306a);
    }
}
