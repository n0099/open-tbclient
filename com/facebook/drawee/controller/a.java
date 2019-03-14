package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.f;
import com.facebook.common.internal.g;
import com.facebook.drawee.c.a;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.a;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public abstract class a<T, INFO> implements a.InterfaceC0431a, a.InterfaceC0432a, com.facebook.drawee.d.a {
    private static final Class<?> jyG = a.class;
    private final com.facebook.drawee.components.a jBG;
    private final DraweeEventTracker jBS = DraweeEventTracker.cuR();
    private final Executor jBT;
    @Nullable
    private com.facebook.drawee.components.b jBU;
    @Nullable
    private com.facebook.drawee.c.a jBV;
    @Nullable
    private c<INFO> jBW;
    @Nullable
    private d jBX;
    @Nullable
    private com.facebook.drawee.d.c jBY;
    @Nullable
    private Drawable jBZ;
    private Object jCa;
    private boolean jCb;
    private boolean jCc;
    private boolean jCd;
    private boolean jCe;
    @Nullable
    private String jCf;
    @Nullable
    private com.facebook.datasource.b<T> jCg;
    @Nullable
    private T jCh;
    @Nullable
    private Throwable jCi;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aK(@Nullable T t);

    @Nullable
    protected abstract INFO aM(T t);

    protected abstract Drawable aN(T t);

    protected abstract com.facebook.datasource.b<T> cuG();

    protected abstract void g(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0433a<INFO> extends e<INFO> {
        private C0433a() {
        }

        public static <INFO> C0433a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0433a<INFO> c0433a = new C0433a<>();
            c0433a.c(cVar);
            c0433a.c(cVar2);
            return c0433a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.jBG = aVar;
        this.jBT = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.jBS.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.ctW()) {
            this.jCi = new Throwable();
        }
        if (!z && this.jBG != null) {
            this.jBG.b(this);
        }
        this.mIsAttached = false;
        this.jCc = false;
        cuU();
        this.jCe = false;
        if (this.jBU != null) {
            this.jBU.init();
        }
        if (this.jBV != null) {
            this.jBV.init();
            this.jBV.a(this);
        }
        if (this.jBW instanceof C0433a) {
            ((C0433a) this.jBW).cvp();
        } else {
            this.jBW = null;
        }
        this.jBX = null;
        if (this.jBY != null) {
            this.jBY.reset();
            this.jBY.h(null);
            this.jBY = null;
        }
        this.jBZ = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.jCa = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0432a
    public void release() {
        this.jBS.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.jBU != null) {
            this.jBU.reset();
        }
        if (this.jBV != null) {
            this.jBV.reset();
        }
        if (this.jBY != null) {
            this.jBY.reset();
        }
        cuU();
    }

    private void cuU() {
        boolean z = this.jCb;
        this.jCb = false;
        this.jCd = false;
        if (this.jCg != null) {
            this.jCg.zf();
            this.jCg = null;
        }
        if (this.mDrawable != null) {
            g(this.mDrawable);
        }
        if (this.jCf != null) {
            this.jCf = null;
        }
        this.mDrawable = null;
        if (this.jCh != null) {
            t("release", this.jCh);
            aK(this.jCh);
            this.jCh = null;
        }
        if (z) {
            cuX().FF(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cuV() {
        return this.jBU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.jBU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cuW() {
        return this.jBV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.jBV = aVar;
        if (this.jBV != null) {
            this.jBV.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rr(boolean z) {
        this.jCe = z;
    }

    public void FE(@Nullable String str) {
        this.jCf = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.jBW instanceof C0433a) {
            ((C0433a) this.jBW).c(cVar);
        } else if (this.jBW != null) {
            this.jBW = C0433a.a(this.jBW, cVar);
        } else {
            this.jBW = cVar;
        }
    }

    protected c<INFO> cuX() {
        return this.jBW == null ? b.cvo() : this.jBW;
    }

    public void a(@Nullable d dVar) {
        this.jBX = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.jBY;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.jBS.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.jCb) {
            this.jBG.b(this);
            release();
        }
        if (this.jBY != null) {
            this.jBY.h(null);
            this.jBY = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.jBY = (com.facebook.drawee.d.c) bVar;
            this.jBY.h(this.jBZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@Nullable Drawable drawable) {
        this.jBZ = drawable;
        if (this.jBY != null) {
            this.jBY.h(this.jBZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cuY() {
        return this.jBZ;
    }

    @Override // com.facebook.drawee.d.a
    public void cuZ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.jCb ? "request already submitted" : "request needs submit");
        }
        this.jBS.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.jBY);
        this.jBG.b(this);
        this.mIsAttached = true;
        if (!this.jCb) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.jBS.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.jBG.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.jBV == null) {
            return false;
        }
        if (this.jBV.cwf() || cva()) {
            this.jBV.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cva() {
        return cuS();
    }

    private boolean cuS() {
        return this.jCd && this.jBU != null && this.jBU.cuS();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0431a
    public boolean cvb() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cuS()) {
            this.jBU.cuT();
            this.jBY.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cuI = cuI();
        if (cuI != null) {
            this.jCg = null;
            this.jCb = true;
            this.jCd = false;
            this.jBS.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cuX().u(this.mId, this.jCa);
            a(this.mId, this.jCg, cuI, 1.0f, true, true);
            return;
        }
        this.jBS.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cuX().u(this.mId, this.jCa);
        this.jBY.d(0.0f, true);
        this.jCb = true;
        this.jCd = false;
        this.jCg = cuG();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.jCg)));
        }
        final String str = this.mId;
        final boolean cuo = this.jCg.cuo();
        this.jCg.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.jCi != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).t(a.this.jCi);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cuo);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cuq(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.jBT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            t("ignore_old_datasource @ onNewResult", t);
            aK(t);
            bVar.zf();
            return;
        }
        this.jBS.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aN = aN(t);
            T t2 = this.jCh;
            Drawable drawable = this.mDrawable;
            this.jCh = t;
            this.mDrawable = aN;
            try {
                if (z) {
                    t("set_final_result @ onNewResult", t);
                    this.jCg = null;
                    this.jBY.a(aN, 1.0f, z2);
                    cuX().a(str, aM(t), cvc());
                } else {
                    t("set_intermediate_result @ onNewResult", t);
                    this.jBY.a(aN, f, z2);
                    cuX().v(str, aM(t));
                }
                if (drawable != null && drawable != aN) {
                    g(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aK(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aN) {
                    g(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aK(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            t("drawable_failed @ onNewResult", t);
            aK(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onFailure", th);
            bVar.zf();
            return;
        }
        this.jBS.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.jCg = null;
            this.jCd = true;
            if (this.jCe && this.mDrawable != null) {
                this.jBY.a(this.mDrawable, 1.0f, true);
            } else if (cuS()) {
                this.jBY.A(th);
            } else {
                this.jBY.z(th);
            }
            cuX().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cuX().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.zf();
        } else if (!z) {
            this.jBY.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.jCg == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.jCg && this.jCb;
    }

    private void t(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jyG, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aO(t), Integer.valueOf(aL(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cvc() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aO(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aL(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aE(this).ay("isAttached", this.mIsAttached).ay("isRequestSubmitted", this.jCb).ay("hasFetchFailed", this.jCd).bz("fetchedImage", aL(this.jCh)).q("events", this.jBS.toString()).toString();
    }

    protected T cuI() {
        return null;
    }
}
