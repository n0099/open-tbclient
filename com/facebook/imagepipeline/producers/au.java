package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class au<T> implements aj<T> {
    private final aj<T> lUn;
    private final int lWe;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> lWg = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int lWf = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.lWf;
        auVar.lWf = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.lWe = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lUn = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dqi().fe(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.lWf >= this.lWe) {
                this.lWg.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.lWf++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dqi().a(akVar.getId(), "ThrottlingProducer", null);
        this.lUn.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            dqt().g(t, i);
            if (IE(i)) {
                dqY();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            dqt().D(th);
            dqY();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void doR() {
            dqt().djn();
            dqY();
        }

        private void dqY() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.lWg.poll();
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
