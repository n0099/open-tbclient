package com.facebook.imagepipeline.d;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.g.c plp;
    private final ap pmQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pmQ = apVar;
        this.plp = cVar;
        this.plp.a(apVar.ewv(), this.pmQ.erm(), this.pmQ.getId(), this.pmQ.ewy());
        ajVar.a(evi(), apVar);
    }

    private k<T> evi() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.d.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(@Nullable T t, int i) {
                a.this.g(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void D(Throwable th) {
                a.this.D(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void evj() {
                a.this.evj();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void by(float f) {
                a.this.bq(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Rh = com.facebook.imagepipeline.producers.b.Rh(i);
        if (super.b(t, Rh) && Rh) {
            this.plp.a(this.pmQ.ewv(), this.pmQ.getId(), this.pmQ.ewy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.plp.a(this.pmQ.ewv(), this.pmQ.getId(), th, this.pmQ.ewy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void evj() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean arP() {
        if (!super.arP()) {
            return false;
        }
        if (!super.isFinished()) {
            this.plp.Zn(this.pmQ.getId());
            this.pmQ.cancel();
        }
        return true;
    }
}
