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
    private static final Class<?> kbD = d.class;
    private com.facebook.cache.common.b kcx;
    private final com.facebook.imagepipeline.a.a.a ker;
    @Nullable
    private final ImmutableList<a> kes;
    @Nullable
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ket;
    private i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> keu;
    private boolean kev;
    private final a kew;
    private final Resources mResources;

    public d(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<a> immutableList) {
        super(aVar, executor, str, obj);
        this.kew = new a() { // from class: com.facebook.drawee.a.a.d.1
            @Override // com.facebook.drawee.a.a.a
            public boolean a(com.facebook.imagepipeline.f.b bVar2) {
                return true;
            }

            @Override // com.facebook.drawee.a.a.a
            public Drawable b(com.facebook.imagepipeline.f.b bVar2) {
                if (!(bVar2 instanceof com.facebook.imagepipeline.f.c)) {
                    if (d.this.ker != null) {
                        return d.this.ker.d(bVar2);
                    }
                    return null;
                }
                com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar2;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(d.this.mResources, cVar.cKM());
                return (cVar.cKP() == 0 || cVar.cKP() == -1) ? bitmapDrawable : new com.facebook.drawee.drawable.i(bitmapDrawable, cVar.cKP());
            }
        };
        this.mResources = resources;
        this.ker = aVar2;
        this.ket = tVar;
        this.kcx = bVar;
        this.kes = immutableList;
        a(iVar);
    }

    public void a(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        super.v(str, obj);
        a(iVar);
        this.kcx = bVar;
    }

    public void sy(boolean z) {
        this.kev = z;
    }

    private void a(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar) {
        this.keu = iVar;
        c(null);
    }

    @Override // com.facebook.drawee.controller.a
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGG() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.keu.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: d */
    public Drawable aL(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        Drawable b;
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        com.facebook.imagepipeline.f.b bVar = aVar.get();
        c(bVar);
        if (this.kes != null) {
            Iterator<a> it = this.kes.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a(bVar) && (b = next.b(bVar)) != null) {
                    return b;
                }
            }
        }
        Drawable b2 = this.kew.b(bVar);
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
        if (this.kev) {
            Drawable cGY = cGY();
            if (cGY == null) {
                cGY = new com.facebook.drawee.b.a();
                g(cGY);
            }
            if (cGY instanceof com.facebook.drawee.b.a) {
                com.facebook.drawee.b.a aVar = (com.facebook.drawee.b.a) cGY;
                aVar.Io(getId());
                com.facebook.drawee.d.b hierarchy = getHierarchy();
                if (hierarchy != null && (l = n.l(hierarchy.getTopLevelDrawable())) != null) {
                    bVar2 = l.cHD();
                }
                aVar.a(bVar2);
                if (bVar != null) {
                    aVar.setDimensions(bVar.getWidth(), bVar.getHeight());
                    aVar.DH(bVar.getSizeInBytes());
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
    public com.facebook.imagepipeline.f.e aK(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        com.facebook.common.internal.g.checkState(com.facebook.common.references.a.a(aVar));
        return aVar.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: f */
    public int aJ(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        if (aVar != null) {
            return aVar.cFY();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: g */
    public void aI(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    @Override // com.facebook.drawee.controller.a
    protected void f(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.b.a.a) {
            ((com.facebook.b.a.a) drawable).cGz();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: cGH */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.b> cGI() {
        if (this.ket == null || this.kcx == null) {
            return null;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.ket.aV(this.kcx);
        if (aV == null || aV.get().cKN().cKZ()) {
            return aV;
        }
        aV.close();
        return null;
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        return com.facebook.common.internal.f.aC(this).t("super", super.toString()).t("dataSourceSupplier", this.keu).toString();
    }
}
