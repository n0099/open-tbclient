package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C0962a f4744a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f40a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MiTinyDataClient.a.C0962a c0962a, hq hqVar) {
        this.f4744a = c0962a;
        this.f40a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4744a.f35a.add(this.f40a);
        this.f4744a.a();
    }
}
