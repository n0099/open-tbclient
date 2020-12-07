package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> pox;
    private final int pqq;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pqs = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pqr = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pqr;
        auVar.pqr = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pqq = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pox = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        akVar.eww().hh(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pqr >= this.pqq) {
                this.pqs.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pqr++;
                z = false;
            }
        }
        if (!z) {
            f(kVar, akVar);
        }
    }

    void f(k<T> kVar, ak akVar) {
        akVar.eww().a(akVar.getId(), "ThrottlingProducer", null);
        this.pox.a(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            ewI().h(t, i);
            if (Rh(i)) {
                ehl();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            ewI().E(th);
            ehl();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void evj() {
            ewI().epM();
            ehl();
        }

        private void ehl() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pqs.poll();
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
