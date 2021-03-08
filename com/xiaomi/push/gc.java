package com.xiaomi.push;
/* loaded from: classes5.dex */
class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fz f8382a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fz fzVar, String str) {
        this.f8382a = fzVar;
        this.f384a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.a().a(this.f384a, true);
    }
}
