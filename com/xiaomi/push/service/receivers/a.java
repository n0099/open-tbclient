package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes6.dex */
class a implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f932a = networkStatusReceiver;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f932a.a(this.a);
    }
}
