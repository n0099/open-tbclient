package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ad implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0944a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f39a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C0944a c0944a, hq hqVar) {
        this.a = c0944a;
        this.f39a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f34a.add(this.f39a);
        this.a.a();
    }
}
