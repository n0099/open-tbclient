package com.xiaomi.mipush.sdk;

import android.content.Context;
/* loaded from: classes7.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40501a;

    public y(Context context) {
        this.f40501a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.f40501a);
    }
}
