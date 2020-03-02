package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c lRU;
    private final ap lTx;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.lTx = apVar;
        this.lRU = cVar;
        this.lRU.a(apVar.drx(), this.lTx.dmf(), this.lTx.getId(), this.lTx.drA());
        ajVar.c(dqg(), apVar);
    }

    private k<T> dqg() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(@Nullable T t, int i) {
                a.this.f(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.B(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dqh() {
                a.this.dqh();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bs(float f) {
                a.this.bj(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean IJ = com.facebook.imagepipeline.producers.b.IJ(i);
        if (super.b(t, IJ) && IJ) {
            this.lRU.a(this.lTx.drx(), this.lTx.getId(), this.lTx.drA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.u(th)) {
            this.lRU.a(this.lTx.drx(), this.lTx.getId(), th, this.lTx.drA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dqh() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean OD() {
        if (!super.OD()) {
            return false;
        }
        if (!super.isFinished()) {
            this.lRU.OY(this.lTx.getId());
            this.lTx.cancel();
        }
        return true;
    }
}
