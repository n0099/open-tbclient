package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes18.dex */
final class gw extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f4936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw(Runnable runnable) {
        this.f4936a = runnable;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        this.f4936a.run();
    }
}
