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
    private static final Class<?> mls = d.class;
    private final Resources mResources;
    private com.facebook.cache.common.b mml;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> moc;
    private final com.facebook.imagepipeline.f.a moj;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.f.a> mok;
    @Nullable
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mol;
    private j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mom;
    private boolean moo;
    @Nullable
    private com.facebook.drawee.a.a.a.g mop;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.h.c> moq;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.a.a.a.b mor;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, @Nullable p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        super(aVar, executor, null, null);
        this.mResources = resources;
        this.moj = new a(resources, aVar2);
        this.mok = immutableList;
        this.mol = pVar;
    }

    public void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable com.facebook.drawee.a.a.a.b bVar2) {
        super.I(str, obj);
        a(jVar);
        this.mml = bVar;
        a(immutableList);
        dvy();
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@Nullable com.facebook.drawee.a.a.a.f fVar) {
        if (this.mop != null) {
            this.mop.reset();
        }
        if (fVar != null) {
            if (this.mop == null) {
                this.mop = new com.facebook.drawee.a.a.a.g(RealtimeSinceBootClock.get(), this);
            }
            this.mop.b(fVar);
            this.mop.setEnabled(true);
        }
    }

    public void vV(boolean z) {
        this.moo = z;
    }

    public void a(@Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        this.moc = immutableList;
    }

    public synchronized void a(com.facebook.imagepipeline.h.c cVar) {
        if (this.moq == null) {
            this.moq = new HashSet();
        }
        this.moq.add(cVar);
    }

    public synchronized void b(com.facebook.imagepipeline.h.c cVar) {
        if (this.moq != null) {
            this.moq.remove(cVar);
        }
    }

    public synchronized void a(com.facebook.drawee.a.a.a.b bVar) {
        if (this.mor instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.mor).a(bVar);
        } else if (this.mor != null) {
            this.mor = new com.facebook.drawee.a.a.a.a(this.mor, bVar);
        } else {
            this.mor = bVar;
        }
    }

    public synchronized void b(com.facebook.drawee.a.a.a.b bVar) {
        if (this.mor instanceof com.facebook.drawee.a.a.a.a) {
            ((com.facebook.drawee.a.a.a.a) this.mor).b(bVar);
        } else if (this.mor != null) {
            this.mor = new com.facebook.drawee.a.a.a.a(this.mor, bVar);
        } else {
            this.mor = bVar;
        }
    }

    protected void dvy() {
        synchronized (this) {
            this.mor = null;
        }
    }

    private void a(j<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> jVar) {
        this.mom = jVar;
        c(null);
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.h.c dvz() {
        com.facebook.imagepipeline.h.c cVar;
        com.facebook.imagepipeline.h.c cVar2 = this.mor != null ? new com.facebook.drawee.a.a.a.c(getId(), this.mor) : null;
        if (this.moq != null) {
            com.facebook.imagepipeline.h.b bVar = new com.facebook.imagepipeline.h.b(this.moq);
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
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dvA() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.mom.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable aX(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.g.c cVar = aVar.get();
        c(cVar);
        Drawable a = a(this.moc, cVar);
        if (a != null) {
            return a;
        }
        Drawable a2 = a(this.mok, cVar);
        if (a2 != null) {
            return a2;
        }
        Drawable b = this.moj.b(cVar);
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
        if (this.moo) {
            if (dvW() == null) {
                com.facebook.drawee.b.a aVar = new com.facebook.drawee.b.a();
                a(new com.facebook.drawee.b.a.a(aVar));
                j(aVar);
            }
            if (dvW() instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar2 = (com.facebook.drawee.b.a) dvW();
                aVar2.PX(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (l = com.facebook.drawee.drawable.p.l(hierarchy.getTopLevelDrawable())) != null) {
                    bVar = l.dwz();
                }
                aVar2.a(bVar);
                if (cVar != null) {
                    aVar2.setDimensions(cVar.getWidth(), cVar.getHeight());
                    aVar2.GX(cVar.getSizeInBytes());
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
    public com.facebook.imagepipeline.g.f aW(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int aV(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        if (aVar != null) {
            return aVar.duQ();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void aU(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void i(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).dvp();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: dvB */
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> dvC() {
        if (this.mol == null || this.mml == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bi = this.mol.bi(this.mml);
        if (bi == null || bi.get().dAs().dAG()) {
            return bi;
        }
        bi.close();
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: a */
    public void H(String str, com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        super.H(str, aVar);
        synchronized (this) {
            if (this.mor != null) {
                this.mor.g(str, 3, true);
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.aN(this).F("super", super.toString()).F("dataSourceSupplier", this.mom).toString();
    }
}
