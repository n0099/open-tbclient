package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bb f18a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, bb bbVar) {
        this.a = aVar;
        this.f18a = bbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18a.run();
    }
}
