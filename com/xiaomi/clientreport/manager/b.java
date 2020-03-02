package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.push.bd;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        IEventProcessor iEventProcessor;
        ExecutorService executorService;
        context = this.a.f8a;
        iEventProcessor = this.a.f10a;
        bd bdVar = new bd(context, iEventProcessor);
        executorService = this.a.f13a;
        executorService.execute(bdVar);
    }
}
