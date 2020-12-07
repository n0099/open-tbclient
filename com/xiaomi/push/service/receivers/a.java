package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes18.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4886a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f929a = networkStatusReceiver;
        this.f4886a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f929a.a(this.f4886a);
    }
}
