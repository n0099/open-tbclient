package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.f;
import com.facebook.common.internal.g;
import com.facebook.drawee.c.a;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.a;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes4.dex */
public abstract class a<T, INFO> implements a.InterfaceC1058a, a.InterfaceC1059a, com.facebook.drawee.d.a {
    private static final Class<?> prR = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a puU;
    private final Executor pvI;
    @Nullable
    private com.facebook.drawee.components.b pvJ;
    @Nullable
    private com.facebook.drawee.c.a pvK;
    @Nullable
    private c<INFO> pvL;
    @Nullable
    private d pvM;
    @Nullable
    private com.facebook.drawee.d.c pvN;
    @Nullable
    private Drawable pvO;
    private boolean pvP;
    private boolean pvQ;
    private boolean pvR;
    private boolean pvS;
    @Nullable
    private String pvT;
    @Nullable
    private com.facebook.datasource.b<T> pvU;
    @Nullable
    private T pvV;
    private Object pva;
    private final DraweeEventTracker pvH = DraweeEventTracker.evl();
    private boolean pvW = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> euW();

    protected abstract void t(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1060a<INFO> extends e<INFO> {
        private C1060a() {
        }

        public static <INFO> C1060a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C1060a<INFO> c1060a = new C1060a<>();
            c1060a.d(cVar);
            c1060a.d(cVar2);
            return c1060a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.puU = aVar;
        this.pvI = executor;
        M(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str, Object obj) {
        M(str, obj);
        this.pvW = false;
    }

    private synchronized void M(String str, Object obj) {
        this.pvH.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.pvW && this.puU != null) {
            this.puU.b(this);
        }
        this.mIsAttached = false;
        this.pvQ = false;
        evo();
        this.pvS = false;
        if (this.pvJ != null) {
            this.pvJ.init();
        }
        if (this.pvK != null) {
            this.pvK.init();
            this.pvK.a(this);
        }
        if (this.pvL instanceof C1060a) {
            ((C1060a) this.pvL).evI();
        } else {
            this.pvL = null;
        }
        this.pvM = null;
        if (this.pvN != null) {
            this.pvN.reset();
            this.pvN.u(null);
            this.pvN = null;
        }
        this.pvO = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pva = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC1059a
    public void release() {
        this.pvH.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.pvJ != null) {
            this.pvJ.reset();
        }
        if (this.pvK != null) {
            this.pvK.reset();
        }
        if (this.pvN != null) {
            this.pvN.reset();
        }
        evo();
    }

    private void evo() {
        boolean z = this.pvP;
        this.pvP = false;
        this.pvR = false;
        if (this.pvU != null) {
            this.pvU.ati();
            this.pvU = null;
        }
        if (this.mDrawable != null) {
            t(this.mDrawable);
        }
        if (this.pvT != null) {
            this.pvT = null;
        }
        this.mDrawable = null;
        if (this.pvV != null) {
            N("release", this.pvV);
            bh(this.pvV);
            this.pvV = null;
        }
        if (z) {
            evr().hm(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b evp() {
        if (this.pvJ == null) {
            this.pvJ = new com.facebook.drawee.components.b();
        }
        return this.pvJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a evq() {
        return this.pvK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pvK = aVar;
        if (this.pvK != null) {
            this.pvK.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AW(boolean z) {
        this.pvS = z;
    }

    public void Zy(@Nullable String str) {
        this.pvT = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pvL instanceof C1060a) {
            ((C1060a) this.pvL).d(cVar);
        } else if (this.pvL != null) {
            this.pvL = C1060a.a(this.pvL, cVar);
        } else {
            this.pvL = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pvL instanceof C1060a) {
            ((C1060a) this.pvL).e(cVar);
        } else if (this.pvL == cVar) {
            this.pvL = null;
        }
    }

    protected c<INFO> evr() {
        return this.pvL == null ? b.evH() : this.pvL;
    }

    public void a(@Nullable d dVar) {
        this.pvM = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.pvN;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.pvH.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.pvP) {
            this.puU.b(this);
            release();
        }
        if (this.pvN != null) {
            this.pvN.u(null);
            this.pvN = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.pvN = (com.facebook.drawee.d.c) bVar;
            this.pvN.u(this.pvO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@Nullable Drawable drawable) {
        this.pvO = drawable;
        if (this.pvN != null) {
            this.pvN.u(this.pvO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable evs() {
        return this.pvO;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.pvP ? "request already submitted" : "request needs submit");
        }
        this.pvH.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.pvN);
        this.puU.b(this);
        this.mIsAttached = true;
        if (!this.pvP) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.pvH.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.puU.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pvK == null) {
            return false;
        }
        if (this.pvK.ewx() || evt()) {
            this.pvK.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean evt() {
        return evm();
    }

    private boolean evm() {
        return this.pvR && this.pvJ != null && this.pvJ.evm();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC1058a
    public boolean evu() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (evm()) {
            this.pvJ.evn();
            this.pvN.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T euY = euY();
        if (euY != null) {
            this.pvU = null;
            this.pvP = true;
            this.pvR = false;
            this.pvH.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            evr().f(this.mId, this.pva);
            K(this.mId, euY);
            a(this.mId, this.pvU, euY, 1.0f, true, true);
            return;
        }
        this.pvH.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        evr().f(this.mId, this.pva);
        this.pvN.d(0.0f, true);
        this.pvP = true;
        this.pvR = false;
        this.pvU = euW();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.pvU)));
        }
        final String str = this.mId;
        final boolean euy = this.pvU.euy();
        this.pvU.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, euy);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.euA(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.pvI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            N("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.ati();
            return;
        }
        this.pvH.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.pvV;
            Drawable drawable = this.mDrawable;
            this.pvV = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    N("set_final_result @ onNewResult", t);
                    this.pvU = null;
                    this.pvN.a(bk, 1.0f, z2);
                    evr().a(str, bj(t), evv());
                } else {
                    N("set_intermediate_result @ onNewResult", t);
                    this.pvN.a(bk, f, z2);
                    evr().g(str, (String) bj(t));
                }
                if (drawable != null && drawable != bk) {
                    t(drawable);
                }
                if (t2 != null && t2 != t) {
                    N("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bk) {
                    t(drawable);
                }
                if (t2 != null && t2 != t) {
                    N("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            N("drawable_failed @ onNewResult", t);
            bh(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.ati();
            return;
        }
        this.pvH.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.pvU = null;
            this.pvR = true;
            if (this.pvS && this.mDrawable != null) {
                this.pvN.a(this.mDrawable, 1.0f, true);
            } else if (evm()) {
                this.pvN.B(th);
            } else {
                this.pvN.A(th);
            }
            evr().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        evr().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.ati();
        } else if (!z) {
            this.pvN.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.pvU == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.pvU && this.pvP;
    }

    private void N(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(prR, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prR, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable evv() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String bm(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int bi(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.bb(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.pvP).bo("hasFetchFailed", this.pvR).cj("fetchedImage", bi(this.pvV)).I("events", this.pvH.toString()).toString();
    }

    protected T euY() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(String str, T t) {
    }
}
