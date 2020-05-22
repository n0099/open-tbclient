package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final int mAp;
    private final Executor mExecutor;
    private final aj<T> myy;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> mAr = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int mAq = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.mAq;
        auVar.mAq = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.mAp = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.myy = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dBj().fK(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.mAq >= this.mAp) {
                this.mAr.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.mAq++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dBj().a(akVar.getId(), "ThrottlingProducer", null);
        this.myy.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            dBu().h(t, i);
            if (Id(i)) {
                dqq();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            dBu().G(th);
            dqq();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dzT() {
            dBu().dum();
            dqq();
        }

        private void dqq() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.mAr.poll();
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
