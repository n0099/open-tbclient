package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final int mBA;
    private final Executor mExecutor;
    private final aj<T> mzI;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> mBC = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int mBB = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.mBB;
        auVar.mBB = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.mBA = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mzI = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dBx().fK(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.mBB >= this.mBA) {
                this.mBC.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.mBB++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dBx().a(akVar.getId(), "ThrottlingProducer", null);
        this.mzI.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dBI().h(t, i);
            if (If(i)) {
                dqE();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            dBI().G(th);
            dqE();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dAh() {
            dBI().duA();
            dqE();
        }

        private void dqE() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.mBC.poll();
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
