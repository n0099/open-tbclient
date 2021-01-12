package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1277a f13798a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C1277a c1277a, hq hqVar) {
        this.f13798a = c1277a;
        this.f118a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13798a.f113a.add(this.f118a);
        this.f13798a.a();
    }
}
