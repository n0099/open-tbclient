package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f extends ai.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo160a() {
        return 100889;
    }

    @Override // java.lang.Runnable
    public void run() {
        int b;
        ExecutorService executorService;
        b = this.a.b();
        if (b > 0) {
            executorService = this.a.f23a;
            executorService.execute(new g(this));
        }
    }
}
