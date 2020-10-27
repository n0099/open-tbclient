package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes12.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f5114a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f926a = networkStatusReceiver;
        this.f5114a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f926a.a(this.f5114a);
    }
}
