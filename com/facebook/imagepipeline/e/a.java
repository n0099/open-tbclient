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
    private final com.facebook.imagepipeline.h.c mby;
    private final ap mcZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.mcZ = apVar;
        this.mby = cVar;
        this.mby.a(apVar.dtT(), this.mcZ.dow(), this.mcZ.getId(), this.mcZ.dtW());
        ajVar.c(dsC(), apVar);
    }

    private k<T> dsC() {
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
            protected void dsD() {
                a.this.dsD();
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
            this.mby.a(this.mcZ.dtT(), this.mcZ.getId(), this.mcZ.dtW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Throwable th) {
        if (super.z(th)) {
            this.mby.a(this.mcZ.dtT(), this.mcZ.getId(), th, this.mcZ.dtW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dsD() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Wv() {
        if (!super.Wv()) {
            return false;
        }
        if (!super.isFinished()) {
            this.mby.Og(this.mcZ.getId());
            this.mcZ.cancel();
        }
        return true;
    }
}
