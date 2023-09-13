package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
/* loaded from: classes10.dex */
public class b implements Runnable {
    public final /* synthetic */ EventClientReport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f27a;

    public b(a aVar, EventClientReport eventClientReport) {
        this.f27a = aVar;
        this.a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27a.b(this.a);
    }
}
