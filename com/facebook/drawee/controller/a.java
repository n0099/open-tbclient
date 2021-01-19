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
    private static final Class<?> pnn = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a pqt;
    private Object pqz;
    private final Executor prh;
    @Nullable
    private com.facebook.drawee.components.b pri;
    @Nullable
    private com.facebook.drawee.c.a prj;
    @Nullable
    private c<INFO> prk;
    @Nullable
    private d prl;
    @Nullable
    private com.facebook.drawee.d.c prm;
    @Nullable
    private Drawable prn;
    private boolean pro;
    private boolean prp;
    private boolean prq;
    private boolean prr;
    @Nullable
    private String prs;
    @Nullable
    private com.facebook.datasource.b<T> prt;
    @Nullable
    private T pru;
    private final DraweeEventTracker prg = DraweeEventTracker.ers();
    private boolean prv = true;

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
        this.pqt = aVar;
        this.prh = executor;
        M(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str, Object obj) {
        M(str, obj);
        this.prv = false;
    }

    private synchronized void M(String str, Object obj) {
        this.prg.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.prv && this.pqt != null) {
            this.pqt.b(this);
        }
        this.mIsAttached = false;
        this.prp = false;
        erv();
        this.prr = false;
        if (this.pri != null) {
            this.pri.init();
        }
        if (this.prj != null) {
            this.prj.init();
            this.prj.a(this);
        }
        if (this.prk instanceof C1043a) {
            ((C1043a) this.prk).erP();
        } else {
            this.prk = null;
        }
        this.prl = null;
        if (this.prm != null) {
            this.prm.reset();
            this.prm.u(null);
            this.prm = null;
        }
        this.prn = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pqz = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC1042a
    public void release() {
        this.prg.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.pri != null) {
            this.pri.reset();
        }
        if (this.prj != null) {
            this.prj.reset();
        }
        if (this.prm != null) {
            this.prm.reset();
        }
        erv();
    }

    private void erv() {
        boolean z = this.pro;
        this.pro = false;
        this.prq = false;
        if (this.prt != null) {
            this.prt.apn();
            this.prt = null;
        }
        if (this.mDrawable != null) {
            t(this.mDrawable);
        }
        if (this.prs != null) {
            this.prs = null;
        }
        this.mDrawable = null;
        if (this.pru != null) {
            N("release", this.pru);
            bh(this.pru);
            this.pru = null;
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
        if (this.pri == null) {
            this.pri = new com.facebook.drawee.components.b();
        }
        return this.pri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a erx() {
        return this.prj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.prj = aVar;
        if (this.prj != null) {
            this.prj.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AS(boolean z) {
        this.prr = z;
    }

    public void Yr(@Nullable String str) {
        this.prs = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.prk instanceof C1043a) {
            ((C1043a) this.prk).d(cVar);
        } else if (this.prk != null) {
            this.prk = C1043a.a(this.prk, cVar);
        } else {
            this.prk = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.prk instanceof C1043a) {
            ((C1043a) this.prk).e(cVar);
        } else if (this.prk == cVar) {
            this.prk = null;
        }
    }

    protected c<INFO> ery() {
        return this.prk == null ? b.erO() : this.prk;
    }

    public void a(@Nullable d dVar) {
        this.prl = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.prm;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.prg.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.pro) {
            this.pqt.b(this);
            release();
        }
        if (this.prm != null) {
            this.prm.u(null);
            this.prm = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.prm = (com.facebook.drawee.d.c) bVar;
            this.prm.u(this.prn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@Nullable Drawable drawable) {
        this.prn = drawable;
        if (this.prm != null) {
            this.prm.u(this.prn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable erz() {
        return this.prn;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.pro ? "request already submitted" : "request needs submit");
        }
        this.prg.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.prm);
        this.pqt.b(this);
        this.mIsAttached = true;
        if (!this.pro) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.prg.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.pqt.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.prj == null) {
            return false;
        }
        if (this.prj.esF() || erA()) {
            this.prj.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean erA() {
        return ert();
    }

    private boolean ert() {
        return this.prq && this.pri != null && this.pri.ert();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC1041a
    public boolean erB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (ert()) {
            this.pri.eru();
            this.prm.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T ere = ere();
        if (ere != null) {
            this.prt = null;
            this.pro = true;
            this.prq = false;
            this.prg.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            ery().f(this.mId, this.pqz);
            K(this.mId, ere);
            a(this.mId, this.prt, ere, 1.0f, true, true);
            return;
        }
        this.prg.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        ery().f(this.mId, this.pqz);
        this.prm.d(0.0f, true);
        this.pro = true;
        this.prq = false;
        this.prt = erc();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.prt)));
        }
        final String str = this.mId;
        final boolean eqE = this.prt.eqE();
        this.prt.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
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
        }, this.prh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            N("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.apn();
            return;
        }
        this.prg.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.pru;
            Drawable drawable = this.mDrawable;
            this.pru = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    N("set_final_result @ onNewResult", t);
                    this.prt = null;
                    this.prm.a(bk, 1.0f, z2);
                    ery().a(str, bj(t), erC());
                } else {
                    N("set_intermediate_result @ onNewResult", t);
                    this.prm.a(bk, f, z2);
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
        this.prg.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.prt = null;
            this.prq = true;
            if (this.prr && this.mDrawable != null) {
                this.prm.a(this.mDrawable, 1.0f, true);
            } else if (ert()) {
                this.prm.B(th);
            } else {
                this.prm.A(th);
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
            this.prm.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.prt == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.prt && this.pro;
    }

    private void N(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(pnn, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pnn, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
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
        return f.bb(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.pro).bo("hasFetchFailed", this.prq).ck("fetchedImage", bi(this.pru)).I("events", this.prg.toString()).toString();
    }

    protected T ere() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(String str, T t) {
    }
}
