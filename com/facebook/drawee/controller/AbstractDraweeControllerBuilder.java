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
    private static final c<Object> lLk = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lLl = new NullPointerException("No image request was specified!");
    private static final AtomicLong lLs = new AtomicLong();
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lJV;
    private boolean lKP;
    @Nullable
    private c<? super INFO> lKW;
    @Nullable
    private d lKX;
    private final Set<c> lKd;
    @Nullable
    private Object lKk;
    private boolean lLd;
    private String lLe;
    @Nullable
    private REQUEST lLm;
    @Nullable
    private REQUEST lLn;
    @Nullable
    private REQUEST[] lLo;
    private boolean lLp;
    private boolean lLq;
    @Nullable
    private com.facebook.drawee.d.a lLr;
    private final Context mContext;

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dlK();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lKd = set;
        init();
    }

    private void init() {
        this.lKk = null;
        this.lLm = null;
        this.lLn = null;
        this.lLo = null;
        this.lLp = true;
        this.lKW = null;
        this.lKX = null;
        this.lKP = false;
        this.lLq = false;
        this.lLr = null;
        this.lLe = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bf */
    public BUILDER bi(Object obj) {
        this.lKk = obj;
        return dmo();
    }

    @Nullable
    public Object dmf() {
        return this.lKk;
    }

    public BUILDER bg(REQUEST request) {
        this.lLm = request;
        return dmo();
    }

    @Nullable
    public REQUEST dmg() {
        return this.lLm;
    }

    public BUILDER bh(REQUEST request) {
        this.lLn = request;
        return dmo();
    }

    public BUILDER vg(boolean z) {
        this.lKP = z;
        return dmo();
    }

    public boolean dmh() {
        return this.lLd;
    }

    public BUILDER vh(boolean z) {
        this.lLq = z;
        return dmo();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lKW = cVar;
        return dmo();
    }

    @Nullable
    public d dmi() {
        return this.lKX;
    }

    @Nullable
    public String dmj() {
        return this.lLe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lLr = aVar;
        return dmo();
    }

    @Nullable
    public com.facebook.drawee.d.a dmk() {
        return this.lLr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dml */
    public a dmp() {
        validate();
        if (this.lLm == null && this.lLo == null && this.lLn != null) {
            this.lLm = this.lLn;
            this.lLn = null;
        }
        return dmm();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lLo == null || this.lLm == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lJV == null || (this.lLo == null && this.lLm == null && this.lLn == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dmm() {
        a dlK = dlK();
        dlK.vf(dmh());
        dlK.OZ(dmj());
        dlK.a(dmi());
        b(dlK);
        a(dlK);
        return dlK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dmn() {
        return String.valueOf(lLs.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lJV != null) {
            return this.lJV;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lLm != null) {
            jVar = a(aVar, str, this.lLm);
        } else if (this.lLo != null) {
            jVar = a(aVar, str, this.lLo, this.lLp);
        }
        if (jVar != null && this.lLn != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lLn));
            jVar = f.z(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.y(lLl);
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
        final Object dmf = dmf();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dll */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dmf, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aS(this).x("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lKd != null) {
            for (c cVar : this.lKd) {
                aVar.a(cVar);
            }
        }
        if (this.lKW != null) {
            aVar.a(this.lKW);
        }
        if (this.lLq) {
            aVar.a(lLk);
        }
    }

    protected void b(a aVar) {
        if (this.lKP) {
            aVar.dlY().ve(this.lKP);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dlZ() == null) {
            aVar.a(com.facebook.drawee.c.a.gk(this.mContext));
        }
    }

    protected final BUILDER dmo() {
        return this;
    }
}
