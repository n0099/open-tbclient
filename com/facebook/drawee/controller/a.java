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
/* loaded from: classes8.dex */
public abstract class a<T, INFO> implements a.InterfaceC0991a, a.InterfaceC0992a, com.facebook.drawee.d.a {
    private static final Class<?> paF = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a pdH;
    private Object pdN;
    @Nullable
    private com.facebook.drawee.d.c peA;
    @Nullable
    private Drawable peB;
    private boolean peC;
    private boolean peD;
    private boolean peE;
    private boolean peF;
    @Nullable
    private String peG;
    @Nullable
    private com.facebook.datasource.b<T> peH;
    @Nullable
    private T peI;
    private final Executor pev;
    @Nullable
    private com.facebook.drawee.components.b pew;
    @Nullable
    private com.facebook.drawee.c.a pex;
    @Nullable
    private c<INFO> pey;
    @Nullable
    private d pez;
    private final DraweeEventTracker peu = DraweeEventTracker.erc();
    private boolean peJ = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> eqN();

    protected abstract void o(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0993a<INFO> extends e<INFO> {
        private C0993a() {
        }

        public static <INFO> C0993a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0993a<INFO> c0993a = new C0993a<>();
            c0993a.d(cVar);
            c0993a.d(cVar2);
            return c0993a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.pdH = aVar;
        this.pev = executor;
        I(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, Object obj) {
        I(str, obj);
        this.peJ = false;
    }

    private synchronized void I(String str, Object obj) {
        this.peu.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.peJ && this.pdH != null) {
            this.pdH.b(this);
        }
        this.mIsAttached = false;
        this.peD = false;
        erf();
        this.peF = false;
        if (this.pew != null) {
            this.pew.init();
        }
        if (this.pex != null) {
            this.pex.init();
            this.pex.a(this);
        }
        if (this.pey instanceof C0993a) {
            ((C0993a) this.pey).erz();
        } else {
            this.pey = null;
        }
        this.pez = null;
        if (this.peA != null) {
            this.peA.reset();
            this.peA.p(null);
            this.peA = null;
        }
        this.peB = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pdN = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0992a
    public void release() {
        this.peu.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.pew != null) {
            this.pew.reset();
        }
        if (this.pex != null) {
            this.pex.reset();
        }
        if (this.peA != null) {
            this.peA.reset();
        }
        erf();
    }

    private void erf() {
        boolean z = this.peC;
        this.peC = false;
        this.peE = false;
        if (this.peH != null) {
            this.peH.arP();
            this.peH = null;
        }
        if (this.mDrawable != null) {
            o(this.mDrawable);
        }
        if (this.peG != null) {
            this.peG = null;
        }
        this.mDrawable = null;
        if (this.peI != null) {
            J("release", this.peI);
            bh(this.peI);
            this.peI = null;
        }
        if (z) {
            eri().hB(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b erg() {
        if (this.pew == null) {
            this.pew = new com.facebook.drawee.components.b();
        }
        return this.pew;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a erh() {
        return this.pex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pex = aVar;
        if (this.pex != null) {
            this.pex.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AO(boolean z) {
        this.peF = z;
    }

    public void Zo(@Nullable String str) {
        this.peG = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pey instanceof C0993a) {
            ((C0993a) this.pey).d(cVar);
        } else if (this.pey != null) {
            this.pey = C0993a.a(this.pey, cVar);
        } else {
            this.pey = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pey instanceof C0993a) {
            ((C0993a) this.pey).e(cVar);
        } else if (this.pey == cVar) {
            this.pey = null;
        }
    }

    protected c<INFO> eri() {
        return this.pey == null ? b.ery() : this.pey;
    }

    public void a(@Nullable d dVar) {
        this.pez = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.peA;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.peu.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.peC) {
            this.pdH.b(this);
            release();
        }
        if (this.peA != null) {
            this.peA.p(null);
            this.peA = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.peA = (com.facebook.drawee.d.c) bVar;
            this.peA.p(this.peB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@Nullable Drawable drawable) {
        this.peB = drawable;
        if (this.peA != null) {
            this.peA.p(this.peB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable erj() {
        return this.peB;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.peC ? "request already submitted" : "request needs submit");
        }
        this.peu.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.peA);
        this.pdH.b(this);
        this.mIsAttached = true;
        if (!this.peC) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.peu.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.pdH.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pex == null) {
            return false;
        }
        if (this.pex.esn() || erk()) {
            this.pex.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean erk() {
        return erd();
    }

    private boolean erd() {
        return this.peE && this.pew != null && this.pew.erd();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0991a
    public boolean erl() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (erd()) {
            this.pew.ere();
            this.peA.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T eqP = eqP();
        if (eqP != null) {
            this.peH = null;
            this.peC = true;
            this.peE = false;
            this.peu.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            eri().f(this.mId, this.pdN);
            G(this.mId, eqP);
            a(this.mId, this.peH, eqP, 1.0f, true, true);
            return;
        }
        this.peu.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        eri().f(this.mId, this.pdN);
        this.peA.c(0.0f, true);
        this.peC = true;
        this.peE = false;
        this.peH = eqN();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.peH)));
        }
        final String str = this.mId;
        final boolean eqp = this.peH.eqp();
        this.peH.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, eqp);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.eqr(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.pev);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            J("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.arP();
            return;
        }
        this.peu.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.peI;
            Drawable drawable = this.mDrawable;
            this.peI = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    J("set_final_result @ onNewResult", t);
                    this.peH = null;
                    this.peA.a(bk, 1.0f, z2);
                    eri().a(str, bj(t), erm());
                } else {
                    J("set_intermediate_result @ onNewResult", t);
                    this.peA.a(bk, f, z2);
                    eri().g(str, (String) bj(t));
                }
                if (drawable != null && drawable != bk) {
                    o(drawable);
                }
                if (t2 != null && t2 != t) {
                    J("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bk) {
                    o(drawable);
                }
                if (t2 != null && t2 != t) {
                    J("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            J("drawable_failed @ onNewResult", t);
            bh(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.arP();
            return;
        }
        this.peu.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.peH = null;
            this.peE = true;
            if (this.peF && this.mDrawable != null) {
                this.peA.a(this.mDrawable, 1.0f, true);
            } else if (erd()) {
                this.peA.C(th);
            } else {
                this.peA.B(th);
            }
            eri().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        eri().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.arP();
        } else if (!z) {
            this.peA.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.peH == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.peH && this.peC;
    }

    private void J(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(paF, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable erm() {
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
        return f.ba(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.peC).bo("hasFetchFailed", this.peE).ca("fetchedImage", bi(this.peI)).E("events", this.peu.toString()).toString();
    }

    protected T eqP() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(String str, T t) {
    }
}
