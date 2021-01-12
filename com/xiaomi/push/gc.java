package com.xiaomi.push;
/* loaded from: classes6.dex */
class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f14041a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.f14041a = fzVar;
        this.f463a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f463a, true);
    }
}
