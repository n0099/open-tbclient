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
    private final com.facebook.imagepipeline.g.b jZm;
    private final an kaF;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.kaF = anVar;
        this.jZm = bVar;
        this.jZm.a(anVar.cHy(), this.kaF.cCU(), this.kaF.getId(), this.kaF.cHB());
        aiVar.a(cGs(), anVar);
    }

    private j<T> cGs() {
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
            protected void cGt() {
                a.this.cGt();
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
            this.jZm.a(this.kaF.cHy(), this.kaF.getId(), this.kaF.cHB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.jZm.a(this.kaF.cHy(), this.kaF.getId(), th, this.kaF.cHB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cGt() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Ab() {
        if (!super.Ab()) {
            return false;
        }
        if (!super.isFinished()) {
            this.jZm.GS(this.kaF.getId());
            this.kaF.cancel();
        }
        return true;
    }
}
