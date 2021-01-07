package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventClientReport f14074a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f98a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f98a = aVar;
        this.f14074a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f98a.b(this.f14074a);
    }
}
