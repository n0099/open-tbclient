package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ar<T> implements ai<T> {
    private final ai<T> igJ;
    private final int iix;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> iiz = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int iiy = 0;

    static /* synthetic */ int b(ar arVar) {
        int i = arVar.iiy;
        arVar.iiy = i - 1;
        return i;
    }

    public ar(int i, Executor executor, ai<T> aiVar) {
        this.iix = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.igJ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.bXr().cX(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.iiy >= this.iix) {
                this.iiz.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.iiy++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.bXr().a(ajVar.getId(), "ThrottlingProducer", null);
        this.igJ.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void d(T t, boolean z) {
            bXD().e(t, z);
            if (z) {
                bYb();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            bXD().B(th);
            bYb();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bWl() {
            bXD().bRy();
            bYb();
        }

        private void bYb() {
            final Pair pair;
            synchronized (ar.this) {
                pair = (Pair) ar.this.iiz.poll();
                if (pair == null) {
                    ar.b(ar.this);
                }
            }
            if (pair != null) {
                ar.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ar.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ar.this.g((j) pair.first, (aj) pair.second);
                    }
                });
            }
        }
    }
}
