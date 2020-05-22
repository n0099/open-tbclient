package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ad implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0859a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f38a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C0859a c0859a, hq hqVar) {
        this.a = c0859a;
        this.f38a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f33a.add(this.f38a);
        this.a.a();
    }
}
