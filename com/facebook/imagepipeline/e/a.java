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
    private final com.facebook.imagepipeline.g.b jGx;
    private final an jHQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.jHQ = anVar;
        this.jGx = bVar;
        this.jGx.a(anVar.czA(), this.jHQ.cuW(), this.jHQ.getId(), this.jHQ.czD());
        aiVar.a(cyu(), anVar);
    }

    private j<T> cyu() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void d(@Nullable T t, boolean z) {
                a.this.d(t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.B(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cyv() {
                a.this.cyv();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void ba(float f) {
                a.this.aS(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable T t, boolean z) {
        if (super.a((a<T>) t, z) && z) {
            this.jGx.a(this.jHQ.czA(), this.jHQ.getId(), this.jHQ.czD());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.u(th)) {
            this.jGx.a(this.jHQ.czA(), this.jHQ.getId(), th, this.jHQ.czD());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cyv() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean ze() {
        if (!super.ze()) {
            return false;
        }
        if (!super.isFinished()) {
            this.jGx.Fx(this.jHQ.getId());
            this.jHQ.cancel();
        }
        return true;
    }
}
