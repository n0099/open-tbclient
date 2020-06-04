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
    private static final c<Object> mpB = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException mpC = new NullPointerException("No image request was specified!");
    private static final AtomicLong mpJ = new AtomicLong();
    private final Context mContext;
    @Nullable
    private Object moC;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> mom;
    private final Set<c> mov;
    @Nullable
    private REQUEST mpD;
    @Nullable
    private REQUEST mpE;
    @Nullable
    private REQUEST[] mpF;
    private boolean mpG;
    private boolean mpH;
    @Nullable
    private com.facebook.drawee.d.a mpI;
    private boolean mpg;
    @Nullable
    private c<? super INFO> mpn;
    @Nullable
    private d mpo;
    private boolean mpu;
    private String mpv;

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dvF();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.mov = set;
        init();
    }

    private void init() {
        this.moC = null;
        this.mpD = null;
        this.mpE = null;
        this.mpF = null;
        this.mpG = true;
        this.mpn = null;
        this.mpo = null;
        this.mpg = false;
        this.mpH = false;
        this.mpI = null;
        this.mpv = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: ba */
    public BUILDER bd(Object obj) {
        this.moC = obj;
        return dwj();
    }

    @Nullable
    public Object dwa() {
        return this.moC;
    }

    public BUILDER bb(REQUEST request) {
        this.mpD = request;
        return dwj();
    }

    @Nullable
    public REQUEST dwb() {
        return this.mpD;
    }

    public BUILDER bc(REQUEST request) {
        this.mpE = request;
        return dwj();
    }

    public BUILDER wb(boolean z) {
        this.mpg = z;
        return dwj();
    }

    public boolean dwc() {
        return this.mpu;
    }

    public BUILDER wc(boolean z) {
        this.mpH = z;
        return dwj();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.mpn = cVar;
        return dwj();
    }

    @Nullable
    public d dwd() {
        return this.mpo;
    }

    @Nullable
    public String dwe() {
        return this.mpv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.mpI = aVar;
        return dwj();
    }

    @Nullable
    public com.facebook.drawee.d.a dwf() {
        return this.mpI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dwg */
    public a dwk() {
        validate();
        if (this.mpD == null && this.mpF == null && this.mpE != null) {
            this.mpD = this.mpE;
            this.mpE = null;
        }
        return dwh();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.mpF == null || this.mpD == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mom == null || (this.mpF == null && this.mpD == null && this.mpE == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dwh() {
        a dvF = dvF();
        dvF.wa(dwc());
        dvF.PZ(dwe());
        dvF.a(dwd());
        b(dvF);
        a(dvF);
        return dvF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dwi() {
        return String.valueOf(mpJ.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.mom != null) {
            return this.mom;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.mpD != null) {
            jVar = a(aVar, str, this.mpD);
        } else if (this.mpF != null) {
            jVar = a(aVar, str, this.mpF, this.mpG);
        }
        if (jVar != null && this.mpE != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.mpE));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.C(mpC);
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
        return com.facebook.datasource.e.fc(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dwa = dwa();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: dvi */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dwa, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aN(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.mov != null) {
            for (c cVar : this.mov) {
                aVar.a(cVar);
            }
        }
        if (this.mpn != null) {
            aVar.a(this.mpn);
        }
        if (this.mpH) {
            aVar.a(mpB);
        }
    }

    protected void b(a aVar) {
        if (this.mpg) {
            aVar.dvT().vZ(this.mpg);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dvU() == null) {
            aVar.a(com.facebook.drawee.c.a.fT(this.mContext));
        }
    }

    protected final BUILDER dwj() {
        return this;
    }
}
