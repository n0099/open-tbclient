package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c mwD;
    private final ap mye;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.mye = apVar;
        this.mwD = cVar;
        this.mwD.a(apVar.dBw(), this.mye.dwa(), this.mye.getId(), this.mye.dBz());
        ajVar.c(dAg(), apVar);
    }

    private k<T> dAg() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(@Nullable T t, int i) {
                a.this.g(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void F(Throwable th) {
                a.this.F(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dAh() {
                a.this.dAh();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aH(float f) {
                a.this.ay(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean If = com.facebook.imagepipeline.producers.b.If(i);
        if (super.b(t, If) && If) {
            this.mwD.a(this.mye.dBw(), this.mye.getId(), this.mye.dBz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Throwable th) {
        if (super.z(th)) {
            this.mwD.a(this.mye.dBw(), this.mye.getId(), th, this.mye.dBz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dAh() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Zg() {
        if (!super.Zg()) {
            return false;
        }
        if (!super.isFinished()) {
            this.mwD.PY(this.mye.getId());
            this.mye.cancel();
        }
        return true;
    }
}
