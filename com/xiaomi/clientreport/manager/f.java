package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public class f extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f40985a;

    public f(a aVar) {
        this.f40985a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo170a() {
        return "100889";
    }

    @Override // java.lang.Runnable
    public void run() {
        int b2;
        ExecutorService executorService;
        b2 = this.f40985a.b();
        if (b2 > 0) {
            executorService = this.f40985a.f34a;
            executorService.execute(new g(this));
        }
    }
}
