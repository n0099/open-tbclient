package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> meH;
    private final int mgy;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> mgA = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int mgz = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.mgz;
        auVar.mgz = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.mgy = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.meH = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dtR().fi(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.mgz >= this.mgy) {
                this.mgA.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.mgz++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dtR().a(akVar.getId(), "ThrottlingProducer", null);
        this.meH.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            duc().h(t, i);
            if (Hr(i)) {
                diZ();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            duc().G(th);
            diZ();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dsA() {
            duc().dmS();
            diZ();
        }

        private void diZ() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.mgA.poll();
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
