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
    private i<com.facebook.datasource.b<IMAGE>> jTK;
    private final Set<c> jTQ;
    @Nullable
    private REQUEST[] jUA;
    private boolean jUB;
    private boolean jUC;
    @Nullable
    private com.facebook.drawee.d.a jUD;
    private boolean jUa;
    @Nullable
    private c<? super INFO> jUh;
    @Nullable
    private d jUi;
    @Nullable
    private Object jUl;
    private boolean jUp;
    private String jUq;
    @Nullable
    private REQUEST jUy;
    @Nullable
    private REQUEST jUz;
    private final Context mContext;
    private static final c<Object> jUw = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException jUx = new NullPointerException("No image request was specified!");
    private static final AtomicLong jUE = new AtomicLong();

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cCD();

    @ReturnsOwnership
    protected abstract a cCE();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.jTQ = set;
        init();
    }

    private void init() {
        this.jUl = null;
        this.jUy = null;
        this.jUz = null;
        this.jUA = null;
        this.jUB = true;
        this.jUh = null;
        this.jUi = null;
        this.jUa = false;
        this.jUC = false;
        this.jUD = null;
        this.jUq = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aN */
    public BUILDER aQ(Object obj) {
        this.jUl = obj;
        return cCD();
    }

    @Nullable
    public Object cCU() {
        return this.jUl;
    }

    public BUILDER aO(REQUEST request) {
        this.jUy = request;
        return cCD();
    }

    @Nullable
    public REQUEST cCV() {
        return this.jUy;
    }

    public boolean cCW() {
        return this.jUp;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.jUh = cVar;
        return cCD();
    }

    @Nullable
    public d cCX() {
        return this.jUi;
    }

    @Nullable
    public String cCY() {
        return this.jUq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.jUD = aVar;
        return cCD();
    }

    @Nullable
    public com.facebook.drawee.d.a cCZ() {
        return this.jUD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cDa */
    public a cDe() {
        validate();
        if (this.jUy == null && this.jUA == null && this.jUz != null) {
            this.jUy = this.jUz;
            this.jUz = null;
        }
        return cDb();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.jUA == null || this.jUy == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.jTK == null || (this.jUA == null && this.jUy == null && this.jUz == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cDb() {
        a cCE = cCE();
        cCE.sg(cCW());
        cCE.GP(cCY());
        cCE.a(cCX());
        c(cCE);
        b(cCE);
        return cCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cDc() {
        return String.valueOf(jUE.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cDd() {
        if (this.jTK != null) {
            return this.jTK;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.jUy != null) {
            iVar = aP(this.jUy);
        } else if (this.jUA != null) {
            iVar = a(this.jUA, this.jUB);
        }
        if (iVar != null && this.jUz != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aP(this.jUz));
            iVar = f.eC(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(jUx);
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
        final Object cCU = cCU();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cCl */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cCU, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aC(this).t("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.jTQ != null) {
            for (c cVar : this.jTQ) {
                aVar.a(cVar);
            }
        }
        if (this.jUh != null) {
            aVar.a(this.jUh);
        }
        if (this.jUC) {
            aVar.a(jUw);
        }
    }

    protected void c(a aVar) {
        if (this.jUa) {
            com.facebook.drawee.components.b cCM = aVar.cCM();
            if (cCM == null) {
                cCM = new com.facebook.drawee.components.b();
                aVar.a(cCM);
            }
            cCM.sf(this.jUa);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cCN() == null) {
            aVar.a(com.facebook.drawee.c.a.ez(this.mContext));
        }
    }
}
