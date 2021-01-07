package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes6.dex */
class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14254a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f307a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f308a = dsVar;
        this.f14254a = context;
        this.f307a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f308a.b(this.f14254a, this.f307a);
    }
}
