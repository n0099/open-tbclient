package com.meizu.cloud.pushsdk.networking.a;

import com.meizu.cloud.pushsdk.networking.common.Priority;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class a extends ThreadPoolExecutor {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, ThreadFactory threadFactory) {
        super(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        C0267a c0267a = new C0267a((com.meizu.cloud.pushsdk.networking.d.c) runnable);
        execute(c0267a);
        return c0267a;
    }

    /* renamed from: com.meizu.cloud.pushsdk.networking.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0267a extends FutureTask<com.meizu.cloud.pushsdk.networking.d.c> implements Comparable<C0267a> {
        private final com.meizu.cloud.pushsdk.networking.d.c a;

        public C0267a(com.meizu.cloud.pushsdk.networking.d.c cVar) {
            super(cVar, null);
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0267a c0267a) {
            Priority a = this.a.a();
            Priority a2 = c0267a.a.a();
            return a == a2 ? this.a.a - c0267a.a.a : a2.ordinal() - a.ordinal();
        }
    }
}
