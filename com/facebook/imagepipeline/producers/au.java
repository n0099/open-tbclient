package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class au<T> implements aj<T> {
    private final aj<T> lQz;
    private final int lSq;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> lSs = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int lSr = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.lSr;
        auVar.lSr = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.lSq = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lQz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.doY().fc(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.lSr >= this.lSq) {
                this.lSs.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.lSr++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.doY().a(akVar.getId(), "ThrottlingProducer", null);
        this.lQz.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            dpj().g(t, i);
            if (Iv(i)) {
                dpL();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            dpj().D(th);
            dpL();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dnL() {
            dpj().dim();
            dpL();
        }

        private void dpL() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.lSs.poll();
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
