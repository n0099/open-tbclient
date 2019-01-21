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
    private static final c<Object> imA = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException imB = new NullPointerException("No image request was specified!");
    private static final AtomicLong imI = new AtomicLong();
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> ilN;
    private final Set<c> ilT;
    @Nullable
    private REQUEST imC;
    @Nullable
    private REQUEST imD;
    @Nullable
    private REQUEST[] imE;
    private boolean imF;
    private boolean imG;
    @Nullable
    private com.facebook.drawee.d.a imH;
    private boolean imd;
    @Nullable
    private c<? super INFO> iml;
    @Nullable
    private d imm;
    @Nullable
    private Object imp;
    private boolean imt;
    private String imu;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER bVC();

    @ReturnsOwnership
    protected abstract a bVD();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.ilT = set;
        init();
    }

    private void init() {
        this.imp = null;
        this.imC = null;
        this.imD = null;
        this.imE = null;
        this.imF = true;
        this.iml = null;
        this.imm = null;
        this.imd = false;
        this.imG = false;
        this.imH = null;
        this.imu = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: az */
    public BUILDER aC(Object obj) {
        this.imp = obj;
        return bVC();
    }

    @Nullable
    public Object bVS() {
        return this.imp;
    }

    public BUILDER aA(REQUEST request) {
        this.imC = request;
        return bVC();
    }

    @Nullable
    public REQUEST bVT() {
        return this.imC;
    }

    public boolean bVU() {
        return this.imt;
    }

    public BUILDER oX(boolean z) {
        this.imG = z;
        return bVC();
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.iml = cVar;
        return bVC();
    }

    @Nullable
    public d bVV() {
        return this.imm;
    }

    @Nullable
    public String bVW() {
        return this.imu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.imH = aVar;
        return bVC();
    }

    @Nullable
    public com.facebook.drawee.d.a bVX() {
        return this.imH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bVY */
    public a bWc() {
        validate();
        if (this.imC == null && this.imE == null && this.imD != null) {
            this.imC = this.imD;
            this.imD = null;
        }
        return bVZ();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.imE == null || this.imC == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.ilN == null || (this.imE == null && this.imC == null && this.imD == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a bVZ() {
        a bVD = bVD();
        bVD.oW(bVU());
        bVD.zB(bVW());
        bVD.a(bVV());
        c(bVD);
        b(bVD);
        return bVD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String bWa() {
        return String.valueOf(imI.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> bWb() {
        if (this.ilN != null) {
            return this.ilN;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.imC != null) {
            iVar = aB(this.imC);
        } else if (this.imE != null) {
            iVar = a(this.imE, this.imF);
        }
        if (iVar != null && this.imD != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aB(this.imD));
            iVar = f.et(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(imB);
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
            arrayList.add(aB(request2));
        }
        return com.facebook.datasource.e.es(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aB(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object bVS = bVS();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: bVk */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, bVS, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ao(this).n("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.ilT != null) {
            for (c cVar : this.ilT) {
                aVar.a(cVar);
            }
        }
        if (this.iml != null) {
            aVar.a(this.iml);
        }
        if (this.imG) {
            aVar.a(imA);
        }
    }

    protected void c(a aVar) {
        if (this.imd) {
            com.facebook.drawee.components.b bVL = aVar.bVL();
            if (bVL == null) {
                bVL = new com.facebook.drawee.components.b();
                aVar.a(bVL);
            }
            bVL.oV(this.imd);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.bVM() == null) {
            aVar.a(com.facebook.drawee.c.a.dq(this.mContext));
        }
    }
}
