package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.log.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends h.b {
    h.b a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.b = bVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void b() {
        b.C0141b c0141b = (b.C0141b) this.b.a.peek();
        if (c0141b == null || !c0141b.d()) {
            return;
        }
        this.a = (h.b) this.b.a.remove();
        this.a.b();
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void c() {
        if (this.a != null) {
            this.a.c();
        }
    }
}
