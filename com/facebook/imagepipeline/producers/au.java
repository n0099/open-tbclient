package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> pBf;
    private final int pCX;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pCZ = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pCY = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pCY;
        auVar.pCY = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pCX = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pBf = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        akVar.ewQ().hm(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pCY >= this.pCX) {
                this.pCZ.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pCY++;
                z = false;
            }
        }
        if (!z) {
            f(kVar, akVar);
        }
    }

    void f(k<T> kVar, ak akVar) {
        akVar.ewQ().b(akVar.getId(), "ThrottlingProducer", null);
        this.pBf.a(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            exc().g(t, i);
            if (PO(i)) {
                edN();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            exc().D(th);
            edN();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void evD() {
            exc().eqc();
            edN();
        }

        private void edN() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pCZ.poll();
                if (pair == null) {
                    au.b(au.this);
                }
            }
            if (pair != null) {
                au.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.au.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        au.this.f((k) pair.first, (ak) pair.second);
                    }
                });
            }
        }
    }
}
