package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> oOJ;
    private final int oQA;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> oQC = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int oQB = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.oQB;
        auVar.oQB = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.oQA = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oOJ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.eng().gX(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.oQB >= this.oQA) {
                this.oQC.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.oQB++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.eng().a(akVar.getId(), "ThrottlingProducer", null);
        this.oOJ.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            enr().h(t, i);
            if (Pn(i)) {
                dXZ();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            enr().E(th);
            dXZ();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void elP() {
            enr().egk();
            dXZ();
        }

        private void dXZ() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.oQC.poll();
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
