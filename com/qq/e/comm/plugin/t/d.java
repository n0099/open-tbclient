package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f12834a = new d();
    private PriorityBlockingQueue<Runnable> c = new PriorityBlockingQueue<>(15);

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f12835b = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.c);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a<T> extends FutureTask<T> implements Comparable<a<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final c.a f12837b;

        public a(Callable<T> callable, c.a aVar) {
            super(callable);
            this.f12837b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a<T> aVar) {
            if (aVar == null) {
                return 1;
            }
            return this.f12837b.a() - aVar.f12837b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Callable<com.qq.e.comm.plugin.t.b.f> {

        /* renamed from: a  reason: collision with root package name */
        final com.qq.e.comm.plugin.t.b.e f12838a;

        /* renamed from: b  reason: collision with root package name */
        final com.qq.e.comm.plugin.t.b f12839b;

        public b(com.qq.e.comm.plugin.t.b.e eVar) {
            this(eVar, null);
        }

        public b(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b bVar) {
            this.f12838a = eVar;
            this.f12839b = bVar;
        }

        private com.qq.e.comm.plugin.t.b.f b() throws Exception {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.qq.e.comm.plugin.t.a.b());
            return new com.qq.e.comm.plugin.t.a(0, arrayList, this.f12838a).a(this.f12838a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public com.qq.e.comm.plugin.t.b.f call() throws Exception {
            com.qq.e.comm.plugin.t.b.f fVar;
            try {
                fVar = b();
                e = null;
            } catch (Exception e) {
                e = e;
                fVar = null;
            }
            if (e == null) {
                if (this.f12839b != null) {
                    this.f12839b.a(this.f12838a, fVar);
                }
                if (this.f12838a.j()) {
                    fVar.c();
                }
            } else {
                if (fVar != null) {
                    fVar.c();
                }
                if (this.f12839b == null) {
                    throw e;
                }
                GDTLogger.w("NetworkClientException", e);
                this.f12839b.a(e);
            }
            return fVar;
        }
    }

    private d() {
    }

    public static c a() {
        return f12834a;
    }

    @Override // com.qq.e.comm.plugin.t.c
    public Future<com.qq.e.comm.plugin.t.b.f> a(com.qq.e.comm.plugin.t.b.e eVar) {
        return a(eVar, c.a.Mid);
    }

    @Override // com.qq.e.comm.plugin.t.c
    public Future<com.qq.e.comm.plugin.t.b.f> a(com.qq.e.comm.plugin.t.b.e eVar, c.a aVar) {
        a aVar2 = new a(new b(eVar), aVar);
        this.f12835b.execute(aVar2);
        GDTLogger.d("QueueSize:" + this.c.size());
        return aVar2;
    }

    @Override // com.qq.e.comm.plugin.t.c
    public void a(com.qq.e.comm.plugin.t.b.e eVar, c.a aVar, com.qq.e.comm.plugin.t.b bVar) {
        a(eVar, aVar, bVar, this.f12835b);
    }

    public void a(com.qq.e.comm.plugin.t.b.e eVar, c.a aVar, com.qq.e.comm.plugin.t.b bVar, Executor executor) {
        if (executor == null) {
            GDTLogger.e("Submit failed for no executor");
            return;
        }
        executor.execute(new a(new b(eVar, bVar), aVar));
        GDTLogger.d("QueueSize:" + this.c.size());
    }
}
