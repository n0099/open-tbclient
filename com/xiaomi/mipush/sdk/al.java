package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class al implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0705a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f40a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(MiTinyDataClient.a.C0705a c0705a, hk hkVar) {
        this.a = c0705a;
        this.f40a = hkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f33a.add(this.f40a);
        this.a.a();
    }
}
