package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.k;
/* loaded from: classes3.dex */
final class f extends k.b {
    final /* synthetic */ Runnable a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.channel.commonutils.misc.k.b
    public void b() {
        this.a.run();
    }
}
