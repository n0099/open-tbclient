package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements Runnable {
    final /* synthetic */ PerfClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f21a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f21a = aVar;
        this.a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21a.b(this.a);
    }
}
