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
    private final com.facebook.imagepipeline.h.c mbC;
    private final ap mdd;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.mdd = apVar;
        this.mbC = cVar;
        this.mbC.a(apVar.dtR(), this.mdd.dou(), this.mdd.getId(), this.mdd.dtU());
        ajVar.c(dsA(), apVar);
    }

    private k<T> dsA() {
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
            protected void dsB() {
                a.this.dsB();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aI(float f) {
                a.this.az(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Hr = com.facebook.imagepipeline.producers.b.Hr(i);
        if (super.b(t, Hr) && Hr) {
            this.mbC.a(this.mdd.dtR(), this.mdd.getId(), this.mdd.dtU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Throwable th) {
        if (super.z(th)) {
            this.mbC.a(this.mdd.dtR(), this.mdd.getId(), th, this.mdd.dtU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dsB() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Wu() {
        if (!super.Wu()) {
            return false;
        }
        if (!super.isFinished()) {
            this.mbC.Oj(this.mdd.getId());
            this.mdd.cancel();
        }
        return true;
    }
}
