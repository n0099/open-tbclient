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
    private static final c<Object> mor = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException mos = new NullPointerException("No image request was specified!");
    private static final AtomicLong moz = new AtomicLong();
    private final Context mContext;
    private boolean mnV;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> mnc;
    private final Set<c> mnk;
    @Nullable
    private Object mnr;
    @Nullable
    private c<? super INFO> moc;
    @Nullable
    private d mod;
    private boolean moj;
    private String mok;
    @Nullable
    private REQUEST mot;
    @Nullable
    private REQUEST mou;
    @Nullable
    private REQUEST[] mov;
    private boolean mow;
    private boolean mox;
    @Nullable
    private com.facebook.drawee.d.a moy;

    /* loaded from: classes13.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dvr();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.mnk = set;
        init();
    }

    private void init() {
        this.mnr = null;
        this.mot = null;
        this.mou = null;
        this.mov = null;
        this.mow = true;
        this.moc = null;
        this.mod = null;
        this.mnV = false;
        this.mox = false;
        this.moy = null;
        this.mok = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: ba */
    public BUILDER bd(Object obj) {
        this.mnr = obj;
        return dvV();
    }

    @Nullable
    public Object dvM() {
        return this.mnr;
    }

    public BUILDER bb(REQUEST request) {
        this.mot = request;
        return dvV();
    }

    @Nullable
    public REQUEST dvN() {
        return this.mot;
    }

    public BUILDER bc(REQUEST request) {
        this.mou = request;
        return dvV();
    }

    public BUILDER vZ(boolean z) {
        this.mnV = z;
        return dvV();
    }

    public boolean dvO() {
        return this.moj;
    }

    public BUILDER wa(boolean z) {
        this.mox = z;
        return dvV();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.moc = cVar;
        return dvV();
    }

    @Nullable
    public d dvP() {
        return this.mod;
    }

    @Nullable
    public String dvQ() {
        return this.mok;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.moy = aVar;
        return dvV();
    }

    @Nullable
    public com.facebook.drawee.d.a dvR() {
        return this.moy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dvS */
    public a dvW() {
        validate();
        if (this.mot == null && this.mov == null && this.mou != null) {
            this.mot = this.mou;
            this.mou = null;
        }
        return dvT();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.mov == null || this.mot == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mnc == null || (this.mov == null && this.mot == null && this.mou == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dvT() {
        a dvr = dvr();
        dvr.vY(dvO());
        dvr.PY(dvQ());
        dvr.a(dvP());
        b(dvr);
        a(dvr);
        return dvr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dvU() {
        return String.valueOf(moz.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.mnc != null) {
            return this.mnc;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.mot != null) {
            jVar = a(aVar, str, this.mot);
        } else if (this.mov != null) {
            jVar = a(aVar, str, this.mov, this.mow);
        }
        if (jVar != null && this.mou != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.mou));
            jVar = f.x(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.C(mos);
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
        return com.facebook.datasource.e.fa(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object dvM = dvM();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: duU */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dvM, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aN(this).F("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.mnk != null) {
            for (c cVar : this.mnk) {
                aVar.a(cVar);
            }
        }
        if (this.moc != null) {
            aVar.a(this.moc);
        }
        if (this.mox) {
            aVar.a(mor);
        }
    }

    protected void b(a aVar) {
        if (this.mnV) {
            aVar.dvF().vX(this.mnV);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dvG() == null) {
            aVar.a(com.facebook.drawee.c.a.fT(this.mContext));
        }
    }

    protected final BUILDER dvV() {
        return this;
    }
}
