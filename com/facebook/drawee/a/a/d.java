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
/* loaded from: classes6.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    private static final Class<?> pnn = d.class;
    private final Resources mResources;
    private com.facebook.cache.common.b pog;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pqb;
    private final com.facebook.imagepipeline.e.a pqh;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.e.a> pqi;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pqj;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pqk;
    private boolean pql;
    @Nullable
    private com.facebook.drawee.a.a.a.g pqm;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.g.c> pqn;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b pqo;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.pqh = new a(resources, aVar2);
        this.pqi = immutableList;
        this.pqj = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.L(str, obj);
        a(jVar);
        this.pog = bVar;
        a(immutableList);
        era();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.pqm != null) {
            this.pqm.reset();
        }
        if (fVar != null) {
            if (this.pqm == null) {
                this.pqm = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.pqm.b(fVar);
            this.pqm.setEnabled(true);
        }
    }

    public void AN(boolean z) {
        this.pql = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        this.pqb = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.g.c cVar) {
        if (this.pqn == null) {
            this.pqn = new HashSet();
        }
        this.pqn.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.g.c cVar) {
        if (this.pqn != null) {
            this.pqn.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.pqo instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.pqo).a(bVar);
        } else if (this.pqo != null) {
            this.pqo = new com.facebook.drawee.a.a.a.a(this.pqo, bVar);
        } else {
            this.pqo = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.pqo instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.pqo).b(bVar);
        } else if (this.pqo != null) {
            this.pqo = new com.facebook.drawee.a.a.a.a(this.pqo, bVar);
        } else {
            this.pqo = bVar;
        }
    }

    protected void era() {
        synchronized (this) {
            this.pqo = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar) {
        this.pqk = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.g.c erb() {
        com.facebook.imagepipeline.g.c cVar;
        com.facebook.imagepipeline.g.c cVar2 = this.pqo != null ? new com.facebook.drawee.a.a.a.c(getId(), this.pqo) : null;
        if (this.pqn != null) {
            com.facebook.imagepipeline.g.b bVar = new com.facebook.imagepipeline.g.b(this.pqn);
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
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> erc() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(pnn, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.pqk.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable bk(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.f.c cVar = aVar.get();
        c(cVar);
        Drawable a2 = a(this.pqb, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable a3 = a(this.pqi, cVar);
        if (a3 != null) {
            return a3;
        }
        Drawable b2 = this.pqh.b(cVar);
        if (b2 != null) {
            return b2;
        }
        throw new UnsupportedOperationException("Unrecognized image class: " + cVar);
    }

    private Drawable a(@Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, com.facebook.imagepipeline.f.c cVar) {
        Drawable b2;
        if (immutableList == null) {
            return null;
        }
        Iterator<com.facebook.imagepipeline.e.a> it = immutableList.iterator();
        while (it.hasNext()) {
            com.facebook.imagepipeline.e.a next = it.next();
            if (next.a(cVar) && (b2 = next.b(cVar)) != null) {
                return b2;
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
        o z;
        p.b bVar = null;
        if (this.pql) {
            if (erz() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                u(aVar);
            }
            if (erz() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) erz();
                aVar2.Yp(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (z = com.facebook.drawee.drawable.p.z(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = z.esd();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.OI(cVar.getSizeInBytes());
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
            return aVar.eqs();
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
    protected void t(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).eqR();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: erd */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> ere() {
        if (this.pqj == null || this.pog == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pqj.bu(this.pog);
        if (bu == null || bu.get().evO().ewc()) {
            return bu;
        }
        bu.close();
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: a */
    public void K(String str, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        super.K(str, aVar);
        synchronized (this) {
            if (this.pqo != null) {
                this.pqo.g(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.bb(this).I("super", super.toString()).I("dataSourceSupplier", this.pqk).toString();
    }
}
