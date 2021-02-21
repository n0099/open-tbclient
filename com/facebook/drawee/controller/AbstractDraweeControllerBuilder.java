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
    private static final c<Object> pCh = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException pCi = new NullPointerException("No image request was specified!");
    private static final AtomicLong pCp = new AtomicLong();
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> pAT;
    private boolean pBM;
    @Nullable
    private c<? super INFO> pBT;
    @Nullable
    private d pBU;
    private final Set<c> pBb;
    @Nullable
    private Object pBi;
    private boolean pCa;
    private String pCb;
    @Nullable
    private REQUEST pCj;
    @Nullable
    private REQUEST pCk;
    @Nullable
    private REQUEST[] pCl;
    private boolean pCm;
    private boolean pCn;
    @Nullable
    private com.facebook.drawee.d.a pCo;

    /* loaded from: classes15.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a etI();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.pBb = set;
        init();
    }

    private void init() {
        this.pBi = null;
        this.pCj = null;
        this.pCk = null;
        this.pCl = null;
        this.pCm = true;
        this.pBT = null;
        this.pBU = null;
        this.pBM = false;
        this.pCn = false;
        this.pCo = null;
        this.pCb = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bp(Object obj) {
        this.pBi = obj;
        return eum();
    }

    @Nullable
    public Object eud() {
        return this.pBi;
    }

    public BUILDER bo(REQUEST request) {
        this.pCj = request;
        return eum();
    }

    @Nullable
    public REQUEST eue() {
        return this.pCj;
    }

    public boolean euf() {
        return this.pCa;
    }

    public BUILDER Bm(boolean z) {
        this.pCn = z;
        return eum();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.pBT = cVar;
        return eum();
    }

    @Nullable
    public d eug() {
        return this.pBU;
    }

    @Nullable
    public String euh() {
        return this.pCb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.pCo = aVar;
        return eum();
    }

    @Nullable
    public com.facebook.drawee.d.a eui() {
        return this.pCo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: euj */
    public a eun() {
        validate();
        if (this.pCj == null && this.pCl == null && this.pCk != null) {
            this.pCj = this.pCk;
            this.pCk = null;
        }
        return euk();
    }

    protected void validate() {
        boolean z = false;
        g.checkState(this.pCl == null || this.pCj == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.pAT == null || (this.pCl == null && this.pCj == null && this.pCk == null)) {
            z = true;
        }
        g.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a euk() {
        a etI = etI();
        etI.Bl(euf());
        etI.ZE(euh());
        etI.a(eug());
        b(etI);
        a(etI);
        return etI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String eul() {
        return String.valueOf(pCp.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.pAT != null) {
            return this.pAT;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.pCj != null) {
            jVar = a(aVar, str, this.pCj);
        } else if (this.pCl != null) {
            jVar = a(aVar, str, this.pCl, this.pCm);
        }
        if (jVar != null && this.pCk != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.pCk));
            jVar = f.D(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.y(pCi);
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
        final Object eud = eud();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: etl */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, eud, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.bb(this).H("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.pBb != null) {
            for (c cVar : this.pBb) {
                aVar.a(cVar);
            }
        }
        if (this.pBT != null) {
            aVar.a(this.pBT);
        }
        if (this.pCn) {
            aVar.a(pCh);
        }
    }

    protected void b(a aVar) {
        if (this.pBM) {
            aVar.etW().Bk(this.pBM);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.etX() == null) {
            aVar.a(com.facebook.drawee.c.a.ii(this.mContext));
        }
    }

    protected final BUILDER eum() {
        return this;
    }
}
