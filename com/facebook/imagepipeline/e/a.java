package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.an;
import com.facebook.imagepipeline.producers.j;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.g.b kgv;
    private final an khO;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.khO = anVar;
        this.kgv = bVar;
        this.kgv.a(anVar.cKB(), this.khO.cFU(), this.khO.getId(), this.khO.cKE());
        aiVar.a(cJu(), anVar);
    }

    private j<T> cJu() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void d(@Nullable T t, boolean z) {
                a.this.d(t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void A(Throwable th) {
                a.this.A(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cJv() {
                a.this.cJv();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bf(float f) {
                a.this.aX(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable T t, boolean z) {
        if (super.a((a<T>) t, z) && z) {
            this.kgv.a(this.khO.cKB(), this.khO.getId(), this.khO.cKE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.kgv.a(this.khO.cKB(), this.khO.getId(), th, this.khO.cKE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cJv() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean AI() {
        if (!super.AI()) {
            return false;
        }
        if (!super.isFinished()) {
            this.kgv.HO(this.khO.getId());
            this.khO.cancel();
        }
        return true;
    }
}
