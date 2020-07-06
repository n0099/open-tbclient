package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes8.dex */
class dt implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f233a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f234a = dsVar;
        this.a = context;
        this.f233a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f234a.b(this.a, this.f233a);
    }
}
