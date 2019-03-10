package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class as<T> implements ai<T> {
    private final ai<T> jJY;
    private final int jLO;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> jLQ = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int jLP = 0;

    static /* synthetic */ int b(as asVar) {
        int i = asVar.jLP;
        asVar.jLP = i - 1;
        return i;
    }

    public as(int i, Executor executor, ai<T> aiVar) {
        this.jLO = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jJY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.czF().em(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.jLP >= this.jLO) {
                this.jLQ.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.jLP++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.czF().a(ajVar.getId(), "ThrottlingProducer", null);
        this.jJY.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void d(T t, boolean z) {
            czR().e(t, z);
            if (z) {
                cAp();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            czR().C(th);
            cAp();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cyz() {
            czR().ctF();
            cAp();
        }

        private void cAp() {
            final Pair pair;
            synchronized (as.this) {
                pair = (Pair) as.this.jLQ.poll();
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
