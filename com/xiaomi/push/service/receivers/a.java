package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes10.dex */
public class a implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ NetworkStatusReceiver f1003a;

    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f1003a = networkStatusReceiver;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1003a.a(this.a);
    }
}
