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
    private static final c<Object> mLA = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException mLB = new NullPointerException("No image request was specified!");
    private static final AtomicLong mLI = new AtomicLong();
    private final Context mContext;
    @Nullable
    private Object mKB;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> mKm;
    private final Set<c> mKu;
    @Nullable
    private REQUEST mLC;
    @Nullable
    private REQUEST mLD;
    @Nullable
    private REQUEST[] mLE;
    private boolean mLF;
    private boolean mLG;
    @Nullable
    private com.facebook.drawee.d.a mLH;
    private boolean mLf;
    @Nullable
    private c<? super INFO> mLm;
    @Nullable
    private d mLn;
    private boolean mLt;
    private String mLu;

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dAi();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.mKu = set;
        init();
    }

    private void init() {
        this.mKB = null;
        this.mLC = null;
        this.mLD = null;
        this.mLE = null;
        this.mLF = true;
        this.mLm = null;
        this.mLn = null;
        this.mLf = false;
        this.mLG = false;
        this.mLH = null;
        this.mLu = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bb */
    public BUILDER be(Object obj) {
        this.mKB = obj;
        return dAM();
    }

    @Nullable
    public Object dAD() {
        return this.mKB;
    }

    public BUILDER bc(REQUEST request) {
        this.mLC = request;
        return dAM();
    }

    @Nullable
    public REQUEST dAE() {
        return this.mLC;
    }

    public BUILDER bd(REQUEST request) {
        this.mLD = request;
        return dAM();
    }

    public BUILDER wx(boolean z) {
        this.mLf = z;
        return dAM();
    }

    public boolean dAF() {
        return this.mLt;
    }

    public BUILDER wy(boolean z) {
        this.mLG = z;
        return dAM();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.mLm = cVar;
        return dAM();
    }

    @Nullable
    public d dAG() {
        return this.mLn;
    }

    @Nullable
    public String dAH() {
        return this.mLu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.mLH = aVar;
        return dAM();
    }

    @Nullable
    public com.facebook.drawee.d.a dAI() {
        return this.mLH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dAJ */
    public a dAN() {
        validate();
        if (this.mLC == null && this.mLE == null && this.mLD != null) {
            this.mLC = this.mLD;
            this.mLD = null;
        }
        return dAK();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.mLE == null || this.mLC == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mKm == null || (this.mLE == null && this.mLC == null && this.mLD == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dAK() {
        a dAi = dAi();
        dAi.ww(dAF());
        dAi.QL(dAH());
        dAi.a(dAG());
        b(dAi);
        a(dAi);
        return dAi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dAL() {
        return String.valueOf(mLI.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.mKm != null) {
            return this.mKm;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.mLC != null) {
            jVar = a(aVar, str, this.mLC);
        } else if (this.mLE != null) {
            jVar = a(aVar, str, this.mLE, this.mLF);
        }
        if (jVar != null && this.mLD != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.mLD));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.C(mLB);
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
        final Object dAD = dAD();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dzL */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dAD, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aO(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.mKu != null) {
            for (c cVar : this.mKu) {
                aVar.a(cVar);
            }
        }
        if (this.mLm != null) {
            aVar.a(this.mLm);
        }
        if (this.mLG) {
            aVar.a(mLA);
        }
    }

    protected void b(a aVar) {
        if (this.mLf) {
            aVar.dAw().wv(this.mLf);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dAx() == null) {
            aVar.a(com.facebook.drawee.c.a.fU(this.mContext));
        }
    }

    protected final BUILDER dAM() {
        return this;
    }
}
