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
    private static final Class<?> jya = a.class;
    @Nullable
    private com.facebook.datasource.b<T> jBA;
    @Nullable
    private T jBB;
    @Nullable
    private Throwable jBC;
    private final com.facebook.drawee.components.a jBa;
    private final DraweeEventTracker jBm = DraweeEventTracker.cuK();
    private final Executor jBn;
    @Nullable
    private com.facebook.drawee.components.b jBo;
    @Nullable
    private com.facebook.drawee.c.a jBp;
    @Nullable
    private c<INFO> jBq;
    @Nullable
    private d jBr;
    @Nullable
    private com.facebook.drawee.d.c jBs;
    @Nullable
    private Drawable jBt;
    private Object jBu;
    private boolean jBv;
    private boolean jBw;
    private boolean jBx;
    private boolean jBy;
    @Nullable
    private String jBz;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aG(@Nullable T t);

    @Nullable
    protected abstract INFO aI(T t);

    protected abstract Drawable aJ(T t);

    protected abstract com.facebook.datasource.b<T> cuz();

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
        this.jBa = aVar;
        this.jBn = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.jBm.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.ctP()) {
            this.jBC = new Throwable();
        }
        if (!z && this.jBa != null) {
            this.jBa.b(this);
        }
        this.mIsAttached = false;
        this.jBw = false;
        cuN();
        this.jBy = false;
        if (this.jBo != null) {
            this.jBo.init();
        }
        if (this.jBp != null) {
            this.jBp.init();
            this.jBp.a(this);
        }
        if (this.jBq instanceof C0433a) {
            ((C0433a) this.jBq).cvi();
        } else {
            this.jBq = null;
        }
        this.jBr = null;
        if (this.jBs != null) {
            this.jBs.reset();
            this.jBs.h(null);
            this.jBs = null;
        }
        this.jBt = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.jBu = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0432a
    public void release() {
        this.jBm.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.jBo != null) {
            this.jBo.reset();
        }
        if (this.jBp != null) {
            this.jBp.reset();
        }
        if (this.jBs != null) {
            this.jBs.reset();
        }
        cuN();
    }

    private void cuN() {
        boolean z = this.jBv;
        this.jBv = false;
        this.jBx = false;
        if (this.jBA != null) {
            this.jBA.ze();
            this.jBA = null;
        }
        if (this.mDrawable != null) {
            g(this.mDrawable);
        }
        if (this.jBz != null) {
            this.jBz = null;
        }
        this.mDrawable = null;
        if (this.jBB != null) {
            t("release", this.jBB);
            aG(this.jBB);
            this.jBB = null;
        }
        if (z) {
            cuQ().Fv(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cuO() {
        return this.jBo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.jBo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cuP() {
        return this.jBp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.jBp = aVar;
        if (this.jBp != null) {
            this.jBp.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rr(boolean z) {
        this.jBy = z;
    }

    public void Fu(@Nullable String str) {
        this.jBz = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.jBq instanceof C0433a) {
            ((C0433a) this.jBq).c(cVar);
        } else if (this.jBq != null) {
            this.jBq = C0433a.a(this.jBq, cVar);
        } else {
            this.jBq = cVar;
        }
    }

    protected c<INFO> cuQ() {
        return this.jBq == null ? b.cvh() : this.jBq;
    }

    public void a(@Nullable d dVar) {
        this.jBr = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.jBs;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.jBm.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.jBv) {
            this.jBa.b(this);
            release();
        }
        if (this.jBs != null) {
            this.jBs.h(null);
            this.jBs = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.jBs = (com.facebook.drawee.d.c) bVar;
            this.jBs.h(this.jBt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@Nullable Drawable drawable) {
        this.jBt = drawable;
        if (this.jBs != null) {
            this.jBs.h(this.jBt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cuR() {
        return this.jBt;
    }

    @Override // com.facebook.drawee.d.a
    public void cuS() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.jBv ? "request already submitted" : "request needs submit");
        }
        this.jBm.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.jBs);
        this.jBa.b(this);
        this.mIsAttached = true;
        if (!this.jBv) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.jBm.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.jBa.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.jBp == null) {
            return false;
        }
        if (this.jBp.cvY() || cuT()) {
            this.jBp.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cuT() {
        return cuL();
    }

    private boolean cuL() {
        return this.jBx && this.jBo != null && this.jBo.cuL();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0431a
    public boolean cuU() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cuL()) {
            this.jBo.cuM();
            this.jBs.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cuB = cuB();
        if (cuB != null) {
            this.jBA = null;
            this.jBv = true;
            this.jBx = false;
            this.jBm.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cuQ().u(this.mId, this.jBu);
            a(this.mId, this.jBA, cuB, 1.0f, true, true);
            return;
        }
        this.jBm.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cuQ().u(this.mId, this.jBu);
        this.jBs.d(0.0f, true);
        this.jBv = true;
        this.jBx = false;
        this.jBA = cuz();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.jBA)));
        }
        final String str = this.mId;
        final boolean cuh = this.jBA.cuh();
        this.jBA.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.jBC != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).t(a.this.jBC);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cuh);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cuj(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.jBn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            t("ignore_old_datasource @ onNewResult", t);
            aG(t);
            bVar.ze();
            return;
        }
        this.jBm.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aJ = aJ(t);
            T t2 = this.jBB;
            Drawable drawable = this.mDrawable;
            this.jBB = t;
            this.mDrawable = aJ;
            try {
                if (z) {
                    t("set_final_result @ onNewResult", t);
                    this.jBA = null;
                    this.jBs.a(aJ, 1.0f, z2);
                    cuQ().a(str, aI(t), cuV());
                } else {
                    t("set_intermediate_result @ onNewResult", t);
                    this.jBs.a(aJ, f, z2);
                    cuQ().v(str, aI(t));
                }
                if (drawable != null && drawable != aJ) {
                    g(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aG(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aJ) {
                    g(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aG(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            t("drawable_failed @ onNewResult", t);
            aG(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onFailure", th);
            bVar.ze();
            return;
        }
        this.jBm.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.jBA = null;
            this.jBx = true;
            if (this.jBy && this.mDrawable != null) {
                this.jBs.a(this.mDrawable, 1.0f, true);
            } else if (cuL()) {
                this.jBs.A(th);
            } else {
                this.jBs.z(th);
            }
            cuQ().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cuQ().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.ze();
        } else if (!z) {
            this.jBs.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.jBA == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.jBA && this.jBv;
    }

    private void t(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jya, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aK(t), Integer.valueOf(aH(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jya, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cuV() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aK(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aH(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aA(this).ay("isAttached", this.mIsAttached).ay("isRequestSubmitted", this.jBv).ay("hasFetchFailed", this.jBx).bz("fetchedImage", aH(this.jBB)).q("events", this.jBm.toString()).toString();
    }

    protected T cuB() {
        return null;
    }
}
