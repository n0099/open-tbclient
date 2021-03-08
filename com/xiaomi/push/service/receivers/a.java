package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes5.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8579a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f928a = networkStatusReceiver;
        this.f8579a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f928a.a(this.f8579a);
    }
}
