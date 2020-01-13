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
    @Nullable
    private j<com.facebook.datasource.b<IMAGE>> lJh;
    private final Set<c> lJp;
    @Nullable
    private Object lJw;
    @Nullable
    private REQUEST[] lKA;
    private boolean lKB;
    private boolean lKC;
    @Nullable
    private com.facebook.drawee.d.a lKD;
    private boolean lKb;
    @Nullable
    private c<? super INFO> lKi;
    @Nullable
    private d lKj;
    private boolean lKp;
    private String lKq;
    @Nullable
    private REQUEST lKy;
    @Nullable
    private REQUEST lKz;
    private final Context mContext;
    private static final c<Object> lKw = new b<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException lKx = new NullPointerException("No image request was specified!");
    private static final AtomicLong lKE = new AtomicLong();

    /* loaded from: classes12.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.b<IMAGE> a(com.facebook.drawee.d.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @ReturnsOwnership
    protected abstract a dkt();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set) {
        this.mContext = context;
        this.lJp = set;
        init();
    }

    private void init() {
        this.lJw = null;
        this.lKy = null;
        this.lKz = null;
        this.lKA = null;
        this.lKB = true;
        this.lKi = null;
        this.lKj = null;
        this.lKb = false;
        this.lKC = false;
        this.lKD = null;
        this.lKq = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: bd */
    public BUILDER bg(Object obj) {
        this.lJw = obj;
        return dkX();
    }

    @Nullable
    public Object dkO() {
        return this.lJw;
    }

    public BUILDER be(REQUEST request) {
        this.lKy = request;
        return dkX();
    }

    @Nullable
    public REQUEST dkP() {
        return this.lKy;
    }

    public BUILDER bf(REQUEST request) {
        this.lKz = request;
        return dkX();
    }

    public BUILDER vc(boolean z) {
        this.lKb = z;
        return dkX();
    }

    public boolean dkQ() {
        return this.lKp;
    }

    public BUILDER vd(boolean z) {
        this.lKC = z;
        return dkX();
    }

    public BUILDER c(c<? super INFO> cVar) {
        this.lKi = cVar;
        return dkX();
    }

    @Nullable
    public d dkR() {
        return this.lKj;
    }

    @Nullable
    public String dkS() {
        return this.lKq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public BUILDER c(@Nullable com.facebook.drawee.d.a aVar) {
        this.lKD = aVar;
        return dkX();
    }

    @Nullable
    public com.facebook.drawee.d.a dkT() {
        return this.lKD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: dkU */
    public a dkY() {
        validate();
        if (this.lKy == null && this.lKA == null && this.lKz != null) {
            this.lKy = this.lKz;
            this.lKz = null;
        }
        return dkV();
    }

    protected void validate() {
        boolean z = false;
        g.d(this.lKA == null || this.lKy == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.lJh == null || (this.lKA == null && this.lKy == null && this.lKz == null)) {
            z = true;
        }
        g.d(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected a dkV() {
        a dkt = dkt();
        dkt.vb(dkQ());
        dkt.OM(dkS());
        dkt.a(dkR());
        b(dkt);
        a(dkt);
        return dkt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String dkW() {
        return String.valueOf(lKE.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j<com.facebook.datasource.b<IMAGE>> a(com.facebook.drawee.d.a aVar, String str) {
        if (this.lJh != null) {
            return this.lJh;
        }
        j<com.facebook.datasource.b<IMAGE>> jVar = null;
        if (this.lKy != null) {
            jVar = a(aVar, str, this.lKy);
        } else if (this.lKA != null) {
            jVar = a(aVar, str, this.lKA, this.lKB);
        }
        if (jVar != null && this.lKz != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(jVar);
            arrayList.add(a(aVar, str, this.lKz));
            jVar = f.y(arrayList, false);
        }
        if (jVar == null) {
            return com.facebook.datasource.c.z(lKx);
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
        final Object dkO = dkO();
        return new j<com.facebook.datasource.b<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.j
            /* renamed from: djU */
            public com.facebook.datasource.b<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.a(aVar, str, request, dkO, cacheLevel);
            }

            public String toString() {
                return com.facebook.common.internal.f.aQ(this).x("request", request.toString()).toString();
            }
        };
    }

    protected void a(a aVar) {
        if (this.lJp != null) {
            for (c cVar : this.lJp) {
                aVar.a(cVar);
            }
        }
        if (this.lKi != null) {
            aVar.a(this.lKi);
        }
        if (this.lKC) {
            aVar.a(lKw);
        }
    }

    protected void b(a aVar) {
        if (this.lKb) {
            aVar.dkH().va(this.lKb);
            c(aVar);
        }
    }

    protected void c(a aVar) {
        if (aVar.dkI() == null) {
            aVar.a(com.facebook.drawee.c.a.gl(this.mContext));
        }
    }

    protected final BUILDER dkX() {
        return this;
    }
}
