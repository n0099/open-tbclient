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
    private final com.facebook.imagepipeline.g.c pKO;
    private final ap pMp;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pMp = apVar;
        this.pKO = cVar;
        this.pKO.a(apVar.ezy(), this.pMp.eum(), this.pMp.getId(), this.pMp.ezB());
        ajVar.a(eym(), apVar);
    }

    private k<T> eym() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.d.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void e(@Nullable T t, int i) {
                a.this.e(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.B(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void eyn() {
                a.this.eyn();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bR(float f) {
                a.this.bJ(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@Nullable T t, int i) {
        boolean Qo = com.facebook.imagepipeline.producers.b.Qo(i);
        if (super.c(t, Qo) && Qo) {
            this.pKO.a(this.pMp.ezy(), this.pMp.getId(), this.pMp.ezB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.t(th)) {
            this.pKO.a(this.pMp.ezy(), this.pMp.getId(), th, this.pMp.ezB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eyn() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean apO() {
        if (!super.apO()) {
            return false;
        }
        if (!super.isFinished()) {
            this.pKO.ZJ(this.pMp.getId());
            this.pMp.cancel();
        }
        return true;
    }
}
