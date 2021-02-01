package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.i;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class g<T> extends d<List<T>, T> {
    private Executor d;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    /* renamed from: a */
    public final Object a_(final b<T> bVar, List<T> list) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        final CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        for (final T t : list) {
            this.d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            copyOnWriteArrayList.add(bVar.a((b) t));
                            countDownLatch.countDown();
                        } catch (i.a e) {
                            Throwable cause = e.getCause();
                            copyOnWriteArrayList2.add(cause);
                            g.this.d(cause);
                            countDownLatch.countDown();
                        } catch (Throwable th) {
                            copyOnWriteArrayList2.add(th);
                            g.this.d(th);
                            countDownLatch.countDown();
                        }
                    } catch (Throwable th2) {
                        countDownLatch.countDown();
                        throw th2;
                    }
                }
            });
        }
        countDownLatch.await();
        if (copyOnWriteArrayList2.isEmpty()) {
            return copyOnWriteArrayList;
        }
        throw new com.bytedance.sdk.openadsdk.preload.a.a.a(copyOnWriteArrayList2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    public void a(Object... objArr) {
        super.a(objArr);
        if (objArr != null) {
            if (objArr.length != 1) {
                throw new IllegalArgumentException("ParallelInterceptor only need one param");
            }
            if (!(objArr[0] instanceof Executor)) {
                throw new IllegalArgumentException("ParallelInterceptor args must be instance of Executor");
            }
            this.d = (Executor) objArr[0];
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.d = threadPoolExecutor;
    }
}
