package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.h;
/* loaded from: classes3.dex */
class j implements Runnable {
    final /* synthetic */ h.b a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, h.b bVar) {
        this.b = hVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
