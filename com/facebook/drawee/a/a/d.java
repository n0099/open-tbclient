package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.i;
import com.facebook.drawee.drawable.m;
import com.facebook.drawee.drawable.n;
import com.facebook.imagepipeline.c.t;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.imagepipeline.f.e> {
    private static final Class<?> hXm = d.class;
    private com.facebook.cache.common.b hYj;
    private final com.facebook.imagepipeline.a.a.a iaf;
    @Nullable
    private final ImmutableList<a> iag;
    @Nullable
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iah;
    private i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iai;
    private boolean iaj;
    private final a iak;
    private final Resources mResources;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<a> immutableList) {
        super(aVar, executor, str, obj);
        this.iak = new a() { // from class: com.facebook.drawee.a.a.d.1
            @Override // com.facebook.drawee.a.a.a
            public boolean a(com.facebook.imagepipeline.f.b bVar2) {
                return true;
            }

            @Override // com.facebook.drawee.a.a.a
            public Drawable b(com.facebook.imagepipeline.f.b bVar2) {
                if (!(bVar2 instanceof com.facebook.imagepipeline.f.c)) {
                    if (d.this.iaf != null) {
                        return d.this.iaf.d(bVar2);
                    }
                    return null;
                }
                com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar2;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(d.this.mResources, cVar.bVO());
                return (cVar.bVR() == 0 || cVar.bVR() == -1) ? bitmapDrawable : new com.facebook.drawee.drawable.i(bitmapDrawable, cVar.bVR());
            }
        };
        this.mResources = resources;
        this.iaf = aVar2;
        this.iah = tVar;
        this.hYj = bVar;
        this.iag = immutableList;
        a(iVar);
    }

    public void a(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        super.p(str, obj);
        a(iVar);
        this.hYj = bVar;
    }

    public void oO(boolean z) {
        this.iaj = z;
    }

    private void a(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar) {
        this.iai = iVar;
        c(null);
    }

    @Override // com.facebook.drawee.controller.a
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bRS() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.iai.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable aw(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        Drawable b;
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.f.b bVar = aVar.get();
        c(bVar);
        if (this.iag != null) {
            Iterator<a> it = this.iag.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a(bVar) && (b = next.b(bVar)) != null) {
                    return b;
                }
            }
        }
        Drawable b2 = this.iak.b(bVar);
        if (b2 != null) {
            return b2;
        }
        throw new UnsupportedOperationException("Unrecognized image class: " + bVar);
    }

    @Override // com.facebook.drawee.controller.a, com.facebook.drawee.d.a
    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        super.setHierarchy(bVar);
        c(null);
    }

    private void c(@Nullable com.facebook.imagepipeline.f.b bVar) {
        m l;
        n.b bVar2 = null;
        if (this.iaj) {
            Drawable bSk = bSk();
            if (bSk == null) {
                bSk = new com.facebook.drawee.b.a();
                g(bSk);
            }
            if (bSk instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar = (com.facebook.drawee.b.a) bSk;
                aVar.yG(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (l = n.l(hierarchy.getTopLevelDrawable())) != null) {
                    bVar2 = l.bSM();
                }
                aVar.a(bVar2);
                if (bVar != null) {
                    aVar.setDimensions(bVar.getWidth(), bVar.getHeight());
                    aVar.xB(bVar.getSizeInBytes());
                    return;
                }
                aVar.reset();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: e */
    public com.facebook.imagepipeline.f.e av(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int au(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        if (aVar != null) {
            return aVar.bRi();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void at(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void f(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).bRL();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: bRT */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.b> bRU() {
        if (this.iah == null || this.hYj == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aG = this.iah.aG(this.hYj);
        if (aG == null || aG.get().bVP().bWa()) {
            return aG;
        }
        aG.close();
        return null;
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.an(this).n("super", super.toString()).n("dataSourceSupplier", this.iai).toString();
    }
}
