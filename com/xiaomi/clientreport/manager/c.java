package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
/* loaded from: classes6.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerfClientReport f38026a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f36a;

    public c(a aVar, PerfClientReport perfClientReport) {
        this.f36a = aVar;
        this.f38026a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f36a.b(this.f38026a);
    }
}
