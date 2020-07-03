package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bg f25a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bg bgVar) {
        this.a = aVar;
        this.f25a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f25a.run();
    }
}
