package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes10.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c lRl;
    private final ap lSO;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.lSO = apVar;
        this.lRl = cVar;
        this.lRl.a(apVar.dqj(), this.lSO.dkQ(), this.lSO.getId(), this.lSO.dqm());
        ajVar.c(doS(), apVar);
    }

    private k<T> doS() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(@Nullable T t, int i) {
                a.this.f(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void C(Throwable th) {
                a.this.C(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void doT() {
                a.this.doT();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bt(float f) {
                a.this.bk(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable T t, int i) {
        boolean IE = com.facebook.imagepipeline.producers.b.IE(i);
        if (super.b(t, IE) && IE) {
            this.lRl.a(this.lSO.dqj(), this.lSO.getId(), this.lSO.dqm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Throwable th) {
        if (super.v(th)) {
            this.lRl.a(this.lSO.dqj(), this.lSO.getId(), th, this.lSO.dqm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doT() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean Mn() {
        if (!super.Mn()) {
            return false;
        }
        if (!super.isFinished()) {
            this.lRl.OL(this.lSO.getId());
            this.lSO.cancel();
        }
        return true;
    }
}
