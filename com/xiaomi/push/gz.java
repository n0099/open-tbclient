package com.xiaomi.push;

import com.xiaomi.push.am;
/* loaded from: classes9.dex */
public final class gz extends am.b {
    public final /* synthetic */ Runnable a;

    public gz(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.push.am.b
    public void b() {
        this.a.run();
    }
}
