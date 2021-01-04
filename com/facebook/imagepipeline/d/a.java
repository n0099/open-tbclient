package com.facebook.imagepipeline.d;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.g.c pAU;
    private final ap pCv;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pCv = apVar;
        this.pAU = cVar;
        this.pAU.a(apVar.eAd(), this.pCv.evp(), this.pCv.getId(), this.pCv.eAg());
        ajVar.a(eyS(), apVar);
    }

    private k<T> eyS() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.d.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(@Nullable T t, int i) {
                a.this.f(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void C(Throwable th) {
                a.this.C(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void eyT() {
                a.this.eyT();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bK(float f) {
                a.this.bC(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean Rf = com.facebook.imagepipeline.producers.b.Rf(i);
        if (super.c(t, Rf) && Rf) {
            this.pAU.a(this.pCv.eAd(), this.pCv.getId(), this.pCv.eAg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Throwable th) {
        if (super.u(th)) {
            this.pAU.a(this.pCv.eAd(), this.pCv.getId(), th, this.pCv.eAg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eyT() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean ath() {
        if (!super.ath()) {
            return false;
        }
        if (!super.isFinished()) {
            this.pAU.Zy(this.pCv.getId());
            this.pCv.cancel();
        }
        return true;
    }
}
