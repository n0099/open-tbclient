package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes8.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> nxL;
    private final int nzC;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> nzE = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int nzD = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.nzD;
        auVar.nzD = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.nzC = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nxL = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dVp().gn(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.nzD >= this.nzC) {
                this.nzE.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.nzD++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dVp().a(akVar.getId(), "ThrottlingProducer", null);
        this.nxL.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dVA().h(t, i);
            if (Ml(i)) {
                dKo();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            dVA().E(th);
            dKo();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dTZ() {
            dVA().dOu();
            dKo();
        }

        private void dKo() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.nzE.poll();
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
