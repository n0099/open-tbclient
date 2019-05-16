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
    private final com.facebook.imagepipeline.g.b jZl;
    private final an kaE;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.kaE = anVar;
        this.jZl = bVar;
        this.jZl.a(anVar.cHw(), this.kaE.cCS(), this.kaE.getId(), this.kaE.cHz());
        aiVar.a(cGq(), anVar);
    }

    private j<T> cGq() {
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
            protected void cGr() {
                a.this.cGr();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void be(float f) {
                a.this.aW(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable T t, boolean z) {
        if (super.a((a<T>) t, z) && z) {
            this.jZl.a(this.kaE.cHw(), this.kaE.getId(), this.kaE.cHz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.jZl.a(this.kaE.cHw(), this.kaE.getId(), th, this.kaE.cHz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cGr() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Ab() {
        if (!super.Ab()) {
            return false;
        }
        if (!super.isFinished()) {
            this.jZl.GS(this.kaE.getId());
            this.kaE.cancel();
        }
        return true;
    }
}
