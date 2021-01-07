package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerfClientReport f14075a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f99a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f99a = aVar;
        this.f14075a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f99a.b(this.f14075a);
    }
}
