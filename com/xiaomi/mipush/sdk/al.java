package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class al implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0590a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f35a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(MiTinyDataClient.a.C0590a c0590a, hk hkVar) {
        this.a = c0590a;
        this.f35a = hkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f28a.add(this.f35a);
        this.a.a();
    }
}
