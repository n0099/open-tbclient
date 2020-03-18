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
    private final com.facebook.imagepipeline.h.c lTL;
    private final ap lVo;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.lVo = apVar;
        this.lTL = cVar;
        this.lTL.a(apVar.drV(), this.lVo.dmD(), this.lVo.getId(), this.lVo.drY());
        ajVar.c(dqE(), apVar);
    }

    private k<T> dqE() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(@Nullable T t, int i) {
                a.this.f(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.B(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dqF() {
                a.this.dqF();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bs(float f) {
                a.this.bj(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean IP = com.facebook.imagepipeline.producers.b.IP(i);
        if (super.b(t, IP) && IP) {
            this.lTL.a(this.lVo.drV(), this.lVo.getId(), this.lVo.drY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.u(th)) {
            this.lTL.a(this.lVo.drV(), this.lVo.getId(), th, this.lVo.drY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dqF() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean OG() {
        if (!super.OG()) {
            return false;
        }
        if (!super.isFinished()) {
            this.lTL.OY(this.lVo.getId());
            this.lVo.cancel();
        }
        return true;
    }
}
