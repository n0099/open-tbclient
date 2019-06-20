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
    private i<com.facebook.datasource.b<IMAGE>> jTN;
    private final Set<c> jTT;
    @Nullable
    private REQUEST jUB;
    @Nullable
    private REQUEST jUC;
    @Nullable
    private REQUEST[] jUD;
    private boolean jUE;
    private boolean jUF;
    @Nullable
    private com.facebook.drawee.d.a jUG;
    private boolean jUd;
    @Nullable
    private c<? super INFO> jUk;
    @Nullable
    private d jUl;
    @Nullable
    private Object jUo;
    private boolean jUs;
    private String jUt;
    private final Context mContext;
    private static final c<Object> jUz = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jUA = new NullPointerException("No image request was specified!");
    private static final AtomicLong jUH = new AtomicLong();

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cCC();

    @ReturnsOwnership
    protected abstract a cCD();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.jTT = set;
        init();
    }

    private void init() {
        this.jUo = null;
        this.jUB = null;
        this.jUC = null;
        this.jUD = null;
        this.jUE = true;
        this.jUk = null;
        this.jUl = null;
        this.jUd = false;
        this.jUF = false;
        this.jUG = null;
        this.jUt = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aN */
    public BUILDER aQ(Object obj) {
        this.jUo = obj;
        return cCC();
    }

    @Nullable
    public Object cCT() {
        return this.jUo;
    }

    public BUILDER aO(REQUEST request) {
        this.jUB = request;
        return cCC();
    }

    @Nullable
    public REQUEST cCU() {
        return this.jUB;
    }

    public boolean cCV() {
        return this.jUs;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jUk = cVar;
        return cCC();
    }

    @Nullable
    public d cCW() {
        return this.jUl;
    }

    @Nullable
    public String cCX() {
        return this.jUt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jUG = aVar;
        return cCC();
    }

    @Nullable
    public com.facebook.drawee.d.a cCY() {
        return this.jUG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cCZ */
    public a cDd() {
        validate();
        if (this.jUB == null && this.jUD == null && this.jUC != null) {
            this.jUB = this.jUC;
            this.jUC = null;
        }
        return cDa();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jUD == null || this.jUB == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jTN == null || (this.jUD == null && this.jUB == null && this.jUC == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cDa() {
        a cCD = cCD();
        cCD.sh(cCV());
        cCD.GR(cCX());
        cCD.a(cCW());
        c(cCD);
        b(cCD);
        return cCD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cDb() {
        return String.valueOf(jUH.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cDc() {
        if (this.jTN != null) {
            return this.jTN;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jUB != null) {
            iVar = aP(this.jUB);
        } else if (this.jUD != null) {
            iVar = a(this.jUD, this.jUE);
        }
        if (iVar != null && this.jUC != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aP(this.jUC));
            iVar = f.eC(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(jUA);
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
        final Object cCT = cCT();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cCk */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cCT, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aC(this).t("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.jTT != null) {
            for (c cVar : this.jTT) {
                aVar.a(cVar);
            }
        }
        if (this.jUk != null) {
            aVar.a(this.jUk);
        }
        if (this.jUF) {
            aVar.a(jUz);
        }
    }

    protected void c(a aVar) {
        if (this.jUd) {
            com.facebook.drawee.components.b cCL = aVar.cCL();
            if (cCL == null) {
                cCL = new com.facebook.drawee.components.b();
                aVar.a(cCL);
            }
            cCL.sg(this.jUd);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cCM() == null) {
            aVar.a(com.facebook.drawee.c.a.ez(this.mContext));
        }
    }
}
