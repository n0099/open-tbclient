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
    private final com.facebook.imagepipeline.h.c nUm;
    private final ap nVN;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.nVN = apVar;
        this.nUm = cVar;
        this.nUm.a(apVar.edg(), this.nVN.dXM(), this.nVN.getId(), this.nVN.edj());
        ajVar.c(ebQ(), apVar);
    }

    private k<T> ebQ() {
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
            protected void ebR() {
                a.this.ebR();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aY(float f) {
                a.this.aP(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Nw = com.facebook.imagepipeline.producers.b.Nw(i);
        if (super.b(t, Nw) && Nw) {
            this.nUm.a(this.nVN.edg(), this.nVN.getId(), this.nVN.edj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.nUm.a(this.nVN.edg(), this.nVN.getId(), th, this.nVN.edj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ebR() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean akV() {
        if (!super.akV()) {
            return false;
        }
        if (!super.isFinished()) {
            this.nUm.VQ(this.nVN.getId());
            this.nVN.cancel();
        }
        return true;
    }
}
