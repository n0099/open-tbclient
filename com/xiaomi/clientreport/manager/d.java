package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class d extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f38027a;

    public d(a aVar) {
        this.f38027a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo172a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2;
        ExecutorService executorService;
        a2 = this.f38027a.a();
        if (a2 > 0) {
            executorService = this.f38027a.f34a;
            executorService.execute(new e(this));
        }
    }
}
