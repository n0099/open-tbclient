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
    private static final c<Object> nNn = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException nNo = new NullPointerException("No image request was specified!");
    private static final AtomicLong nNv = new AtomicLong();
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> nLZ;
    private boolean nMS;
    @Nullable
    private c<? super INFO> nMZ;
    private final Set<c> nMh;
    @Nullable
    private Object nMo;
    @Nullable
    private d nNa;
    private boolean nNg;
    private String nNh;
    @Nullable
    private REQUEST nNp;
    @Nullable
    private REQUEST nNq;
    @Nullable
    private REQUEST[] nNr;
    private boolean nNs;
    private boolean nNt;
    @Nullable
    private com.facebook.drawee.d.a nNu;

    /* loaded from: classes15.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dXr();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.nMh = set;
        init();
    }

    private void init() {
        this.nMo = null;
        this.nNp = null;
        this.nNq = null;
        this.nNr = null;
        this.nNs = true;
        this.nMZ = null;
        this.nNa = null;
        this.nMS = false;
        this.nNt = false;
        this.nNu = null;
        this.nNh = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bi */
    public BUILDER bl(Object obj) {
        this.nMo = obj;
        return dXV();
    }

    @Nullable
    public Object dXM() {
        return this.nMo;
    }

    public BUILDER bj(REQUEST request) {
        this.nNp = request;
        return dXV();
    }

    @Nullable
    public REQUEST dXN() {
        return this.nNp;
    }

    public BUILDER bk(REQUEST request) {
        this.nNq = request;
        return dXV();
    }

    public BUILDER yL(boolean z) {
        this.nMS = z;
        return dXV();
    }

    public boolean dXO() {
        return this.nNg;
    }

    public BUILDER yM(boolean z) {
        this.nNt = z;
        return dXV();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.nMZ = cVar;
        return dXV();
    }

    @Nullable
    public d dXP() {
        return this.nNa;
    }

    @Nullable
    public String dXQ() {
        return this.nNh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.nNu = aVar;
        return dXV();
    }

    @Nullable
    public com.facebook.drawee.d.a dXR() {
        return this.nNu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dXS */
    public a dXW() {
        validate();
        if (this.nNp == null && this.nNr == null && this.nNq != null) {
            this.nNp = this.nNq;
            this.nNq = null;
        }
        return dXT();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.nNr == null || this.nNp == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.nLZ == null || (this.nNr == null && this.nNp == null && this.nNq == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dXT() {
        a dXr = dXr();
        dXr.yK(dXO());
        dXr.VR(dXQ());
        dXr.a(dXP());
        b(dXr);
        a(dXr);
        return dXr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dXU() {
        return String.valueOf(nNv.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.nLZ != null) {
            return this.nLZ;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.nNp != null) {
            jVar = a(aVar, str, this.nNp);
        } else if (this.nNr != null) {
            jVar = a(aVar, str, this.nNr, this.nNs);
        }
        if (jVar != null && this.nNq != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.nNq));
            jVar = f.w(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.A(nNo);
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
        return com.facebook.datasource.e.fT(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dXM = dXM();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dWU */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dXM, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aV(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.nMh != null) {
            for (c cVar : this.nMh) {
                aVar.a(cVar);
            }
        }
        if (this.nMZ != null) {
            aVar.a(this.nMZ);
        }
        if (this.nNt) {
            aVar.a(nNn);
        }
    }

    protected void b(a aVar) {
        if (this.nMS) {
            aVar.dXF().yJ(this.nMS);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dXG() == null) {
            aVar.a(com.facebook.drawee.c.a.gE(this.mContext));
        }
    }

    protected final BUILDER dXV() {
        return this;
    }
}
