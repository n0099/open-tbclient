package com.xiaomi.push;
/* loaded from: classes7.dex */
class gc implements Runnable {
    final /* synthetic */ fz a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.a = fzVar;
        this.f385a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f385a, true);
    }
}
