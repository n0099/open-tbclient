package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1265a f8207a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f39a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C1265a c1265a, hq hqVar) {
        this.f8207a = c1265a;
        this.f39a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8207a.f34a.add(this.f39a);
        this.f8207a.a();
    }
}
