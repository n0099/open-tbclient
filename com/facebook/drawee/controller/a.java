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
public abstract class a<T, INFO> implements a.InterfaceC0335a, a.InterfaceC0336a, com.facebook.drawee.d.a {
    private static final Class<?> jyv = a.class;
    private final DraweeEventTracker jBH = DraweeEventTracker.cuE();
    private final Executor jBI;
    @Nullable
    private com.facebook.drawee.components.b jBJ;
    @Nullable
    private com.facebook.drawee.c.a jBK;
    @Nullable
    private c<INFO> jBL;
    @Nullable
    private d jBM;
    @Nullable
    private com.facebook.drawee.d.c jBN;
    @Nullable
    private Drawable jBO;
    private Object jBP;
    private boolean jBQ;
    private boolean jBR;
    private boolean jBS;
    private boolean jBT;
    @Nullable
    private String jBU;
    @Nullable
    private com.facebook.datasource.b<T> jBV;
    @Nullable
    private T jBW;
    @Nullable
    private Throwable jBX;
    private final com.facebook.drawee.components.a jBv;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aJ(@Nullable T t);

    @Nullable
    protected abstract INFO aL(T t);

    protected abstract Drawable aM(T t);

    protected abstract com.facebook.datasource.b<T> cut();

    protected abstract void g(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0337a<INFO> extends e<INFO> {
        private C0337a() {
        }

        public static <INFO> C0337a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0337a<INFO> c0337a = new C0337a<>();
            c0337a.c(cVar);
            c0337a.c(cVar2);
            return c0337a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.jBv = aVar;
        this.jBI = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.jBH.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.ctJ()) {
            this.jBX = new Throwable();
        }
        if (!z && this.jBv != null) {
            this.jBv.b(this);
        }
        this.mIsAttached = false;
        this.jBR = false;
        cuH();
        this.jBT = false;
        if (this.jBJ != null) {
            this.jBJ.init();
        }
        if (this.jBK != null) {
            this.jBK.init();
            this.jBK.a(this);
        }
        if (this.jBL instanceof C0337a) {
            ((C0337a) this.jBL).cvc();
        } else {
            this.jBL = null;
        }
        this.jBM = null;
        if (this.jBN != null) {
            this.jBN.reset();
            this.jBN.h(null);
            this.jBN = null;
        }
        this.jBO = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.jBP = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0336a
    public void release() {
        this.jBH.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.jBJ != null) {
            this.jBJ.reset();
        }
        if (this.jBK != null) {
            this.jBK.reset();
        }
        if (this.jBN != null) {
            this.jBN.reset();
        }
        cuH();
    }

    private void cuH() {
        boolean z = this.jBQ;
        this.jBQ = false;
        this.jBS = false;
        if (this.jBV != null) {
            this.jBV.zf();
            this.jBV = null;
        }
        if (this.mDrawable != null) {
            g(this.mDrawable);
        }
        if (this.jBU != null) {
            this.jBU = null;
        }
        this.mDrawable = null;
        if (this.jBW != null) {
            t("release", this.jBW);
            aJ(this.jBW);
            this.jBW = null;
        }
        if (z) {
            cuK().FE(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cuI() {
        return this.jBJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.jBJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cuJ() {
        return this.jBK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.jBK = aVar;
        if (this.jBK != null) {
            this.jBK.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rr(boolean z) {
        this.jBT = z;
    }

    public void FD(@Nullable String str) {
        this.jBU = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.jBL instanceof C0337a) {
            ((C0337a) this.jBL).c(cVar);
        } else if (this.jBL != null) {
            this.jBL = C0337a.a(this.jBL, cVar);
        } else {
            this.jBL = cVar;
        }
    }

    protected c<INFO> cuK() {
        return this.jBL == null ? b.cvb() : this.jBL;
    }

    public void a(@Nullable d dVar) {
        this.jBM = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.jBN;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.jBH.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.jBQ) {
            this.jBv.b(this);
            release();
        }
        if (this.jBN != null) {
            this.jBN.h(null);
            this.jBN = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.jBN = (com.facebook.drawee.d.c) bVar;
            this.jBN.h(this.jBO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@Nullable Drawable drawable) {
        this.jBO = drawable;
        if (this.jBN != null) {
            this.jBN.h(this.jBO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cuL() {
        return this.jBO;
    }

    @Override // com.facebook.drawee.d.a
    public void cuM() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.jBQ ? "request already submitted" : "request needs submit");
        }
        this.jBH.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.jBN);
        this.jBv.b(this);
        this.mIsAttached = true;
        if (!this.jBQ) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.jBH.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.jBv.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.jBK == null) {
            return false;
        }
        if (this.jBK.cvS() || cuN()) {
            this.jBK.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cuN() {
        return cuF();
    }

    private boolean cuF() {
        return this.jBS && this.jBJ != null && this.jBJ.cuF();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0335a
    public boolean cuO() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cuF()) {
            this.jBJ.cuG();
            this.jBN.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cuv = cuv();
        if (cuv != null) {
            this.jBV = null;
            this.jBQ = true;
            this.jBS = false;
            this.jBH.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cuK().u(this.mId, this.jBP);
            a(this.mId, this.jBV, cuv, 1.0f, true, true);
            return;
        }
        this.jBH.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cuK().u(this.mId, this.jBP);
        this.jBN.d(0.0f, true);
        this.jBQ = true;
        this.jBS = false;
        this.jBV = cut();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.jBV)));
        }
        final String str = this.mId;
        final boolean cub = this.jBV.cub();
        this.jBV.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.jBX != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).t(a.this.jBX);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cub);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cud(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.jBI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            t("ignore_old_datasource @ onNewResult", t);
            aJ(t);
            bVar.zf();
            return;
        }
        this.jBH.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aM = aM(t);
            T t2 = this.jBW;
            Drawable drawable = this.mDrawable;
            this.jBW = t;
            this.mDrawable = aM;
            try {
                if (z) {
                    t("set_final_result @ onNewResult", t);
                    this.jBV = null;
                    this.jBN.a(aM, 1.0f, z2);
                    cuK().a(str, aL(t), cuP());
                } else {
                    t("set_intermediate_result @ onNewResult", t);
                    this.jBN.a(aM, f, z2);
                    cuK().v(str, aL(t));
                }
                if (drawable != null && drawable != aM) {
                    g(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aJ(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aM) {
                    g(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aJ(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            t("drawable_failed @ onNewResult", t);
            aJ(t);
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
        this.jBH.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.jBV = null;
            this.jBS = true;
            if (this.jBT && this.mDrawable != null) {
                this.jBN.a(this.mDrawable, 1.0f, true);
            } else if (cuF()) {
                this.jBN.A(th);
            } else {
                this.jBN.z(th);
            }
            cuK().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cuK().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.zf();
        } else if (!z) {
            this.jBN.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.jBV == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.jBV && this.jBQ;
    }

    private void t(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jyv, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aN(t), Integer.valueOf(aK(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyv, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cuP() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aN(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aK(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aD(this).ax("isAttached", this.mIsAttached).ax("isRequestSubmitted", this.jBQ).ax("hasFetchFailed", this.jBS).bz("fetchedImage", aK(this.jBW)).q("events", this.jBH.toString()).toString();
    }

    protected T cuv() {
        return null;
    }
}
