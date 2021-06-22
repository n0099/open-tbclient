package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
public final class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f41016a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f59a;

    public ak(Context context, Intent intent) {
        this.f41016a = context;
        this.f59a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.b(this.f41016a, this.f59a);
    }
}
