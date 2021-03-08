package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.g;
import com.facebook.common.internal.j;
import com.facebook.datasource.f;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> pEm = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException pEn = new NullPointerException("No image request was specified!");
    private static final AtomicLong pEu = new AtomicLong();
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> pCY;
    private boolean pDR;
    @Nullable
    private c<? super INFO> pDY;
    @Nullable
    private d pDZ;
    private final Set<c> pDg;
    @Nullable
    private Object pDn;
    private boolean pEf;
    private String pEg;
    @Nullable
    private REQUEST pEo;
    @Nullable
    private REQUEST pEp;
    @Nullable
    private REQUEST[] pEq;
    private boolean pEr;
    private boolean pEs;
    @Nullable
    private com.facebook.drawee.d.a pEt;

    /* loaded from: classes4.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a etR();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.pDg = set;
        init();
    }

    private void init() {
        this.pDn = null;
        this.pEo = null;
        this.pEp = null;
        this.pEq = null;
        this.pEr = true;
        this.pDY = null;
        this.pDZ = null;
        this.pDR = false;
        this.pEs = false;
        this.pEt = null;
        this.pEg = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bp */
    public BUILDER br(Object obj) {
        this.pDn = obj;
        return euv();
    }

    @Nullable
    public Object eum() {
        return this.pDn;
    }

    public BUILDER bq(REQUEST request) {
        this.pEo = request;
        return euv();
    }

    @Nullable
    public REQUEST eun() {
        return this.pEo;
    }

    public boolean euo() {
        return this.pEf;
    }

    public BUILDER Bk(boolean z) {
        this.pEs = z;
        return euv();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.pDY = cVar;
        return euv();
    }

    @Nullable
    public d eup() {
        return this.pDZ;
    }

    @Nullable
    public String euq() {
        return this.pEg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.pEt = aVar;
        return euv();
    }

    @Nullable
    public com.facebook.drawee.d.a eur() {
        return this.pEt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: eus */
    public a euw() {
        validate();
        if (this.pEo == null && this.pEq == null && this.pEp != null) {
            this.pEo = this.pEp;
            this.pEp = null;
        }
        return eut();
    }

    protected void validate() {
        boolean z = false;
        g.checkState(this.pEq == null || this.pEo == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.pCY == null || (this.pEq == null && this.pEo == null && this.pEp == null)) {
            z = true;
        }
        g.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a eut() {
        a etR = etR();
        etR.Bj(euo());
        etR.ZK(euq());
        etR.a(eup());
        b(etR);
        a(etR);
        return etR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String euu() {
        return String.valueOf(pEu.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.pCY != null) {
            return this.pCY;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.pEo != null) {
            jVar = a(aVar, str, this.pEo);
        } else if (this.pEq != null) {
            jVar = a(aVar, str, this.pEq, this.pEr);
        }
        if (jVar != null && this.pEp != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.pEp));
            jVar = f.D(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.y(pEn);
        }
        return jVar;
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(a(aVar, str, (String) request, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(a(aVar, str, request2));
        }
        return com.facebook.datasource.e.gI(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object eum = eum();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: etu */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, eum, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.bd(this).G("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.pDg != null) {
            for (c cVar : this.pDg) {
                aVar.a(cVar);
            }
        }
        if (this.pDY != null) {
            aVar.a(this.pDY);
        }
        if (this.pEs) {
            aVar.a(pEm);
        }
    }

    protected void b(a aVar) {
        if (this.pDR) {
            aVar.euf().Bi(this.pDR);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.eug() == null) {
            aVar.a(com.facebook.drawee.c.a.ih(this.mContext));
        }
    }

    protected final BUILDER euv() {
        return this;
    }
}
