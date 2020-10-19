package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes12.dex */
class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4866a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f228a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ds f229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, Context context, Intent intent) {
        this.f229a = dsVar;
        this.f4866a = context;
        this.f228a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f229a.b(this.f4866a, this.f228a);
    }
}
