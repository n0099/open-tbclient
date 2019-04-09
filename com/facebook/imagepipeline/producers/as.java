package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class as<T> implements ai<T> {
    private final ai<T> jJl;
    private final int jLb;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> jLd = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int jLc = 0;

    static /* synthetic */ int b(as asVar) {
        int i = asVar.jLc;
        asVar.jLc = i - 1;
        return i;
    }

    public as(int i, Executor executor, ai<T> aiVar) {
        this.jLb = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jJl = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.czB().em(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.jLc >= this.jLb) {
                this.jLd.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.jLc++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.czB().a(ajVar.getId(), "ThrottlingProducer", null);
        this.jJl.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void d(T t, boolean z) {
            czN().e(t, z);
            if (z) {
                cAl();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            czN().C(th);
            cAl();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cyv() {
            czN().ctB();
            cAl();
        }

        private void cAl() {
            final Pair pair;
            synchronized (as.this) {
                pair = (Pair) as.this.jLd.poll();
                if (pair == null) {
                    as.b(as.this);
                }
            }
            if (pair != null) {
                as.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.as.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        as.this.g((j) pair.first, (aj) pair.second);
                    }
                });
            }
        }
    }
}
