package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c oUX;
    private final ap oWy;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.oWy = apVar;
        this.oUX = cVar;
        this.oUX.a(apVar.eqV(), this.oWy.elz(), this.oWy.getId(), this.oWy.eqY());
        ajVar.c(epF(), apVar);
    }

    private k<T> epF() {
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
            protected void epG() {
                a.this.epG();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void br(float f) {
                a.this.bi(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean PI = com.facebook.imagepipeline.producers.b.PI(i);
        if (super.b(t, PI) && PI) {
            this.oUX.a(this.oWy.eqV(), this.oWy.getId(), this.oWy.eqY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.oUX.a(this.oWy.eqV(), this.oWy.getId(), th, this.oWy.eqY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void epG() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean apq() {
        if (!super.apq()) {
            return false;
        }
        if (!super.isFinished()) {
            this.oUX.Yh(this.oWy.getId());
            this.oWy.cancel();
        }
        return true;
    }
}
