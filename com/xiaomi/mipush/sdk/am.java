package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class am implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f49a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(Context context, Intent intent) {
        this.a = context;
        this.f49a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.a, this.f49a);
    }
}
