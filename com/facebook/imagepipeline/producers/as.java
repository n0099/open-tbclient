package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class as<T> implements ai<T> {
    private final ai<T> kkh;
    private final int klX;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> klZ = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int klY = 0;

    static /* synthetic */ int b(as asVar) {
        int i = asVar.klY;
        asVar.klY = i - 1;
        return i;
    }

    public as(int i, Executor executor, ai<T> aiVar) {
        this.klX = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kkh = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.cIG().en(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.klY >= this.klX) {
                this.klZ.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.klY++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.cIG().a(ajVar.getId(), "ThrottlingProducer", null);
        this.kkh.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void e(T t, boolean z) {
            cIS().f(t, z);
            if (z) {
                cJq();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            cIS().B(th);
            cJq();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cHz() {
            cIS().cCF();
            cJq();
        }

        private void cJq() {
            final Pair pair;
            synchronized (as.this) {
                pair = (Pair) as.this.klZ.poll();
                if (pair == null) {
                    as.b(as.this);
                }
            }
            if (pair != null) {
                as.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.as.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        as.this.g((j) pair.first, (aj) pair.second);
                    }
                });
            }
        }
    }
}
