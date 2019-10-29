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
    private static final c<Object> kdp = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException kdq = new NullPointerException("No image request was specified!");
    private static final AtomicLong kdx = new AtomicLong();
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> kcD;
    private final Set<c> kcJ;
    private boolean kcT;
    @Nullable
    private c<? super INFO> kda;
    @Nullable
    private d kdb;
    @Nullable
    private Object kde;
    private boolean kdi;
    private String kdj;
    @Nullable
    private REQUEST kdr;
    @Nullable
    private REQUEST kds;
    @Nullable
    private REQUEST[] kdt;
    private boolean kdu;
    private boolean kdv;
    @Nullable
    private com.facebook.drawee.d.a kdw;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cDK();

    @ReturnsOwnership
    protected abstract a cDL();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.kcJ = set;
        init();
    }

    private void init() {
        this.kde = null;
        this.kdr = null;
        this.kds = null;
        this.kdt = null;
        this.kdu = true;
        this.kda = null;
        this.kdb = null;
        this.kcT = false;
        this.kdv = false;
        this.kdw = null;
        this.kdj = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aI */
    public BUILDER aL(Object obj) {
        this.kde = obj;
        return cDK();
    }

    @Nullable
    public Object cEb() {
        return this.kde;
    }

    public BUILDER aJ(REQUEST request) {
        this.kdr = request;
        return cDK();
    }

    @Nullable
    public REQUEST cEc() {
        return this.kdr;
    }

    public boolean cEd() {
        return this.kdi;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.kda = cVar;
        return cDK();
    }

    @Nullable
    public d cEe() {
        return this.kdb;
    }

    @Nullable
    public String cEf() {
        return this.kdj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.kdw = aVar;
        return cDK();
    }

    @Nullable
    public com.facebook.drawee.d.a cEg() {
        return this.kdw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cEh */
    public a cEl() {
        validate();
        if (this.kdr == null && this.kdt == null && this.kds != null) {
            this.kdr = this.kds;
            this.kds = null;
        }
        return cEi();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.kdt == null || this.kdr == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.kcD == null || (this.kdt == null && this.kdr == null && this.kds == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cEi() {
        a cDL = cDL();
        cDL.sf(cEd());
        cDL.GD(cEf());
        cDL.a(cEe());
        c(cDL);
        b(cDL);
        return cDL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cEj() {
        return String.valueOf(kdx.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cEk() {
        if (this.kcD != null) {
            return this.kcD;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.kdr != null) {
            iVar = aK(this.kdr);
        } else if (this.kdt != null) {
            iVar = a(this.kdt, this.kdu);
        }
        if (iVar != null && this.kds != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aK(this.kds));
            iVar = f.eR(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.v(kdq);
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
        final Object cEb = cEb();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cDs */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cEb, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ax(this).q("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.kcJ != null) {
            for (c cVar : this.kcJ) {
                aVar.a(cVar);
            }
        }
        if (this.kda != null) {
            aVar.a(this.kda);
        }
        if (this.kdv) {
            aVar.a(kdp);
        }
    }

    protected void c(a aVar) {
        if (this.kcT) {
            com.facebook.drawee.components.b cDT = aVar.cDT();
            if (cDT == null) {
                cDT = new com.facebook.drawee.components.b();
                aVar.a(cDT);
            }
            cDT.se(this.kcT);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cDU() == null) {
            aVar.a(com.facebook.drawee.c.a.er(this.mContext));
        }
    }
}
