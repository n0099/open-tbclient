package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes7.dex */
public final class gp extends al.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f40986a;

    public gp(Runnable runnable) {
        this.f40986a = runnable;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        this.f40986a.run();
    }
}
