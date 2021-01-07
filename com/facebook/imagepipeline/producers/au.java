package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> pFG;
    private final int pHy;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> pHA = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int pHz = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.pHz;
        auVar.pHz = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.pHy = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pFG = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        akVar.eAI().hn(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.pHz >= this.pHy) {
                this.pHA.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.pHz++;
                z = false;
            }
        }
        if (!z) {
            f(kVar, akVar);
        }
    }

    void f(k<T> kVar, ak akVar) {
        akVar.eAI().b(akVar.getId(), "ThrottlingProducer", null);
        this.pFG.a(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            eAU().g(t, i);
            if (Rv(i)) {
                ehF();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            eAU().D(th);
            ehF();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void ezv() {
            eAU().etW();
            ehF();
        }

        private void ehF() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.pHA.poll();
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
