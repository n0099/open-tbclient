package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f8191a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bh f21a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, bh bhVar) {
        this.f8191a = aVar;
        this.f21a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21a.run();
    }
}
