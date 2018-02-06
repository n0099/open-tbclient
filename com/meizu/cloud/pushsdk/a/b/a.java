package com.meizu.cloud.pushsdk.a.b;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a extends ThreadPoolExecutor {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, ThreadFactory threadFactory) {
        super(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        C0264a c0264a = new C0264a((com.meizu.cloud.pushsdk.a.f.c) runnable);
        execute(c0264a);
        return c0264a;
    }

    /* renamed from: com.meizu.cloud.pushsdk.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0264a extends FutureTask<com.meizu.cloud.pushsdk.a.f.c> implements Comparable<C0264a> {
        private final com.meizu.cloud.pushsdk.a.f.c a;

        public C0264a(com.meizu.cloud.pushsdk.a.f.c cVar) {
            super(cVar, null);
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0264a c0264a) {
            com.meizu.cloud.pushsdk.a.a.d a = this.a.a();
            com.meizu.cloud.pushsdk.a.a.d a2 = c0264a.a.a();
            return a == a2 ? this.a.a - c0264a.a.a : a2.ordinal() - a.ordinal();
        }
    }
}
