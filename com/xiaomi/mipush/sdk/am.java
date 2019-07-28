package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class am implements Runnable {
    final /* synthetic */ com.xiaomi.xmpush.thrift.f a;
    final /* synthetic */ MiTinyDataClient.a.C0489a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MiTinyDataClient.a.C0489a c0489a, com.xiaomi.xmpush.thrift.f fVar) {
        this.b = c0489a;
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a.add(this.a);
        this.b.a();
    }
}
