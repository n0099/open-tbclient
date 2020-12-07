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
    private static final c<Object> peK = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException peL = new NullPointerException("No image request was specified!");
    private static final AtomicLong peS = new AtomicLong();
    private final Context mContext;
    private final Set<c> pdE;
    @Nullable
    private Object pdL;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> pdw;
    private boolean peD;
    private String peE;
    @Nullable
    private REQUEST peM;
    @Nullable
    private REQUEST peN;
    @Nullable
    private REQUEST[] peO;
    private boolean peP;
    private boolean peQ;
    @Nullable
    private com.facebook.drawee.d.a peR;
    private boolean pep;
    @Nullable
    private c<? super INFO> pew;
    @Nullable
    private d pex;

    /* loaded from: classes8.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a eqR();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.pdE = set;
        init();
    }

    private void init() {
        this.pdL = null;
        this.peM = null;
        this.peN = null;
        this.peO = null;
        this.peP = true;
        this.pew = null;
        this.pex = null;
        this.pep = false;
        this.peQ = false;
        this.peR = null;
        this.peE = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bp(Object obj) {
        this.pdL = obj;
        return erv();
    }

    @Nullable
    public Object erm() {
        return this.pdL;
    }

    public BUILDER bo(REQUEST request) {
        this.peM = request;
        return erv();
    }

    @Nullable
    public REQUEST ern() {
        return this.peM;
    }

    public boolean ero() {
        return this.peD;
    }

    public BUILDER AP(boolean z) {
        this.peQ = z;
        return erv();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.pew = cVar;
        return erv();
    }

    @Nullable
    public d erp() {
        return this.pex;
    }

    @Nullable
    public String erq() {
        return this.peE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.peR = aVar;
        return erv();
    }

    @Nullable
    public com.facebook.drawee.d.a err() {
        return this.peR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: ers */
    public a erw() {
        validate();
        if (this.peM == null && this.peO == null && this.peN != null) {
            this.peM = this.peN;
            this.peN = null;
        }
        return ert();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.peO == null || this.peM == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.pdw == null || (this.peO == null && this.peM == null && this.peN == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a ert() {
        a eqR = eqR();
        eqR.AO(ero());
        eqR.Zo(erq());
        eqR.a(erp());
        b(eqR);
        a(eqR);
        return eqR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String eru() {
        return String.valueOf(peS.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.pdw != null) {
            return this.pdw;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.peM != null) {
            jVar = a(aVar, str, this.peM);
        } else if (this.peO != null) {
            jVar = a(aVar, str, this.peO, this.peP);
        }
        if (jVar != null && this.peN != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.peN));
            jVar = f.z(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.A(peL);
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
        final Object erm = erm();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: equ */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, erm, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ba(this).E("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.pdE != null) {
            for (c cVar : this.pdE) {
                aVar.a(cVar);
            }
        }
        if (this.pew != null) {
            aVar.a(this.pew);
        }
        if (this.peQ) {
            aVar.a(peK);
        }
    }

    protected void b(a aVar) {
        if (this.pep) {
            aVar.erf().AN(this.pep);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.erg() == null) {
            aVar.a(com.facebook.drawee.c.a.hF(this.mContext));
        }
    }

    protected final BUILDER erv() {
        return this;
    }
}
