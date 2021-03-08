package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f8188a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f8188a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo170a() {
        return 100889;
    }

    @Override // java.lang.Runnable
    public void run() {
        int b;
        ExecutorService executorService;
        b = this.f8188a.b();
        if (b > 0) {
            executorService = this.f8188a.f17a;
            executorService.execute(new g(this));
        }
    }
}
