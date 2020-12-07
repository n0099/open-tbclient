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
    private static final Class<?> paD = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a pdF;
    private Object pdL;
    private boolean peA;
    private boolean peB;
    private boolean peC;
    private boolean peD;
    @Nullable
    private String peE;
    @Nullable
    private com.facebook.datasource.b<T> peF;
    @Nullable
    private T peG;
    private final Executor pet;
    @Nullable
    private com.facebook.drawee.components.b peu;
    @Nullable
    private com.facebook.drawee.c.a pev;
    @Nullable
    private c<INFO> pew;
    @Nullable
    private d pex;
    @Nullable
    private com.facebook.drawee.d.c pey;
    @Nullable
    private Drawable pez;
    private final DraweeEventTracker pes = DraweeEventTracker.erb();
    private boolean peH = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> eqM();

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
        this.pdF = aVar;
        this.pet = executor;
        I(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, Object obj) {
        I(str, obj);
        this.peH = false;
    }

    private synchronized void I(String str, Object obj) {
        this.pes.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.peH && this.pdF != null) {
            this.pdF.b(this);
        }
        this.mIsAttached = false;
        this.peB = false;
        ere();
        this.peD = false;
        if (this.peu != null) {
            this.peu.init();
        }
        if (this.pev != null) {
            this.pev.init();
            this.pev.a(this);
        }
        if (this.pew instanceof C0993a) {
            ((C0993a) this.pew).ery();
        } else {
            this.pew = null;
        }
        this.pex = null;
        if (this.pey != null) {
            this.pey.reset();
            this.pey.p(null);
            this.pey = null;
        }
        this.pez = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pdL = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0992a
    public void release() {
        this.pes.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.peu != null) {
            this.peu.reset();
        }
        if (this.pev != null) {
            this.pev.reset();
        }
        if (this.pey != null) {
            this.pey.reset();
        }
        ere();
    }

    private void ere() {
        boolean z = this.peA;
        this.peA = false;
        this.peC = false;
        if (this.peF != null) {
            this.peF.arP();
            this.peF = null;
        }
        if (this.mDrawable != null) {
            o(this.mDrawable);
        }
        if (this.peE != null) {
            this.peE = null;
        }
        this.mDrawable = null;
        if (this.peG != null) {
            J("release", this.peG);
            bh(this.peG);
            this.peG = null;
        }
        if (z) {
            erh().hB(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b erf() {
        if (this.peu == null) {
            this.peu = new com.facebook.drawee.components.b();
        }
        return this.peu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a erg() {
        return this.pev;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pev = aVar;
        if (this.pev != null) {
            this.pev.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AO(boolean z) {
        this.peD = z;
    }

    public void Zo(@Nullable String str) {
        this.peE = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pew instanceof C0993a) {
            ((C0993a) this.pew).d(cVar);
        } else if (this.pew != null) {
            this.pew = C0993a.a(this.pew, cVar);
        } else {
            this.pew = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pew instanceof C0993a) {
            ((C0993a) this.pew).e(cVar);
        } else if (this.pew == cVar) {
            this.pew = null;
        }
    }

    protected c<INFO> erh() {
        return this.pew == null ? b.erx() : this.pew;
    }

    public void a(@Nullable d dVar) {
        this.pex = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.pey;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.pes.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.peA) {
            this.pdF.b(this);
            release();
        }
        if (this.pey != null) {
            this.pey.p(null);
            this.pey = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.pey = (com.facebook.drawee.d.c) bVar;
            this.pey.p(this.pez);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@Nullable Drawable drawable) {
        this.pez = drawable;
        if (this.pey != null) {
            this.pey.p(this.pez);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable eri() {
        return this.pez;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.peA ? "request already submitted" : "request needs submit");
        }
        this.pes.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.pey);
        this.pdF.b(this);
        this.mIsAttached = true;
        if (!this.peA) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.pes.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.pdF.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pev == null) {
            return false;
        }
        if (this.pev.esm() || erj()) {
            this.pev.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean erj() {
        return erc();
    }

    private boolean erc() {
        return this.peC && this.peu != null && this.peu.erc();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0991a
    public boolean erk() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (erc()) {
            this.peu.erd();
            this.pey.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T eqO = eqO();
        if (eqO != null) {
            this.peF = null;
            this.peA = true;
            this.peC = false;
            this.pes.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            erh().f(this.mId, this.pdL);
            G(this.mId, eqO);
            a(this.mId, this.peF, eqO, 1.0f, true, true);
            return;
        }
        this.pes.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        erh().f(this.mId, this.pdL);
        this.pey.c(0.0f, true);
        this.peA = true;
        this.peC = false;
        this.peF = eqM();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.peF)));
        }
        final String str = this.mId;
        final boolean eqo = this.peF.eqo();
        this.peF.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, eqo);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.eqq(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.pet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            J("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.arP();
            return;
        }
        this.pes.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.peG;
            Drawable drawable = this.mDrawable;
            this.peG = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    J("set_final_result @ onNewResult", t);
                    this.peF = null;
                    this.pey.a(bk, 1.0f, z2);
                    erh().a(str, bj(t), erl());
                } else {
                    J("set_intermediate_result @ onNewResult", t);
                    this.pey.a(bk, f, z2);
                    erh().g(str, (String) bj(t));
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
        this.pes.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.peF = null;
            this.peC = true;
            if (this.peD && this.mDrawable != null) {
                this.pey.a(this.mDrawable, 1.0f, true);
            } else if (erc()) {
                this.pey.C(th);
            } else {
                this.pey.B(th);
            }
            erh().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        erh().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.arP();
        } else if (!z) {
            this.pey.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.peF == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.peF && this.peA;
    }

    private void J(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(paD, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable erl() {
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
        return f.ba(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.peA).bo("hasFetchFailed", this.peC).ca("fetchedImage", bi(this.peG)).E("events", this.pes.toString()).toString();
    }

    protected T eqO() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(String str, T t) {
    }
}
