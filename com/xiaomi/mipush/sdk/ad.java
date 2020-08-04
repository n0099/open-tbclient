package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ad implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0889a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f44a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C0889a c0889a, hq hqVar) {
        this.a = c0889a;
        this.f44a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f39a.add(this.f44a);
        this.a.a();
    }
}
