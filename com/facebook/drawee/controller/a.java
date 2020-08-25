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
public abstract class a<T, INFO> implements a.InterfaceC0865a, a.InterfaceC0866a, com.facebook.drawee.d.a {
    private static final Class<?> nju = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private Object nmD;
    private final com.facebook.drawee.components.a nmx;
    private final Executor nnl;
    @Nullable
    private com.facebook.drawee.components.b nnm;
    @Nullable
    private com.facebook.drawee.c.a nnn;
    @Nullable
    private c<INFO> nno;
    @Nullable
    private d nnp;
    @Nullable
    private com.facebook.drawee.d.c nnq;
    @Nullable
    private Drawable nnr;
    private boolean nns;
    private boolean nnt;
    private boolean nnu;
    private boolean nnv;
    @Nullable
    private String nnw;
    @Nullable
    private com.facebook.datasource.b<T> nnx;
    @Nullable
    private T nny;
    private final DraweeEventTracker nnk = DraweeEventTracker.dPJ();
    private boolean nnz = true;

    protected abstract void aX(@Nullable T t);

    @Nullable
    protected abstract INFO aZ(T t);

    protected abstract Drawable ba(T t);

    protected abstract com.facebook.datasource.b<T> dPu();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0867a<INFO> extends e<INFO> {
        private C0867a() {
        }

        public static <INFO> C0867a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0867a<INFO> c0867a = new C0867a<>();
            c0867a.d(cVar);
            c0867a.d(cVar2);
            return c0867a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.nmx = aVar;
        this.nnl = executor;
        I(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, Object obj) {
        I(str, obj);
        this.nnz = false;
    }

    private synchronized void I(String str, Object obj) {
        this.nnk.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.nnz && this.nmx != null) {
            this.nmx.b(this);
        }
        this.mIsAttached = false;
        this.nnt = false;
        dPM();
        this.nnv = false;
        if (this.nnm != null) {
            this.nnm.init();
        }
        if (this.nnn != null) {
            this.nnn.init();
            this.nnn.a(this);
        }
        if (this.nno instanceof C0867a) {
            ((C0867a) this.nno).dQg();
        } else {
            this.nno = null;
        }
        this.nnp = null;
        if (this.nnq != null) {
            this.nnq.reset();
            this.nnq.j(null);
            this.nnq = null;
        }
        this.nnr = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.nmD = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0866a
    public void release() {
        this.nnk.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.nnm != null) {
            this.nnm.reset();
        }
        if (this.nnn != null) {
            this.nnn.reset();
        }
        if (this.nnq != null) {
            this.nnq.reset();
        }
        dPM();
    }

    private void dPM() {
        boolean z = this.nns;
        this.nns = false;
        this.nnu = false;
        if (this.nnx != null) {
            this.nnx.ahA();
            this.nnx = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.nnw != null) {
            this.nnw = null;
        }
        this.mDrawable = null;
        if (this.nny != null) {
            J("release", this.nny);
            aX(this.nny);
            this.nny = null;
        }
        if (z) {
            dPP().gv(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dPN() {
        if (this.nnm == null) {
            this.nnm = new com.facebook.drawee.components.b();
        }
        return this.nnm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dPO() {
        return this.nnn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.nnn = aVar;
        if (this.nnn != null) {
            this.nnn.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xS(boolean z) {
        this.nnv = z;
    }

    public void UB(@Nullable String str) {
        this.nnw = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nno instanceof C0867a) {
            ((C0867a) this.nno).d(cVar);
        } else if (this.nno != null) {
            this.nno = C0867a.a(this.nno, cVar);
        } else {
            this.nno = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nno instanceof C0867a) {
            ((C0867a) this.nno).e(cVar);
        } else if (this.nno == cVar) {
            this.nno = null;
        }
    }

    protected c<INFO> dPP() {
        return this.nno == null ? b.dQf() : this.nno;
    }

    public void a(@Nullable d dVar) {
        this.nnp = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.nnq;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.nnk.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.nns) {
            this.nmx.b(this);
            release();
        }
        if (this.nnq != null) {
            this.nnq.j(null);
            this.nnq = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.nnq = (com.facebook.drawee.d.c) bVar;
            this.nnq.j(this.nnr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.nnr = drawable;
        if (this.nnq != null) {
            this.nnq.j(this.nnr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dPQ() {
        return this.nnr;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.nns ? "request already submitted" : "request needs submit");
        }
        this.nnk.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.nnq);
        this.nmx.b(this);
        this.mIsAttached = true;
        if (!this.nns) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.nnk.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.nmx.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.nnn == null) {
            return false;
        }
        if (this.nnn.dQV() || dPR()) {
            this.nnn.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dPR() {
        return dPK();
    }

    private boolean dPK() {
        return this.nnu && this.nnm != null && this.nnm.dPK();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0865a
    public boolean dPS() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dPK()) {
            this.nnm.dPL();
            this.nnq.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dPw = dPw();
        if (dPw != null) {
            this.nnx = null;
            this.nns = true;
            this.nnu = false;
            this.nnk.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dPP().g(this.mId, this.nmD);
            G(this.mId, dPw);
            a(this.mId, this.nnx, dPw, 1.0f, true, true);
            return;
        }
        this.nnk.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dPP().g(this.mId, this.nmD);
        this.nnq.c(0.0f, true);
        this.nns = true;
        this.nnu = false;
        this.nnx = dPu();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.nnx)));
        }
        final String str = this.mId;
        final boolean dOW = this.nnx.dOW();
        this.nnx.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dOW);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dOY(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.nnl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            J("ignore_old_datasource @ onNewResult", t);
            aX(t);
            bVar.ahA();
            return;
        }
        this.nnk.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ba = ba(t);
            T t2 = this.nny;
            Drawable drawable = this.mDrawable;
            this.nny = t;
            this.mDrawable = ba;
            try {
                if (z) {
                    J("set_final_result @ onNewResult", t);
                    this.nnx = null;
                    this.nnq.a(ba, 1.0f, z2);
                    dPP().a(str, aZ(t), dPT());
                } else {
                    J("set_intermediate_result @ onNewResult", t);
                    this.nnq.a(ba, f, z2);
                    dPP().h(str, (String) aZ(t));
                }
                if (drawable != null && drawable != ba) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    J("release_previous_result @ onNewResult", t2);
                    aX(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != ba) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    J("release_previous_result @ onNewResult", t2);
                    aX(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            J("drawable_failed @ onNewResult", t);
            aX(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.ahA();
            return;
        }
        this.nnk.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.nnx = null;
            this.nnu = true;
            if (this.nnv && this.mDrawable != null) {
                this.nnq.a(this.mDrawable, 1.0f, true);
            } else if (dPK()) {
                this.nnq.C(th);
            } else {
                this.nnq.B(th);
            }
            dPP().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dPP().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.ahA();
        } else if (!z) {
            this.nnq.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.nnx == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.nnx && this.nns;
    }

    private void J(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(nju, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bc(t), Integer.valueOf(aY(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dPT() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String bc(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aY(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aQ(this).ba("isAttached", this.mIsAttached).ba("isRequestSubmitted", this.nns).ba("hasFetchFailed", this.nnu).bP("fetchedImage", aY(this.nny)).E("events", this.nnk.toString()).toString();
    }

    protected T dPw() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(String str, T t) {
    }
}
