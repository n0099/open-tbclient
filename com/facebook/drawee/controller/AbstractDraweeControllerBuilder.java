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
    private static final c<Object> jBG = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jBH = new NullPointerException("No image request was specified!");
    private static final AtomicLong jBO = new AtomicLong();
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> jAU;
    private String jBA;
    @Nullable
    private REQUEST jBI;
    @Nullable
    private REQUEST jBJ;
    @Nullable
    private REQUEST[] jBK;
    private boolean jBL;
    private boolean jBM;
    @Nullable
    private com.facebook.drawee.d.a jBN;
    private final Set<c> jBa;
    private boolean jBk;
    @Nullable
    private c<? super INFO> jBr;
    @Nullable
    private d jBs;
    @Nullable
    private Object jBv;
    private boolean jBz;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cuF();

    @ReturnsOwnership
    protected abstract a cuG();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.jBa = set;
        init();
    }

    private void init() {
        this.jBv = null;
        this.jBI = null;
        this.jBJ = null;
        this.jBK = null;
        this.jBL = true;
        this.jBr = null;
        this.jBs = null;
        this.jBk = false;
        this.jBM = false;
        this.jBN = null;
        this.jBA = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aL */
    public BUILDER aO(Object obj) {
        this.jBv = obj;
        return cuF();
    }

    @Nullable
    public Object cuW() {
        return this.jBv;
    }

    public BUILDER aM(REQUEST request) {
        this.jBI = request;
        return cuF();
    }

    @Nullable
    public REQUEST cuX() {
        return this.jBI;
    }

    public boolean cuY() {
        return this.jBz;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jBr = cVar;
        return cuF();
    }

    @Nullable
    public d cuZ() {
        return this.jBs;
    }

    @Nullable
    public String cva() {
        return this.jBA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jBN = aVar;
        return cuF();
    }

    @Nullable
    public com.facebook.drawee.d.a cvb() {
        return this.jBN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cvc */
    public a cvg() {
        validate();
        if (this.jBI == null && this.jBK == null && this.jBJ != null) {
            this.jBI = this.jBJ;
            this.jBJ = null;
        }
        return cvd();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jBK == null || this.jBI == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jAU == null || (this.jBK == null && this.jBI == null && this.jBJ == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cvd() {
        a cuG = cuG();
        cuG.rr(cuY());
        cuG.Fu(cva());
        cuG.a(cuZ());
        c(cuG);
        b(cuG);
        return cuG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cve() {
        return String.valueOf(jBO.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cvf() {
        if (this.jAU != null) {
            return this.jAU;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jBI != null) {
            iVar = aN(this.jBI);
        } else if (this.jBK != null) {
            iVar = a(this.jBK, this.jBL);
        }
        if (iVar != null && this.jBJ != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aN(this.jBJ));
            iVar = f.eu(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.y(jBH);
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
            arrayList.add(aN(request2));
        }
        return com.facebook.datasource.e.et(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aN(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object cuW = cuW();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cun */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cuW, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aA(this).q("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.jBa != null) {
            for (c cVar : this.jBa) {
                aVar.a(cVar);
            }
        }
        if (this.jBr != null) {
            aVar.a(this.jBr);
        }
        if (this.jBM) {
            aVar.a(jBG);
        }
    }

    protected void c(a aVar) {
        if (this.jBk) {
            com.facebook.drawee.components.b cuO = aVar.cuO();
            if (cuO == null) {
                cuO = new com.facebook.drawee.components.b();
                aVar.a(cuO);
            }
            cuO.rq(this.jBk);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cuP() == null) {
            aVar.a(com.facebook.drawee.c.a.eJ(this.mContext));
        }
    }
}
