package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
class dt implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f228a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f229a = dsVar;
        this.a = context;
        this.f228a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f229a.b(this.a, this.f228a);
    }
}
