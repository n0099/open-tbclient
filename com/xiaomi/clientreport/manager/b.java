package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {
    final /* synthetic */ EventClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f20a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f20a = aVar;
        this.a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20a.b(this.a);
    }
}
