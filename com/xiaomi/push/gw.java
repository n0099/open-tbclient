package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes6.dex */
final class gw extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f14071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw(Runnable runnable) {
        this.f14071a = runnable;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        this.f14071a.run();
    }
}
