package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1034a f4742a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f37a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C1034a c1034a, hq hqVar) {
        this.f4742a = c1034a;
        this.f37a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4742a.f32a.add(this.f37a);
        this.f4742a.a();
    }
}
