package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.g;
import com.facebook.common.internal.i;
import com.facebook.datasource.f;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> ilM;
    private final Set<c> ilS;
    @Nullable
    private REQUEST imB;
    @Nullable
    private REQUEST imC;
    @Nullable
    private REQUEST[] imD;
    private boolean imE;
    private boolean imF;
    @Nullable
    private com.facebook.drawee.d.a imG;
    private boolean imc;
    @Nullable
    private c<? super INFO> imk;
    @Nullable
    private d iml;
    @Nullable
    private Object imo;
    private boolean ims;
    private String imt;
    private final Context mContext;
    private static final c<Object> imz = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException imA = new NullPointerException("No image request was specified!");
    private static final AtomicLong imH = new AtomicLong();

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER bVC();

    @ReturnsOwnership
    protected abstract a bVD();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.ilS = set;
        init();
    }

    private void init() {
        this.imo = null;
        this.imB = null;
        this.imC = null;
        this.imD = null;
        this.imE = true;
        this.imk = null;
        this.iml = null;
        this.imc = false;
        this.imF = false;
        this.imG = null;
        this.imt = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: az */
    public BUILDER aC(Object obj) {
        this.imo = obj;
        return bVC();
    }

    @Nullable
    public Object bVS() {
        return this.imo;
    }

    public BUILDER aA(REQUEST request) {
        this.imB = request;
        return bVC();
    }

    @Nullable
    public REQUEST bVT() {
        return this.imB;
    }

    public boolean bVU() {
        return this.ims;
    }

    public BUILDER oX(boolean z) {
        this.imF = z;
        return bVC();
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.imk = cVar;
        return bVC();
    }

    @Nullable
    public d bVV() {
        return this.iml;
    }

    @Nullable
    public String bVW() {
        return this.imt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.imG = aVar;
        return bVC();
    }

    @Nullable
    public com.facebook.drawee.d.a bVX() {
        return this.imG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bVY */
    public a bWc() {
        validate();
        if (this.imB == null && this.imD == null && this.imC != null) {
            this.imB = this.imC;
            this.imC = null;
        }
        return bVZ();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.imD == null || this.imB == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.ilM == null || (this.imD == null && this.imB == null && this.imC == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a bVZ() {
        a bVD = bVD();
        bVD.oW(bVU());
        bVD.zB(bVW());
        bVD.a(bVV());
        c(bVD);
        b(bVD);
        return bVD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String bWa() {
        return String.valueOf(imH.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> bWb() {
        if (this.ilM != null) {
            return this.ilM;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.imB != null) {
            iVar = aB(this.imB);
        } else if (this.imD != null) {
            iVar = a(this.imD, this.imE);
        }
        if (iVar != null && this.imC != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aB(this.imC));
            iVar = f.et(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(imA);
        }
        return iVar;
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(aB(request2));
        }
        return com.facebook.datasource.e.es(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aB(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object bVS = bVS();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: bVk */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, bVS, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ao(this).n("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.ilS != null) {
            for (c cVar : this.ilS) {
                aVar.a(cVar);
            }
        }
        if (this.imk != null) {
            aVar.a(this.imk);
        }
        if (this.imF) {
            aVar.a(imz);
        }
    }

    protected void c(a aVar) {
        if (this.imc) {
            com.facebook.drawee.components.b bVL = aVar.bVL();
            if (bVL == null) {
                bVL = new com.facebook.drawee.components.b();
                aVar.a(bVL);
            }
            bVL.oV(this.imc);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.bVM() == null) {
            aVar.a(com.facebook.drawee.c.a.dq(this.mContext));
        }
    }
}
