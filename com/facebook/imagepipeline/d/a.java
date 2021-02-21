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
    private final com.facebook.imagepipeline.g.c pIJ;
    private final ap pKk;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pKk = apVar;
        this.pIJ = cVar;
        this.pIJ.a(apVar.ezp(), this.pKk.eud(), this.pKk.getId(), this.pKk.ezs());
        ajVar.a(eyd(), apVar);
    }

    private k<T> eyd() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.d.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(@Nullable T t, int i) {
                a.this.f(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.B(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void eye() {
                a.this.eye();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bN(float f) {
                a.this.bF(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean Qk = com.facebook.imagepipeline.producers.b.Qk(i);
        if (super.c(t, Qk) && Qk) {
            this.pIJ.a(this.pKk.ezp(), this.pKk.getId(), this.pKk.ezs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.t(th)) {
            this.pIJ.a(this.pKk.ezp(), this.pKk.getId(), th, this.pKk.ezs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eye() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean apL() {
        if (!super.apL()) {
            return false;
        }
        if (!super.isFinished()) {
            this.pIJ.ZD(this.pKk.getId());
            this.pKk.cancel();
        }
        return true;
    }
}
