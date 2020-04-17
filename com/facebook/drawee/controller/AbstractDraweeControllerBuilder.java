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
/* loaded from: classes13.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private boolean lTZ;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lTg;
    private final Set<c> lTo;
    @Nullable
    private Object lTv;
    private boolean lUA;
    @Nullable
    private com.facebook.drawee.d.a lUB;
    @Nullable
    private c<? super INFO> lUg;
    @Nullable
    private d lUh;
    private boolean lUn;
    private String lUo;
    @Nullable
    private REQUEST lUw;
    @Nullable
    private REQUEST lUx;
    @Nullable
    private REQUEST[] lUy;
    private boolean lUz;
    private final Context mContext;
    private static final c<Object> lUu = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lUv = new NullPointerException("No image request was specified!");
    private static final AtomicLong lUC = new AtomicLong();

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dob();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lTo = set;
        init();
    }

    private void init() {
        this.lTv = null;
        this.lUw = null;
        this.lUx = null;
        this.lUy = null;
        this.lUz = true;
        this.lUg = null;
        this.lUh = null;
        this.lTZ = false;
        this.lUA = false;
        this.lUB = null;
        this.lUo = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aV */
    public BUILDER aY(Object obj) {
        this.lTv = obj;
        return doF();
    }

    @Nullable
    public Object dow() {
        return this.lTv;
    }

    public BUILDER aW(REQUEST request) {
        this.lUw = request;
        return doF();
    }

    @Nullable
    public REQUEST dox() {
        return this.lUw;
    }

    public BUILDER aX(REQUEST request) {
        this.lUx = request;
        return doF();
    }

    public BUILDER vB(boolean z) {
        this.lTZ = z;
        return doF();
    }

    public boolean doy() {
        return this.lUn;
    }

    public BUILDER vC(boolean z) {
        this.lUA = z;
        return doF();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lUg = cVar;
        return doF();
    }

    @Nullable
    public d doz() {
        return this.lUh;
    }

    @Nullable
    public String doA() {
        return this.lUo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lUB = aVar;
        return doF();
    }

    @Nullable
    public com.facebook.drawee.d.a doB() {
        return this.lUB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: doC */
    public a doG() {
        validate();
        if (this.lUw == null && this.lUy == null && this.lUx != null) {
            this.lUw = this.lUx;
            this.lUx = null;
        }
        return doD();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lUy == null || this.lUw == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lTg == null || (this.lUy == null && this.lUw == null && this.lUx == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a doD() {
        a dob = dob();
        dob.vA(doy());
        dob.Oh(doA());
        dob.a(doz());
        b(dob);
        a(dob);
        return dob;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String doE() {
        return String.valueOf(lUC.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lTg != null) {
            return this.lTg;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lUw != null) {
            jVar = a(aVar, str, this.lUw);
        } else if (this.lUy != null) {
            jVar = a(aVar, str, this.lUy, this.lUz);
        }
        if (jVar != null && this.lUx != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lUx));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.C(lUv);
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
        return com.facebook.datasource.e.eT(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dow = dow();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dnE */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dow, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aI(this).C("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lTo != null) {
            for (c cVar : this.lTo) {
                aVar.a(cVar);
            }
        }
        if (this.lUg != null) {
            aVar.a(this.lUg);
        }
        if (this.lUA) {
            aVar.a(lUu);
        }
    }

    protected void b(a aVar) {
        if (this.lTZ) {
            aVar.dop().vz(this.lTZ);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.doq() == null) {
            aVar.a(com.facebook.drawee.c.a.fN(this.mContext));
        }
    }

    protected final BUILDER doF() {
        return this;
    }
}
