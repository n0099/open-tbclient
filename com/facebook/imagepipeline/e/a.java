package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes25.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c nET;
    private final ap nGw;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.nGw = apVar;
        this.nET = cVar;
        this.nET.a(apVar.dZv(), this.nGw.dUb(), this.nGw.getId(), this.nGw.dZy());
        ajVar.c(dYf(), apVar);
    }

    private k<T> dYf() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(@Nullable T t, int i) {
                a.this.g(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void D(Throwable th) {
                a.this.D(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dYg() {
                a.this.dYg();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aS(float f) {
                a.this.aJ(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean MQ = com.facebook.imagepipeline.producers.b.MQ(i);
        if (super.b(t, MQ) && MQ) {
            this.nET.a(this.nGw.dZv(), this.nGw.getId(), this.nGw.dZy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.nET.a(this.nGw.dZv(), this.nGw.getId(), th, this.nGw.dZy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dYg() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean aik() {
        if (!super.aik()) {
            return false;
        }
        if (!super.isFinished()) {
            this.nET.Vc(this.nGw.getId());
            this.nGw.cancel();
        }
        return true;
    }
}
