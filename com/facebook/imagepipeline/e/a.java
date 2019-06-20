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
    private final com.facebook.imagepipeline.g.b jZp;
    private final an kaI;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.kaI = anVar;
        this.jZp = bVar;
        this.jZp.a(anVar.cHx(), this.kaI.cCT(), this.kaI.getId(), this.kaI.cHA());
        aiVar.a(cGr(), anVar);
    }

    private j<T> cGr() {
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
            protected void cGs() {
                a.this.cGs();
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
            this.jZp.a(this.kaI.cHx(), this.kaI.getId(), this.kaI.cHA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.jZp.a(this.kaI.cHx(), this.kaI.getId(), th, this.kaI.cHA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cGs() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Ab() {
        if (!super.Ab()) {
            return false;
        }
        if (!super.isFinished()) {
            this.jZp.GU(this.kaI.getId());
            this.kaI.cancel();
        }
        return true;
    }
}
