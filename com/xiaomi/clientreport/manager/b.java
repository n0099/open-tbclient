package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventClientReport f40981a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f35a;

    public b(a aVar, EventClientReport eventClientReport) {
        this.f35a = aVar;
        this.f40981a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f35a.b(this.f40981a);
    }
}
