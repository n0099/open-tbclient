package com.xiaomi.mipush.sdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ae implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = MiPushClient.sContext;
        MiPushClient.initialize(context, this.a, this.b, null);
    }
}
