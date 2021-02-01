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
    private final com.facebook.imagepipeline.g.c pIj;
    private final ap pJK;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pJK = apVar;
        this.pIj = cVar;
        this.pIj.a(apVar.ezh(), this.pJK.etV(), this.pJK.getId(), this.pJK.ezk());
        ajVar.a(exV(), apVar);
    }

    private k<T> exV() {
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
            protected void exW() {
                a.this.exW();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bN(float f) {
                a.this.bF(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean Qj = com.facebook.imagepipeline.producers.b.Qj(i);
        if (super.c(t, Qj) && Qj) {
            this.pIj.a(this.pJK.ezh(), this.pJK.getId(), this.pJK.ezk());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.t(th)) {
            this.pIj.a(this.pJK.ezh(), this.pJK.getId(), th, this.pJK.ezk());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exW() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean apL() {
        if (!super.apL()) {
            return false;
        }
        if (!super.isFinished()) {
            this.pIj.Zr(this.pJK.getId());
            this.pJK.cancel();
        }
        return true;
    }
}
