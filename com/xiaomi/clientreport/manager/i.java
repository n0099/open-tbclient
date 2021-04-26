package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bo;
/* loaded from: classes6.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f38032a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ bo f38a;

    public i(a aVar, bo boVar) {
        this.f38032a = aVar;
        this.f38a = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f38a.run();
    }
}
