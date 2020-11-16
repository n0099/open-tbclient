package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1057a f4744a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f42a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C1057a c1057a, hq hqVar) {
        this.f4744a = c1057a;
        this.f42a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4744a.f37a.add(this.f42a);
        this.f4744a.a();
    }
}
