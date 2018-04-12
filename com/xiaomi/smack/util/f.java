package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.h;
/* loaded from: classes3.dex */
final class f extends h.b {
    final /* synthetic */ Runnable a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void b() {
        this.a.run();
    }
}
