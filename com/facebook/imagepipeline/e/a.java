package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c naM;
    private final ap ncp;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.ncp = apVar;
        this.naM = cVar;
        this.naM.a(apVar.dJo(), this.ncp.dDT(), this.ncp.getId(), this.ncp.dJr());
        ajVar.c(dHY(), apVar);
    }

    private k<T> dHY() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(@Nullable T t, int i) {
                a.this.g(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void E(Throwable th) {
                a.this.E(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dHZ() {
                a.this.dHZ();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.aD(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean JH = com.facebook.imagepipeline.producers.b.JH(i);
        if (super.b(t, JH) && JH) {
            this.naM.a(this.ncp.dJo(), this.ncp.getId(), this.ncp.dJr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Throwable th) {
        if (super.y(th)) {
            this.naM.a(this.ncp.dJo(), this.ncp.getId(), th, this.ncp.dJr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dHZ() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean abo() {
        if (!super.abo()) {
            return false;
        }
        if (!super.isFinished()) {
            this.naM.Rw(this.ncp.getId());
            this.ncp.cancel();
        }
        return true;
    }
}
