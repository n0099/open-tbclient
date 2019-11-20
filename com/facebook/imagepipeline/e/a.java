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
    private final com.facebook.imagepipeline.g.b kht;
    private final an kiN;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.kiN = anVar;
        this.kht = bVar;
        this.kht.a(anVar.cIF(), this.kiN.cDZ(), this.kiN.getId(), this.kiN.cII());
        aiVar.a(cHy(), anVar);
    }

    private j<T> cHy() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void e(@Nullable T t, boolean z) {
                a.this.e(t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void A(Throwable th) {
                a.this.A(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cHz() {
                a.this.cHz();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aJ(float f) {
                a.this.aB(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@Nullable T t, boolean z) {
        if (super.b(t, z) && z) {
            this.kht.a(this.kiN.cIF(), this.kiN.getId(), this.kiN.cII());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.kht.a(this.kiN.cIF(), this.kiN.getId(), th, this.kiN.cII());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cHz() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean FI() {
        if (!super.FI()) {
            return false;
        }
        if (!super.isFinished()) {
            this.kht.GG(this.kiN.getId());
            this.kiN.cancel();
        }
        return true;
    }
}
