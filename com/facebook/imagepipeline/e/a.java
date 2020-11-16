package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c oWA;
    private final ap oYb;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.oYb = apVar;
        this.oWA = cVar;
        this.oWA.a(apVar.eqT(), this.oYb.elx(), this.oYb.getId(), this.oYb.eqW());
        ajVar.c(epD(), apVar);
    }

    private k<T> epD() {
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
            protected void epE() {
                a.this.epE();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void by(float f) {
                a.this.bp(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Ql = com.facebook.imagepipeline.producers.b.Ql(i);
        if (super.b(t, Ql) && Ql) {
            this.oWA.a(this.oYb.eqT(), this.oYb.getId(), this.oYb.eqW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.oWA.a(this.oYb.eqT(), this.oYb.getId(), th, this.oYb.eqW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void epE() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean aoH() {
        if (!super.aoH()) {
            return false;
        }
        if (!super.isFinished()) {
            this.oWA.XS(this.oYb.getId());
            this.oYb.cancel();
        }
        return true;
    }
}
