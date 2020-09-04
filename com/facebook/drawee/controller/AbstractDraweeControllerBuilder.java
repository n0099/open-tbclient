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
/* loaded from: classes4.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> nnU = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException nnV = new NullPointerException("No image request was specified!");
    private static final AtomicLong noc = new AtomicLong();
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> nmG;
    private final Set<c> nmO;
    @Nullable
    private Object nmV;
    @Nullable
    private c<? super INFO> nnG;
    @Nullable
    private d nnH;
    private boolean nnN;
    private String nnO;
    @Nullable
    private REQUEST nnW;
    @Nullable
    private REQUEST nnX;
    @Nullable
    private REQUEST[] nnY;
    private boolean nnZ;
    private boolean nnz;
    private boolean noa;
    @Nullable
    private com.facebook.drawee.d.a nob;

    /* loaded from: classes4.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dPI();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.nmO = set;
        init();
    }

    private void init() {
        this.nmV = null;
        this.nnW = null;
        this.nnX = null;
        this.nnY = null;
        this.nnZ = true;
        this.nnG = null;
        this.nnH = null;
        this.nnz = false;
        this.noa = false;
        this.nob = null;
        this.nnO = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bd */
    public BUILDER bg(Object obj) {
        this.nmV = obj;
        return dQm();
    }

    @Nullable
    public Object dQd() {
        return this.nmV;
    }

    public BUILDER be(REQUEST request) {
        this.nnW = request;
        return dQm();
    }

    @Nullable
    public REQUEST dQe() {
        return this.nnW;
    }

    public BUILDER bf(REQUEST request) {
        this.nnX = request;
        return dQm();
    }

    public BUILDER xV(boolean z) {
        this.nnz = z;
        return dQm();
    }

    public boolean dQf() {
        return this.nnN;
    }

    public BUILDER xW(boolean z) {
        this.noa = z;
        return dQm();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.nnG = cVar;
        return dQm();
    }

    @Nullable
    public d dQg() {
        return this.nnH;
    }

    @Nullable
    public String dQh() {
        return this.nnO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.nob = aVar;
        return dQm();
    }

    @Nullable
    public com.facebook.drawee.d.a dQi() {
        return this.nob;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dQj */
    public a dQn() {
        validate();
        if (this.nnW == null && this.nnY == null && this.nnX != null) {
            this.nnW = this.nnX;
            this.nnX = null;
        }
        return dQk();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.nnY == null || this.nnW == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.nmG == null || (this.nnY == null && this.nnW == null && this.nnX == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dQk() {
        a dPI = dPI();
        dPI.xU(dQf());
        dPI.UB(dQh());
        dPI.a(dQg());
        b(dPI);
        a(dPI);
        return dPI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dQl() {
        return String.valueOf(noc.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.nmG != null) {
            return this.nmG;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.nnW != null) {
            jVar = a(aVar, str, this.nnW);
        } else if (this.nnY != null) {
            jVar = a(aVar, str, this.nnY, this.nnZ);
        }
        if (jVar != null && this.nnX != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.nnX));
            jVar = f.v(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.A(nnV);
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
        return com.facebook.datasource.e.fH(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dQd = dQd();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dPl */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dQd, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aQ(this).E("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.nmO != null) {
            for (c cVar : this.nmO) {
                aVar.a(cVar);
            }
        }
        if (this.nnG != null) {
            aVar.a(this.nnG);
        }
        if (this.noa) {
            aVar.a(nnU);
        }
    }

    protected void b(a aVar) {
        if (this.nnz) {
            aVar.dPW().xT(this.nnz);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dPX() == null) {
            aVar.a(com.facebook.drawee.c.a.gq(this.mContext));
        }
    }

    protected final BUILDER dQm() {
        return this;
    }
}
