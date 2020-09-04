package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ad implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0947a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f40a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C0947a c0947a, hq hqVar) {
        this.a = c0947a;
        this.f40a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f35a.add(this.f40a);
        this.a.a();
    }
}
