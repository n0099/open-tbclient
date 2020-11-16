package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> oZF;
    private final int pby;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pbA = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pbz = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pbz;
        auVar.pbz = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pby = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oZF = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.eqU().gZ(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pbz >= this.pby) {
                this.pbA.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pbz++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.eqU().a(akVar.getId(), "ThrottlingProducer", null);
        this.oZF.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            erf().h(t, i);
            if (Ql(i)) {
                ebG();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            erf().E(th);
            ebG();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void epE() {
            erf().ejX();
            ebG();
        }

        private void ebG() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pbA.poll();
                if (pair == null) {
                    au.b(au.this);
                }
            }
            if (pair != null) {
                au.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.au.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        au.this.g((k) pair.first, (ak) pair.second);
                    }
                });
            }
        }
    }
}
