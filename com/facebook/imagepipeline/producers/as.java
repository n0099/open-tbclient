package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class as<T> implements ai<T> {
    private final ai<T> kjj;
    private final int kkZ;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> klb = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int kla = 0;

    static /* synthetic */ int b(as asVar) {
        int i = asVar.kla;
        asVar.kla = i - 1;
        return i;
    }

    public as(int i, Executor executor, ai<T> aiVar) {
        this.kkZ = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kjj = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.cKC().eA(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.kla >= this.kkZ) {
                this.klb.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.kla++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.cKC().a(ajVar.getId(), "ThrottlingProducer", null);
        this.kjj.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void d(T t, boolean z) {
            cKO().e(t, z);
            if (z) {
                cLm();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            cKO().B(th);
            cLm();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cJv() {
            cKO().cEA();
            cLm();
        }

        private void cLm() {
            final Pair pair;
            synchronized (as.this) {
                pair = (Pair) as.this.klb.poll();
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
