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
/* loaded from: classes15.dex */
public abstract class a<T, INFO> implements a.InterfaceC0952a, a.InterfaceC0953a, com.facebook.drawee.d.a {
    private static final Class<?> oAy = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a oDB;
    private Object oDH;
    @Nullable
    private String oEA;
    @Nullable
    private com.facebook.datasource.b<T> oEB;
    @Nullable
    private T oEC;
    private final Executor oEp;
    @Nullable
    private com.facebook.drawee.components.b oEq;
    @Nullable
    private com.facebook.drawee.c.a oEr;
    @Nullable
    private c<INFO> oEs;
    @Nullable
    private d oEt;
    @Nullable
    private com.facebook.drawee.d.c oEu;
    @Nullable
    private Drawable oEv;
    private boolean oEw;
    private boolean oEx;
    private boolean oEy;
    private boolean oEz;
    private final DraweeEventTracker oEo = DraweeEventTracker.ehz();
    private boolean oED = true;

    protected abstract void bg(@Nullable T t);

    @Nullable
    protected abstract INFO bi(T t);

    protected abstract Drawable bj(T t);

    protected abstract com.facebook.datasource.b<T> ehk();

    protected abstract void n(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0954a<INFO> extends e<INFO> {
        private C0954a() {
        }

        public static <INFO> C0954a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0954a<INFO> c0954a = new C0954a<>();
            c0954a.d(cVar);
            c0954a.d(cVar2);
            return c0954a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.oDB = aVar;
        this.oEp = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.oED = false;
    }

    private synchronized void J(String str, Object obj) {
        this.oEo.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.oED && this.oDB != null) {
            this.oDB.b(this);
        }
        this.mIsAttached = false;
        this.oEx = false;
        ehC();
        this.oEz = false;
        if (this.oEq != null) {
            this.oEq.init();
        }
        if (this.oEr != null) {
            this.oEr.init();
            this.oEr.a(this);
        }
        if (this.oEs instanceof C0954a) {
            ((C0954a) this.oEs).ehW();
        } else {
            this.oEs = null;
        }
        this.oEt = null;
        if (this.oEu != null) {
            this.oEu.reset();
            this.oEu.o(null);
            this.oEu = null;
        }
        this.oEv = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.oDH = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0953a
    public void release() {
        this.oEo.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.oEq != null) {
            this.oEq.reset();
        }
        if (this.oEr != null) {
            this.oEr.reset();
        }
        if (this.oEu != null) {
            this.oEu.reset();
        }
        ehC();
    }

    private void ehC() {
        boolean z = this.oEw;
        this.oEw = false;
        this.oEy = false;
        if (this.oEB != null) {
            this.oEB.amP();
            this.oEB = null;
        }
        if (this.mDrawable != null) {
            n(this.mDrawable);
        }
        if (this.oEA != null) {
            this.oEA = null;
        }
        this.mDrawable = null;
        if (this.oEC != null) {
            K("release", this.oEC);
            bg(this.oEC);
            this.oEC = null;
        }
        if (z) {
            ehF().hf(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b ehD() {
        if (this.oEq == null) {
            this.oEq = new com.facebook.drawee.components.b();
        }
        return this.oEq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a ehE() {
        return this.oEr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.oEr = aVar;
        if (this.oEr != null) {
            this.oEr.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zS(boolean z) {
        this.oEz = z;
    }

    public void XE(@Nullable String str) {
        this.oEA = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.oEs instanceof C0954a) {
            ((C0954a) this.oEs).d(cVar);
        } else if (this.oEs != null) {
            this.oEs = C0954a.a(this.oEs, cVar);
        } else {
            this.oEs = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.oEs instanceof C0954a) {
            ((C0954a) this.oEs).e(cVar);
        } else if (this.oEs == cVar) {
            this.oEs = null;
        }
    }

    protected c<INFO> ehF() {
        return this.oEs == null ? b.ehV() : this.oEs;
    }

    public void a(@Nullable d dVar) {
        this.oEt = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.oEu;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.oEo.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.oEw) {
            this.oDB.b(this);
            release();
        }
        if (this.oEu != null) {
            this.oEu.o(null);
            this.oEu = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.oEu = (com.facebook.drawee.d.c) bVar;
            this.oEu.o(this.oEv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(@Nullable Drawable drawable) {
        this.oEv = drawable;
        if (this.oEu != null) {
            this.oEu.o(this.oEv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable ehG() {
        return this.oEv;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.oEw ? "request already submitted" : "request needs submit");
        }
        this.oEo.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.oEu);
        this.oDB.b(this);
        this.mIsAttached = true;
        if (!this.oEw) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.oEo.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.oDB.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.oEr == null) {
            return false;
        }
        if (this.oEr.eiL() || ehH()) {
            this.oEr.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean ehH() {
        return ehA();
    }

    private boolean ehA() {
        return this.oEy && this.oEq != null && this.oEq.ehA();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0952a
    public boolean ehI() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (ehA()) {
            this.oEq.ehB();
            this.oEu.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T ehm = ehm();
        if (ehm != null) {
            this.oEB = null;
            this.oEw = true;
            this.oEy = false;
            this.oEo.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            ehF().g(this.mId, this.oDH);
            H(this.mId, ehm);
            a(this.mId, this.oEB, ehm, 1.0f, true, true);
            return;
        }
        this.oEo.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        ehF().g(this.mId, this.oDH);
        this.oEu.c(0.0f, true);
        this.oEw = true;
        this.oEy = false;
        this.oEB = ehk();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.oEB)));
        }
        final String str = this.mId;
        final boolean egM = this.oEB.egM();
        this.oEB.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, egM);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.egO(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.oEp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            bg(t);
            bVar.amP();
            return;
        }
        this.oEo.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bj = bj(t);
            T t2 = this.oEC;
            Drawable drawable = this.mDrawable;
            this.oEC = t;
            this.mDrawable = bj;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.oEB = null;
                    this.oEu.a(bj, 1.0f, z2);
                    ehF().a(str, bi(t), ehJ());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.oEu.a(bj, f, z2);
                    ehF().h(str, (String) bi(t));
                }
                if (drawable != null && drawable != bj) {
                    n(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bg(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bj) {
                    n(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bg(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            bg(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.amP();
            return;
        }
        this.oEo.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.oEB = null;
            this.oEy = true;
            if (this.oEz && this.mDrawable != null) {
                this.oEu.a(this.mDrawable, 1.0f, true);
            } else if (ehA()) {
                this.oEu.C(th);
            } else {
                this.oEu.B(th);
            }
            ehF().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        ehF().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.amP();
        } else if (!z) {
            this.oEu.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.oEB == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.oEB && this.oEw;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(oAy, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bl(t), Integer.valueOf(bh(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable ehJ() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String bl(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int bh(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aZ(this).bl("isAttached", this.mIsAttached).bl("isRequestSubmitted", this.oEw).bl("hasFetchFailed", this.oEy).bU("fetchedImage", bh(this.oEC)).F("events", this.oEo.toString()).toString();
    }

    protected T ehm() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
