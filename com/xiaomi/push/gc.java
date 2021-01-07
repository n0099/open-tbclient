package com.xiaomi.push;
/* loaded from: classes6.dex */
class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f14341a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.f14341a = fzVar;
        this.f464a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f464a, true);
    }
}
