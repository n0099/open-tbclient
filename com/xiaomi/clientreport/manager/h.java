package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4725a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bg f18a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bg bgVar) {
        this.f4725a = aVar;
        this.f18a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18a.run();
    }
}
