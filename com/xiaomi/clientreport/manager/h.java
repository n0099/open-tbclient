package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4497a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bg f21a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bg bgVar) {
        this.f4497a = aVar;
        this.f21a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21a.run();
    }
}
