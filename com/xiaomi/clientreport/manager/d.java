package com.xiaomi.clientreport.manager;

import com.xiaomi.push.ai;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public class d extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f40880a;

    public d(a aVar) {
        this.f40880a = aVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo170a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2;
        ExecutorService executorService;
        a2 = this.f40880a.a();
        if (a2 > 0) {
            executorService = this.f40880a.f34a;
            executorService.execute(new e(this));
        }
    }
}
