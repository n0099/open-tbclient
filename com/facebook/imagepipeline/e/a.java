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
    private final com.facebook.imagepipeline.g.b jHl;
    private final an jIE;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.jIE = anVar;
        this.jHl = bVar;
        this.jHl.a(anVar.czE(), this.jIE.cva(), this.jIE.getId(), this.jIE.czH());
        aiVar.a(cyy(), anVar);
    }

    private j<T> cyy() {
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
            protected void cyz() {
                a.this.cyz();
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
            this.jHl.a(this.jIE.czE(), this.jIE.getId(), this.jIE.czH());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Throwable th) {
        if (super.u(th)) {
            this.jHl.a(this.jIE.czE(), this.jIE.getId(), th, this.jIE.czH());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cyz() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean zf() {
        if (!super.zf()) {
            return false;
        }
        if (!super.isFinished()) {
            this.jHl.FJ(this.jIE.getId());
            this.jIE.cancel();
        }
        return true;
    }
}
