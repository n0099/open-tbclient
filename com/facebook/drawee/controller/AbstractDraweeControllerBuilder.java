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
    private static final c<Object> jBF = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jBG = new NullPointerException("No image request was specified!");
    private static final AtomicLong jBN = new AtomicLong();
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> jAT;
    private final Set<c> jAZ;
    @Nullable
    private REQUEST jBH;
    @Nullable
    private REQUEST jBI;
    @Nullable
    private REQUEST[] jBJ;
    private boolean jBK;
    private boolean jBL;
    @Nullable
    private com.facebook.drawee.d.a jBM;
    private boolean jBj;
    @Nullable
    private c<? super INFO> jBq;
    @Nullable
    private d jBr;
    @Nullable
    private Object jBu;
    private boolean jBy;
    private String jBz;
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
        this.jAZ = set;
        init();
    }

    private void init() {
        this.jBu = null;
        this.jBH = null;
        this.jBI = null;
        this.jBJ = null;
        this.jBK = true;
        this.jBq = null;
        this.jBr = null;
        this.jBj = false;
        this.jBL = false;
        this.jBM = null;
        this.jBz = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aL */
    public BUILDER aO(Object obj) {
        this.jBu = obj;
        return cuF();
    }

    @Nullable
    public Object cuW() {
        return this.jBu;
    }

    public BUILDER aM(REQUEST request) {
        this.jBH = request;
        return cuF();
    }

    @Nullable
    public REQUEST cuX() {
        return this.jBH;
    }

    public boolean cuY() {
        return this.jBy;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jBq = cVar;
        return cuF();
    }

    @Nullable
    public d cuZ() {
        return this.jBr;
    }

    @Nullable
    public String cva() {
        return this.jBz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jBM = aVar;
        return cuF();
    }

    @Nullable
    public com.facebook.drawee.d.a cvb() {
        return this.jBM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cvc */
    public a cvg() {
        validate();
        if (this.jBH == null && this.jBJ == null && this.jBI != null) {
            this.jBH = this.jBI;
            this.jBI = null;
        }
        return cvd();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jBJ == null || this.jBH == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jAT == null || (this.jBJ == null && this.jBH == null && this.jBI == null)) {
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
        return String.valueOf(jBN.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cvf() {
        if (this.jAT != null) {
            return this.jAT;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jBH != null) {
            iVar = aN(this.jBH);
        } else if (this.jBJ != null) {
            iVar = a(this.jBJ, this.jBK);
        }
        if (iVar != null && this.jBI != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aN(this.jBI));
            iVar = f.eu(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.y(jBG);
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
        if (this.jAZ != null) {
            for (c cVar : this.jAZ) {
                aVar.a(cVar);
            }
        }
        if (this.jBq != null) {
            aVar.a(this.jBq);
        }
        if (this.jBL) {
            aVar.a(jBF);
        }
    }

    protected void c(a aVar) {
        if (this.jBj) {
            com.facebook.drawee.components.b cuO = aVar.cuO();
            if (cuO == null) {
                cuO = new com.facebook.drawee.components.b();
                aVar.a(cuO);
            }
            cuO.rq(this.jBj);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cuP() == null) {
            aVar.a(com.facebook.drawee.c.a.eJ(this.mContext));
        }
    }
}
