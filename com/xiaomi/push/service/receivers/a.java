package com.xiaomi.push.service.receivers;

import android.content.Context;
/* loaded from: classes7.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f38237a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ NetworkStatusReceiver f971a;

    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f971a = networkStatusReceiver;
        this.f38237a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f971a.a(this.f38237a);
    }
}
