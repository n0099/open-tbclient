package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ad implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0860a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f38a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C0860a c0860a, hq hqVar) {
        this.a = c0860a;
        this.f38a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f33a.add(this.f38a);
        this.a.a();
    }
}
