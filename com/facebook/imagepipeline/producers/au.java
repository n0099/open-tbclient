package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> poz;
    private final int pqs;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pqu = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pqt = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pqt;
        auVar.pqt = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pqs = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.poz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        akVar.ewx().hh(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pqt >= this.pqs) {
                this.pqu.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pqt++;
                z = false;
            }
        }
        if (!z) {
            f(kVar, akVar);
        }
    }

    void f(k<T> kVar, ak akVar) {
        akVar.ewx().a(akVar.getId(), "ThrottlingProducer", null);
        this.poz.a(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            ewJ().h(t, i);
            if (Rh(i)) {
                ehm();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            ewJ().E(th);
            ehm();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void evk() {
            ewJ().epN();
            ehm();
        }

        private void ehm() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pqu.poll();
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
