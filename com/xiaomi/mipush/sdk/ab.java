package com.xiaomi.mipush.sdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Context context) {
        this.f14096a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.f14096a);
    }
}
