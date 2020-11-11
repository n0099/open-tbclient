package com.xiaomi.mipush.sdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Context context) {
        this.f4743a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.f4743a);
    }
}
