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
    private static final c<Object> mLD = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException mLE = new NullPointerException("No image request was specified!");
    private static final AtomicLong mLL = new AtomicLong();
    private final Context mContext;
    @Nullable
    private Object mKE;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> mKp;
    private final Set<c> mKx;
    @Nullable
    private REQUEST mLF;
    @Nullable
    private REQUEST mLG;
    @Nullable
    private REQUEST[] mLH;
    private boolean mLI;
    private boolean mLJ;
    @Nullable
    private com.facebook.drawee.d.a mLK;
    private boolean mLi;
    @Nullable
    private c<? super INFO> mLp;
    @Nullable
    private d mLq;
    private boolean mLw;
    private String mLx;

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dAm();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.mKx = set;
        init();
    }

    private void init() {
        this.mKE = null;
        this.mLF = null;
        this.mLG = null;
        this.mLH = null;
        this.mLI = true;
        this.mLp = null;
        this.mLq = null;
        this.mLi = false;
        this.mLJ = false;
        this.mLK = null;
        this.mLx = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bb */
    public BUILDER be(Object obj) {
        this.mKE = obj;
        return dAQ();
    }

    @Nullable
    public Object dAH() {
        return this.mKE;
    }

    public BUILDER bc(REQUEST request) {
        this.mLF = request;
        return dAQ();
    }

    @Nullable
    public REQUEST dAI() {
        return this.mLF;
    }

    public BUILDER bd(REQUEST request) {
        this.mLG = request;
        return dAQ();
    }

    public BUILDER wx(boolean z) {
        this.mLi = z;
        return dAQ();
    }

    public boolean dAJ() {
        return this.mLw;
    }

    public BUILDER wy(boolean z) {
        this.mLJ = z;
        return dAQ();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.mLp = cVar;
        return dAQ();
    }

    @Nullable
    public d dAK() {
        return this.mLq;
    }

    @Nullable
    public String dAL() {
        return this.mLx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.mLK = aVar;
        return dAQ();
    }

    @Nullable
    public com.facebook.drawee.d.a dAM() {
        return this.mLK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dAN */
    public a dAR() {
        validate();
        if (this.mLF == null && this.mLH == null && this.mLG != null) {
            this.mLF = this.mLG;
            this.mLG = null;
        }
        return dAO();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.mLH == null || this.mLF == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mKp == null || (this.mLH == null && this.mLF == null && this.mLG == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dAO() {
        a dAm = dAm();
        dAm.ww(dAJ());
        dAm.QM(dAL());
        dAm.a(dAK());
        b(dAm);
        a(dAm);
        return dAm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dAP() {
        return String.valueOf(mLL.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.mKp != null) {
            return this.mKp;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.mLF != null) {
            jVar = a(aVar, str, this.mLF);
        } else if (this.mLH != null) {
            jVar = a(aVar, str, this.mLH, this.mLI);
        }
        if (jVar != null && this.mLG != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.mLG));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.C(mLE);
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
        return com.facebook.datasource.e.fo(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dAH = dAH();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dzP */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dAH, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aO(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.mKx != null) {
            for (c cVar : this.mKx) {
                aVar.a(cVar);
            }
        }
        if (this.mLp != null) {
            aVar.a(this.mLp);
        }
        if (this.mLJ) {
            aVar.a(mLD);
        }
    }

    protected void b(a aVar) {
        if (this.mLi) {
            aVar.dAA().wv(this.mLi);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dAB() == null) {
            aVar.a(com.facebook.drawee.c.a.fU(this.mContext));
        }
    }

    protected final BUILDER dAQ() {
        return this;
    }
}
