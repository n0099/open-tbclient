package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f14081a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bh f101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, bh bhVar) {
        this.f14081a = aVar;
        this.f101a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f101a.run();
    }
}
