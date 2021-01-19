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
/* loaded from: classes3.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> pqk;
    private final Set<c> pqs;
    @Nullable
    private Object pqz;
    @Nullable
    private REQUEST prA;
    @Nullable
    private REQUEST prB;
    @Nullable
    private REQUEST[] prC;
    private boolean prD;
    private boolean prE;
    @Nullable
    private com.facebook.drawee.d.a prF;
    private boolean prd;
    @Nullable
    private c<? super INFO> prk;
    @Nullable
    private d prl;
    private boolean prr;
    private String prs;
    private static final c<Object> pry = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException prz = new NullPointerException("No image request was specified!");
    private static final AtomicLong prG = new AtomicLong();

    /* loaded from: classes3.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a erh();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.pqs = set;
        init();
    }

    private void init() {
        this.pqz = null;
        this.prA = null;
        this.prB = null;
        this.prC = null;
        this.prD = true;
        this.prk = null;
        this.prl = null;
        this.prd = false;
        this.prE = false;
        this.prF = null;
        this.prs = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bp(Object obj) {
        this.pqz = obj;
        return erM();
    }

    @Nullable
    public Object erD() {
        return this.pqz;
    }

    public BUILDER bo(REQUEST request) {
        this.prA = request;
        return erM();
    }

    @Nullable
    public REQUEST erE() {
        return this.prA;
    }

    public boolean erF() {
        return this.prr;
    }

    public BUILDER AT(boolean z) {
        this.prE = z;
        return erM();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.prk = cVar;
        return erM();
    }

    @Nullable
    public d erG() {
        return this.prl;
    }

    @Nullable
    public String erH() {
        return this.prs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.prF = aVar;
        return erM();
    }

    @Nullable
    public com.facebook.drawee.d.a erI() {
        return this.prF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: erJ */
    public a erN() {
        validate();
        if (this.prA == null && this.prC == null && this.prB != null) {
            this.prA = this.prB;
            this.prB = null;
        }
        return erK();
    }

    protected void validate() {
        boolean z = false;
        g.checkState(this.prC == null || this.prA == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.pqk == null || (this.prC == null && this.prA == null && this.prB == null)) {
            z = true;
        }
        g.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a erK() {
        a erh = erh();
        erh.AS(erF());
        erh.Yr(erH());
        erh.a(erG());
        b(erh);
        a(erh);
        return erh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String erL() {
        return String.valueOf(prG.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.pqk != null) {
            return this.pqk;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.prA != null) {
            jVar = a(aVar, str, this.prA);
        } else if (this.prC != null) {
            jVar = a(aVar, str, this.prC, this.prD);
        }
        if (jVar != null && this.prB != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.prB));
            jVar = f.B(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.z(prz);
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
        return com.facebook.datasource.e.gK(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object erD = erD();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: eqK */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, erD, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.bb(this).I("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.pqs != null) {
            for (c cVar : this.pqs) {
                aVar.a(cVar);
            }
        }
        if (this.prk != null) {
            aVar.a(this.prk);
        }
        if (this.prE) {
            aVar.a(pry);
        }
    }

    protected void b(a aVar) {
        if (this.prd) {
            aVar.erw().AR(this.prd);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.erx() == null) {
            aVar.a(com.facebook.drawee.c.a.m55if(this.mContext));
        }
    }

    protected final BUILDER erM() {
        return this;
    }
}
