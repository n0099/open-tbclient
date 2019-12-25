package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c lNu;
    private final ap lOX;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.lOX = apVar;
        this.lNu = cVar;
        this.lNu.a(apVar.doX(), this.lOX.djN(), this.lOX.getId(), this.lOX.dpa());
        ajVar.c(dnK(), apVar);
    }

    private k<T> dnK() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(@Nullable T t, int i) {
                a.this.f(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void C(Throwable th) {
                a.this.C(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dnL() {
                a.this.dnL();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bt(float f) {
                a.this.bl(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean Iv = com.facebook.imagepipeline.producers.b.Iv(i);
        if (super.b(t, Iv) && Iv) {
            this.lNu.a(this.lOX.doX(), this.lOX.getId(), this.lOX.dpa());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Throwable th) {
        if (super.v(th)) {
            this.lNu.a(this.lOX.doX(), this.lOX.getId(), th, this.lOX.dpa());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dnL() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean LR() {
        if (!super.LR()) {
            return false;
        }
        if (!super.isFinished()) {
            this.lNu.OB(this.lOX.getId());
            this.lOX.cancel();
        }
        return true;
    }
}
