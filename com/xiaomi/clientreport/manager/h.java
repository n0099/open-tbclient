package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bp;
/* loaded from: classes10.dex */
public class h implements Runnable {
    public final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ bp f30a;

    public h(a aVar, bp bpVar) {
        this.a = aVar;
        this.f30a = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f30a.run();
    }
}
