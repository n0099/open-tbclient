package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* loaded from: classes10.dex */
public class c implements Runnable {
    public final /* synthetic */ PerfClientReport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f28a;

    public c(a aVar, PerfClientReport perfClientReport) {
        this.f28a = aVar;
        this.a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f28a.b(this.a);
    }
}
