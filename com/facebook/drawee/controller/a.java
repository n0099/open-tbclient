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
public abstract class a<T, INFO> implements a.InterfaceC0338a, a.InterfaceC0339a, com.facebook.drawee.d.a {
    private static final Class<?> jyO = a.class;
    private final com.facebook.drawee.components.a jBO;
    private final DraweeEventTracker jCa = DraweeEventTracker.cuO();
    private final Executor jCb;
    @Nullable
    private com.facebook.drawee.components.b jCc;
    @Nullable
    private com.facebook.drawee.c.a jCd;
    @Nullable
    private c<INFO> jCe;
    @Nullable
    private d jCf;
    @Nullable
    private com.facebook.drawee.d.c jCg;
    @Nullable
    private Drawable jCh;
    private Object jCi;
    private boolean jCj;
    private boolean jCk;
    private boolean jCl;
    private boolean jCm;
    @Nullable
    private String jCn;
    @Nullable
    private com.facebook.datasource.b<T> jCo;
    @Nullable
    private T jCp;
    @Nullable
    private Throwable jCq;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aK(@Nullable T t);

    @Nullable
    protected abstract INFO aM(T t);

    protected abstract Drawable aN(T t);

    protected abstract com.facebook.datasource.b<T> cuD();

    protected abstract void g(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0340a<INFO> extends e<INFO> {
        private C0340a() {
        }

        public static <INFO> C0340a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0340a<INFO> c0340a = new C0340a<>();
            c0340a.c(cVar);
            c0340a.c(cVar2);
            return c0340a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.jBO = aVar;
        this.jCb = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.jCa.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.ctT()) {
            this.jCq = new Throwable();
        }
        if (!z && this.jBO != null) {
            this.jBO.b(this);
        }
        this.mIsAttached = false;
        this.jCk = false;
        cuR();
        this.jCm = false;
        if (this.jCc != null) {
            this.jCc.init();
        }
        if (this.jCd != null) {
            this.jCd.init();
            this.jCd.a(this);
        }
        if (this.jCe instanceof C0340a) {
            ((C0340a) this.jCe).cvm();
        } else {
            this.jCe = null;
        }
        this.jCf = null;
        if (this.jCg != null) {
            this.jCg.reset();
            this.jCg.h(null);
            this.jCg = null;
        }
        this.jCh = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.jCi = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0339a
    public void release() {
        this.jCa.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.jCc != null) {
            this.jCc.reset();
        }
        if (this.jCd != null) {
            this.jCd.reset();
        }
        if (this.jCg != null) {
            this.jCg.reset();
        }
        cuR();
    }

    private void cuR() {
        boolean z = this.jCj;
        this.jCj = false;
        this.jCl = false;
        if (this.jCo != null) {
            this.jCo.zf();
            this.jCo = null;
        }
        if (this.mDrawable != null) {
            g(this.mDrawable);
        }
        if (this.jCn != null) {
            this.jCn = null;
        }
        this.mDrawable = null;
        if (this.jCp != null) {
            t("release", this.jCp);
            aK(this.jCp);
            this.jCp = null;
        }
        if (z) {
            cuU().FH(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cuS() {
        return this.jCc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.jCc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cuT() {
        return this.jCd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.jCd = aVar;
        if (this.jCd != null) {
            this.jCd.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rr(boolean z) {
        this.jCm = z;
    }

    public void FG(@Nullable String str) {
        this.jCn = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.jCe instanceof C0340a) {
            ((C0340a) this.jCe).c(cVar);
        } else if (this.jCe != null) {
            this.jCe = C0340a.a(this.jCe, cVar);
        } else {
            this.jCe = cVar;
        }
    }

    protected c<INFO> cuU() {
        return this.jCe == null ? b.cvl() : this.jCe;
    }

    public void a(@Nullable d dVar) {
        this.jCf = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.jCg;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.jCa.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.jCj) {
            this.jBO.b(this);
            release();
        }
        if (this.jCg != null) {
            this.jCg.h(null);
            this.jCg = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.jCg = (com.facebook.drawee.d.c) bVar;
            this.jCg.h(this.jCh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@Nullable Drawable drawable) {
        this.jCh = drawable;
        if (this.jCg != null) {
            this.jCg.h(this.jCh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cuV() {
        return this.jCh;
    }

    @Override // com.facebook.drawee.d.a
    public void cuW() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.jCj ? "request already submitted" : "request needs submit");
        }
        this.jCa.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.jCg);
        this.jBO.b(this);
        this.mIsAttached = true;
        if (!this.jCj) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.jCa.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.jBO.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.jCd == null) {
            return false;
        }
        if (this.jCd.cwc() || cuX()) {
            this.jCd.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cuX() {
        return cuP();
    }

    private boolean cuP() {
        return this.jCl && this.jCc != null && this.jCc.cuP();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0338a
    public boolean cuY() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cuP()) {
            this.jCc.cuQ();
            this.jCg.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cuF = cuF();
        if (cuF != null) {
            this.jCo = null;
            this.jCj = true;
            this.jCl = false;
            this.jCa.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cuU().u(this.mId, this.jCi);
            a(this.mId, this.jCo, cuF, 1.0f, true, true);
            return;
        }
        this.jCa.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cuU().u(this.mId, this.jCi);
        this.jCg.d(0.0f, true);
        this.jCj = true;
        this.jCl = false;
        this.jCo = cuD();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.jCo)));
        }
        final String str = this.mId;
        final boolean cul = this.jCo.cul();
        this.jCo.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.jCq != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).t(a.this.jCq);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cul);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cun(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.jCb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            t("ignore_old_datasource @ onNewResult", t);
            aK(t);
            bVar.zf();
            return;
        }
        this.jCa.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aN = aN(t);
            T t2 = this.jCp;
            Drawable drawable = this.mDrawable;
            this.jCp = t;
            this.mDrawable = aN;
            try {
                if (z) {
                    t("set_final_result @ onNewResult", t);
                    this.jCo = null;
                    this.jCg.a(aN, 1.0f, z2);
                    cuU().a(str, aM(t), cuZ());
                } else {
                    t("set_intermediate_result @ onNewResult", t);
                    this.jCg.a(aN, f, z2);
                    cuU().v(str, aM(t));
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
        this.jCa.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.jCo = null;
            this.jCl = true;
            if (this.jCm && this.mDrawable != null) {
                this.jCg.a(this.mDrawable, 1.0f, true);
            } else if (cuP()) {
                this.jCg.A(th);
            } else {
                this.jCg.z(th);
            }
            cuU().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cuU().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.zf();
        } else if (!z) {
            this.jCg.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.jCo == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.jCo && this.jCj;
    }

    private void t(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jyO, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aO(t), Integer.valueOf(aL(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jyO, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cuZ() {
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
        return f.aE(this).ay("isAttached", this.mIsAttached).ay("isRequestSubmitted", this.jCj).ay("hasFetchFailed", this.jCl).bz("fetchedImage", aL(this.jCp)).q("events", this.jCa.toString()).toString();
    }

    protected T cuF() {
        return null;
    }
}
