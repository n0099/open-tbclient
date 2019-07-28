package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.misc.k;
import com.xiaomi.push.log.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d extends k.b {
    k.b a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.b = bVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.k.b
    public void b() {
        b.C0490b c0490b = (b.C0490b) this.b.a.peek();
        if (c0490b == null || !c0490b.d()) {
            return;
        }
        if (this.b.a.remove(c0490b)) {
            this.a = c0490b;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.k.b
    public void c() {
        if (this.a != null) {
            this.a.c();
        }
    }
}
