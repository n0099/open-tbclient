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
/* loaded from: classes8.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> peM = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException peN = new NullPointerException("No image request was specified!");
    private static final AtomicLong peU = new AtomicLong();
    private final Context mContext;
    private final Set<c> pdG;
    @Nullable
    private Object pdN;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> pdy;
    private boolean peF;
    private String peG;
    @Nullable
    private REQUEST peO;
    @Nullable
    private REQUEST peP;
    @Nullable
    private REQUEST[] peQ;
    private boolean peR;
    private boolean peS;
    @Nullable
    private com.facebook.drawee.d.a peT;
    private boolean per;
    @Nullable
    private c<? super INFO> pey;
    @Nullable
    private d pez;

    /* loaded from: classes8.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a eqS();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.pdG = set;
        init();
    }

    private void init() {
        this.pdN = null;
        this.peO = null;
        this.peP = null;
        this.peQ = null;
        this.peR = true;
        this.pey = null;
        this.pez = null;
        this.per = false;
        this.peS = false;
        this.peT = null;
        this.peG = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bp(Object obj) {
        this.pdN = obj;
        return erw();
    }

    @Nullable
    public Object ern() {
        return this.pdN;
    }

    public BUILDER bo(REQUEST request) {
        this.peO = request;
        return erw();
    }

    @Nullable
    public REQUEST ero() {
        return this.peO;
    }

    public boolean erp() {
        return this.peF;
    }

    public BUILDER AP(boolean z) {
        this.peS = z;
        return erw();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.pey = cVar;
        return erw();
    }

    @Nullable
    public d erq() {
        return this.pez;
    }

    @Nullable
    public String err() {
        return this.peG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.peT = aVar;
        return erw();
    }

    @Nullable
    public com.facebook.drawee.d.a ers() {
        return this.peT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: ert */
    public a erx() {
        validate();
        if (this.peO == null && this.peQ == null && this.peP != null) {
            this.peO = this.peP;
            this.peP = null;
        }
        return eru();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.peQ == null || this.peO == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.pdy == null || (this.peQ == null && this.peO == null && this.peP == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a eru() {
        a eqS = eqS();
        eqS.AO(erp());
        eqS.Zo(err());
        eqS.a(erq());
        b(eqS);
        a(eqS);
        return eqS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String erv() {
        return String.valueOf(peU.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.pdy != null) {
            return this.pdy;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.peO != null) {
            jVar = a(aVar, str, this.peO);
        } else if (this.peQ != null) {
            jVar = a(aVar, str, this.peQ, this.peR);
        }
        if (jVar != null && this.peP != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.peP));
            jVar = f.z(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.A(peN);
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
        return com.facebook.datasource.e.gN(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object ern = ern();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: eqv */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, ern, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ba(this).E("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.pdG != null) {
            for (c cVar : this.pdG) {
                aVar.a(cVar);
            }
        }
        if (this.pey != null) {
            aVar.a(this.pey);
        }
        if (this.peS) {
            aVar.a(peM);
        }
    }

    protected void b(a aVar) {
        if (this.per) {
            aVar.erg().AN(this.per);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.erh() == null) {
            aVar.a(com.facebook.drawee.c.a.hF(this.mContext));
        }
    }

    protected final BUILDER erw() {
        return this;
    }
}
