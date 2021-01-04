package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14104a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(Context context, Intent intent) {
        this.f14104a = context;
        this.f122a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.f14104a, this.f122a);
    }
}
