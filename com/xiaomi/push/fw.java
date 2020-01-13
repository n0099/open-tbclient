package com.xiaomi.push;
/* loaded from: classes6.dex */
class fw implements Runnable {
    final /* synthetic */ ft a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(ft ftVar, String str) {
        this.a = ftVar;
        this.f398a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu.a().a(this.f398a, true);
    }
}
