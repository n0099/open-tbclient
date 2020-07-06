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
    private final com.facebook.imagepipeline.h.c mSH;
    private final ap mUo;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.mUo = apVar;
        this.mSH = cVar;
        this.mSH.a(apVar.dGc(), this.mUo.dAH(), this.mUo.getId(), this.mUo.dGf());
        ajVar.c(dEM(), apVar);
    }

    private k<T> dEM() {
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
            protected void dEN() {
                a.this.dEN();
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
            this.mSH.a(this.mUo.dGc(), this.mUo.getId(), this.mUo.dGf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Throwable th) {
        if (super.z(th)) {
            this.mSH.a(this.mUo.dGc(), this.mUo.getId(), th, this.mUo.dGf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dEN() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean aam() {
        if (!super.aam()) {
            return false;
        }
        if (!super.isFinished()) {
            this.mSH.QL(this.mUo.getId());
            this.mUo.cancel();
        }
        return true;
    }
}
