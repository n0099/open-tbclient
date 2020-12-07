package com.xiaomi.push;
/* loaded from: classes18.dex */
class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f4689a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.f4689a = fzVar;
        this.f385a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f385a, true);
    }
}
