package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bq;
/* loaded from: classes8.dex */
public class i implements Runnable {
    public final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ bq f30a;

    public i(a aVar, bq bqVar) {
        this.a = aVar;
        this.f30a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f30a.run();
    }
}
