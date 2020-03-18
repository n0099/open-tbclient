package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final aj<T> lWS;
    private final int lYJ;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> lYL = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int lYK = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.lYK;
        auVar.lYK = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.lYJ = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lWS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.drW().fk(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.lYK >= this.lYJ) {
                this.lYL.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.lYK++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.drW().a(akVar.getId(), "ThrottlingProducer", null);
        this.lWS.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            dsh().g(t, i);
            if (IP(i)) {
                dsM();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            dsh().C(th);
            dsM();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dqF() {
            dsh().dlc();
            dsM();
        }

        private void dsM() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.lYL.poll();
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
