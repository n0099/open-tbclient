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
    private i<com.facebook.datasource.b<IMAGE>> jTJ;
    private final Set<c> jTP;
    private boolean jTZ;
    private boolean jUA;
    private boolean jUB;
    @Nullable
    private com.facebook.drawee.d.a jUC;
    @Nullable
    private c<? super INFO> jUg;
    @Nullable
    private d jUh;
    @Nullable
    private Object jUk;
    private boolean jUo;
    private String jUp;
    @Nullable
    private REQUEST jUx;
    @Nullable
    private REQUEST jUy;
    @Nullable
    private REQUEST[] jUz;
    private final Context mContext;
    private static final c<Object> jUv = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jUw = new NullPointerException("No image request was specified!");
    private static final AtomicLong jUD = new AtomicLong();

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cCB();

    @ReturnsOwnership
    protected abstract a cCC();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.jTP = set;
        init();
    }

    private void init() {
        this.jUk = null;
        this.jUx = null;
        this.jUy = null;
        this.jUz = null;
        this.jUA = true;
        this.jUg = null;
        this.jUh = null;
        this.jTZ = false;
        this.jUB = false;
        this.jUC = null;
        this.jUp = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aN */
    public BUILDER aQ(Object obj) {
        this.jUk = obj;
        return cCB();
    }

    @Nullable
    public Object cCS() {
        return this.jUk;
    }

    public BUILDER aO(REQUEST request) {
        this.jUx = request;
        return cCB();
    }

    @Nullable
    public REQUEST cCT() {
        return this.jUx;
    }

    public boolean cCU() {
        return this.jUo;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jUg = cVar;
        return cCB();
    }

    @Nullable
    public d cCV() {
        return this.jUh;
    }

    @Nullable
    public String cCW() {
        return this.jUp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jUC = aVar;
        return cCB();
    }

    @Nullable
    public com.facebook.drawee.d.a cCX() {
        return this.jUC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cCY */
    public a cDc() {
        validate();
        if (this.jUx == null && this.jUz == null && this.jUy != null) {
            this.jUx = this.jUy;
            this.jUy = null;
        }
        return cCZ();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jUz == null || this.jUx == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jTJ == null || (this.jUz == null && this.jUx == null && this.jUy == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cCZ() {
        a cCC = cCC();
        cCC.sg(cCU());
        cCC.GP(cCW());
        cCC.a(cCV());
        c(cCC);
        b(cCC);
        return cCC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cDa() {
        return String.valueOf(jUD.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cDb() {
        if (this.jTJ != null) {
            return this.jTJ;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jUx != null) {
            iVar = aP(this.jUx);
        } else if (this.jUz != null) {
            iVar = a(this.jUz, this.jUA);
        }
        if (iVar != null && this.jUy != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aP(this.jUy));
            iVar = f.eC(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(jUw);
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
            arrayList.add(aP(request2));
        }
        return com.facebook.datasource.e.eB(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aP(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object cCS = cCS();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cCj */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cCS, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aC(this).t("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.jTP != null) {
            for (c cVar : this.jTP) {
                aVar.a(cVar);
            }
        }
        if (this.jUg != null) {
            aVar.a(this.jUg);
        }
        if (this.jUB) {
            aVar.a(jUv);
        }
    }

    protected void c(a aVar) {
        if (this.jTZ) {
            com.facebook.drawee.components.b cCK = aVar.cCK();
            if (cCK == null) {
                cCK = new com.facebook.drawee.components.b();
                aVar.a(cCK);
            }
            cCK.sf(this.jTZ);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cCL() == null) {
            aVar.a(com.facebook.drawee.c.a.ez(this.mContext));
        }
    }
}
