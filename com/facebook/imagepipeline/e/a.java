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
    private final com.facebook.imagepipeline.g.b ifI;
    private final an igY;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.igY = anVar;
        this.ifI = bVar;
        this.ifI.a(anVar.bWL(), this.igY.bSo(), this.igY.getId(), this.igY.bWO());
        aiVar.a(bVF(), anVar);
    }

    private j<T> bVF() {
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
            protected void bVG() {
                a.this.bVG();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.aF(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable T t, boolean z) {
        if (super.a((a<T>) t, z) && z) {
            this.ifI.a(this.igY.bWL(), this.igY.getId(), this.igY.bWO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.ifI.a(this.igY.bWL(), this.igY.getId(), th, this.igY.bWO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bVG() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean bRC() {
        if (!super.bRC()) {
            return false;
        }
        if (!super.isFinished()) {
            this.ifI.yH(this.igY.getId());
            this.igY.cancel();
        }
        return true;
    }
}
