package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventClientReport f13774a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f97a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f97a = aVar;
        this.f13774a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f97a.b(this.f13774a);
    }
}
