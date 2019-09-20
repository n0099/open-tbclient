package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class as<T> implements ai<T> {
    private final ai<T> kmM;
    private final int koC;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> koE = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int koD = 0;

    static /* synthetic */ int b(as asVar) {
        int i = asVar.koD;
        asVar.koD = i - 1;
        return i;
    }

    public as(int i, Executor executor, ai<T> aiVar) {
        this.koC = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kmM = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.cLL().eB(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.koD >= this.koC) {
                this.koE.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.koD++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.cLL().a(ajVar.getId(), "ThrottlingProducer", null);
        this.kmM.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void d(T t, boolean z) {
            cLX().e(t, z);
            if (z) {
                cMv();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            cLX().B(th);
            cMv();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cKE() {
            cLX().cFJ();
            cMv();
        }

        private void cMv() {
            final Pair pair;
            synchronized (as.this) {
                pair = (Pair) as.this.koE.poll();
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
