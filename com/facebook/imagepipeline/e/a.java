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
    private final com.facebook.imagepipeline.g.b kil;
    private final an kjE;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ai<T> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        this.kjE = anVar;
        this.kil = bVar;
        this.kil.a(anVar.cIH(), this.kjE.cEb(), this.kjE.getId(), this.kjE.cIK());
        aiVar.a(cHA(), anVar);
    }

    private j<T> cHA() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.e.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void e(@Nullable T t, boolean z) {
                a.this.e(t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void z(Throwable th) {
                a.this.z(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cHB() {
                a.this.cHB();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aJ(float f) {
                a.this.aB(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@Nullable T t, boolean z) {
        if (super.b(t, z) && z) {
            this.kil.a(this.kjE.cIH(), this.kjE.getId(), this.kjE.cIK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Throwable th) {
        if (super.s(th)) {
            this.kil.a(this.kjE.cIH(), this.kjE.getId(), th, this.kjE.cIK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cHB() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean FH() {
        if (!super.FH()) {
            return false;
        }
        if (!super.isFinished()) {
            this.kil.GG(this.kjE.getId());
            this.kjE.cancel();
        }
        return true;
    }
}
