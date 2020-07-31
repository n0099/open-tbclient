package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> ndT;
    private final int nfL;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> nfN = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int nfM = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.nfM;
        auVar.nfM = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.nfL = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ndT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dJp().fW(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.nfM >= this.nfL) {
                this.nfN.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.nfM++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dJp().a(akVar.getId(), "ThrottlingProducer", null);
        this.ndT.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dJA().h(t, i);
            if (JH(i)) {
                dyA();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            dJA().F(th);
            dyA();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dHZ() {
            dJA().dCt();
            dyA();
        }

        private void dyA() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.nfN.poll();
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
