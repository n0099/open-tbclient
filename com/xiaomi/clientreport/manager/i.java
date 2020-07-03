package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bh f26a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, bh bhVar) {
        this.a = aVar;
        this.f26a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f26a.run();
    }
}
