package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4748a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f41a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(Context context, Intent intent) {
        this.f4748a = context;
        this.f41a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.f4748a, this.f41a);
    }
}
