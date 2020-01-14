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
/* loaded from: classes12.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> lKB = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lKC = new NullPointerException("No image request was specified!");
    private static final AtomicLong lKJ = new AtomicLong();
    @Nullable
    private Object lJB;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lJm;
    private final Set<c> lJu;
    @Nullable
    private REQUEST lKD;
    @Nullable
    private REQUEST lKE;
    @Nullable
    private REQUEST[] lKF;
    private boolean lKG;
    private boolean lKH;
    @Nullable
    private com.facebook.drawee.d.a lKI;
    private boolean lKg;
    @Nullable
    private c<? super INFO> lKn;
    @Nullable
    private d lKo;
    private boolean lKu;
    private String lKv;
    private final Context mContext;

    /* loaded from: classes12.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dkv();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lJu = set;
        init();
    }

    private void init() {
        this.lJB = null;
        this.lKD = null;
        this.lKE = null;
        this.lKF = null;
        this.lKG = true;
        this.lKn = null;
        this.lKo = null;
        this.lKg = false;
        this.lKH = false;
        this.lKI = null;
        this.lKv = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bd */
    public BUILDER bg(Object obj) {
        this.lJB = obj;
        return dkZ();
    }

    @Nullable
    public Object dkQ() {
        return this.lJB;
    }

    public BUILDER be(REQUEST request) {
        this.lKD = request;
        return dkZ();
    }

    @Nullable
    public REQUEST dkR() {
        return this.lKD;
    }

    public BUILDER bf(REQUEST request) {
        this.lKE = request;
        return dkZ();
    }

    public BUILDER vc(boolean z) {
        this.lKg = z;
        return dkZ();
    }

    public boolean dkS() {
        return this.lKu;
    }

    public BUILDER vd(boolean z) {
        this.lKH = z;
        return dkZ();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lKn = cVar;
        return dkZ();
    }

    @Nullable
    public d dkT() {
        return this.lKo;
    }

    @Nullable
    public String dkU() {
        return this.lKv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lKI = aVar;
        return dkZ();
    }

    @Nullable
    public com.facebook.drawee.d.a dkV() {
        return this.lKI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dkW */
    public a dla() {
        validate();
        if (this.lKD == null && this.lKF == null && this.lKE != null) {
            this.lKD = this.lKE;
            this.lKE = null;
        }
        return dkX();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lKF == null || this.lKD == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lJm == null || (this.lKF == null && this.lKD == null && this.lKE == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dkX() {
        a dkv = dkv();
        dkv.vb(dkS());
        dkv.OM(dkU());
        dkv.a(dkT());
        b(dkv);
        a(dkv);
        return dkv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dkY() {
        return String.valueOf(lKJ.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lJm != null) {
            return this.lJm;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lKD != null) {
            jVar = a(aVar, str, this.lKD);
        } else if (this.lKF != null) {
            jVar = a(aVar, str, this.lKF, this.lKG);
        }
        if (jVar != null && this.lKE != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lKE));
            jVar = f.y(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.z(lKC);
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
        return com.facebook.datasource.e.eX(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dkQ = dkQ();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: djW */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dkQ, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aQ(this).x("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lJu != null) {
            for (c cVar : this.lJu) {
                aVar.a(cVar);
            }
        }
        if (this.lKn != null) {
            aVar.a(this.lKn);
        }
        if (this.lKH) {
            aVar.a(lKB);
        }
    }

    protected void b(a aVar) {
        if (this.lKg) {
            aVar.dkJ().va(this.lKg);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dkK() == null) {
            aVar.a(com.facebook.drawee.c.a.gl(this.mContext));
        }
    }

    protected final BUILDER dkZ() {
        return this;
    }
}
