package com.xiaomi.clientreport.manager;

import com.xiaomi.push.aj;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public class f extends aj.a {
    public final /* synthetic */ a a;

    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo310a() {
        return "100889";
    }

    @Override // java.lang.Runnable
    public void run() {
        int b;
        ExecutorService executorService;
        b = this.a.b();
        if (b > 0) {
            executorService = this.a.f22a;
            executorService.execute(new g(this));
        }
    }
}
