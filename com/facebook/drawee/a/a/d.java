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
    private static final Class<?> prQ = d.class;
    private final Resources mResources;
    private com.facebook.cache.common.b psJ;
    private final com.facebook.imagepipeline.e.a puB;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.e.a> puC;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puD;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> puE;
    private boolean puF;
    @Nullable
    private com.facebook.drawee.a.a.a.g puG;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.g.c> puH;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b puI;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> puv;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.puB = new a(resources, aVar2);
        this.puC = immutableList;
        this.puD = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.L(str, obj);
        a(jVar);
        this.psJ = bVar;
        a(immutableList);
        euN();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.puG != null) {
            this.puG.reset();
        }
        if (fVar != null) {
            if (this.puG == null) {
                this.puG = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.puG.b(fVar);
            this.puG.setEnabled(true);
        }
    }

    public void AR(boolean z) {
        this.puF = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        this.puv = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.g.c cVar) {
        if (this.puH == null) {
            this.puH = new HashSet();
        }
        this.puH.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.g.c cVar) {
        if (this.puH != null) {
            this.puH.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.puI instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.puI).a(bVar);
        } else if (this.puI != null) {
            this.puI = new com.facebook.drawee.a.a.a.a(this.puI, bVar);
        } else {
            this.puI = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.puI instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.puI).b(bVar);
        } else if (this.puI != null) {
            this.puI = new com.facebook.drawee.a.a.a.a(this.puI, bVar);
        } else {
            this.puI = bVar;
        }
    }

    protected void euN() {
        synchronized (this) {
            this.puI = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar) {
        this.puE = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.g.c euO() {
        com.facebook.imagepipeline.g.c cVar;
        com.facebook.imagepipeline.g.c cVar2 = this.puI != null ? new com.facebook.drawee.a.a.a.c(getId(), this.puI) : null;
        if (this.puH != null) {
            com.facebook.imagepipeline.g.b bVar = new com.facebook.imagepipeline.g.b(this.puH);
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
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> euP() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(prQ, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.puE.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable bk(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.f.c cVar = aVar.get();
        c(cVar);
        Drawable a2 = a(this.puv, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable a3 = a(this.puC, cVar);
        if (a3 != null) {
            return a3;
        }
        Drawable b2 = this.puB.b(cVar);
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
        if (this.puF) {
            if (evl() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                u(aVar);
            }
            if (evl() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) evl();
                aVar2.Zx(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (z = com.facebook.drawee.drawable.p.z(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = z.evP();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.Qk(cVar.getSizeInBytes());
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
            return aVar.euf();
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
            ((com.facebook.b.a.a) drawable).euE();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: euQ */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> euR() {
        if (this.puD == null || this.psJ == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.puD.bu(this.psJ);
        if (bu == null || bu.get().ezd().ezq()) {
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
            if (this.puI != null) {
                this.puI.g(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.bb(this).I("super", super.toString()).I("dataSourceSupplier", this.puE).toString();
    }
}
