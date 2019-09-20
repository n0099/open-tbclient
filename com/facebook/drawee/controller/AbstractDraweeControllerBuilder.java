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
    private static final c<Object> kfh = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException kfi = new NullPointerException("No image request was specified!");
    private static final AtomicLong kfp = new AtomicLong();
    private final Set<c> keB;
    private boolean keL;
    @Nullable
    private c<? super INFO> keS;
    @Nullable
    private d keT;
    @Nullable
    private Object keW;
    @Nullable
    private i<com.facebook.datasource.b<IMAGE>> keu;
    private boolean kfa;
    private String kfb;
    @Nullable
    private REQUEST kfj;
    @Nullable
    private REQUEST kfk;
    @Nullable
    private REQUEST[] kfl;
    private boolean kfm;
    private boolean kfn;
    @Nullable
    private com.facebook.drawee.d.a kfo;
    private final Context mContext;

    /* loaded from: classes2.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(REQUEST request, Object obj, CacheLevel cacheLevel);

    protected abstract BUILDER cGM();

    @ReturnsOwnership
    protected abstract a cGN();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.keB = set;
        init();
    }

    private void init() {
        this.keW = null;
        this.kfj = null;
        this.kfk = null;
        this.kfl = null;
        this.kfm = true;
        this.keS = null;
        this.keT = null;
        this.keL = false;
        this.kfn = false;
        this.kfo = null;
        this.kfb = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: aN */
    public BUILDER aQ(Object obj) {
        this.keW = obj;
        return cGM();
    }

    @Nullable
    public Object cHd() {
        return this.keW;
    }

    public BUILDER aO(REQUEST request) {
        this.kfj = request;
        return cGM();
    }

    @Nullable
    public REQUEST cHe() {
        return this.kfj;
    }

    public boolean cHf() {
        return this.kfa;
    }

    public BUILDER b(c<? super INFO> cVar) {
        this.keS = cVar;
        return cGM();
    }

    @Nullable
    public d cHg() {
        return this.keT;
    }

    @Nullable
    public String cHh() {
        return this.kfb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: a */
    public BUILDER b(@Nullable com.facebook.drawee.d.a aVar) {
        this.kfo = aVar;
        return cGM();
    }

    @Nullable
    public com.facebook.drawee.d.a cHi() {
        return this.kfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: cHj */
    public a cHn() {
        validate();
        if (this.kfj == null && this.kfl == null && this.kfk != null) {
            this.kfj = this.kfk;
            this.kfk = null;
        }
        return cHk();
    }

    protected void validate() {
        boolean z = false;
        g.c(this.kfl == null || this.kfj == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.keu == null || (this.kfl == null && this.kfj == null && this.kfk == null)) {
            z = true;
        }
        g.c(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a cHk() {
        a cGN = cGN();
        cGN.sA(cHf());
        cGN.Im(cHh());
        cGN.a(cHg());
        c(cGN);
        b(cGN);
        return cGN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cHl() {
        return String.valueOf(kfp.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i<com.facebook.datasource.b<IMAGE>> cHm() {
        if (this.keu != null) {
            return this.keu;
        }
        i<com.facebook.datasource.b<IMAGE>> iVar = null;
        if (this.kfj != null) {
            iVar = aP(this.kfj);
        } else if (this.kfl != null) {
            iVar = a(this.kfl, this.kfm);
        }
        if (iVar != null && this.kfk != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(iVar);
            arrayList.add(aP(this.kfk));
            iVar = f.eE(arrayList);
        }
        if (iVar == null) {
            return com.facebook.datasource.c.x(kfi);
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
        final Object cHd = cHd();
        return new i<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.i
            /* renamed from: cGu */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(request, cHd, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aC(this).t("request", request.toString()).toString();
            }
        };
    }

    protected void b(a aVar) {
        if (this.keB != null) {
            for (c cVar : this.keB) {
                aVar.a(cVar);
            }
        }
        if (this.keS != null) {
            aVar.a(this.keS);
        }
        if (this.kfn) {
            aVar.a(kfh);
        }
    }

    protected void c(a aVar) {
        if (this.keL) {
            com.facebook.drawee.components.b cGV = aVar.cGV();
            if (cGV == null) {
                cGV = new com.facebook.drawee.components.b();
                aVar.a(cGV);
            }
            cGV.sz(this.keL);
            d(aVar);
        }
    }

    protected void d(a aVar) {
        if (aVar.cGW() == null) {
            aVar.a(com.facebook.drawee.c.a.eC(this.mContext));
        }
    }
}
