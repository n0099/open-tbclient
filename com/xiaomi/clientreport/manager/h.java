package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f8190a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bg f20a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bg bgVar) {
        this.f8190a = aVar;
        this.f20a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20a.run();
    }
}
