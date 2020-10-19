package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> nXr;
    private final int nZi;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> nZk = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int nZj = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.nZj;
        auVar.nZj = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.nZi = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nXr = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.edh().gH(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.nZj >= this.nZi) {
                this.nZk.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.nZj++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.edh().a(akVar.getId(), "ThrottlingProducer", null);
        this.nXr.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            eds().h(t, i);
            if (Nw(i)) {
                dSh();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            eds().E(th);
            dSh();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void ebR() {
            eds().dWm();
            dSh();
        }

        private void dSh() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.nZk.poll();
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
