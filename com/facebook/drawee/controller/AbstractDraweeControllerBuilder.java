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
    private i<com.facebook.datasource.b<IMAGE>> kbM;
    private final Set<c> kbS;
    @Nullable
    private REQUEST kcA;
    @Nullable
    private REQUEST kcB;
    @Nullable
    private REQUEST[] kcC;
    private boolean kcD;
    private boolean kcE;
    @Nullable
    private com.facebook.drawee.d.a kcF;
    private boolean kcc;
    @Nullable
    private c<? super INFO> kcj;
    @Nullable
    private d kck;
    @Nullable
    private Object kcn;
    private boolean kcr;
    private String kcs;
    private final Context mContext;
    private static final c<Object> kcy = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException kcz = new NullPointerException("No image request was specified!");
    private static final AtomicLong kcG = new AtomicLong();

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cDI();

    @ReturnsOwnership
    protected abstract a cDJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.kbS = set;
        init();
    }

    private void init() {
        this.kcn = null;
        this.kcA = null;
        this.kcB = null;
        this.kcC = null;
        this.kcD = true;
        this.kcj = null;
        this.kck = null;
        this.kcc = false;
        this.kcE = false;
        this.kcF = null;
        this.kcs = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aI */
    public BUILDER aL(Object obj) {
        this.kcn = obj;
        return cDI();
    }

    @Nullable
    public Object cDZ() {
        return this.kcn;
    }

    public BUILDER aJ(REQUEST request) {
        this.kcA = request;
        return cDI();
    }

    @Nullable
    public REQUEST cEa() {
        return this.kcA;
    }

    public boolean cEb() {
        return this.kcr;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.kcj = cVar;
        return cDI();
    }

    @Nullable
    public d cEc() {
        return this.kck;
    }

    @Nullable
    public String cEd() {
        return this.kcs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.kcF = aVar;
        return cDI();
    }

    @Nullable
    public com.facebook.drawee.d.a cEe() {
        return this.kcF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cEf */
    public a cEj() {
        validate();
        if (this.kcA == null && this.kcC == null && this.kcB != null) {
            this.kcA = this.kcB;
            this.kcB = null;
        }
        return cEg();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.kcC == null || this.kcA == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.kbM == null || (this.kcC == null && this.kcA == null && this.kcB == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cEg() {
        a cDJ = cDJ();
        cDJ.sf(cEb());
        cDJ.GD(cEd());
        cDJ.a(cEc());
        c(cDJ);
        b(cDJ);
        return cDJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cEh() {
        return String.valueOf(kcG.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cEi() {
        if (this.kbM != null) {
            return this.kbM;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.kcA != null) {
            iVar = aK(this.kcA);
        } else if (this.kcC != null) {
            iVar = a(this.kcC, this.kcD);
        }
        if (iVar != null && this.kcB != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aK(this.kcB));
            iVar = f.eR(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(kcz);
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
            arrayList.add(aK(request2));
        }
        return com.facebook.datasource.e.eQ(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aK(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object cDZ = cDZ();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cDq */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cDZ, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ax(this).q("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.kbS != null) {
            for (c cVar : this.kbS) {
                aVar.a(cVar);
            }
        }
        if (this.kcj != null) {
            aVar.a(this.kcj);
        }
        if (this.kcE) {
            aVar.a(kcy);
        }
    }

    protected void c(a aVar) {
        if (this.kcc) {
            com.facebook.drawee.components.b cDR = aVar.cDR();
            if (cDR == null) {
                cDR = new com.facebook.drawee.components.b();
                aVar.a(cDR);
            }
            cDR.se(this.kcc);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cDS() == null) {
            aVar.a(com.facebook.drawee.c.a.er(this.mContext));
        }
    }
}
