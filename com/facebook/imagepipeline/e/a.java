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
    private final com.facebook.imagepipeline.g.b idY;
    private final an ifo;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.ifo = anVar;
        this.idY = bVar;
        this.idY.a(anVar.bXq(), this.ifo.bST(), this.ifo.getId(), this.ifo.bXt());
        aiVar.a(bWk(), anVar);
    }

    private j<T> bWk() {
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
            protected void bWl() {
                a.this.bWl();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aK(float f) {
                a.this.aD(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable T t, boolean z) {
        if (super.a((a<T>) t, z) && z) {
            this.idY.a(this.ifo.bXq(), this.ifo.getId(), this.ifo.bXt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.idY.a(this.ifo.bXq(), this.ifo.getId(), th, this.ifo.bXt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bWl() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean bSh() {
        if (!super.bSh()) {
            return false;
        }
        if (!super.isFinished()) {
            this.idY.yC(this.ifo.getId());
            this.ifo.cancel();
        }
        return true;
    }
}
