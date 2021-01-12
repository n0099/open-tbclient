package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f13781a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bh f100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, bh bhVar) {
        this.f13781a = aVar;
        this.f100a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f100a.run();
    }
}
