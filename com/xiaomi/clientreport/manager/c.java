package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerfClientReport f4722a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f19a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f19a = aVar;
        this.f4722a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19a.b(this.f4722a);
    }
}
