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
public abstract class a<T, INFO> implements a.InterfaceC0797a, a.InterfaceC0798a, com.facebook.drawee.d.a {
    private static final Class<?> mHo = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private Object mKB;
    private final com.facebook.drawee.components.a mKv;
    private final Executor mLj;
    @Nullable
    private com.facebook.drawee.components.b mLk;
    @Nullable
    private com.facebook.drawee.c.a mLl;
    @Nullable
    private c<INFO> mLm;
    @Nullable
    private d mLn;
    @Nullable
    private com.facebook.drawee.d.c mLo;
    @Nullable
    private Drawable mLp;
    private boolean mLq;
    private boolean mLr;
    private boolean mLs;
    private boolean mLt;
    @Nullable
    private String mLu;
    @Nullable
    private com.facebook.datasource.b<T> mLv;
    @Nullable
    private T mLw;
    private final DraweeEventTracker mLi = DraweeEventTracker.dAs();
    private boolean mLx = true;

    protected abstract void aV(@Nullable T t);

    @Nullable
    protected abstract INFO aX(T t);

    protected abstract Drawable aY(T t);

    protected abstract com.facebook.datasource.b<T> dAd();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0799a<INFO> extends e<INFO> {
        private C0799a() {
        }

        public static <INFO> C0799a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0799a<INFO> c0799a = new C0799a<>();
            c0799a.d(cVar);
            c0799a.d(cVar2);
            return c0799a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.mKv = aVar;
        this.mLj = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.mLx = false;
    }

    private synchronized void J(String str, Object obj) {
        this.mLi.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mLx && this.mKv != null) {
            this.mKv.b(this);
        }
        this.mIsAttached = false;
        this.mLr = false;
        dAv();
        this.mLt = false;
        if (this.mLk != null) {
            this.mLk.init();
        }
        if (this.mLl != null) {
            this.mLl.init();
            this.mLl.a(this);
        }
        if (this.mLm instanceof C0799a) {
            ((C0799a) this.mLm).dAP();
        } else {
            this.mLm = null;
        }
        this.mLn = null;
        if (this.mLo != null) {
            this.mLo.reset();
            this.mLo.j(null);
            this.mLo = null;
        }
        this.mLp = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mKB = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0798a
    public void release() {
        this.mLi.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.mLk != null) {
            this.mLk.reset();
        }
        if (this.mLl != null) {
            this.mLl.reset();
        }
        if (this.mLo != null) {
            this.mLo.reset();
        }
        dAv();
    }

    private void dAv() {
        boolean z = this.mLq;
        this.mLq = false;
        this.mLs = false;
        if (this.mLv != null) {
            this.mLv.aam();
            this.mLv = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.mLu != null) {
            this.mLu = null;
        }
        this.mDrawable = null;
        if (this.mLw != null) {
            K("release", this.mLw);
            aV(this.mLw);
            this.mLw = null;
        }
        if (z) {
            dAy().fb(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dAw() {
        if (this.mLk == null) {
            this.mLk = new com.facebook.drawee.components.b();
        }
        return this.mLk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dAx() {
        return this.mLl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.mLl = aVar;
        if (this.mLl != null) {
            this.mLl.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ww(boolean z) {
        this.mLt = z;
    }

    public void QL(@Nullable String str) {
        this.mLu = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mLm instanceof C0799a) {
            ((C0799a) this.mLm).d(cVar);
        } else if (this.mLm != null) {
            this.mLm = C0799a.a(this.mLm, cVar);
        } else {
            this.mLm = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mLm instanceof C0799a) {
            ((C0799a) this.mLm).e(cVar);
        } else if (this.mLm == cVar) {
            this.mLm = null;
        }
    }

    protected c<INFO> dAy() {
        return this.mLm == null ? b.dAO() : this.mLm;
    }

    public void a(@Nullable d dVar) {
        this.mLn = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.mLo;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.mLi.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mLq) {
            this.mKv.b(this);
            release();
        }
        if (this.mLo != null) {
            this.mLo.j(null);
            this.mLo = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.mLo = (com.facebook.drawee.d.c) bVar;
            this.mLo.j(this.mLp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.mLp = drawable;
        if (this.mLo != null) {
            this.mLo.j(this.mLp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dAz() {
        return this.mLp;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mLq ? "request already submitted" : "request needs submit");
        }
        this.mLi.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.mLo);
        this.mKv.b(this);
        this.mIsAttached = true;
        if (!this.mLq) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.mLi.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mKv.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.mLl == null) {
            return false;
        }
        if (this.mLl.dBF() || dAA()) {
            this.mLl.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dAA() {
        return dAt();
    }

    private boolean dAt() {
        return this.mLs && this.mLk != null && this.mLk.dAt();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0797a
    public boolean dAB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dAt()) {
            this.mLk.dAu();
            this.mLo.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dAf = dAf();
        if (dAf != null) {
            this.mLv = null;
            this.mLq = true;
            this.mLs = false;
            this.mLi.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dAy().g(this.mId, this.mKB);
            H(this.mId, dAf);
            a(this.mId, this.mLv, dAf, 1.0f, true, true);
            return;
        }
        this.mLi.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dAy().g(this.mId, this.mKB);
        this.mLo.c(0.0f, true);
        this.mLq = true;
        this.mLs = false;
        this.mLv = dAd();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mLv)));
        }
        final String str = this.mId;
        final boolean dzF = this.mLv.dzF();
        this.mLv.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dzF);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dzH(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.mLj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            aV(t);
            bVar.aam();
            return;
        }
        this.mLi.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aY = aY(t);
            T t2 = this.mLw;
            Drawable drawable = this.mDrawable;
            this.mLw = t;
            this.mDrawable = aY;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.mLv = null;
                    this.mLo.a(aY, 1.0f, z2);
                    dAy().a(str, aX(t), dAC());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.mLo.a(aY, f, z2);
                    dAy().h(str, (String) aX(t));
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
        this.mLi.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.mLv = null;
            this.mLs = true;
            if (this.mLt && this.mDrawable != null) {
                this.mLo.a(this.mDrawable, 1.0f, true);
            } else if (dAt()) {
                this.mLo.E(th);
            } else {
                this.mLo.D(th);
            }
            dAy().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dAy().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.aam();
        } else if (!z) {
            this.mLo.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.mLv == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.mLv && this.mLq;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(mHo, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ba(t), Integer.valueOf(aW(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHo, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dAC() {
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
        return f.aO(this).aZ("isAttached", this.mIsAttached).aZ("isRequestSubmitted", this.mLq).aZ("hasFetchFailed", this.mLs).bM("fetchedImage", aW(this.mLw)).F("events", this.mLi.toString()).toString();
    }

    protected T dAf() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
