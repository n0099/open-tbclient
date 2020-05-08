package com.xiaomi.push;
/* loaded from: classes8.dex */
class gc implements Runnable {
    final /* synthetic */ fz a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.a = fzVar;
        this.f383a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f383a, true);
    }
}
