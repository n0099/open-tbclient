package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerfClientReport f4492a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f20a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f20a = aVar;
        this.f4492a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20a.b(this.f4492a);
    }
}
