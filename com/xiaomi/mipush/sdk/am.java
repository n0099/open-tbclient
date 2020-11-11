package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4750a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f43a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(Context context, Intent intent) {
        this.f4750a = context;
        this.f43a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.f4750a, this.f43a);
    }
}
