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
    private static final c<Object> iaU = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException iaV = new NullPointerException("No image request was specified!");
    private static final AtomicLong ibc = new AtomicLong();
    @Nullable
    private c<? super INFO> iaF;
    @Nullable
    private d iaG;
    @Nullable
    private Object iaJ;
    private boolean iaN;
    private String iaO;
    @Nullable
    private REQUEST iaW;
    @Nullable
    private REQUEST iaX;
    @Nullable
    private REQUEST[] iaY;
    private boolean iaZ;
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> iai;
    private final Set<c> iao;
    private boolean iay;
    private boolean iba;
    @Nullable
    private com.facebook.drawee.d.a ibb;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER bRY();

    @ReturnsOwnership
    protected abstract a bRZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.iao = set;
        init();
    }

    private void init() {
        this.iaJ = null;
        this.iaW = null;
        this.iaX = null;
        this.iaY = null;
        this.iaZ = true;
        this.iaF = null;
        this.iaG = null;
        this.iay = false;
        this.iba = false;
        this.ibb = null;
        this.iaO = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: ay */
    public BUILDER aB(Object obj) {
        this.iaJ = obj;
        return bRY();
    }

    @Nullable
    public Object bSo() {
        return this.iaJ;
    }

    public BUILDER az(REQUEST request) {
        this.iaW = request;
        return bRY();
    }

    @Nullable
    public REQUEST bSp() {
        return this.iaW;
    }

    public boolean bSq() {
        return this.iaN;
    }

    public BUILDER oR(boolean z) {
        this.iba = z;
        return bRY();
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.iaF = cVar;
        return bRY();
    }

    @Nullable
    public d bSr() {
        return this.iaG;
    }

    @Nullable
    public String bSs() {
        return this.iaO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.ibb = aVar;
        return bRY();
    }

    @Nullable
    public com.facebook.drawee.d.a bSt() {
        return this.ibb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bSu */
    public a bSy() {
        validate();
        if (this.iaW == null && this.iaY == null && this.iaX != null) {
            this.iaW = this.iaX;
            this.iaX = null;
        }
        return bSv();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.iaY == null || this.iaW == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.iai == null || (this.iaY == null && this.iaW == null && this.iaX == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a bSv() {
        a bRZ = bRZ();
        bRZ.oQ(bSq());
        bRZ.yF(bSs());
        bRZ.a(bSr());
        c(bRZ);
        b(bRZ);
        return bRZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String bSw() {
        return String.valueOf(ibc.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> bSx() {
        if (this.iai != null) {
            return this.iai;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.iaW != null) {
            iVar = aA(this.iaW);
        } else if (this.iaY != null) {
            iVar = a(this.iaY, this.iaZ);
        }
        if (iVar != null && this.iaX != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aA(this.iaX));
            iVar = f.en(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(iaV);
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
            arrayList.add(aA(request2));
        }
        return com.facebook.datasource.e.em(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aA(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object bSo = bSo();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: bRG */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, bSo, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.an(this).n("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.iao != null) {
            for (c cVar : this.iao) {
                aVar.a(cVar);
            }
        }
        if (this.iaF != null) {
            aVar.a(this.iaF);
        }
        if (this.iba) {
            aVar.a(iaU);
        }
    }

    protected void c(a aVar) {
        if (this.iay) {
            com.facebook.drawee.components.b bSh = aVar.bSh();
            if (bSh == null) {
                bSh = new com.facebook.drawee.components.b();
                aVar.a(bSh);
            }
            bSh.oP(this.iay);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.bSi() == null) {
            aVar.a(com.facebook.drawee.c.a.dm(this.mContext));
        }
    }
}
