package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventClientReport f4721a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f19a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f19a = aVar;
        this.f4721a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19a.b(this.f4721a);
    }
}
