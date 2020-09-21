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
/* loaded from: classes15.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    private static final Class<?> ntL = d.class;
    private final Resources mResources;
    private com.facebook.cache.common.b nuF;
    private final com.facebook.imagepipeline.f.a nwD;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.f.a> nwE;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nwF;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nwG;
    private boolean nwH;
    @Nullable
    private com.facebook.drawee.a.a.a.g nwI;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.h.c> nwJ;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b nwK;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nww;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.nwD = new a(resources, aVar2);
        this.nwE = immutableList;
        this.nwF = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.H(str, obj);
        a(jVar);
        this.nuF = bVar;
        a(immutableList);
        dTz();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.nwI != null) {
            this.nwI.reset();
        }
        if (fVar != null) {
            if (this.nwI == null) {
                this.nwI = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.nwI.b(fVar);
            this.nwI.setEnabled(true);
        }
    }

    public void xY(boolean z) {
        this.nwH = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        this.nww = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.h.c cVar) {
        if (this.nwJ == null) {
            this.nwJ = new HashSet();
        }
        this.nwJ.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.h.c cVar) {
        if (this.nwJ != null) {
            this.nwJ.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.nwK instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.nwK).a(bVar);
        } else if (this.nwK != null) {
            this.nwK = new com.facebook.drawee.a.a.a.a(this.nwK, bVar);
        } else {
            this.nwK = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.nwK instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.nwK).b(bVar);
        } else if (this.nwK != null) {
            this.nwK = new com.facebook.drawee.a.a.a.a(this.nwK, bVar);
        } else {
            this.nwK = bVar;
        }
    }

    protected void dTz() {
        synchronized (this) {
            this.nwK = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar) {
        this.nwG = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.h.c dTA() {
        com.facebook.imagepipeline.h.c cVar;
        com.facebook.imagepipeline.h.c cVar2 = this.nwK != null ? new com.facebook.drawee.a.a.a.c(getId(), this.nwK) : null;
        if (this.nwJ != null) {
            com.facebook.imagepipeline.h.b bVar = new com.facebook.imagepipeline.h.b(this.nwJ);
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
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.nwG.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable bc(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.g.c cVar = aVar.get();
        c(cVar);
        Drawable a = a(this.nww, cVar);
        if (a != null) {
            return a;
        }
        Drawable a2 = a(this.nwE, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable b = this.nwD.b(cVar);
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
        if (this.nwH) {
            if (dTX() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                j(aVar);
            }
            if (dTX() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) dTX();
                aVar2.Vb(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (l = com.facebook.drawee.drawable.p.l(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = l.dUA();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.LI(cVar.getSizeInBytes());
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
    public com.facebook.imagepipeline.g.f bb(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int ba(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        if (aVar != null) {
            return aVar.dSR();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void aZ(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void i(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).dTq();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: dTC */
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dTD() {
        if (this.nwF == null || this.nuF == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.nwF.bn(this.nuF);
        if (bn == null || bn.get().dYr().dYF()) {
            return bn;
        }
        bn.close();
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: a */
    public void G(String str, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        super.G(str, aVar);
        synchronized (this) {
            if (this.nwK != null) {
                this.nwK.g(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.aS(this).E("super", super.toString()).E("dataSourceSupplier", this.nwG).toString();
    }
}
