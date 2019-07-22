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
    private static final c<Object> kbD = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException kbE = new NullPointerException("No image request was specified!");
    private static final AtomicLong kbL = new AtomicLong();
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> kaR;
    private final Set<c> kaX;
    @Nullable
    private REQUEST kbF;
    @Nullable
    private REQUEST kbG;
    @Nullable
    private REQUEST[] kbH;
    private boolean kbI;
    private boolean kbJ;
    @Nullable
    private com.facebook.drawee.d.a kbK;
    private boolean kbh;
    @Nullable
    private c<? super INFO> kbo;
    @Nullable
    private d kbp;
    @Nullable
    private Object kbs;
    private boolean kbw;
    private String kbx;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cFD();

    @ReturnsOwnership
    protected abstract a cFE();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.kaX = set;
        init();
    }

    private void init() {
        this.kbs = null;
        this.kbF = null;
        this.kbG = null;
        this.kbH = null;
        this.kbI = true;
        this.kbo = null;
        this.kbp = null;
        this.kbh = false;
        this.kbJ = false;
        this.kbK = null;
        this.kbx = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aN */
    public BUILDER aQ(Object obj) {
        this.kbs = obj;
        return cFD();
    }

    @Nullable
    public Object cFU() {
        return this.kbs;
    }

    public BUILDER aO(REQUEST request) {
        this.kbF = request;
        return cFD();
    }

    @Nullable
    public REQUEST cFV() {
        return this.kbF;
    }

    public boolean cFW() {
        return this.kbw;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.kbo = cVar;
        return cFD();
    }

    @Nullable
    public d cFX() {
        return this.kbp;
    }

    @Nullable
    public String cFY() {
        return this.kbx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.kbK = aVar;
        return cFD();
    }

    @Nullable
    public com.facebook.drawee.d.a cFZ() {
        return this.kbK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cGa */
    public a cGe() {
        validate();
        if (this.kbF == null && this.kbH == null && this.kbG != null) {
            this.kbF = this.kbG;
            this.kbG = null;
        }
        return cGb();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.kbH == null || this.kbF == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.kaR == null || (this.kbH == null && this.kbF == null && this.kbG == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cGb() {
        a cFE = cFE();
        cFE.sw(cFW());
        cFE.HL(cFY());
        cFE.a(cFX());
        c(cFE);
        b(cFE);
        return cFE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cGc() {
        return String.valueOf(kbL.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cGd() {
        if (this.kaR != null) {
            return this.kaR;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.kbF != null) {
            iVar = aP(this.kbF);
        } else if (this.kbH != null) {
            iVar = a(this.kbH, this.kbI);
        }
        if (iVar != null && this.kbG != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aP(this.kbG));
            iVar = f.eF(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(kbE);
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
        return com.facebook.datasource.e.eE(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aP(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object cFU = cFU();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cFl */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cFU, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aC(this).t("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.kaX != null) {
            for (c cVar : this.kaX) {
                aVar.a(cVar);
            }
        }
        if (this.kbo != null) {
            aVar.a(this.kbo);
        }
        if (this.kbJ) {
            aVar.a(kbD);
        }
    }

    protected void c(a aVar) {
        if (this.kbh) {
            com.facebook.drawee.components.b cFM = aVar.cFM();
            if (cFM == null) {
                cFM = new com.facebook.drawee.components.b();
                aVar.a(cFM);
            }
            cFM.sv(this.kbh);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cFN() == null) {
            aVar.a(com.facebook.drawee.c.a.eA(this.mContext));
        }
    }
}
