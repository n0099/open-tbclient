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
    private final com.facebook.imagepipeline.h.c mvt;
    private final ap mwU;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.mwU = apVar;
        this.mvt = cVar;
        this.mvt.a(apVar.dBi(), this.mwU.dvM(), this.mwU.getId(), this.mwU.dBl());
        ajVar.c(dzS(), apVar);
    }

    private k<T> dzS() {
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
            protected void dzT() {
                a.this.dzT();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aH(float f) {
                a.this.ay(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Id = com.facebook.imagepipeline.producers.b.Id(i);
        if (super.b(t, Id) && Id) {
            this.mvt.a(this.mwU.dBi(), this.mwU.getId(), this.mwU.dBl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Throwable th) {
        if (super.z(th)) {
            this.mvt.a(this.mwU.dBi(), this.mwU.getId(), th, this.mwU.dBl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dzT() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Zg() {
        if (!super.Zg()) {
            return false;
        }
        if (!super.isFinished()) {
            this.mvt.PX(this.mwU.getId());
            this.mwU.cancel();
        }
        return true;
    }
}
