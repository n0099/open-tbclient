package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> pNT;
    private final int pPL;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pPN = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pPM = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pPM;
        auVar.pPM = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pPL = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pNT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        akVar.ezz().hv(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pPM >= this.pPL) {
                this.pPN.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pPM++;
                z = false;
            }
        }
        if (!z) {
            f(kVar, akVar);
        }
    }

    void f(k<T> kVar, ak akVar) {
        akVar.ezz().b(akVar.getId(), "ThrottlingProducer", null);
        this.pNT.a(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void e(T t, int i) {
            ezL().f(t, i);
            if (Qo(i)) {
                egv();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            ezL().C(th);
            egv();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eyn() {
            ezL().esM();
            egv();
        }

        private void egv() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pPN.poll();
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
