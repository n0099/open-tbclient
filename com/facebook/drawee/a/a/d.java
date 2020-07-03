package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.c.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    private static final Class<?> mHo = d.class;
    private com.facebook.cache.common.b mIi;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mKc;
    private final com.facebook.imagepipeline.f.a mKj;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.f.a> mKk;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKl;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mKm;
    private boolean mKn;
    @Nullable
    private com.facebook.drawee.a.a.a.g mKo;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.h.c> mKp;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b mKq;
    private final Resources mResources;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.mKj = new a(resources, aVar2);
        this.mKk = immutableList;
        this.mKl = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.I(str, obj);
        a(jVar);
        this.mIi = bVar;
        a(immutableList);
        dAb();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.mKo != null) {
            this.mKo.reset();
        }
        if (fVar != null) {
            if (this.mKo == null) {
                this.mKo = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.mKo.b(fVar);
            this.mKo.setEnabled(true);
        }
    }

    public void wr(boolean z) {
        this.mKn = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        this.mKc = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.h.c cVar) {
        if (this.mKp == null) {
            this.mKp = new HashSet();
        }
        this.mKp.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.h.c cVar) {
        if (this.mKp != null) {
            this.mKp.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.mKq instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.mKq).a(bVar);
        } else if (this.mKq != null) {
            this.mKq = new com.facebook.drawee.a.a.a.a(this.mKq, bVar);
        } else {
            this.mKq = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.mKq instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.mKq).b(bVar);
        } else if (this.mKq != null) {
            this.mKq = new com.facebook.drawee.a.a.a.a(this.mKq, bVar);
        } else {
            this.mKq = bVar;
        }
    }

    protected void dAb() {
        synchronized (this) {
            this.mKq = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar) {
        this.mKm = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.h.c dAc() {
        com.facebook.imagepipeline.h.c cVar;
        com.facebook.imagepipeline.h.c cVar2 = this.mKq != null ? new com.facebook.drawee.a.a.a.c(getId(), this.mKq) : null;
        if (this.mKp != null) {
            com.facebook.imagepipeline.h.b bVar = new com.facebook.imagepipeline.h.b(this.mKp);
            cVar = bVar;
            if (cVar2 != null) {
                bVar.a(cVar2);
                cVar = bVar;
            }
        } else {
            cVar = cVar2;
        }
        return cVar;
    }

    @Override // com.facebook.drawee.controller.a
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dAd() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.mKm.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable aY(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.g.c cVar = aVar.get();
        c(cVar);
        Drawable a = a(this.mKc, cVar);
        if (a != null) {
            return a;
        }
        Drawable a2 = a(this.mKk, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable b = this.mKj.b(cVar);
        if (b != null) {
            return b;
        }
        throw new UnsupportedOperationException("Unrecognized image class: " + cVar);
    }

    private Drawable a(@Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, com.facebook.imagepipeline.g.c cVar) {
        Drawable b;
        if (immutableList == null) {
            return null;
        }
        Iterator<com.facebook.imagepipeline.f.a> it = immutableList.iterator();
        while (it.hasNext()) {
            com.facebook.imagepipeline.f.a next = it.next();
            if (next.a(cVar) && (b = next.b(cVar)) != null) {
                return b;
            }
        }
        return null;
    }

    @Override // com.facebook.drawee.controller.a, com.facebook.drawee.d.a
    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        super.setHierarchy(bVar);
        c(null);
    }

    private void c(@Nullable com.facebook.imagepipeline.g.c cVar) {
        o l;
        p.b bVar = null;
        if (this.mKn) {
            if (dAz() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                j(aVar);
            }
            if (dAz() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) dAz();
                aVar2.QJ(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (l = com.facebook.drawee.drawable.p.l(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = l.dBc();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.Ie(cVar.getSizeInBytes());
                    return;
                }
                aVar2.reset();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: e */
    public com.facebook.imagepipeline.g.f aX(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int aW(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        if (aVar != null) {
            return aVar.dzt();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void aV(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void i(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).dzS();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: dAe */
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dAf() {
        if (this.mKl == null || this.mIi == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mKl.bj(this.mIi);
        if (bj == null || bj.get().dEU().dFi()) {
            return bj;
        }
        bj.close();
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: a */
    public void H(String str, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        super.H(str, aVar);
        synchronized (this) {
            if (this.mKq != null) {
                this.mKq.g(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("super", super.toString()).F("dataSourceSupplier", this.mKm).toString();
    }
}
