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
    private static final c<Object> jCa = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jCb = new NullPointerException("No image request was specified!");
    private static final AtomicLong jCi = new AtomicLong();
    private boolean jBE;
    @Nullable
    private c<? super INFO> jBL;
    @Nullable
    private d jBM;
    @Nullable
    private Object jBP;
    private boolean jBT;
    private String jBU;
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> jBo;
    private final Set<c> jBu;
    @Nullable
    private REQUEST jCc;
    @Nullable
    private REQUEST jCd;
    @Nullable
    private REQUEST[] jCe;
    private boolean jCf;
    private boolean jCg;
    @Nullable
    private com.facebook.drawee.d.a jCh;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a cuA();

    protected abstract BUILDER cuz();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.jBu = set;
        init();
    }

    private void init() {
        this.jBP = null;
        this.jCc = null;
        this.jCd = null;
        this.jCe = null;
        this.jCf = true;
        this.jBL = null;
        this.jBM = null;
        this.jBE = false;
        this.jCg = false;
        this.jCh = null;
        this.jBU = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aO */
    public BUILDER aR(Object obj) {
        this.jBP = obj;
        return cuz();
    }

    @Nullable
    public Object cuQ() {
        return this.jBP;
    }

    public BUILDER aP(REQUEST request) {
        this.jCc = request;
        return cuz();
    }

    @Nullable
    public REQUEST cuR() {
        return this.jCc;
    }

    public boolean cuS() {
        return this.jBT;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jBL = cVar;
        return cuz();
    }

    @Nullable
    public d cuT() {
        return this.jBM;
    }

    @Nullable
    public String cuU() {
        return this.jBU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jCh = aVar;
        return cuz();
    }

    @Nullable
    public com.facebook.drawee.d.a cuV() {
        return this.jCh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cuW */
    public a cva() {
        validate();
        if (this.jCc == null && this.jCe == null && this.jCd != null) {
            this.jCc = this.jCd;
            this.jCd = null;
        }
        return cuX();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jCe == null || this.jCc == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jBo == null || (this.jCe == null && this.jCc == null && this.jCd == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cuX() {
        a cuA = cuA();
        cuA.rr(cuS());
        cuA.FD(cuU());
        cuA.a(cuT());
        c(cuA);
        b(cuA);
        return cuA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cuY() {
        return String.valueOf(jCi.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cuZ() {
        if (this.jBo != null) {
            return this.jBo;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jCc != null) {
            iVar = aQ(this.jCc);
        } else if (this.jCe != null) {
            iVar = a(this.jCe, this.jCf);
        }
        if (iVar != null && this.jCd != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aQ(this.jCd));
            iVar = f.ex(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.y(jCb);
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
            arrayList.add(aQ(request2));
        }
        return com.facebook.datasource.e.ew(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aQ(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object cuQ = cuQ();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cuh */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cuQ, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aD(this).q("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.jBu != null) {
            for (c cVar : this.jBu) {
                aVar.a(cVar);
            }
        }
        if (this.jBL != null) {
            aVar.a(this.jBL);
        }
        if (this.jCg) {
            aVar.a(jCa);
        }
    }

    protected void c(a aVar) {
        if (this.jBE) {
            com.facebook.drawee.components.b cuI = aVar.cuI();
            if (cuI == null) {
                cuI = new com.facebook.drawee.components.b();
                aVar.a(cuI);
            }
            cuI.rq(this.jBE);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cuJ() == null) {
            aVar.a(com.facebook.drawee.c.a.eL(this.mContext));
        }
    }
}
