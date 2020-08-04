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
/* loaded from: classes9.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> mTN = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException mTO = new NullPointerException("No image request was specified!");
    private static final AtomicLong mTV = new AtomicLong();
    private final Context mContext;
    private final Set<c> mSE;
    @Nullable
    private Object mSL;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> mSv;
    @Nullable
    private d mTA;
    private boolean mTG;
    private String mTH;
    @Nullable
    private REQUEST mTP;
    @Nullable
    private REQUEST mTQ;
    @Nullable
    private REQUEST[] mTR;
    private boolean mTS;
    private boolean mTT;
    @Nullable
    private com.facebook.drawee.d.a mTU;
    private boolean mTs;
    @Nullable
    private c<? super INFO> mTz;

    /* loaded from: classes9.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dDz();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.mSE = set;
        init();
    }

    private void init() {
        this.mSL = null;
        this.mTP = null;
        this.mTQ = null;
        this.mTR = null;
        this.mTS = true;
        this.mTz = null;
        this.mTA = null;
        this.mTs = false;
        this.mTT = false;
        this.mTU = null;
        this.mTH = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bb */
    public BUILDER be(Object obj) {
        this.mSL = obj;
        return dEd();
    }

    @Nullable
    public Object dDU() {
        return this.mSL;
    }

    public BUILDER bc(REQUEST request) {
        this.mTP = request;
        return dEd();
    }

    @Nullable
    public REQUEST dDV() {
        return this.mTP;
    }

    public BUILDER bd(REQUEST request) {
        this.mTQ = request;
        return dEd();
    }

    public BUILDER xc(boolean z) {
        this.mTs = z;
        return dEd();
    }

    public boolean dDW() {
        return this.mTG;
    }

    public BUILDER xd(boolean z) {
        this.mTT = z;
        return dEd();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.mTz = cVar;
        return dEd();
    }

    @Nullable
    public d dDX() {
        return this.mTA;
    }

    @Nullable
    public String dDY() {
        return this.mTH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.mTU = aVar;
        return dEd();
    }

    @Nullable
    public com.facebook.drawee.d.a dDZ() {
        return this.mTU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dEa */
    public a dEe() {
        validate();
        if (this.mTP == null && this.mTR == null && this.mTQ != null) {
            this.mTP = this.mTQ;
            this.mTQ = null;
        }
        return dEb();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.mTR == null || this.mTP == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mSv == null || (this.mTR == null && this.mTP == null && this.mTQ == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dEb() {
        a dDz = dDz();
        dDz.xb(dDW());
        dDz.Rx(dDY());
        dDz.a(dDX());
        b(dDz);
        a(dDz);
        return dDz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dEc() {
        return String.valueOf(mTV.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.mSv != null) {
            return this.mSv;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.mTP != null) {
            jVar = a(aVar, str, this.mTP);
        } else if (this.mTR != null) {
            jVar = a(aVar, str, this.mTR, this.mTS);
        }
        if (jVar != null && this.mTQ != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.mTQ));
            jVar = f.v(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.B(mTO);
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
        return com.facebook.datasource.e.fx(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dDU = dDU();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dDc */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dDU, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aO(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.mSE != null) {
            for (c cVar : this.mSE) {
                aVar.a(cVar);
            }
        }
        if (this.mTz != null) {
            aVar.a(this.mTz);
        }
        if (this.mTT) {
            aVar.a(mTN);
        }
    }

    protected void b(a aVar) {
        if (this.mTs) {
            aVar.dDN().xa(this.mTs);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dDO() == null) {
            aVar.a(com.facebook.drawee.c.a.fX(this.mContext));
        }
    }

    protected final BUILDER dEd() {
        return this;
    }
}
