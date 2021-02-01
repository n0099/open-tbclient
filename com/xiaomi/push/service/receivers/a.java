package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes6.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14320a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f1007a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f1007a = networkStatusReceiver;
        this.f14320a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1007a.a(this.f14320a);
    }
}
