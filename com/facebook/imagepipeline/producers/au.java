package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class au<T> implements aj<T> {
    private final Executor mExecutor;
    private final aj<T> meD;
    private final int mgu;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<k<T>, ak>> mgw = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int mgv = 0;

    static /* synthetic */ int b(au auVar) {
        int i = auVar.mgv;
        auVar.mgv = i - 1;
        return i;
    }

    public au(int i, Executor executor, aj<T> ajVar) {
        this.mgu = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.meD = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        akVar.dtU().fi(akVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.mgv >= this.mgu) {
                this.mgw.add(Pair.create(kVar, akVar));
                z = true;
            } else {
                this.mgv++;
                z = false;
            }
        }
        if (!z) {
            g(kVar, akVar);
        }
    }

    void g(k<T> kVar, ak akVar) {
        akVar.dtU().a(akVar.getId(), "ThrottlingProducer", null);
        this.meD.c(new a(kVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<T, T> {
        private a(k<T> kVar) {
            super(kVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(T t, int i) {
            duf().h(t, i);
            if (Hr(i)) {
                djc();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            duf().G(th);
            djc();
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dsD() {
            duf().dmV();
            djc();
        }

        private void djc() {
            final Pair pair;
            synchronized (au.this) {
                pair = (Pair) au.this.mgw.poll();
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
