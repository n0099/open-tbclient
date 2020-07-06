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
/* loaded from: classes13.dex */
public abstract class a<T, INFO> implements a.InterfaceC0798a, a.InterfaceC0799a, com.facebook.drawee.d.a {
    private static final Class<?> mHr = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private Object mKE;
    private final com.facebook.drawee.components.a mKy;
    private final Executor mLm;
    @Nullable
    private com.facebook.drawee.components.b mLn;
    @Nullable
    private com.facebook.drawee.c.a mLo;
    @Nullable
    private c<INFO> mLp;
    @Nullable
    private d mLq;
    @Nullable
    private com.facebook.drawee.d.c mLr;
    @Nullable
    private Drawable mLs;
    private boolean mLt;
    private boolean mLu;
    private boolean mLv;
    private boolean mLw;
    @Nullable
    private String mLx;
    @Nullable
    private com.facebook.datasource.b<T> mLy;
    @Nullable
    private T mLz;
    private final DraweeEventTracker mLl = DraweeEventTracker.dAw();
    private boolean mLA = true;

    protected abstract void aV(@Nullable T t);

    @Nullable
    protected abstract INFO aX(T t);

    protected abstract Drawable aY(T t);

    protected abstract com.facebook.datasource.b<T> dAh();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0800a<INFO> extends e<INFO> {
        private C0800a() {
        }

        public static <INFO> C0800a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0800a<INFO> c0800a = new C0800a<>();
            c0800a.d(cVar);
            c0800a.d(cVar2);
            return c0800a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.mKy = aVar;
        this.mLm = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.mLA = false;
    }

    private synchronized void J(String str, Object obj) {
        this.mLl.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mLA && this.mKy != null) {
            this.mKy.b(this);
        }
        this.mIsAttached = false;
        this.mLu = false;
        dAz();
        this.mLw = false;
        if (this.mLn != null) {
            this.mLn.init();
        }
        if (this.mLo != null) {
            this.mLo.init();
            this.mLo.a(this);
        }
        if (this.mLp instanceof C0800a) {
            ((C0800a) this.mLp).dAT();
        } else {
            this.mLp = null;
        }
        this.mLq = null;
        if (this.mLr != null) {
            this.mLr.reset();
            this.mLr.j(null);
            this.mLr = null;
        }
        this.mLs = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mKE = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0799a
    public void release() {
        this.mLl.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.mLn != null) {
            this.mLn.reset();
        }
        if (this.mLo != null) {
            this.mLo.reset();
        }
        if (this.mLr != null) {
            this.mLr.reset();
        }
        dAz();
    }

    private void dAz() {
        boolean z = this.mLt;
        this.mLt = false;
        this.mLv = false;
        if (this.mLy != null) {
            this.mLy.aam();
            this.mLy = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.mLx != null) {
            this.mLx = null;
        }
        this.mDrawable = null;
        if (this.mLz != null) {
            K("release", this.mLz);
            aV(this.mLz);
            this.mLz = null;
        }
        if (z) {
            dAC().fb(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dAA() {
        if (this.mLn == null) {
            this.mLn = new com.facebook.drawee.components.b();
        }
        return this.mLn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dAB() {
        return this.mLo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.mLo = aVar;
        if (this.mLo != null) {
            this.mLo.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ww(boolean z) {
        this.mLw = z;
    }

    public void QM(@Nullable String str) {
        this.mLx = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mLp instanceof C0800a) {
            ((C0800a) this.mLp).d(cVar);
        } else if (this.mLp != null) {
            this.mLp = C0800a.a(this.mLp, cVar);
        } else {
            this.mLp = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mLp instanceof C0800a) {
            ((C0800a) this.mLp).e(cVar);
        } else if (this.mLp == cVar) {
            this.mLp = null;
        }
    }

    protected c<INFO> dAC() {
        return this.mLp == null ? b.dAS() : this.mLp;
    }

    public void a(@Nullable d dVar) {
        this.mLq = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.mLr;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.mLl.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mLt) {
            this.mKy.b(this);
            release();
        }
        if (this.mLr != null) {
            this.mLr.j(null);
            this.mLr = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.mLr = (com.facebook.drawee.d.c) bVar;
            this.mLr.j(this.mLs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.mLs = drawable;
        if (this.mLr != null) {
            this.mLr.j(this.mLs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dAD() {
        return this.mLs;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mLt ? "request already submitted" : "request needs submit");
        }
        this.mLl.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.mLr);
        this.mKy.b(this);
        this.mIsAttached = true;
        if (!this.mLt) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.mLl.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mKy.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.mLo == null) {
            return false;
        }
        if (this.mLo.dBJ() || dAE()) {
            this.mLo.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dAE() {
        return dAx();
    }

    private boolean dAx() {
        return this.mLv && this.mLn != null && this.mLn.dAx();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0798a
    public boolean dAF() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dAx()) {
            this.mLn.dAy();
            this.mLr.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dAj = dAj();
        if (dAj != null) {
            this.mLy = null;
            this.mLt = true;
            this.mLv = false;
            this.mLl.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dAC().g(this.mId, this.mKE);
            H(this.mId, dAj);
            a(this.mId, this.mLy, dAj, 1.0f, true, true);
            return;
        }
        this.mLl.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dAC().g(this.mId, this.mKE);
        this.mLr.c(0.0f, true);
        this.mLt = true;
        this.mLv = false;
        this.mLy = dAh();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mLy)));
        }
        final String str = this.mId;
        final boolean dzJ = this.mLy.dzJ();
        this.mLy.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dzJ);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dzL(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.mLm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            aV(t);
            bVar.aam();
            return;
        }
        this.mLl.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aY = aY(t);
            T t2 = this.mLz;
            Drawable drawable = this.mDrawable;
            this.mLz = t;
            this.mDrawable = aY;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.mLy = null;
                    this.mLr.a(aY, 1.0f, z2);
                    dAC().a(str, aX(t), dAG());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.mLr.a(aY, f, z2);
                    dAC().h(str, (String) aX(t));
                }
                if (drawable != null && drawable != aY) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aV(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aY) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aV(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            aV(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.aam();
            return;
        }
        this.mLl.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.mLy = null;
            this.mLv = true;
            if (this.mLw && this.mDrawable != null) {
                this.mLr.a(this.mDrawable, 1.0f, true);
            } else if (dAx()) {
                this.mLr.E(th);
            } else {
                this.mLr.D(th);
            }
            dAC().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dAC().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.aam();
        } else if (!z) {
            this.mLr.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.mLy == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.mLy && this.mLt;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(mHr, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ba(t), Integer.valueOf(aW(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dAG() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String ba(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aW(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aO(this).aZ("isAttached", this.mIsAttached).aZ("isRequestSubmitted", this.mLt).aZ("hasFetchFailed", this.mLv).bM("fetchedImage", aW(this.mLz)).F("events", this.mLl.toString()).toString();
    }

    protected T dAj() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
