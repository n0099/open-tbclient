package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f13782a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bg f99a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bg bgVar) {
        this.f13782a = aVar;
        this.f99a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f99a.run();
    }
}
