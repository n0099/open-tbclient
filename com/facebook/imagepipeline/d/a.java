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
    private final com.facebook.imagepipeline.g.c pya;
    private final ap pzB;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pzB = apVar;
        this.pya = cVar;
        this.pya.a(apVar.ewP(), this.pzB.erD(), this.pzB.getId(), this.pzB.ewS());
        ajVar.a(evC(), apVar);
    }

    private k<T> evC() {
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
            protected void evD() {
                a.this.evD();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bK(float f) {
                a.this.bC(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean PO = com.facebook.imagepipeline.producers.b.PO(i);
        if (super.c(t, PO) && PO) {
            this.pya.a(this.pzB.ewP(), this.pzB.getId(), this.pzB.ewS());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Throwable th) {
        if (super.u(th)) {
            this.pya.a(this.pzB.ewP(), this.pzB.getId(), th, this.pzB.ewS());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void evD() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean apn() {
        if (!super.apn()) {
            return false;
        }
        if (!super.isFinished()) {
            this.pya.Yp(this.pzB.getId());
            this.pzB.cancel();
        }
        return true;
    }
}
