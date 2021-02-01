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
/* loaded from: classes15.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> pBH = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException pBI = new NullPointerException("No image request was specified!");
    private static final AtomicLong pBP = new AtomicLong();
    private final Context mContext;
    private final Set<c> pAB;
    @Nullable
    private Object pAI;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> pAt;
    private boolean pBA;
    private String pBB;
    @Nullable
    private REQUEST pBJ;
    @Nullable
    private REQUEST pBK;
    @Nullable
    private REQUEST[] pBL;
    private boolean pBM;
    private boolean pBN;
    @Nullable
    private com.facebook.drawee.d.a pBO;
    private boolean pBm;
    @Nullable
    private c<? super INFO> pBt;
    @Nullable
    private d pBu;

    /* loaded from: classes15.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a etA();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.pAB = set;
        init();
    }

    private void init() {
        this.pAI = null;
        this.pBJ = null;
        this.pBK = null;
        this.pBL = null;
        this.pBM = true;
        this.pBt = null;
        this.pBu = null;
        this.pBm = false;
        this.pBN = false;
        this.pBO = null;
        this.pBB = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bp(Object obj) {
        this.pAI = obj;
        return eue();
    }

    @Nullable
    public Object etV() {
        return this.pAI;
    }

    public BUILDER bo(REQUEST request) {
        this.pBJ = request;
        return eue();
    }

    @Nullable
    public REQUEST etW() {
        return this.pBJ;
    }

    public boolean etX() {
        return this.pBA;
    }

    public BUILDER Bm(boolean z) {
        this.pBN = z;
        return eue();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.pBt = cVar;
        return eue();
    }

    @Nullable
    public d etY() {
        return this.pBu;
    }

    @Nullable
    public String etZ() {
        return this.pBB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.pBO = aVar;
        return eue();
    }

    @Nullable
    public com.facebook.drawee.d.a eua() {
        return this.pBO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: eub */
    public a euf() {
        validate();
        if (this.pBJ == null && this.pBL == null && this.pBK != null) {
            this.pBJ = this.pBK;
            this.pBK = null;
        }
        return euc();
    }

    protected void validate() {
        boolean z = false;
        g.checkState(this.pBL == null || this.pBJ == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.pAt == null || (this.pBL == null && this.pBJ == null && this.pBK == null)) {
            z = true;
        }
        g.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a euc() {
        a etA = etA();
        etA.Bl(etX());
        etA.Zs(etZ());
        etA.a(etY());
        b(etA);
        a(etA);
        return etA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String eud() {
        return String.valueOf(pBP.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.pAt != null) {
            return this.pAt;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.pBJ != null) {
            jVar = a(aVar, str, this.pBJ);
        } else if (this.pBL != null) {
            jVar = a(aVar, str, this.pBL, this.pBM);
        }
        if (jVar != null && this.pBK != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.pBK));
            jVar = f.D(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.y(pBI);
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
        final Object etV = etV();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: etd */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, etV, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.bb(this).H("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.pAB != null) {
            for (c cVar : this.pAB) {
                aVar.a(cVar);
            }
        }
        if (this.pBt != null) {
            aVar.a(this.pBt);
        }
        if (this.pBN) {
            aVar.a(pBH);
        }
    }

    protected void b(a aVar) {
        if (this.pBm) {
            aVar.etO().Bk(this.pBm);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.etP() == null) {
            aVar.a(com.facebook.drawee.c.a.ii(this.mContext));
        }
    }

    protected final BUILDER eue() {
        return this;
    }
}
