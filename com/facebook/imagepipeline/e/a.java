package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c nuE;
    private final ap nwh;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.nwh = apVar;
        this.nuE = cVar;
        this.nuE.a(apVar.dVo(), this.nwh.dPU(), this.nwh.getId(), this.nwh.dVr());
        ajVar.c(dTY(), apVar);
    }

    private k<T> dTY() {
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
            protected void dTZ() {
                a.this.dTZ();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aS(float f) {
                a.this.aJ(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Ml = com.facebook.imagepipeline.producers.b.Ml(i);
        if (super.b(t, Ml) && Ml) {
            this.nuE.a(this.nwh.dVo(), this.nwh.getId(), this.nwh.dVr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.nuE.a(this.nwh.dVo(), this.nwh.getId(), th, this.nwh.dVr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dTZ() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean ahA() {
        if (!super.ahA()) {
            return false;
        }
        if (!super.isFinished()) {
            this.nuE.UA(this.nwh.getId());
            this.nwh.cancel();
        }
        return true;
    }
}
