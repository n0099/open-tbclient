package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerfClientReport f14074a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f98a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f98a = aVar;
        this.f14074a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f98a.b(this.f14074a);
    }
}
