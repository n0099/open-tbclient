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
    private static final c<Object> lLi = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lLj = new NullPointerException("No image request was specified!");
    private static final AtomicLong lLq = new AtomicLong();
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lJT;
    private boolean lKN;
    @Nullable
    private c<? super INFO> lKU;
    @Nullable
    private d lKV;
    private final Set<c> lKb;
    @Nullable
    private Object lKi;
    private boolean lLb;
    private String lLc;
    @Nullable
    private REQUEST lLk;
    @Nullable
    private REQUEST lLl;
    @Nullable
    private REQUEST[] lLm;
    private boolean lLn;
    private boolean lLo;
    @Nullable
    private com.facebook.drawee.d.a lLp;
    private final Context mContext;

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dlI();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lKb = set;
        init();
    }

    private void init() {
        this.lKi = null;
        this.lLk = null;
        this.lLl = null;
        this.lLm = null;
        this.lLn = true;
        this.lKU = null;
        this.lKV = null;
        this.lKN = false;
        this.lLo = false;
        this.lLp = null;
        this.lLc = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bf */
    public BUILDER bi(Object obj) {
        this.lKi = obj;
        return dmm();
    }

    @Nullable
    public Object dmd() {
        return this.lKi;
    }

    public BUILDER bg(REQUEST request) {
        this.lLk = request;
        return dmm();
    }

    @Nullable
    public REQUEST dme() {
        return this.lLk;
    }

    public BUILDER bh(REQUEST request) {
        this.lLl = request;
        return dmm();
    }

    public BUILDER vg(boolean z) {
        this.lKN = z;
        return dmm();
    }

    public boolean dmf() {
        return this.lLb;
    }

    public BUILDER vh(boolean z) {
        this.lLo = z;
        return dmm();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lKU = cVar;
        return dmm();
    }

    @Nullable
    public d dmg() {
        return this.lKV;
    }

    @Nullable
    public String dmh() {
        return this.lLc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lLp = aVar;
        return dmm();
    }

    @Nullable
    public com.facebook.drawee.d.a dmi() {
        return this.lLp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dmj */
    public a dmn() {
        validate();
        if (this.lLk == null && this.lLm == null && this.lLl != null) {
            this.lLk = this.lLl;
            this.lLl = null;
        }
        return dmk();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lLm == null || this.lLk == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lJT == null || (this.lLm == null && this.lLk == null && this.lLl == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dmk() {
        a dlI = dlI();
        dlI.vf(dmf());
        dlI.OZ(dmh());
        dlI.a(dmg());
        b(dlI);
        a(dlI);
        return dlI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dml() {
        return String.valueOf(lLq.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lJT != null) {
            return this.lJT;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lLk != null) {
            jVar = a(aVar, str, this.lLk);
        } else if (this.lLm != null) {
            jVar = a(aVar, str, this.lLm, this.lLn);
        }
        if (jVar != null && this.lLl != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lLl));
            jVar = f.z(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.y(lLj);
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
        final Object dmd = dmd();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dlj */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dmd, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aS(this).x("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lKb != null) {
            for (c cVar : this.lKb) {
                aVar.a(cVar);
            }
        }
        if (this.lKU != null) {
            aVar.a(this.lKU);
        }
        if (this.lLo) {
            aVar.a(lLi);
        }
    }

    protected void b(a aVar) {
        if (this.lKN) {
            aVar.dlW().ve(this.lKN);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dlX() == null) {
            aVar.a(com.facebook.drawee.c.a.gk(this.mContext));
        }
    }

    protected final BUILDER dmm() {
        return this;
    }
}
