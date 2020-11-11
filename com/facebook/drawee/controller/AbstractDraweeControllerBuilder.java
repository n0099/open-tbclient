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
    private static final c<Object> oNZ = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException oOa = new NullPointerException("No image request was specified!");
    private static final AtomicLong oOh = new AtomicLong();
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> oML;
    private final Set<c> oMT;
    private boolean oNE;
    @Nullable
    private c<? super INFO> oNL;
    @Nullable
    private d oNM;
    private boolean oNS;
    private String oNT;
    @Nullable
    private Object oNa;
    @Nullable
    private REQUEST oOb;
    @Nullable
    private REQUEST oOc;
    @Nullable
    private REQUEST[] oOd;
    private boolean oOe;
    private boolean oOf;
    @Nullable
    private com.facebook.drawee.d.a oOg;

    /* loaded from: classes15.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a ele();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.oMT = set;
        init();
    }

    private void init() {
        this.oNa = null;
        this.oOb = null;
        this.oOc = null;
        this.oOd = null;
        this.oOe = true;
        this.oNL = null;
        this.oNM = null;
        this.oNE = false;
        this.oOf = false;
        this.oOg = null;
        this.oNT = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bm */
    public BUILDER bp(Object obj) {
        this.oNa = obj;
        return elI();
    }

    @Nullable
    public Object elz() {
        return this.oNa;
    }

    public BUILDER bn(REQUEST request) {
        this.oOb = request;
        return elI();
    }

    @Nullable
    public REQUEST elA() {
        return this.oOb;
    }

    public BUILDER bo(REQUEST request) {
        this.oOc = request;
        return elI();
    }

    public BUILDER Ae(boolean z) {
        this.oNE = z;
        return elI();
    }

    public boolean elB() {
        return this.oNS;
    }

    public BUILDER Af(boolean z) {
        this.oOf = z;
        return elI();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.oNL = cVar;
        return elI();
    }

    @Nullable
    public d elC() {
        return this.oNM;
    }

    @Nullable
    public String elD() {
        return this.oNT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.oOg = aVar;
        return elI();
    }

    @Nullable
    public com.facebook.drawee.d.a elE() {
        return this.oOg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: elF */
    public a elJ() {
        validate();
        if (this.oOb == null && this.oOd == null && this.oOc != null) {
            this.oOb = this.oOc;
            this.oOc = null;
        }
        return elG();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.oOd == null || this.oOb == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.oML == null || (this.oOd == null && this.oOb == null && this.oOc == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a elG() {
        a ele = ele();
        ele.Ad(elB());
        ele.Yi(elD());
        ele.a(elC());
        b(ele);
        a(ele);
        return ele;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String elH() {
        return String.valueOf(oOh.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.oML != null) {
            return this.oML;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.oOb != null) {
            jVar = a(aVar, str, this.oOb);
        } else if (this.oOd != null) {
            jVar = a(aVar, str, this.oOd, this.oOe);
        }
        if (jVar != null && this.oOc != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.oOc));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.A(oOa);
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
        return com.facebook.datasource.e.gy(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object elz = elz();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: ekH */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, elz, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aZ(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.oMT != null) {
            for (c cVar : this.oMT) {
                aVar.a(cVar);
            }
        }
        if (this.oNL != null) {
            aVar.a(this.oNL);
        }
        if (this.oOf) {
            aVar.a(oNZ);
        }
    }

    protected void b(a aVar) {
        if (this.oNE) {
            aVar.els().Ac(this.oNE);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.elt() == null) {
            aVar.a(com.facebook.drawee.c.a.gY(this.mContext));
        }
    }

    protected final BUILDER elI() {
        return this;
    }
}
