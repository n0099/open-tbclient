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
    private static final c<Object> iih = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException iii = new NullPointerException("No image request was specified!");
    private static final AtomicLong iip = new AtomicLong();
    private final Set<c> ihB;
    private boolean ihL;
    @Nullable
    private c<? super INFO> ihS;
    @Nullable
    private d ihT;
    @Nullable
    private Object ihW;
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> ihv;
    private boolean iia;
    private String iib;
    @Nullable
    private REQUEST iij;
    @Nullable
    private REQUEST iik;
    @Nullable
    private REQUEST[] iil;
    private boolean iim;
    private boolean iin;
    @Nullable
    private com.facebook.drawee.d.a iio;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER bUd();

    @ReturnsOwnership
    protected abstract a bUe();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.ihB = set;
        init();
    }

    private void init() {
        this.ihW = null;
        this.iij = null;
        this.iik = null;
        this.iil = null;
        this.iim = true;
        this.ihS = null;
        this.ihT = null;
        this.ihL = false;
        this.iin = false;
        this.iio = null;
        this.iib = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: az */
    public BUILDER aC(Object obj) {
        this.ihW = obj;
        return bUd();
    }

    @Nullable
    public Object bUt() {
        return this.ihW;
    }

    public BUILDER aA(REQUEST request) {
        this.iij = request;
        return bUd();
    }

    @Nullable
    public REQUEST bUu() {
        return this.iij;
    }

    public boolean bUv() {
        return this.iia;
    }

    public BUILDER oT(boolean z) {
        this.iin = z;
        return bUd();
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.ihS = cVar;
        return bUd();
    }

    @Nullable
    public d bUw() {
        return this.ihT;
    }

    @Nullable
    public String bUx() {
        return this.iib;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.iio = aVar;
        return bUd();
    }

    @Nullable
    public com.facebook.drawee.d.a bUy() {
        return this.iio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bUz */
    public a bUD() {
        validate();
        if (this.iij == null && this.iil == null && this.iik != null) {
            this.iij = this.iik;
            this.iik = null;
        }
        return bUA();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.iil == null || this.iij == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.ihv == null || (this.iil == null && this.iij == null && this.iik == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a bUA() {
        a bUe = bUe();
        bUe.oS(bUv());
        bUe.zi(bUx());
        bUe.a(bUw());
        c(bUe);
        b(bUe);
        return bUe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String bUB() {
        return String.valueOf(iip.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> bUC() {
        if (this.ihv != null) {
            return this.ihv;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.iij != null) {
            iVar = aB(this.iij);
        } else if (this.iil != null) {
            iVar = a(this.iil, this.iim);
        }
        if (iVar != null && this.iik != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aB(this.iik));
            iVar = f.er(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(iii);
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
        return com.facebook.datasource.e.eq(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aB(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object bUt = bUt();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: bTL */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, bUt, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ao(this).n("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.ihB != null) {
            for (c cVar : this.ihB) {
                aVar.a(cVar);
            }
        }
        if (this.ihS != null) {
            aVar.a(this.ihS);
        }
        if (this.iin) {
            aVar.a(iih);
        }
    }

    protected void c(a aVar) {
        if (this.ihL) {
            com.facebook.drawee.components.b bUm = aVar.bUm();
            if (bUm == null) {
                bUm = new com.facebook.drawee.components.b();
                aVar.a(bUm);
            }
            bUm.oR(this.ihL);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.bUn() == null) {
            aVar.a(com.facebook.drawee.c.a.dq(this.mContext));
        }
    }
}
