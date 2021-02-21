package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> pLO;
    private final int pNG;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pNI = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pNH = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pNH;
        auVar.pNH = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pNG = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pLO = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        akVar.ezq().hv(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pNH >= this.pNG) {
                this.pNI.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pNH++;
                z = false;
            }
        }
        if (!z) {
            f(kVar, akVar);
        }
    }

    void f(k<T> kVar, ak akVar) {
        akVar.ezq().b(akVar.getId(), "ThrottlingProducer", null);
        this.pLO.a(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            ezC().g(t, i);
            if (Qk(i)) {
                egn();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            ezC().C(th);
            egn();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eye() {
            ezC().esD();
            egn();
        }

        private void egn() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pNI.poll();
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
