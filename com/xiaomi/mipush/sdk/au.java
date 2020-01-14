package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class au implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f43a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(Context context, Intent intent) {
        this.a = context;
        this.f43a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.a, this.f43a);
    }
}
