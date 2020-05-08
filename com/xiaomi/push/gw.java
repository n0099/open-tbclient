package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes8.dex */
final class gw extends al.b {
    final /* synthetic */ Runnable a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        this.a.run();
    }
}
