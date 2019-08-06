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
    private final com.facebook.imagepipeline.g.b khB;
    private final an kiV;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.kiV = anVar;
        this.khB = bVar;
        this.khB.a(anVar.cKW(), this.kiV.cGp(), this.kiV.getId(), this.kiV.cKZ());
        aiVar.a(cJP(), anVar);
    }

    private j<T> cJP() {
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
            protected void cJQ() {
                a.this.cJQ();
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
            this.khB.a(this.kiV.cKW(), this.kiV.getId(), this.kiV.cKZ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.khB.a(this.kiV.cKW(), this.kiV.getId(), th, this.kiV.cKZ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cJQ() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean AI() {
        if (!super.AI()) {
            return false;
        }
        if (!super.isFinished()) {
            this.khB.HP(this.kiV.getId());
            this.kiV.cancel();
        }
        return true;
    }
}
