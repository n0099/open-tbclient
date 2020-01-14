package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class al implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0745a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f39a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(MiTinyDataClient.a.C0745a c0745a, hk hkVar) {
        this.a = c0745a;
        this.f39a = hkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f32a.add(this.f39a);
        this.a.a();
    }
}
