package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ba f14a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ba baVar) {
        this.a = aVar;
        this.f14a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14a.run();
    }
}
