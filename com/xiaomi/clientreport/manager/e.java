package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bb f20a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, bb bbVar) {
        this.a = aVar;
        this.f20a = bbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20a.run();
    }
}
