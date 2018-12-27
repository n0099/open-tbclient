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
    private static final c<Object> ilr = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException ils = new NullPointerException("No image request was specified!");
    private static final AtomicLong ilz = new AtomicLong();
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> ikF;
    private final Set<c> ikL;
    private boolean ikV;
    @Nullable
    private c<? super INFO> ilc;
    @Nullable
    private d ild;
    @Nullable
    private Object ilg;
    private boolean ilk;
    private String ill;
    @Nullable
    private REQUEST ilt;
    @Nullable
    private REQUEST ilu;
    @Nullable
    private REQUEST[] ilv;
    private boolean ilw;
    private boolean ilx;
    @Nullable
    private com.facebook.drawee.d.a ily;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER bUU();

    @ReturnsOwnership
    protected abstract a bUV();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.ikL = set;
        init();
    }

    private void init() {
        this.ilg = null;
        this.ilt = null;
        this.ilu = null;
        this.ilv = null;
        this.ilw = true;
        this.ilc = null;
        this.ild = null;
        this.ikV = false;
        this.ilx = false;
        this.ily = null;
        this.ill = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: az */
    public BUILDER aC(Object obj) {
        this.ilg = obj;
        return bUU();
    }

    @Nullable
    public Object bVk() {
        return this.ilg;
    }

    public BUILDER aA(REQUEST request) {
        this.ilt = request;
        return bUU();
    }

    @Nullable
    public REQUEST bVl() {
        return this.ilt;
    }

    public boolean bVm() {
        return this.ilk;
    }

    public BUILDER oW(boolean z) {
        this.ilx = z;
        return bUU();
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.ilc = cVar;
        return bUU();
    }

    @Nullable
    public d bVn() {
        return this.ild;
    }

    @Nullable
    public String bVo() {
        return this.ill;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.ily = aVar;
        return bUU();
    }

    @Nullable
    public com.facebook.drawee.d.a bVp() {
        return this.ily;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bVq */
    public a bVu() {
        validate();
        if (this.ilt == null && this.ilv == null && this.ilu != null) {
            this.ilt = this.ilu;
            this.ilu = null;
        }
        return bVr();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.ilv == null || this.ilt == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.ikF == null || (this.ilv == null && this.ilt == null && this.ilu == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a bVr() {
        a bUV = bUV();
        bUV.oV(bVm());
        bUV.zl(bVo());
        bUV.a(bVn());
        c(bUV);
        b(bUV);
        return bUV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String bVs() {
        return String.valueOf(ilz.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> bVt() {
        if (this.ikF != null) {
            return this.ikF;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.ilt != null) {
            iVar = aB(this.ilt);
        } else if (this.ilv != null) {
            iVar = a(this.ilv, this.ilw);
        }
        if (iVar != null && this.ilu != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aB(this.ilu));
            iVar = f.es(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(ils);
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
        return com.facebook.datasource.e.er(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aB(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object bVk = bVk();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: bUC */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, bVk, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ao(this).n("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.ikL != null) {
            for (c cVar : this.ikL) {
                aVar.a(cVar);
            }
        }
        if (this.ilc != null) {
            aVar.a(this.ilc);
        }
        if (this.ilx) {
            aVar.a(ilr);
        }
    }

    protected void c(a aVar) {
        if (this.ikV) {
            com.facebook.drawee.components.b bVd = aVar.bVd();
            if (bVd == null) {
                bVd = new com.facebook.drawee.components.b();
                aVar.a(bVd);
            }
            bVd.oU(this.ikV);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.bVe() == null) {
            aVar.a(com.facebook.drawee.c.a.dq(this.mContext));
        }
    }
}
