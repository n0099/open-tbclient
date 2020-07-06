package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ad implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0880a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f45a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C0880a c0880a, hq hqVar) {
        this.a = c0880a;
        this.f45a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f40a.add(this.f45a);
        this.a.a();
    }
}
