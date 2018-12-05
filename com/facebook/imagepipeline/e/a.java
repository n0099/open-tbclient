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
    private final com.facebook.imagepipeline.g.b imT;
    private final an iok;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.iok = anVar;
        this.imT = bVar;
        this.imT.a(anVar.bYR(), this.iok.bUu(), this.iok.getId(), this.iok.bYU());
        aiVar.a(bXL(), anVar);
    }

    private j<T> bXL() {
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
            protected void bXM() {
                a.this.bXM();
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
            this.imT.a(this.iok.bYR(), this.iok.getId(), this.iok.bYU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Throwable th) {
        if (super.t(th)) {
            this.imT.a(this.iok.bYR(), this.iok.getId(), th, this.iok.bYU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bXM() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean bTI() {
        if (!super.bTI()) {
            return false;
        }
        if (!super.isFinished()) {
            this.imT.zk(this.iok.getId());
            this.iok.cancel();
        }
        return true;
    }
}
