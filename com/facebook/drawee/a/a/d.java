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
/* loaded from: classes12.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    private static final Class<?> lGm = d.class;
    private com.facebook.cache.common.b lHf;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lIW;
    private final com.facebook.imagepipeline.f.a lJe;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.f.a> lJf;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJg;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lJh;
    private boolean lJi;
    @Nullable
    private com.facebook.drawee.a.a.a.g lJj;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.h.c> lJk;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b lJl;
    private final Resources mResources;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.lJe = new a(resources, aVar2);
        this.lJf = immutableList;
        this.lJg = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.A(str, obj);
        a(jVar);
        this.lHf = bVar;
        a(immutableList);
        dkm();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.lJj != null) {
            this.lJj.reset();
        }
        if (fVar != null) {
            if (this.lJj == null) {
                this.lJj = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.lJj.b(fVar);
            this.lJj.setEnabled(true);
        }
    }

    public void uW(boolean z) {
        this.lJi = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        this.lIW = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.h.c cVar) {
        if (this.lJk == null) {
            this.lJk = new HashSet();
        }
        this.lJk.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.h.c cVar) {
        if (this.lJk != null) {
            this.lJk.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.lJl instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.lJl).a(bVar);
        } else if (this.lJl != null) {
            this.lJl = new com.facebook.drawee.a.a.a.a(this.lJl, bVar);
        } else {
            this.lJl = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.lJl instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.lJl).b(bVar);
        } else if (this.lJl != null) {
            this.lJl = new com.facebook.drawee.a.a.a.a(this.lJl, bVar);
        } else {
            this.lJl = bVar;
        }
    }

    protected void dkm() {
        synchronized (this) {
            this.lJl = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar) {
        this.lJh = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.h.c dkn() {
        com.facebook.imagepipeline.h.c cVar;
        com.facebook.imagepipeline.h.c cVar2 = this.lJl != null ? new com.facebook.drawee.a.a.a.c(getId(), this.lJl) : null;
        if (this.lJk != null) {
            com.facebook.imagepipeline.h.b bVar = new com.facebook.imagepipeline.h.b(this.lJk);
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
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dko() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.lJh.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable ba(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.g.c cVar = aVar.get();
        c(cVar);
        Drawable a = a(this.lIW, cVar);
        if (a != null) {
            return a;
        }
        Drawable a2 = a(this.lJf, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable b = this.lJe.b(cVar);
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
        o p;
        p.b bVar = null;
        if (this.lJi) {
            if (dkK() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                n(aVar);
            }
            if (dkK() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) dkK();
                aVar2.OK(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (p = com.facebook.drawee.drawable.p.p(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = p.dlm();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.Hx(cVar.getSizeInBytes());
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
    public com.facebook.imagepipeline.g.f aZ(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int aY(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        if (aVar != null) {
            return aVar.djD();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void aX(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void m(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).dkb();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: dkp */
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dkq() {
        if (this.lJg == null || this.lHf == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.lJg.bl(this.lHf);
        if (bl == null || bl.get().dpc().dpq()) {
            return bl;
        }
        bl.close();
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: a */
    public void z(String str, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        super.z(str, aVar);
        synchronized (this) {
            if (this.lJl != null) {
                this.lJl.h(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.aQ(this).x("super", super.toString()).x("dataSourceSupplier", this.lJh).toString();
    }
}
