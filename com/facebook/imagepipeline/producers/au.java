package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> pDZ;
    private final int pFS;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pFU = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pFT = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pFT;
        auVar.pFT = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pFS = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pDZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        akVar.eAe().hm(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pFT >= this.pFS) {
                this.pFU.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pFT++;
                z = false;
            }
        }
        if (!z) {
            f(kVar, akVar);
        }
    }

    void f(k<T> kVar, ak akVar) {
        akVar.eAe().b(akVar.getId(), "ThrottlingProducer", null);
        this.pDZ.a(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            eAq().g(t, i);
            if (Rf(i)) {
                ehE();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            eAq().D(th);
            ehE();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eyT() {
            eAq().etQ();
            ehE();
        }

        private void ehE() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pFU.poll();
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
