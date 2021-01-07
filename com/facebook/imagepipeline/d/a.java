package com.facebook.imagepipeline.d;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.g.c pCB;
    private final ap pEc;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pEc = apVar;
        this.pCB = cVar;
        this.pCB.a(apVar.eAH(), this.pEc.evw(), this.pEc.getId(), this.pEc.eAK());
        ajVar.a(ezu(), apVar);
    }

    private k<T> ezu() {
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
            protected void ezv() {
                a.this.ezv();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bK(float f) {
                a.this.bC(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean Rv = com.facebook.imagepipeline.producers.b.Rv(i);
        if (super.c(t, Rv) && Rv) {
            this.pCB.a(this.pEc.eAH(), this.pEc.getId(), this.pEc.eAK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Throwable th) {
        if (super.u(th)) {
            this.pCB.a(this.pEc.eAH(), this.pEc.getId(), th, this.pEc.eAK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ezv() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean ati() {
        if (!super.ati()) {
            return false;
        }
        if (!super.isFinished()) {
            this.pCB.Zx(this.pEc.getId());
            this.pEc.cancel();
        }
        return true;
    }
}
