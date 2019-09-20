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
        b.C0496b c0496b = (b.C0496b) this.b.a.peek();
        if (c0496b == null || !c0496b.d()) {
            return;
        }
        if (this.b.a.remove(c0496b)) {
            this.a = c0496b;
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
