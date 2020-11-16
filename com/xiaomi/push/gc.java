package com.xiaomi.push;
/* loaded from: classes18.dex */
class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f4919a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.f4919a = fzVar;
        this.f387a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f387a, true);
    }
}
