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
    private static final c<Object> oEG = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException oEH = new NullPointerException("No image request was specified!");
    private static final AtomicLong oEO = new AtomicLong();
    private final Context mContext;
    private final Set<c> oDA;
    @Nullable
    private Object oDH;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> oDs;
    private String oEA;
    @Nullable
    private REQUEST oEI;
    @Nullable
    private REQUEST oEJ;
    @Nullable
    private REQUEST[] oEK;
    private boolean oEL;
    private boolean oEM;
    @Nullable
    private com.facebook.drawee.d.a oEN;
    private boolean oEl;
    @Nullable
    private c<? super INFO> oEs;
    @Nullable
    private d oEt;
    private boolean oEz;

    /* loaded from: classes15.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a ehp();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.oDA = set;
        init();
    }

    private void init() {
        this.oDH = null;
        this.oEI = null;
        this.oEJ = null;
        this.oEK = null;
        this.oEL = true;
        this.oEs = null;
        this.oEt = null;
        this.oEl = false;
        this.oEM = false;
        this.oEN = null;
        this.oEA = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bm */
    public BUILDER bp(Object obj) {
        this.oDH = obj;
        return ehT();
    }

    @Nullable
    public Object ehK() {
        return this.oDH;
    }

    public BUILDER bn(REQUEST request) {
        this.oEI = request;
        return ehT();
    }

    @Nullable
    public REQUEST ehL() {
        return this.oEI;
    }

    public BUILDER bo(REQUEST request) {
        this.oEJ = request;
        return ehT();
    }

    public BUILDER zT(boolean z) {
        this.oEl = z;
        return ehT();
    }

    public boolean ehM() {
        return this.oEz;
    }

    public BUILDER zU(boolean z) {
        this.oEM = z;
        return ehT();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.oEs = cVar;
        return ehT();
    }

    @Nullable
    public d ehN() {
        return this.oEt;
    }

    @Nullable
    public String ehO() {
        return this.oEA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.oEN = aVar;
        return ehT();
    }

    @Nullable
    public com.facebook.drawee.d.a ehP() {
        return this.oEN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: ehQ */
    public a ehU() {
        validate();
        if (this.oEI == null && this.oEK == null && this.oEJ != null) {
            this.oEI = this.oEJ;
            this.oEJ = null;
        }
        return ehR();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.oEK == null || this.oEI == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.oDs == null || (this.oEK == null && this.oEI == null && this.oEJ == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a ehR() {
        a ehp = ehp();
        ehp.zS(ehM());
        ehp.XE(ehO());
        ehp.a(ehN());
        b(ehp);
        a(ehp);
        return ehp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String ehS() {
        return String.valueOf(oEO.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.oDs != null) {
            return this.oDs;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.oEI != null) {
            jVar = a(aVar, str, this.oEI);
        } else if (this.oEK != null) {
            jVar = a(aVar, str, this.oEK, this.oEL);
        }
        if (jVar != null && this.oEJ != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.oEJ));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.A(oEH);
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
        return com.facebook.datasource.e.gp(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object ehK = ehK();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: egS */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, ehK, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aZ(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.oDA != null) {
            for (c cVar : this.oDA) {
                aVar.a(cVar);
            }
        }
        if (this.oEs != null) {
            aVar.a(this.oEs);
        }
        if (this.oEM) {
            aVar.a(oEG);
        }
    }

    protected void b(a aVar) {
        if (this.oEl) {
            aVar.ehD().zR(this.oEl);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.ehE() == null) {
            aVar.a(com.facebook.drawee.c.a.gY(this.mContext));
        }
    }

    protected final BUILDER ehT() {
        return this;
    }
}
