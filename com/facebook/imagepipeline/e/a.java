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
    private final com.facebook.imagepipeline.g.b iqe;
    private final an iru;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.iru = anVar;
        this.iqe = bVar;
        this.iqe.a(anVar.bZH(), this.iru.bVk(), this.iru.getId(), this.iru.bZK());
        aiVar.a(bYB(), anVar);
    }

    private j<T> bYB() {
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
            protected void bYC() {
                a.this.bYC();
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
            this.iqe.a(this.iru.bZH(), this.iru.getId(), this.iru.bZK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.iqe.a(this.iru.bZH(), this.iru.getId(), th, this.iru.bZK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bYC() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean bUy() {
        if (!super.bUy()) {
            return false;
        }
        if (!super.isFinished()) {
            this.iqe.zn(this.iru.getId());
            this.iru.cancel();
        }
        return true;
    }
}
