package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventClientReport f8184a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f18a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f18a = aVar;
        this.f8184a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18a.b(this.f8184a);
    }
}
