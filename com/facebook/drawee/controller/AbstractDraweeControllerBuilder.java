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
    private static final c<Object> lNb = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lNc = new NullPointerException("No image request was specified!");
    private static final AtomicLong lNj = new AtomicLong();
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lLM;
    private final Set<c> lLU;
    private boolean lMG;
    @Nullable
    private c<? super INFO> lMN;
    @Nullable
    private d lMO;
    private boolean lMU;
    private String lMV;
    @Nullable
    private Object lMb;
    @Nullable
    private REQUEST lNd;
    @Nullable
    private REQUEST lNe;
    @Nullable
    private REQUEST[] lNf;
    private boolean lNg;
    private boolean lNh;
    @Nullable
    private com.facebook.drawee.d.a lNi;
    private final Context mContext;

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dmi();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lLU = set;
        init();
    }

    private void init() {
        this.lMb = null;
        this.lNd = null;
        this.lNe = null;
        this.lNf = null;
        this.lNg = true;
        this.lMN = null;
        this.lMO = null;
        this.lMG = false;
        this.lNh = false;
        this.lNi = null;
        this.lMV = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bf */
    public BUILDER bi(Object obj) {
        this.lMb = obj;
        return dmM();
    }

    @Nullable
    public Object dmD() {
        return this.lMb;
    }

    public BUILDER bg(REQUEST request) {
        this.lNd = request;
        return dmM();
    }

    @Nullable
    public REQUEST dmE() {
        return this.lNd;
    }

    public BUILDER bh(REQUEST request) {
        this.lNe = request;
        return dmM();
    }

    public BUILDER vn(boolean z) {
        this.lMG = z;
        return dmM();
    }

    public boolean dmF() {
        return this.lMU;
    }

    public BUILDER vo(boolean z) {
        this.lNh = z;
        return dmM();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lMN = cVar;
        return dmM();
    }

    @Nullable
    public d dmG() {
        return this.lMO;
    }

    @Nullable
    public String dmH() {
        return this.lMV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lNi = aVar;
        return dmM();
    }

    @Nullable
    public com.facebook.drawee.d.a dmI() {
        return this.lNi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dmJ */
    public a dmN() {
        validate();
        if (this.lNd == null && this.lNf == null && this.lNe != null) {
            this.lNd = this.lNe;
            this.lNe = null;
        }
        return dmK();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lNf == null || this.lNd == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lLM == null || (this.lNf == null && this.lNd == null && this.lNe == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dmK() {
        a dmi = dmi();
        dmi.vm(dmF());
        dmi.OZ(dmH());
        dmi.a(dmG());
        b(dmi);
        a(dmi);
        return dmi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dmL() {
        return String.valueOf(lNj.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lLM != null) {
            return this.lLM;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lNd != null) {
            jVar = a(aVar, str, this.lNd);
        } else if (this.lNf != null) {
            jVar = a(aVar, str, this.lNf, this.lNg);
        }
        if (jVar != null && this.lNe != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lNe));
            jVar = f.z(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.y(lNc);
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
        final Object dmD = dmD();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dlJ */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dmD, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aS(this).x("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lLU != null) {
            for (c cVar : this.lLU) {
                aVar.a(cVar);
            }
        }
        if (this.lMN != null) {
            aVar.a(this.lMN);
        }
        if (this.lNh) {
            aVar.a(lNb);
        }
    }

    protected void b(a aVar) {
        if (this.lMG) {
            aVar.dmw().vl(this.lMG);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dmx() == null) {
            aVar.a(com.facebook.drawee.c.a.gj(this.mContext));
        }
    }

    protected final BUILDER dmM() {
        return this;
    }
}
