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
    private final com.facebook.imagepipeline.g.b irm;
    private final an isC;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.isC = anVar;
        this.irm = bVar;
        this.irm.a(anVar.cap(), this.isC.bVS(), this.isC.getId(), this.isC.cas());
        aiVar.a(bZj(), anVar);
    }

    private j<T> bZj() {
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
            protected void bZk() {
                a.this.bZk();
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
            this.irm.a(this.isC.cap(), this.isC.getId(), this.isC.cas());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.irm.a(this.isC.cap(), this.isC.getId(), th, this.isC.cas());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bZk() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean bVg() {
        if (!super.bVg()) {
            return false;
        }
        if (!super.isFinished()) {
            this.irm.zD(this.isC.getId());
            this.isC.cancel();
        }
        return true;
    }
}
