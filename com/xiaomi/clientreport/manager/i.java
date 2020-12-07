package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4498a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bh f22a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, bh bhVar) {
        this.f4498a = aVar;
        this.f22a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22a.run();
    }
}
