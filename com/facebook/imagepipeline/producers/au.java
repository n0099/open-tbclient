package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> ndV;
    private final int nfN;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> nfP = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int nfO = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.nfO;
        auVar.nfO = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.nfN = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ndV = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dJq().fW(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.nfO >= this.nfN) {
                this.nfP.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.nfO++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dJq().a(akVar.getId(), "ThrottlingProducer", null);
        this.ndV.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dJB().h(t, i);
            if (JH(i)) {
                dyB();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            dJB().F(th);
            dyB();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dIa() {
            dJB().dCu();
            dyB();
        }

        private void dyB() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.nfP.poll();
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
