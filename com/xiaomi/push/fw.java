package com.xiaomi.push;
/* loaded from: classes3.dex */
class fw implements Runnable {
    final /* synthetic */ ft a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(ft ftVar, String str) {
        this.a = ftVar;
        this.f395a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu.a().a(this.f395a, true);
    }
}
