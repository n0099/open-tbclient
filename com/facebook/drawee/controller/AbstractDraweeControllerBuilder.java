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
    private i<com.facebook.datasource.b<IMAGE>> jBH;
    private final Set<c> jBN;
    private boolean jBX;
    @Nullable
    private com.facebook.drawee.d.a jCA;
    @Nullable
    private c<? super INFO> jCe;
    @Nullable
    private d jCf;
    @Nullable
    private Object jCi;
    private boolean jCm;
    private String jCn;
    @Nullable
    private REQUEST jCv;
    @Nullable
    private REQUEST jCw;
    @Nullable
    private REQUEST[] jCx;
    private boolean jCy;
    private boolean jCz;
    private final Context mContext;
    private static final c<Object> jCt = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jCu = new NullPointerException("No image request was specified!");
    private static final AtomicLong jCB = new AtomicLong();

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cuJ();

    @ReturnsOwnership
    protected abstract a cuK();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.jBN = set;
        init();
    }

    private void init() {
        this.jCi = null;
        this.jCv = null;
        this.jCw = null;
        this.jCx = null;
        this.jCy = true;
        this.jCe = null;
        this.jCf = null;
        this.jBX = false;
        this.jCz = false;
        this.jCA = null;
        this.jCn = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aP */
    public BUILDER aS(Object obj) {
        this.jCi = obj;
        return cuJ();
    }

    @Nullable
    public Object cva() {
        return this.jCi;
    }

    public BUILDER aQ(REQUEST request) {
        this.jCv = request;
        return cuJ();
    }

    @Nullable
    public REQUEST cvb() {
        return this.jCv;
    }

    public boolean cvc() {
        return this.jCm;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jCe = cVar;
        return cuJ();
    }

    @Nullable
    public d cvd() {
        return this.jCf;
    }

    @Nullable
    public String cve() {
        return this.jCn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jCA = aVar;
        return cuJ();
    }

    @Nullable
    public com.facebook.drawee.d.a cvf() {
        return this.jCA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cvg */
    public a cvk() {
        validate();
        if (this.jCv == null && this.jCx == null && this.jCw != null) {
            this.jCv = this.jCw;
            this.jCw = null;
        }
        return cvh();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jCx == null || this.jCv == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jBH == null || (this.jCx == null && this.jCv == null && this.jCw == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cvh() {
        a cuK = cuK();
        cuK.rr(cvc());
        cuK.FG(cve());
        cuK.a(cvd());
        c(cuK);
        b(cuK);
        return cuK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cvi() {
        return String.valueOf(jCB.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cvj() {
        if (this.jBH != null) {
            return this.jBH;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jCv != null) {
            iVar = aR(this.jCv);
        } else if (this.jCx != null) {
            iVar = a(this.jCx, this.jCy);
        }
        if (iVar != null && this.jCw != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aR(this.jCw));
            iVar = f.ex(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.y(jCu);
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
            arrayList.add(aR(request2));
        }
        return com.facebook.datasource.e.ew(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aR(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object cva = cva();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cur */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cva, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aE(this).q("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.jBN != null) {
            for (c cVar : this.jBN) {
                aVar.a(cVar);
            }
        }
        if (this.jCe != null) {
            aVar.a(this.jCe);
        }
        if (this.jCz) {
            aVar.a(jCt);
        }
    }

    protected void c(a aVar) {
        if (this.jBX) {
            com.facebook.drawee.components.b cuS = aVar.cuS();
            if (cuS == null) {
                cuS = new com.facebook.drawee.components.b();
                aVar.a(cuS);
            }
            cuS.rq(this.jBX);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cuT() == null) {
            aVar.a(com.facebook.drawee.c.a.eL(this.mContext));
        }
    }
}
