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
/* loaded from: classes3.dex */
public abstract class a<T, INFO> implements a.InterfaceC1041a, a.InterfaceC1042a, com.facebook.drawee.d.a {
    private static final Class<?> pnm = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a pqs;
    private Object pqy;
    private final Executor prg;
    @Nullable
    private com.facebook.drawee.components.b prh;
    @Nullable
    private com.facebook.drawee.c.a pri;
    @Nullable
    private c<INFO> prj;
    @Nullable
    private d prk;
    @Nullable
    private com.facebook.drawee.d.c prl;
    @Nullable
    private Drawable prm;
    private boolean prn;
    private boolean pro;
    private boolean prp;
    private boolean prq;
    @Nullable
    private String prr;
    @Nullable
    private com.facebook.datasource.b<T> prs;
    @Nullable
    private T prt;
    private final DraweeEventTracker prf = DraweeEventTracker.ers();
    private boolean pru = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> erc();

    protected abstract void t(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1043a<INFO> extends e<INFO> {
        private C1043a() {
        }

        public static <INFO> C1043a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C1043a<INFO> c1043a = new C1043a<>();
            c1043a.d(cVar);
            c1043a.d(cVar2);
            return c1043a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.pqs = aVar;
        this.prg = executor;
        M(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str, Object obj) {
        M(str, obj);
        this.pru = false;
    }

    private synchronized void M(String str, Object obj) {
        this.prf.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.pru && this.pqs != null) {
            this.pqs.b(this);
        }
        this.mIsAttached = false;
        this.pro = false;
        erv();
        this.prq = false;
        if (this.prh != null) {
            this.prh.init();
        }
        if (this.pri != null) {
            this.pri.init();
            this.pri.a(this);
        }
        if (this.prj instanceof C1043a) {
            ((C1043a) this.prj).erP();
        } else {
            this.prj = null;
        }
        this.prk = null;
        if (this.prl != null) {
            this.prl.reset();
            this.prl.u(null);
            this.prl = null;
        }
        this.prm = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pqy = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC1042a
    public void release() {
        this.prf.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.prh != null) {
            this.prh.reset();
        }
        if (this.pri != null) {
            this.pri.reset();
        }
        if (this.prl != null) {
            this.prl.reset();
        }
        erv();
    }

    private void erv() {
        boolean z = this.prn;
        this.prn = false;
        this.prp = false;
        if (this.prs != null) {
            this.prs.apn();
            this.prs = null;
        }
        if (this.mDrawable != null) {
            t(this.mDrawable);
        }
        if (this.prr != null) {
            this.prr = null;
        }
        this.mDrawable = null;
        if (this.prt != null) {
            N("release", this.prt);
            bh(this.prt);
            this.prt = null;
        }
        if (z) {
            ery().ga(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b erw() {
        if (this.prh == null) {
            this.prh = new com.facebook.drawee.components.b();
        }
        return this.prh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a erx() {
        return this.pri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pri = aVar;
        if (this.pri != null) {
            this.pri.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AS(boolean z) {
        this.prq = z;
    }

    public void Yq(@Nullable String str) {
        this.prr = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.prj instanceof C1043a) {
            ((C1043a) this.prj).d(cVar);
        } else if (this.prj != null) {
            this.prj = C1043a.a(this.prj, cVar);
        } else {
            this.prj = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.prj instanceof C1043a) {
            ((C1043a) this.prj).e(cVar);
        } else if (this.prj == cVar) {
            this.prj = null;
        }
    }

    protected c<INFO> ery() {
        return this.prj == null ? b.erO() : this.prj;
    }

    public void a(@Nullable d dVar) {
        this.prk = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.prl;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.prf.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.prn) {
            this.pqs.b(this);
            release();
        }
        if (this.prl != null) {
            this.prl.u(null);
            this.prl = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.prl = (com.facebook.drawee.d.c) bVar;
            this.prl.u(this.prm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@Nullable Drawable drawable) {
        this.prm = drawable;
        if (this.prl != null) {
            this.prl.u(this.prm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable erz() {
        return this.prm;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.prn ? "request already submitted" : "request needs submit");
        }
        this.prf.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.prl);
        this.pqs.b(this);
        this.mIsAttached = true;
        if (!this.prn) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.prf.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.pqs.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pri == null) {
            return false;
        }
        if (this.pri.esF() || erA()) {
            this.pri.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean erA() {
        return ert();
    }

    private boolean ert() {
        return this.prp && this.prh != null && this.prh.ert();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC1041a
    public boolean erB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (ert()) {
            this.prh.eru();
            this.prl.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T ere = ere();
        if (ere != null) {
            this.prs = null;
            this.prn = true;
            this.prp = false;
            this.prf.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            ery().f(this.mId, this.pqy);
            K(this.mId, ere);
            a(this.mId, this.prs, ere, 1.0f, true, true);
            return;
        }
        this.prf.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        ery().f(this.mId, this.pqy);
        this.prl.d(0.0f, true);
        this.prn = true;
        this.prp = false;
        this.prs = erc();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.prs)));
        }
        final String str = this.mId;
        final boolean eqE = this.prs.eqE();
        this.prs.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, eqE);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.eqG(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.prg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            N("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.apn();
            return;
        }
        this.prf.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.prt;
            Drawable drawable = this.mDrawable;
            this.prt = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    N("set_final_result @ onNewResult", t);
                    this.prs = null;
                    this.prl.a(bk, 1.0f, z2);
                    ery().a(str, bj(t), erC());
                } else {
                    N("set_intermediate_result @ onNewResult", t);
                    this.prl.a(bk, f, z2);
                    ery().g(str, (String) bj(t));
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
            bVar.apn();
            return;
        }
        this.prf.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.prs = null;
            this.prp = true;
            if (this.prq && this.mDrawable != null) {
                this.prl.a(this.mDrawable, 1.0f, true);
            } else if (ert()) {
                this.prl.B(th);
            } else {
                this.prl.A(th);
            }
            ery().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        ery().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.apn();
        } else if (!z) {
            this.prl.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.prs == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.prs && this.prn;
    }

    private void N(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(pnm, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnm, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable erC() {
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
        return f.bb(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.prn).bo("hasFetchFailed", this.prp).cj("fetchedImage", bi(this.prt)).I("events", this.prf.toString()).toString();
    }

    protected T ere() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(String str, T t) {
    }
}
