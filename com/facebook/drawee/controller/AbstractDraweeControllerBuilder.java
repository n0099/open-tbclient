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
    private static final c<Object> pvS = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException pvT = new NullPointerException("No image request was specified!");
    private static final AtomicLong pwa = new AtomicLong();
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> puE;
    private final Set<c> puM;
    @Nullable
    private Object puT;
    @Nullable
    private c<? super INFO> pvE;
    @Nullable
    private d pvF;
    private boolean pvL;
    private String pvM;
    @Nullable
    private REQUEST pvU;
    @Nullable
    private REQUEST pvV;
    @Nullable
    private REQUEST[] pvW;
    private boolean pvX;
    private boolean pvY;
    @Nullable
    private com.facebook.drawee.d.a pvZ;
    private boolean pvx;

    /* loaded from: classes15.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a euU();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.puM = set;
        init();
    }

    private void init() {
        this.puT = null;
        this.pvU = null;
        this.pvV = null;
        this.pvW = null;
        this.pvX = true;
        this.pvE = null;
        this.pvF = null;
        this.pvx = false;
        this.pvY = false;
        this.pvZ = null;
        this.pvM = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bp(Object obj) {
        this.puT = obj;
        return evy();
    }

    @Nullable
    public Object evp() {
        return this.puT;
    }

    public BUILDER bo(REQUEST request) {
        this.pvU = request;
        return evy();
    }

    @Nullable
    public REQUEST evq() {
        return this.pvU;
    }

    public boolean evr() {
        return this.pvL;
    }

    public BUILDER AX(boolean z) {
        this.pvY = z;
        return evy();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.pvE = cVar;
        return evy();
    }

    @Nullable
    public d evs() {
        return this.pvF;
    }

    @Nullable
    public String evt() {
        return this.pvM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.pvZ = aVar;
        return evy();
    }

    @Nullable
    public com.facebook.drawee.d.a evu() {
        return this.pvZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: evv */
    public a evz() {
        validate();
        if (this.pvU == null && this.pvW == null && this.pvV != null) {
            this.pvU = this.pvV;
            this.pvV = null;
        }
        return evw();
    }

    protected void validate() {
        boolean z = false;
        g.checkState(this.pvW == null || this.pvU == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.puE == null || (this.pvW == null && this.pvU == null && this.pvV == null)) {
            z = true;
        }
        g.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a evw() {
        a euU = euU();
        euU.AW(evr());
        euU.Zz(evt());
        euU.a(evs());
        b(euU);
        a(euU);
        return euU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String evx() {
        return String.valueOf(pwa.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.puE != null) {
            return this.puE;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.pvU != null) {
            jVar = a(aVar, str, this.pvU);
        } else if (this.pvW != null) {
            jVar = a(aVar, str, this.pvW, this.pvX);
        }
        if (jVar != null && this.pvV != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.pvV));
            jVar = f.B(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.z(pvT);
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
        final Object evp = evp();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: eux */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, evp, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.bb(this).I("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.puM != null) {
            for (c cVar : this.puM) {
                aVar.a(cVar);
            }
        }
        if (this.pvE != null) {
            aVar.a(this.pvE);
        }
        if (this.pvY) {
            aVar.a(pvS);
        }
    }

    protected void b(a aVar) {
        if (this.pvx) {
            aVar.evi().AV(this.pvx);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.evj() == null) {
            aVar.a(com.facebook.drawee.c.a.ih(this.mContext));
        }
    }

    protected final BUILDER evy() {
        return this;
    }
}
