package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes18.dex */
class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4866a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f230a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f231a = dsVar;
        this.f4866a = context;
        this.f230a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f231a.b(this.f4866a, this.f230a);
    }
}
