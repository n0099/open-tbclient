package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.b.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    private static final Class<?> paD = d.class;
    private final Resources mResources;
    private com.facebook.cache.common.b pbw;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b pdA;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pdn;
    private final com.facebook.imagepipeline.e.a pdt;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.e.a> pdu;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdv;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pdw;
    private boolean pdx;
    @Nullable
    private com.facebook.drawee.a.a.a.g pdy;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.g.c> pdz;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.pdt = new a(resources, aVar2);
        this.pdu = immutableList;
        this.pdv = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.H(str, obj);
        a(jVar);
        this.pbw = bVar;
        a(immutableList);
        eqK();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.pdy != null) {
            this.pdy.reset();
        }
        if (fVar != null) {
            if (this.pdy == null) {
                this.pdy = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.pdy.b(fVar);
            this.pdy.setEnabled(true);
        }
    }

    public void AJ(boolean z) {
        this.pdx = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        this.pdn = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.g.c cVar) {
        if (this.pdz == null) {
            this.pdz = new HashSet();
        }
        this.pdz.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.g.c cVar) {
        if (this.pdz != null) {
            this.pdz.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.pdA instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.pdA).a(bVar);
        } else if (this.pdA != null) {
            this.pdA = new com.facebook.drawee.a.a.a.a(this.pdA, bVar);
        } else {
            this.pdA = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.pdA instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.pdA).b(bVar);
        } else if (this.pdA != null) {
            this.pdA = new com.facebook.drawee.a.a.a.a(this.pdA, bVar);
        } else {
            this.pdA = bVar;
        }
    }

    protected void eqK() {
        synchronized (this) {
            this.pdA = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar) {
        this.pdw = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.g.c eqL() {
        com.facebook.imagepipeline.g.c cVar;
        com.facebook.imagepipeline.g.c cVar2 = this.pdA != null ? new com.facebook.drawee.a.a.a.c(getId(), this.pdA) : null;
        if (this.pdz != null) {
            com.facebook.imagepipeline.g.b bVar = new com.facebook.imagepipeline.g.b(this.pdz);
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
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eqM() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.pdw.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable bk(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.f.c cVar = aVar.get();
        c(cVar);
        Drawable a2 = a(this.pdn, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable a3 = a(this.pdu, cVar);
        if (a3 != null) {
            return a3;
        }
        Drawable b = this.pdt.b(cVar);
        if (b != null) {
            return b;
        }
        throw new UnsupportedOperationException("Unrecognized image class: " + cVar);
    }

    private Drawable a(@Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, com.facebook.imagepipeline.f.c cVar) {
        Drawable b;
        if (immutableList == null) {
            return null;
        }
        Iterator<com.facebook.imagepipeline.e.a> it = immutableList.iterator();
        while (it.hasNext()) {
            com.facebook.imagepipeline.e.a next = it.next();
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

    private void c(@Nullable com.facebook.imagepipeline.f.c cVar) {
        o r;
        p.b bVar = null;
        if (this.pdx) {
            if (eri() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                p(aVar);
            }
            if (eri() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) eri();
                aVar2.Zm(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (r = com.facebook.drawee.drawable.p.r(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = r.erL();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.Qb(cVar.getSizeInBytes());
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
    public com.facebook.imagepipeline.f.f bj(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int bi(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        if (aVar != null) {
            return aVar.eqc();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void bh(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void o(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).eqB();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: eqN */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> eqO() {
        if (this.pdv == null || this.pbw == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pdv.bu(this.pbw);
        if (bu == null || bu.get().evu().evI()) {
            return bu;
        }
        bu.close();
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: a */
    public void G(String str, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        super.G(str, aVar);
        synchronized (this) {
            if (this.pdA != null) {
                this.pdA.g(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.ba(this).E("super", super.toString()).E("dataSourceSupplier", this.pdw).toString();
    }
}
