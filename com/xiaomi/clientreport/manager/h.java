package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bn;
/* loaded from: classes6.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f38031a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ bn f37a;

    public h(a aVar, bn bnVar) {
        this.f38031a = aVar;
        this.f37a = bnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f37a.run();
    }
}
