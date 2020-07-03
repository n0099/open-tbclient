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
    private final com.facebook.imagepipeline.h.c mSE;
    private final ap mUl;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.mUl = apVar;
        this.mSE = cVar;
        this.mSE.a(apVar.dFY(), this.mUl.dAD(), this.mUl.getId(), this.mUl.dGb());
        ajVar.c(dEI(), apVar);
    }

    private k<T> dEI() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(@Nullable T t, int i) {
                a.this.g(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void F(Throwable th) {
                a.this.F(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dEJ() {
                a.this.dEJ();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aN(float f) {
                a.this.aE(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Jm = com.facebook.imagepipeline.producers.b.Jm(i);
        if (super.b(t, Jm) && Jm) {
            this.mSE.a(this.mUl.dFY(), this.mUl.getId(), this.mUl.dGb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Throwable th) {
        if (super.z(th)) {
            this.mSE.a(this.mUl.dFY(), this.mUl.getId(), th, this.mUl.dGb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dEJ() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean aam() {
        if (!super.aam()) {
            return false;
        }
        if (!super.isFinished()) {
            this.mSE.QK(this.mUl.getId());
            this.mUl.cancel();
        }
        return true;
    }
}
