package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> mVP;
    private final int mXH;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> mXJ = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int mXI = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.mXI;
        auVar.mXI = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.mXH = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mVP = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dFZ().fU(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.mXI >= this.mXH) {
                this.mXJ.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.mXI++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dFZ().a(akVar.getId(), "ThrottlingProducer", null);
        this.mVP.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dGk().h(t, i);
            if (Jm(i)) {
                dvj();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            dGk().G(th);
            dvj();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dEJ() {
            dGk().dzd();
            dvj();
        }

        private void dvj() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.mXJ.poll();
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
