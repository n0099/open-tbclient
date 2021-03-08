package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerfClientReport f8185a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f19a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f19a = aVar;
        this.f8185a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19a.b(this.f8185a);
    }
}
