package com.xiaomi.push;
/* loaded from: classes5.dex */
class fw implements Runnable {
    final /* synthetic */ ft a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(ft ftVar, String str) {
        this.a = ftVar;
        this.f400a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu.a().a(this.f400a, true);
    }
}
