package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bq;
/* loaded from: classes10.dex */
public class i implements Runnable {
    public final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ bq f31a;

    public i(a aVar, bq bqVar) {
        this.a = aVar;
        this.f31a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31a.run();
    }
}
