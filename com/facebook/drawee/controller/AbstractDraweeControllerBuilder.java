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
    private j<com.facebook.datasource.b<IMAGE>> lKg;
    private final Set<c> lKo;
    @Nullable
    private Object lKv;
    private boolean lLA;
    private boolean lLB;
    @Nullable
    private com.facebook.drawee.d.a lLC;
    private boolean lLa;
    @Nullable
    private c<? super INFO> lLh;
    @Nullable
    private d lLi;
    private boolean lLo;
    private String lLp;
    @Nullable
    private REQUEST lLx;
    @Nullable
    private REQUEST lLy;
    @Nullable
    private REQUEST[] lLz;
    private final Context mContext;
    private static final c<Object> lLv = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lLw = new NullPointerException("No image request was specified!");
    private static final AtomicLong lLD = new AtomicLong();

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dlL();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lKo = set;
        init();
    }

    private void init() {
        this.lKv = null;
        this.lLx = null;
        this.lLy = null;
        this.lLz = null;
        this.lLA = true;
        this.lLh = null;
        this.lLi = null;
        this.lLa = false;
        this.lLB = false;
        this.lLC = null;
        this.lLp = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bf */
    public BUILDER bi(Object obj) {
        this.lKv = obj;
        return dmp();
    }

    @Nullable
    public Object dmg() {
        return this.lKv;
    }

    public BUILDER bg(REQUEST request) {
        this.lLx = request;
        return dmp();
    }

    @Nullable
    public REQUEST dmh() {
        return this.lLx;
    }

    public BUILDER bh(REQUEST request) {
        this.lLy = request;
        return dmp();
    }

    public BUILDER vg(boolean z) {
        this.lLa = z;
        return dmp();
    }

    public boolean dmi() {
        return this.lLo;
    }

    public BUILDER vh(boolean z) {
        this.lLB = z;
        return dmp();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lLh = cVar;
        return dmp();
    }

    @Nullable
    public d dmj() {
        return this.lLi;
    }

    @Nullable
    public String dmk() {
        return this.lLp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lLC = aVar;
        return dmp();
    }

    @Nullable
    public com.facebook.drawee.d.a dml() {
        return this.lLC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dmm */
    public a dmq() {
        validate();
        if (this.lLx == null && this.lLz == null && this.lLy != null) {
            this.lLx = this.lLy;
            this.lLy = null;
        }
        return dmn();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lLz == null || this.lLx == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lKg == null || (this.lLz == null && this.lLx == null && this.lLy == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dmn() {
        a dlL = dlL();
        dlL.vf(dmi());
        dlL.Pa(dmk());
        dlL.a(dmj());
        b(dlL);
        a(dlL);
        return dlL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dmo() {
        return String.valueOf(lLD.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lKg != null) {
            return this.lKg;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lLx != null) {
            jVar = a(aVar, str, this.lLx);
        } else if (this.lLz != null) {
            jVar = a(aVar, str, this.lLz, this.lLA);
        }
        if (jVar != null && this.lLy != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lLy));
            jVar = f.z(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.y(lLw);
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
        return com.facebook.datasource.e.eS(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dmg = dmg();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dlm */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dmg, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aS(this).x("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lKo != null) {
            for (c cVar : this.lKo) {
                aVar.a(cVar);
            }
        }
        if (this.lLh != null) {
            aVar.a(this.lLh);
        }
        if (this.lLB) {
            aVar.a(lLv);
        }
    }

    protected void b(a aVar) {
        if (this.lLa) {
            aVar.dlZ().ve(this.lLa);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dma() == null) {
            aVar.a(com.facebook.drawee.c.a.gk(this.mContext));
        }
    }

    protected final BUILDER dmp() {
        return this;
    }
}
