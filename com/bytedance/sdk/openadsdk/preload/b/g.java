package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.i;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class g<T> extends d<List<T>, T> {

    /* renamed from: d  reason: collision with root package name */
    public Executor f30118d;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public final Object a_(final b<T> bVar, List<T> list) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        final CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        for (final T t : list) {
            this.f30118d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.b.g.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            copyOnWriteArrayList.add(bVar.a((b) t));
                        } catch (i.a e2) {
                            Throwable cause = e2.getCause();
                            copyOnWriteArrayList2.add(cause);
                            g.this.d(cause);
                        }
                        countDownLatch.countDown();
                    }
                }
            });
        }
        countDownLatch.await();
        if (copyOnWriteArrayList2.isEmpty()) {
            return copyOnWriteArrayList;
        }
        throw new com.bytedance.sdk.openadsdk.preload.b.a.a(copyOnWriteArrayList2);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        super.a(objArr);
        if (objArr != null) {
            if (objArr.length == 1) {
                if (objArr[0] instanceof Executor) {
                    this.f30118d = (Executor) objArr[0];
                    return;
                }
                throw new IllegalArgumentException("ParallelInterceptor args must be instance of Executor");
            }
            throw new IllegalArgumentException("ParallelInterceptor only need one param");
        }
        this.f30118d = com.bytedance.sdk.openadsdk.l.e.a();
    }
}
