package com.xiaomi.push;
/* loaded from: classes12.dex */
class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f4917a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.f4917a = fzVar;
        this.f382a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f382a, true);
    }
}
