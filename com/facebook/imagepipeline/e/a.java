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
    private final com.facebook.imagepipeline.g.b kjZ;
    private final an kls;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.kls = anVar;
        this.kjZ = bVar;
        this.kjZ.a(anVar.cLK(), this.kls.cHd(), this.kls.getId(), this.kls.cLN());
        aiVar.a(cKD(), anVar);
    }

    private j<T> cKD() {
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
            protected void cKE() {
                a.this.cKE();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bg(float f) {
                a.this.aY(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable T t, boolean z) {
        if (super.a((a<T>) t, z) && z) {
            this.kjZ.a(this.kls.cLK(), this.kls.getId(), this.kls.cLN());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.kjZ.a(this.kls.cLK(), this.kls.getId(), th, this.kls.cLN());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cKE() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean AM() {
        if (!super.AM()) {
            return false;
        }
        if (!super.isFinished()) {
            this.kjZ.Ip(this.kls.getId());
            this.kls.cancel();
        }
        return true;
    }
}
