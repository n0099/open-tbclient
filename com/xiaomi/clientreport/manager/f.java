package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class f extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f4495a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo159a() {
        return 100889;
    }

    @Override // java.lang.Runnable
    public void run() {
        int b;
        ExecutorService executorService;
        b = this.f4495a.b();
        if (b > 0) {
            executorService = this.f4495a.f18a;
            executorService.execute(new g(this));
        }
    }
}
