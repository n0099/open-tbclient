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
    private static final c<Object> mTL = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException mTM = new NullPointerException("No image request was specified!");
    private static final AtomicLong mTT = new AtomicLong();
    private final Context mContext;
    private final Set<c> mSB;
    @Nullable
    private Object mSJ;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> mSt;
    private boolean mTE;
    private String mTF;
    @Nullable
    private REQUEST mTN;
    @Nullable
    private REQUEST mTO;
    @Nullable
    private REQUEST[] mTP;
    private boolean mTQ;
    private boolean mTR;
    @Nullable
    private com.facebook.drawee.d.a mTS;
    private boolean mTq;
    @Nullable
    private c<? super INFO> mTx;
    @Nullable
    private d mTy;

    /* loaded from: classes9.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dDy();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.mSB = set;
        init();
    }

    private void init() {
        this.mSJ = null;
        this.mTN = null;
        this.mTO = null;
        this.mTP = null;
        this.mTQ = true;
        this.mTx = null;
        this.mTy = null;
        this.mTq = false;
        this.mTR = false;
        this.mTS = null;
        this.mTF = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bb */
    public BUILDER be(Object obj) {
        this.mSJ = obj;
        return dEc();
    }

    @Nullable
    public Object dDT() {
        return this.mSJ;
    }

    public BUILDER bc(REQUEST request) {
        this.mTN = request;
        return dEc();
    }

    @Nullable
    public REQUEST dDU() {
        return this.mTN;
    }

    public BUILDER bd(REQUEST request) {
        this.mTO = request;
        return dEc();
    }

    public BUILDER xc(boolean z) {
        this.mTq = z;
        return dEc();
    }

    public boolean dDV() {
        return this.mTE;
    }

    public BUILDER xd(boolean z) {
        this.mTR = z;
        return dEc();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.mTx = cVar;
        return dEc();
    }

    @Nullable
    public d dDW() {
        return this.mTy;
    }

    @Nullable
    public String dDX() {
        return this.mTF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.mTS = aVar;
        return dEc();
    }

    @Nullable
    public com.facebook.drawee.d.a dDY() {
        return this.mTS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dDZ */
    public a dEd() {
        validate();
        if (this.mTN == null && this.mTP == null && this.mTO != null) {
            this.mTN = this.mTO;
            this.mTO = null;
        }
        return dEa();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.mTP == null || this.mTN == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mSt == null || (this.mTP == null && this.mTN == null && this.mTO == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dEa() {
        a dDy = dDy();
        dDy.xb(dDV());
        dDy.Rx(dDX());
        dDy.a(dDW());
        b(dDy);
        a(dDy);
        return dDy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dEb() {
        return String.valueOf(mTT.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.mSt != null) {
            return this.mSt;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.mTN != null) {
            jVar = a(aVar, str, this.mTN);
        } else if (this.mTP != null) {
            jVar = a(aVar, str, this.mTP, this.mTQ);
        }
        if (jVar != null && this.mTO != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.mTO));
            jVar = f.v(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.B(mTM);
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
        final Object dDT = dDT();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dDb */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dDT, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aO(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.mSB != null) {
            for (c cVar : this.mSB) {
                aVar.a(cVar);
            }
        }
        if (this.mTx != null) {
            aVar.a(this.mTx);
        }
        if (this.mTR) {
            aVar.a(mTL);
        }
    }

    protected void b(a aVar) {
        if (this.mTq) {
            aVar.dDM().xa(this.mTq);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dDN() == null) {
            aVar.a(com.facebook.drawee.c.a.fX(this.mContext));
        }
    }

    protected final BUILDER dEc() {
        return this;
    }
}
