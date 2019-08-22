package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m implements Runnable {
    final /* synthetic */ k.b a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, k.b bVar) {
        this.b = kVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
