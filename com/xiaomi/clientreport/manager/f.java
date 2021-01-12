package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f13778a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f13778a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo192a() {
        return 100889;
    }

    @Override // java.lang.Runnable
    public void run() {
        int b2;
        ExecutorService executorService;
        b2 = this.f13778a.b();
        if (b2 > 0) {
            executorService = this.f13778a.f96a;
            executorService.execute(new g(this));
        }
    }
}
