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
    private static final Class<?> jyG = d.class;
    private boolean jBA;
    private final a jBB;
    private final com.facebook.imagepipeline.a.a.a jBw;
    @Nullable
    private final ImmutableList<a> jBx;
    @Nullable
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBy;
    private i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> jBz;
    private com.facebook.cache.common.b jzB;
    private final Resources mResources;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<a> immutableList) {
        super(aVar, executor, str, obj);
        this.jBB = new a() { // from class: com.facebook.drawee.a.a.d.1
            @Override // com.facebook.drawee.a.a.a
            public boolean a(com.facebook.imagepipeline.f.b bVar2) {
                return true;
            }

            @Override // com.facebook.drawee.a.a.a
            public Drawable b(com.facebook.imagepipeline.f.b bVar2) {
                if (!(bVar2 instanceof com.facebook.imagepipeline.f.c)) {
                    if (d.this.jBw != null) {
                        return d.this.jBw.d(bVar2);
                    }
                    return null;
                }
                com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar2;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(d.this.mResources, cVar.cyK());
                return (cVar.cyN() == 0 || cVar.cyN() == -1) ? bitmapDrawable : new com.facebook.drawee.drawable.i(bitmapDrawable, cVar.cyN());
            }
        };
        this.mResources = resources;
        this.jBw = aVar2;
        this.jBy = tVar;
        this.jzB = bVar;
        this.jBx = immutableList;
        a(iVar);
    }

    public void a(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        super.s(str, obj);
        a(iVar);
        this.jzB = bVar;
    }

    public void rp(boolean z) {
        this.jBA = z;
    }

    private void a(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar) {
        this.jBz = iVar;
        c(null);
    }

    @Override // com.facebook.drawee.controller.a
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cuG() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.jBz.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable aN(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        Drawable b;
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.f.b bVar = aVar.get();
        c(bVar);
        if (this.jBx != null) {
            Iterator<a> it = this.jBx.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a(bVar) && (b = next.b(bVar)) != null) {
                    return b;
                }
            }
        }
        Drawable b2 = this.jBB.b(bVar);
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
        m m;
        n.b bVar2 = null;
        if (this.jBA) {
            Drawable cuY = cuY();
            if (cuY == null) {
                cuY = new com.facebook.drawee.b.a();
                h(cuY);
            }
            if (cuY instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar = (com.facebook.drawee.b.a) cuY;
                aVar.FG(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (m = n.m(hierarchy.getTopLevelDrawable())) != null) {
                    bVar2 = m.cvC();
                }
                aVar.a(bVar2);
                if (bVar != null) {
                    aVar.setDimensions(bVar.getWidth(), bVar.getHeight());
                    aVar.Ca(bVar.getSizeInBytes());
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
    public com.facebook.imagepipeline.f.e aM(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int aL(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        if (aVar != null) {
            return aVar.ctX();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void aK(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void g(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).cuz();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: cuH */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.b> cuI() {
        if (this.jBy == null || this.jzB == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aX = this.jBy.aX(this.jzB);
        if (aX == null || aX.get().cyL().cyW()) {
            return aX;
        }
        aX.close();
        return null;
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.aE(this).q("super", super.toString()).q("dataSourceSupplier", this.jBz).toString();
    }
}
