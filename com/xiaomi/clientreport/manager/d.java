package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f14075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f14075a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo185a() {
        return 100888;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2;
        ExecutorService executorService;
        a2 = this.f14075a.a();
        if (a2 > 0) {
            executorService = this.f14075a.f96a;
            executorService.execute(new e(this));
        }
    }
}
