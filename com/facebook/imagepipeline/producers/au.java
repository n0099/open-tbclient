package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class au<T> implements aj<T> {
    private final aj<T> lUs;
    private final int lWj;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> lWl = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int lWk = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.lWk;
        auVar.lWk = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.lWj = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lUs = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dqk().fe(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.lWk >= this.lWj) {
                this.lWl.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.lWk++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dqk().a(akVar.getId(), "ThrottlingProducer", null);
        this.lUs.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            dqv().g(t, i);
            if (IE(i)) {
                dra();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            dqv().D(th);
            dra();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void doT() {
            dqv().djp();
            dra();
        }

        private void dra() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.lWl.poll();
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
