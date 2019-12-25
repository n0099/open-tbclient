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
/* loaded from: classes11.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> lGY = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lGZ = new NullPointerException("No image request was specified!");
    private static final AtomicLong lHg = new AtomicLong();
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lFJ;
    private final Set<c> lFR;
    @Nullable
    private Object lFY;
    private boolean lGD;
    @Nullable
    private c<? super INFO> lGK;
    @Nullable
    private d lGL;
    private boolean lGR;
    private String lGS;
    @Nullable
    private REQUEST lHa;
    @Nullable
    private REQUEST lHb;
    @Nullable
    private REQUEST[] lHc;
    private boolean lHd;
    private boolean lHe;
    @Nullable
    private com.facebook.drawee.d.a lHf;
    private final Context mContext;

    /* loaded from: classes11.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a djs();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lFR = set;
        init();
    }

    private void init() {
        this.lFY = null;
        this.lHa = null;
        this.lHb = null;
        this.lHc = null;
        this.lHd = true;
        this.lGK = null;
        this.lGL = null;
        this.lGD = false;
        this.lHe = false;
        this.lHf = null;
        this.lGS = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bd */
    public BUILDER bf(Object obj) {
        this.lFY = obj;
        return djW();
    }

    @Nullable
    public Object djN() {
        return this.lFY;
    }

    public BUILDER be(REQUEST request) {
        this.lHa = request;
        return djW();
    }

    @Nullable
    public REQUEST djO() {
        return this.lHa;
    }

    public boolean djP() {
        return this.lGR;
    }

    public BUILDER uR(boolean z) {
        this.lHe = z;
        return djW();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lGK = cVar;
        return djW();
    }

    @Nullable
    public d djQ() {
        return this.lGL;
    }

    @Nullable
    public String djR() {
        return this.lGS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lHf = aVar;
        return djW();
    }

    @Nullable
    public com.facebook.drawee.d.a djS() {
        return this.lHf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: djT */
    public a djX() {
        validate();
        if (this.lHa == null && this.lHc == null && this.lHb != null) {
            this.lHa = this.lHb;
            this.lHb = null;
        }
        return djU();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lHc == null || this.lHa == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lFJ == null || (this.lHc == null && this.lHa == null && this.lHb == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a djU() {
        a djs = djs();
        djs.uQ(djP());
        djs.OC(djR());
        djs.a(djQ());
        b(djs);
        a(djs);
        return djs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String djV() {
        return String.valueOf(lHg.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lFJ != null) {
            return this.lFJ;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lHa != null) {
            jVar = a(aVar, str, this.lHa);
        } else if (this.lHc != null) {
            jVar = a(aVar, str, this.lHc, this.lHd);
        }
        if (jVar != null && this.lHb != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lHb));
            jVar = f.w(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.z(lGZ);
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
        return com.facebook.datasource.e.eX(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object djN = djN();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: diT */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, djN, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aQ(this).x("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lFR != null) {
            for (c cVar : this.lFR) {
                aVar.a(cVar);
            }
        }
        if (this.lGK != null) {
            aVar.a(this.lGK);
        }
        if (this.lHe) {
            aVar.a(lGY);
        }
    }

    protected void b(a aVar) {
        if (this.lGD) {
            aVar.djG().uP(this.lGD);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.djH() == null) {
            aVar.a(com.facebook.drawee.c.a.gk(this.mContext));
        }
    }

    protected final BUILDER djW() {
        return this;
    }
}
