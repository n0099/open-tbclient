package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ar<T> implements ai<T> {
    private final ai<T> iit;
    private final int ikh;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> ikj = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int iki = 0;

    static /* synthetic */ int b(ar arVar) {
        int i = arVar.iki;
        arVar.iki = i - 1;
        return i;
    }

    public ar(int i, Executor executor, ai<T> aiVar) {
        this.ikh = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.iit = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.bWM().cW(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.iki >= this.ikh) {
                this.ikj.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.iki++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.bWM().a(ajVar.getId(), "ThrottlingProducer", null);
        this.iit.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void d(T t, boolean z) {
            bWY().e(t, z);
            if (z) {
                bXw();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            bWY().B(th);
            bXw();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bVG() {
            bWY().bQT();
            bXw();
        }

        private void bXw() {
            final Pair pair;
            synchronized (ar.this) {
                pair = (Pair) ar.this.ikj.poll();
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
