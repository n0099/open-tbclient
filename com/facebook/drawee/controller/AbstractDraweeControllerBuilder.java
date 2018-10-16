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
    private static final c<Object> hZj = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException hZk = new NullPointerException("No image request was specified!");
    private static final AtomicLong hZr = new AtomicLong();
    private final Set<c> hYD;
    private boolean hYN;
    @Nullable
    private c<? super INFO> hYU;
    @Nullable
    private d hYV;
    @Nullable
    private Object hYY;
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> hYx;
    private boolean hZc;
    private String hZd;
    @Nullable
    private REQUEST hZl;
    @Nullable
    private REQUEST hZm;
    @Nullable
    private REQUEST[] hZn;
    private boolean hZo;
    private boolean hZp;
    @Nullable
    private com.facebook.drawee.d.a hZq;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER bSD();

    @ReturnsOwnership
    protected abstract a bSE();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.hYD = set;
        init();
    }

    private void init() {
        this.hYY = null;
        this.hZl = null;
        this.hZm = null;
        this.hZn = null;
        this.hZo = true;
        this.hYU = null;
        this.hYV = null;
        this.hYN = false;
        this.hZp = false;
        this.hZq = null;
        this.hZd = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: az */
    public BUILDER aC(Object obj) {
        this.hYY = obj;
        return bSD();
    }

    @Nullable
    public Object bST() {
        return this.hYY;
    }

    public BUILDER aA(REQUEST request) {
        this.hZl = request;
        return bSD();
    }

    @Nullable
    public REQUEST bSU() {
        return this.hZl;
    }

    public boolean bSV() {
        return this.hZc;
    }

    public BUILDER oD(boolean z) {
        this.hZp = z;
        return bSD();
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.hYU = cVar;
        return bSD();
    }

    @Nullable
    public d bSW() {
        return this.hYV;
    }

    @Nullable
    public String bSX() {
        return this.hZd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.hZq = aVar;
        return bSD();
    }

    @Nullable
    public com.facebook.drawee.d.a bSY() {
        return this.hZq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bSZ */
    public a bTd() {
        validate();
        if (this.hZl == null && this.hZn == null && this.hZm != null) {
            this.hZl = this.hZm;
            this.hZm = null;
        }
        return bTa();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.hZn == null || this.hZl == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.hYx == null || (this.hZn == null && this.hZl == null && this.hZm == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a bTa() {
        a bSE = bSE();
        bSE.oC(bSV());
        bSE.yA(bSX());
        bSE.a(bSW());
        c(bSE);
        b(bSE);
        return bSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String bTb() {
        return String.valueOf(hZr.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> bTc() {
        if (this.hYx != null) {
            return this.hYx;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.hZl != null) {
            iVar = aB(this.hZl);
        } else if (this.hZn != null) {
            iVar = a(this.hZn, this.hZo);
        }
        if (iVar != null && this.hZm != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aB(this.hZm));
            iVar = f.ep(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(hZk);
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
        return com.facebook.datasource.e.eo(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aB(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object bST = bST();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: bSl */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, bST, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ao(this).n("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.hYD != null) {
            for (c cVar : this.hYD) {
                aVar.a(cVar);
            }
        }
        if (this.hYU != null) {
            aVar.a(this.hYU);
        }
        if (this.hZp) {
            aVar.a(hZj);
        }
    }

    protected void c(a aVar) {
        if (this.hYN) {
            com.facebook.drawee.components.b bSM = aVar.bSM();
            if (bSM == null) {
                bSM = new com.facebook.drawee.components.b();
                aVar.a(bSM);
            }
            bSM.oB(this.hYN);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.bSN() == null) {
            aVar.a(com.facebook.drawee.c.a.dr(this.mContext));
        }
    }
}
