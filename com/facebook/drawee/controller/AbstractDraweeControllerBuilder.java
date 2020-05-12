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
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lTk;
    private final Set<c> lTs;
    @Nullable
    private Object lTz;
    @Nullable
    private REQUEST lUA;
    @Nullable
    private REQUEST lUB;
    @Nullable
    private REQUEST[] lUC;
    private boolean lUD;
    private boolean lUE;
    @Nullable
    private com.facebook.drawee.d.a lUF;
    private boolean lUd;
    @Nullable
    private c<? super INFO> lUk;
    @Nullable
    private d lUl;
    private boolean lUr;
    private String lUs;
    private final Context mContext;
    private static final c<Object> lUy = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lUz = new NullPointerException("No image request was specified!");
    private static final AtomicLong lUG = new AtomicLong();

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dnZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lTs = set;
        init();
    }

    private void init() {
        this.lTz = null;
        this.lUA = null;
        this.lUB = null;
        this.lUC = null;
        this.lUD = true;
        this.lUk = null;
        this.lUl = null;
        this.lUd = false;
        this.lUE = false;
        this.lUF = null;
        this.lUs = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aW */
    public BUILDER aZ(Object obj) {
        this.lTz = obj;
        return doD();
    }

    @Nullable
    public Object dou() {
        return this.lTz;
    }

    public BUILDER aX(REQUEST request) {
        this.lUA = request;
        return doD();
    }

    @Nullable
    public REQUEST dov() {
        return this.lUA;
    }

    public BUILDER aY(REQUEST request) {
        this.lUB = request;
        return doD();
    }

    public BUILDER vB(boolean z) {
        this.lUd = z;
        return doD();
    }

    public boolean dow() {
        return this.lUr;
    }

    public BUILDER vC(boolean z) {
        this.lUE = z;
        return doD();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lUk = cVar;
        return doD();
    }

    @Nullable
    public d dox() {
        return this.lUl;
    }

    @Nullable
    public String doy() {
        return this.lUs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lUF = aVar;
        return doD();
    }

    @Nullable
    public com.facebook.drawee.d.a doz() {
        return this.lUF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: doA */
    public a doE() {
        validate();
        if (this.lUA == null && this.lUC == null && this.lUB != null) {
            this.lUA = this.lUB;
            this.lUB = null;
        }
        return doB();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lUC == null || this.lUA == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lTk == null || (this.lUC == null && this.lUA == null && this.lUB == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a doB() {
        a dnZ = dnZ();
        dnZ.vA(dow());
        dnZ.Ok(doy());
        dnZ.a(dox());
        b(dnZ);
        a(dnZ);
        return dnZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String doC() {
        return String.valueOf(lUG.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lTk != null) {
            return this.lTk;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lUA != null) {
            jVar = a(aVar, str, this.lUA);
        } else if (this.lUC != null) {
            jVar = a(aVar, str, this.lUC, this.lUD);
        }
        if (jVar != null && this.lUB != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lUB));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.C(lUz);
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
        final Object dou = dou();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dnC */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dou, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aJ(this).C("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lTs != null) {
            for (c cVar : this.lTs) {
                aVar.a(cVar);
            }
        }
        if (this.lUk != null) {
            aVar.a(this.lUk);
        }
        if (this.lUE) {
            aVar.a(lUy);
        }
    }

    protected void b(a aVar) {
        if (this.lUd) {
            aVar.don().vz(this.lUd);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.doo() == null) {
            aVar.a(com.facebook.drawee.c.a.fB(this.mContext));
        }
    }

    protected final BUILDER doD() {
        return this;
    }
}
