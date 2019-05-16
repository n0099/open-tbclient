package com.xiaomi.push.service.awake;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, String str, int i, String str2) {
        this.a = context;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.c(this.a, this.b, this.c, this.d);
    }
}
