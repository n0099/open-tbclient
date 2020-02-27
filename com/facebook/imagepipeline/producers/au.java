package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final aj<T> lUZ;
    private final int lWQ;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> lWS = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int lWR = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.lWR;
        auVar.lWR = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.lWQ = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lUZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.drw().fm(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.lWR >= this.lWQ) {
                this.lWS.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.lWR++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.drw().a(akVar.getId(), "ThrottlingProducer", null);
        this.lUZ.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            drH().g(t, i);
            if (IJ(i)) {
                dsm();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            drH().C(th);
            dsm();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dqf() {
            drH().dkC();
            dsm();
        }

        private void dsm() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.lWS.poll();
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
