package com.facebook.imagepipeline.d;

import com.facebook.common.internal.g;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.k;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public abstract class a<T> extends AbstractDataSource<T> {
    private final com.facebook.imagepipeline.g.c plr;
    private final ap pmS;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(aj<T> ajVar, ap apVar, com.facebook.imagepipeline.g.c cVar) {
        this.pmS = apVar;
        this.plr = cVar;
        this.plr.a(apVar.eww(), this.pmS.ern(), this.pmS.getId(), this.pmS.ewz());
        ajVar.a(evj(), apVar);
    }

    private k<T> evj() {
        return new com.facebook.imagepipeline.producers.b<T>() { // from class: com.facebook.imagepipeline.d.a.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(@Nullable T t, int i) {
                a.this.g(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void D(Throwable th) {
                a.this.D(th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void evk() {
                a.this.evk();
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void by(float f) {
                a.this.bq(f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable T t, int i) {
        boolean Rh = com.facebook.imagepipeline.producers.b.Rh(i);
        if (super.b(t, Rh) && Rh) {
            this.plr.a(this.pmS.eww(), this.pmS.getId(), this.pmS.ewz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (super.x(th)) {
            this.plr.a(this.pmS.eww(), this.pmS.getId(), th, this.pmS.ewz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void evk() {
        g.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean arP() {
        if (!super.arP()) {
            return false;
        }
        if (!super.isFinished()) {
            this.plr.Zn(this.pmS.getId());
            this.pmS.cancel();
        }
        return true;
    }
}
