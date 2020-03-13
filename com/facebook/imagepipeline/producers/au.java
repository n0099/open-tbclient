package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final aj<T> lVm;
    private final int lXd;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> lXf = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int lXe = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.lXe;
        auVar.lXe = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.lXd = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lVm = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.drz().fm(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.lXe >= this.lXd) {
                this.lXf.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.lXe++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.drz().a(akVar.getId(), "ThrottlingProducer", null);
        this.lVm.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f(T t, int i) {
            drK().g(t, i);
            if (IJ(i)) {
                dsp();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            drK().C(th);
            dsp();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dqi() {
            drK().dkF();
            dsp();
        }

        private void dsp() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.lXf.poll();
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
