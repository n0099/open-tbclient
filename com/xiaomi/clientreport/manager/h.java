package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4727a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bg f23a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bg bgVar) {
        this.f4727a = aVar;
        this.f23a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f23a.run();
    }
}
