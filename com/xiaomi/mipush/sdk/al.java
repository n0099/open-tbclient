package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class al implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0753a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f36a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(MiTinyDataClient.a.C0753a c0753a, hk hkVar) {
        this.a = c0753a;
        this.f36a = hkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f29a.add(this.f36a);
        this.a.a();
    }
}
