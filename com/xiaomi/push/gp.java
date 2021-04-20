package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes7.dex */
public final class gp extends al.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f40891a;

    public gp(Runnable runnable) {
        this.f40891a = runnable;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        this.f40891a.run();
    }
}
