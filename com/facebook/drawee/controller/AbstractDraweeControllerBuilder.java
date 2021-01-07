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
/* loaded from: classes4.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.d.d {
    private static final c<Object> pvZ = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException pwa = new NullPointerException("No image request was specified!");
    private static final AtomicLong pwh = new AtomicLong();
    private final Context mContext;
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> puL;
    private final Set<c> puT;
    private boolean pvE;
    @Nullable
    private c<? super INFO> pvL;
    @Nullable
    private d pvM;
    private boolean pvS;
    private String pvT;
    @Nullable
    private Object pva;
    @Nullable
    private REQUEST pwb;
    @Nullable
    private REQUEST pwc;
    @Nullable
    private REQUEST[] pwd;
    private boolean pwe;
    private boolean pwf;
    @Nullable
    private com.facebook.drawee.d.a pwg;

    /* loaded from: classes4.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a evb();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.puT = set;
        init();
    }

    private void init() {
        this.pva = null;
        this.pwb = null;
        this.pwc = null;
        this.pwd = null;
        this.pwe = true;
        this.pvL = null;
        this.pvM = null;
        this.pvE = false;
        this.pwf = false;
        this.pwg = null;
        this.pvT = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bn */
    public BUILDER bp(Object obj) {
        this.pva = obj;
        return evF();
    }

    @Nullable
    public Object evw() {
        return this.pva;
    }

    public BUILDER bo(REQUEST request) {
        this.pwb = request;
        return evF();
    }

    @Nullable
    public REQUEST evx() {
        return this.pwb;
    }

    public boolean evy() {
        return this.pvS;
    }

    public BUILDER AX(boolean z) {
        this.pwf = z;
        return evF();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.pvL = cVar;
        return evF();
    }

    @Nullable
    public d evz() {
        return this.pvM;
    }

    @Nullable
    public String evA() {
        return this.pvT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.pwg = aVar;
        return evF();
    }

    @Nullable
    public com.facebook.drawee.d.a evB() {
        return this.pwg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: evC */
    public a evG() {
        validate();
        if (this.pwb == null && this.pwd == null && this.pwc != null) {
            this.pwb = this.pwc;
            this.pwc = null;
        }
        return evD();
    }

    protected void validate() {
        boolean z = false;
        g.checkState(this.pwd == null || this.pwb == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.puL == null || (this.pwd == null && this.pwb == null && this.pwc == null)) {
            z = true;
        }
        g.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a evD() {
        a evb = evb();
        evb.AW(evy());
        evb.Zy(evA());
        evb.a(evz());
        b(evb);
        a(evb);
        return evb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String evE() {
        return String.valueOf(pwh.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.puL != null) {
            return this.puL;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.pwb != null) {
            jVar = a(aVar, str, this.pwb);
        } else if (this.pwd != null) {
            jVar = a(aVar, str, this.pwd, this.pwe);
        }
        if (jVar != null && this.pwc != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.pwc));
            jVar = f.B(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.z(pwa);
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
        return com.facebook.datasource.e.gK(arrayList);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str, REQUEST request) {
        return a(aVar, str, (String) request, CacheLevel.FULL_FETCH);
    }

    protected j<com.facebook.datasource.b<IMAGE>> a(final com.facebook.drawee.d.a aVar, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object evw = evw();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: euE */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, evw, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.bb(this).I("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.puT != null) {
            for (c cVar : this.puT) {
                aVar.a(cVar);
            }
        }
        if (this.pvL != null) {
            aVar.a(this.pvL);
        }
        if (this.pwf) {
            aVar.a(pvZ);
        }
    }

    protected void b(a aVar) {
        if (this.pvE) {
            aVar.evp().AV(this.pvE);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.evq() == null) {
            aVar.a(com.facebook.drawee.c.a.ih(this.mContext));
        }
    }

    protected final BUILDER evF() {
        return this;
    }
}
