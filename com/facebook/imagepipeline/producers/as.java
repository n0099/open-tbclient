package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class as<T> implements ai<T> {
    private final ai<T> jJF;
    private final int jLv;
    private final Executor mExecutor;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Pair<j<T>, aj>> jLx = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
    private int jLw = 0;

    static /* synthetic */ int b(as asVar) {
        int i = asVar.jLw;
        asVar.jLw = i - 1;
        return i;
    }

    public as(int i, Executor executor, ai<T> aiVar) {
        this.jLv = i;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jJF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ajVar.czv().em(ajVar.getId(), "ThrottlingProducer");
        synchronized (this) {
            if (this.jLw >= this.jLv) {
                this.jLx.add(Pair.create(jVar, ajVar));
                z = true;
            } else {
                this.jLw++;
                z = false;
            }
        }
        if (!z) {
            g(jVar, ajVar);
        }
    }

    void g(j<T> jVar, aj ajVar) {
        ajVar.czv().a(ajVar.getId(), "ThrottlingProducer", null);
        this.jJF.a(new a(jVar), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<T, T> {
        private a(j<T> jVar) {
            super(jVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void d(T t, boolean z) {
            czH().e(t, z);
            if (z) {
                cAf();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            czH().C(th);
            cAf();
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cyp() {
            czH().ctv();
            cAf();
        }

        private void cAf() {
            final Pair pair;
            synchronized (as.this) {
                pair = (Pair) as.this.jLx.poll();
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
