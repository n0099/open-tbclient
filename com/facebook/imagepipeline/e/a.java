package com.facebook.imagepipeline.e;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.h.c oLE;
    private final ap oNf;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        this.oNf = apVar;
        this.oLE = cVar;
        this.oLE.a(apVar.enf(), this.oNf.ehK(), this.oNf.getId(), this.oNf.eni());
        ajVar.c(elO(), apVar);
    }

    private k<T> elO() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(@Nullable T t, int i) {
                a.this.g(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void D(Throwable th) {
                a.this.D(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void elP() {
                a.this.elP();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bp(float f) {
                a.this.bg(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Pn = com.facebook.imagepipeline.producers.b.Pn(i);
        if (super.b(t, Pn) && Pn) {
            this.oLE.a(this.oNf.enf(), this.oNf.getId(), this.oNf.eni());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.oLE.a(this.oNf.enf(), this.oNf.getId(), th, this.oNf.eni());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void elP() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean amP() {
        if (!super.amP()) {
            return false;
        }
        if (!super.isFinished()) {
            this.oLE.XD(this.oNf.getId());
            this.oNf.cancel();
        }
        return true;
    }
}
