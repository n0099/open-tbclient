package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class d extends ai.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo166a() {
        return 100888;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a;
        ExecutorService executorService;
        a = this.a.a();
        if (a > 0) {
            executorService = this.a.f17a;
            executorService.execute(new e(this));
        }
    }
}
