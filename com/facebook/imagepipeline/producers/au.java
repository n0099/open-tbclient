package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes8.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> nyd;
    private final int nzU;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> nzW = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int nzV = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.nzV;
        auVar.nzV = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.nzU = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nyd = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dVy().go(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.nzV >= this.nzU) {
                this.nzW.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.nzV++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dVy().a(akVar.getId(), "ThrottlingProducer", null);
        this.nyd.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dVJ().h(t, i);
            if (Ml(i)) {
                dKx();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            dVJ().E(th);
            dKx();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dUi() {
            dVJ().dOD();
            dKx();
        }

        private void dKx() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.nzW.poll();
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
