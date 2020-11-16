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
/* loaded from: classes14.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> oPD = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException oPE = new NullPointerException("No image request was specified!");
    private static final AtomicLong oPL = new AtomicLong();
    private final Context mContext;
    @Nullable
    private Object oOE;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> oOp;
    private final Set<c> oOx;
    @Nullable
    private REQUEST oPF;
    @Nullable
    private REQUEST oPG;
    @Nullable
    private REQUEST[] oPH;
    private boolean oPI;
    private boolean oPJ;
    @Nullable
    private com.facebook.drawee.d.a oPK;
    private boolean oPi;
    @Nullable
    private c<? super INFO> oPp;
    @Nullable
    private d oPq;
    private boolean oPw;
    private String oPx;

    /* loaded from: classes14.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a elc();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.oOx = set;
        init();
    }

    private void init() {
        this.oOE = null;
        this.oPF = null;
        this.oPG = null;
        this.oPH = null;
        this.oPI = true;
        this.oPp = null;
        this.oPq = null;
        this.oPi = false;
        this.oPJ = false;
        this.oPK = null;
        this.oPx = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bq(Object obj) {
        this.oOE = obj;
        return elG();
    }

    @Nullable
    public Object elx() {
        return this.oOE;
    }

    public BUILDER bo(REQUEST request) {
        this.oPF = request;
        return elG();
    }

    @Nullable
    public REQUEST ely() {
        return this.oPF;
    }

    public BUILDER bp(REQUEST request) {
        this.oPG = request;
        return elG();
    }

    public BUILDER Al(boolean z) {
        this.oPi = z;
        return elG();
    }

    public boolean elz() {
        return this.oPw;
    }

    public BUILDER Am(boolean z) {
        this.oPJ = z;
        return elG();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.oPp = cVar;
        return elG();
    }

    @Nullable
    public d elA() {
        return this.oPq;
    }

    @Nullable
    public String elB() {
        return this.oPx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.oPK = aVar;
        return elG();
    }

    @Nullable
    public com.facebook.drawee.d.a elC() {
        return this.oPK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: elD */
    public a elH() {
        validate();
        if (this.oPF == null && this.oPH == null && this.oPG != null) {
            this.oPF = this.oPG;
            this.oPG = null;
        }
        return elE();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.oPH == null || this.oPF == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.oOp == null || (this.oPH == null && this.oPF == null && this.oPG == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a elE() {
        a elc = elc();
        elc.Ak(elz());
        elc.XT(elB());
        elc.a(elA());
        b(elc);
        a(elc);
        return elc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String elF() {
        return String.valueOf(oPL.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.oOp != null) {
            return this.oOp;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.oPF != null) {
            jVar = a(aVar, str, this.oPF);
        } else if (this.oPH != null) {
            jVar = a(aVar, str, this.oPH, this.oPI);
        }
        if (jVar != null && this.oPG != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.oPG));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.A(oPE);
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
        final Object elx = elx();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: ekF */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, elx, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.ba(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.oOx != null) {
            for (c cVar : this.oOx) {
                aVar.a(cVar);
            }
        }
        if (this.oPp != null) {
            aVar.a(this.oPp);
        }
        if (this.oPJ) {
            aVar.a(oPD);
        }
    }

    protected void b(a aVar) {
        if (this.oPi) {
            aVar.elq().Aj(this.oPi);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.elr() == null) {
            aVar.a(com.facebook.drawee.c.a.gW(this.mContext));
        }
    }

    protected final BUILDER elG() {
        return this;
    }
}
