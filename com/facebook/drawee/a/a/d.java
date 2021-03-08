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
/* loaded from: classes14.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    private static final Class<?> pAh = d.class;
    private final Resources mResources;
    private com.facebook.cache.common.b pBa;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pCP;
    private final com.facebook.imagepipeline.e.a pCV;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.e.a> pCW;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pCX;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pCY;
    private boolean pCZ;
    @Nullable
    private com.facebook.drawee.a.a.a.g pDa;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.g.c> pDb;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b pDc;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.pCV = new a(resources, aVar2);
        this.pCW = immutableList;
        this.pCX = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.J(str, obj);
        a(jVar);
        this.pBa = bVar;
        a(immutableList);
        etK();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.pDa != null) {
            this.pDa.reset();
        }
        if (fVar != null) {
            if (this.pDa == null) {
                this.pDa = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.pDa.b(fVar);
            this.pDa.setEnabled(true);
        }
    }

    public void Be(boolean z) {
        this.pCZ = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        this.pCP = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.g.c cVar) {
        if (this.pDb == null) {
            this.pDb = new HashSet();
        }
        this.pDb.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.g.c cVar) {
        if (this.pDb != null) {
            this.pDb.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.pDc instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.pDc).a(bVar);
        } else if (this.pDc != null) {
            this.pDc = new com.facebook.drawee.a.a.a.a(this.pDc, bVar);
        } else {
            this.pDc = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.pDc instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.pDc).b(bVar);
        } else if (this.pDc != null) {
            this.pDc = new com.facebook.drawee.a.a.a.a(this.pDc, bVar);
        } else {
            this.pDc = bVar;
        }
    }

    protected void etK() {
        synchronized (this) {
            this.pDc = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> jVar) {
        this.pCY = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.g.c etL() {
        com.facebook.imagepipeline.g.c cVar;
        com.facebook.imagepipeline.g.c cVar2 = this.pDc != null ? new com.facebook.drawee.a.a.a.c(getId(), this.pDc) : null;
        if (this.pDb != null) {
            com.facebook.imagepipeline.g.b bVar = new com.facebook.imagepipeline.g.b(this.pDb);
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
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> etM() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.pCY.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable bm(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.f.c cVar = aVar.get();
        c(cVar);
        Drawable a2 = a(this.pCP, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable a3 = a(this.pCW, cVar);
        if (a3 != null) {
            return a3;
        }
        Drawable b = this.pCV.b(cVar);
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
        o z;
        p.b bVar = null;
        if (this.pCZ) {
            if (eui() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                u(aVar);
            }
            if (eui() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) eui();
                aVar2.ZI(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (z = com.facebook.drawee.drawable.p.z(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = z.euM();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.Pi(cVar.getSizeInBytes());
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
    public com.facebook.imagepipeline.f.f bl(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int bk(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        if (aVar != null) {
            return aVar.etc();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void bj(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void t(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).etB();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: etN */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> etO() {
        if (this.pCX == null || this.pBa == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bw = this.pCX.bw(this.pBa);
        if (bw == null || bw.get().eyy().eyL()) {
            return bw;
        }
        bw.close();
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: a */
    public void I(String str, com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        super.I(str, aVar);
        synchronized (this) {
            if (this.pDc != null) {
                this.pDc.g(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.bd(this).G("super", super.toString()).G("dataSourceSupplier", this.pCY).toString();
    }
}
