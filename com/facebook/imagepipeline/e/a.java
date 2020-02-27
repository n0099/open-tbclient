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
    private final com.facebook.imagepipeline.h.c lRS;
    private final ap lTv;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.lTv = apVar;
        this.lRS = cVar;
        this.lRS.a(apVar.drv(), this.lTv.dmd(), this.lTv.getId(), this.lTv.dry());
        ajVar.c(dqe(), apVar);
    }

    private k<T> dqe() {
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
            protected void dqf() {
                a.this.dqf();
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
            this.lRS.a(this.lTv.drv(), this.lTv.getId(), this.lTv.dry());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.u(th)) {
            this.lRS.a(this.lTv.drv(), this.lTv.getId(), th, this.lTv.dry());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dqf() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean OB() {
        if (!super.OB()) {
            return false;
        }
        if (!super.isFinished()) {
            this.lRS.OY(this.lTv.getId());
            this.lTv.cancel();
        }
        return true;
    }
}
