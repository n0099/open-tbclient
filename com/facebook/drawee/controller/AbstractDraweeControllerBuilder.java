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
    private static final c<Object> kcJ = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException kcK = new NullPointerException("No image request was specified!");
    private static final AtomicLong kcR = new AtomicLong();
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> kbX;
    private boolean kcC;
    private String kcD;
    @Nullable
    private REQUEST kcL;
    @Nullable
    private REQUEST kcM;
    @Nullable
    private REQUEST[] kcN;
    private boolean kcO;
    private boolean kcP;
    @Nullable
    private com.facebook.drawee.d.a kcQ;
    private final Set<c> kcd;
    private boolean kcn;
    @Nullable
    private c<? super INFO> kcu;
    @Nullable
    private d kcv;
    @Nullable
    private Object kcy;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cFY();

    @ReturnsOwnership
    protected abstract a cFZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.kcd = set;
        init();
    }

    private void init() {
        this.kcy = null;
        this.kcL = null;
        this.kcM = null;
        this.kcN = null;
        this.kcO = true;
        this.kcu = null;
        this.kcv = null;
        this.kcn = false;
        this.kcP = false;
        this.kcQ = null;
        this.kcD = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aN */
    public BUILDER aQ(Object obj) {
        this.kcy = obj;
        return cFY();
    }

    @Nullable
    public Object cGp() {
        return this.kcy;
    }

    public BUILDER aO(REQUEST request) {
        this.kcL = request;
        return cFY();
    }

    @Nullable
    public REQUEST cGq() {
        return this.kcL;
    }

    public boolean cGr() {
        return this.kcC;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.kcu = cVar;
        return cFY();
    }

    @Nullable
    public d cGs() {
        return this.kcv;
    }

    @Nullable
    public String cGt() {
        return this.kcD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.kcQ = aVar;
        return cFY();
    }

    @Nullable
    public com.facebook.drawee.d.a cGu() {
        return this.kcQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cGv */
    public a cGz() {
        validate();
        if (this.kcL == null && this.kcN == null && this.kcM != null) {
            this.kcL = this.kcM;
            this.kcM = null;
        }
        return cGw();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.kcN == null || this.kcL == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.kbX == null || (this.kcN == null && this.kcL == null && this.kcM == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cGw() {
        a cFZ = cFZ();
        cFZ.sx(cGr());
        cFZ.HM(cGt());
        cFZ.a(cGs());
        c(cFZ);
        b(cFZ);
        return cFZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cGx() {
        return String.valueOf(kcR.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cGy() {
        if (this.kbX != null) {
            return this.kbX;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.kcL != null) {
            iVar = aP(this.kcL);
        } else if (this.kcN != null) {
            iVar = a(this.kcN, this.kcO);
        }
        if (iVar != null && this.kcM != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aP(this.kcM));
            iVar = f.eE(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(kcK);
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
        return com.facebook.datasource.e.eD(arrayList);
    }

    protected i<com.facebook.datasource.b<IMAGE>> aP(REQUEST request) {
        return a((AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>) request, CacheLevel.FULL_FETCH);
    }

    protected i<com.facebook.datasource.b<IMAGE>> a(final REQUEST request, final CacheLevel cacheLevel) {
        final Object cGp = cGp();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cFG */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cGp, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aC(this).t("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.kcd != null) {
            for (c cVar : this.kcd) {
                aVar.a(cVar);
            }
        }
        if (this.kcu != null) {
            aVar.a(this.kcu);
        }
        if (this.kcP) {
            aVar.a(kcJ);
        }
    }

    protected void c(a aVar) {
        if (this.kcn) {
            com.facebook.drawee.components.b cGh = aVar.cGh();
            if (cGh == null) {
                cGh = new com.facebook.drawee.components.b();
                aVar.a(cGh);
            }
            cGh.sw(this.kcn);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cGi() == null) {
            aVar.a(com.facebook.drawee.c.a.eB(this.mContext));
        }
    }
}
