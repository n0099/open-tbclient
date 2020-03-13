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
    private final com.facebook.imagepipeline.h.c lSf;
    private final ap lTI;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.lTI = apVar;
        this.lSf = cVar;
        this.lSf.a(apVar.dry(), this.lTI.dmg(), this.lTI.getId(), this.lTI.drB());
        ajVar.c(dqh(), apVar);
    }

    private k<T> dqh() {
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
            protected void dqi() {
                a.this.dqi();
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
            this.lSf.a(this.lTI.dry(), this.lTI.getId(), this.lTI.drB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.u(th)) {
            this.lSf.a(this.lTI.dry(), this.lTI.getId(), th, this.lTI.drB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dqi() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean OD() {
        if (!super.OD()) {
            return false;
        }
        if (!super.isFinished()) {
            this.lSf.OZ(this.lTI.getId());
            this.lTI.cancel();
        }
        return true;
    }
}
