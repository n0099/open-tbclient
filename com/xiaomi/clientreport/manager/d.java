package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d extends ai.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo164a() {
        return 100888;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a;
        ExecutorService executorService;
        a = this.a.a();
        if (a > 0) {
            executorService = this.a.f16a;
            executorService.execute(new e(this));
        }
    }
}
