package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes25.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> nIa;
    private final int nJR;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> nJT = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int nJS = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.nJS;
        auVar.nJS = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.nJR = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nIa = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dZw().gA(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.nJS >= this.nJR) {
                this.nJT.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.nJS++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dZw().a(akVar.getId(), "ThrottlingProducer", null);
        this.nIa.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dZH().h(t, i);
            if (MQ(i)) {
                dOv();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            dZH().E(th);
            dOv();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dYg() {
            dZH().dSB();
            dOv();
        }

        private void dOv() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.nJT.poll();
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
