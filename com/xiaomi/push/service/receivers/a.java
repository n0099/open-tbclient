package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes12.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f5116a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f928a = networkStatusReceiver;
        this.f5116a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f928a.a(this.f5116a);
    }
}
