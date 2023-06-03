package com.xiaomi.clientreport.manager;

import com.xiaomi.push.aj;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public class d extends aj.a {
    public final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo295a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public void run() {
        int a;
        ExecutorService executorService;
        a = this.a.a();
        if (a > 0) {
            executorService = this.a.f26a;
            executorService.execute(new e(this));
        }
    }
}
