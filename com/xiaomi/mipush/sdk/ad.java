package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1294a f14098a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C1294a c1294a, hq hqVar) {
        this.f14098a = c1294a;
        this.f119a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14098a.f114a.add(this.f119a);
        this.f14098a.a();
    }
}
