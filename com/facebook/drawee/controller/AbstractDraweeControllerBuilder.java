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
    private static final c<Object> jCl = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jCm = new NullPointerException("No image request was specified!");
    private static final AtomicLong jCt = new AtomicLong();
    private final Set<c> jBF;
    private boolean jBP;
    @Nullable
    private c<? super INFO> jBW;
    @Nullable
    private d jBX;
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> jBz;
    @Nullable
    private Object jCa;
    private boolean jCe;
    private String jCf;
    @Nullable
    private REQUEST jCn;
    @Nullable
    private REQUEST jCo;
    @Nullable
    private REQUEST[] jCp;
    private boolean jCq;
    private boolean jCr;
    @Nullable
    private com.facebook.drawee.d.a jCs;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cuM();

    @ReturnsOwnership
    protected abstract a cuN();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.jBF = set;
        init();
    }

    private void init() {
        this.jCa = null;
        this.jCn = null;
        this.jCo = null;
        this.jCp = null;
        this.jCq = true;
        this.jBW = null;
        this.jBX = null;
        this.jBP = false;
        this.jCr = false;
        this.jCs = null;
        this.jCf = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aP */
    public BUILDER aS(Object obj) {
        this.jCa = obj;
        return cuM();
    }

    @Nullable
    public Object cvd() {
        return this.jCa;
    }

    public BUILDER aQ(REQUEST request) {
        this.jCn = request;
        return cuM();
    }

    @Nullable
    public REQUEST cve() {
        return this.jCn;
    }

    public boolean cvf() {
        return this.jCe;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jBW = cVar;
        return cuM();
    }

    @Nullable
    public d cvg() {
        return this.jBX;
    }

    @Nullable
    public String cvh() {
        return this.jCf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jCs = aVar;
        return cuM();
    }

    @Nullable
    public com.facebook.drawee.d.a cvi() {
        return this.jCs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cvj */
    public a cvn() {
        validate();
        if (this.jCn == null && this.jCp == null && this.jCo != null) {
            this.jCn = this.jCo;
            this.jCo = null;
        }
        return cvk();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jCp == null || this.jCn == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jBz == null || (this.jCp == null && this.jCn == null && this.jCo == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cvk() {
        a cuN = cuN();
        cuN.rr(cvf());
        cuN.FE(cvh());
        cuN.a(cvg());
        c(cuN);
        b(cuN);
        return cuN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cvl() {
        return String.valueOf(jCt.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cvm() {
        if (this.jBz != null) {
            return this.jBz;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jCn != null) {
            iVar = aR(this.jCn);
        } else if (this.jCp != null) {
            iVar = a(this.jCp, this.jCq);
        }
        if (iVar != null && this.jCo != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aR(this.jCo));
            iVar = f.ex(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.y(jCm);
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
        final Object cvd = cvd();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cuu */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cvd, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aE(this).q("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.jBF != null) {
            for (c cVar : this.jBF) {
                aVar.a(cVar);
            }
        }
        if (this.jBW != null) {
            aVar.a(this.jBW);
        }
        if (this.jCr) {
            aVar.a(jCl);
        }
    }

    protected void c(a aVar) {
        if (this.jBP) {
            com.facebook.drawee.components.b cuV = aVar.cuV();
            if (cuV == null) {
                cuV = new com.facebook.drawee.components.b();
                aVar.a(cuV);
            }
            cuV.rq(this.jBP);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cuW() == null) {
            aVar.a(com.facebook.drawee.c.a.eK(this.mContext));
        }
    }
}
