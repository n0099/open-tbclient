package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> oYc;
    private final int oZT;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> oZV = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int oZU = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.oZU;
        auVar.oZU = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.oZT = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oYc = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.eqW().gZ(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.oZU >= this.oZT) {
                this.oZV.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.oZU++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.eqW().a(akVar.getId(), "ThrottlingProducer", null);
        this.oYc.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            erh().h(t, i);
            if (PI(i)) {
                ebH();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            erh().E(th);
            ebH();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void epG() {
            erh().ejZ();
            ebH();
        }

        private void ebH() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.oZV.poll();
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
