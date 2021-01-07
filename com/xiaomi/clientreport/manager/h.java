package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f14080a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bg f100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bg bgVar) {
        this.f14080a = aVar;
        this.f100a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f100a.run();
    }
}
