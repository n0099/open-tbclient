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
public abstract class a<T, INFO> implements a.InterfaceC1020a, a.InterfaceC1021a, com.facebook.drawee.d.a {
    private static final Class<?> prQ = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a puN;
    private Object puT;
    private final Executor pvB;
    @Nullable
    private com.facebook.drawee.components.b pvC;
    @Nullable
    private com.facebook.drawee.c.a pvD;
    @Nullable
    private c<INFO> pvE;
    @Nullable
    private d pvF;
    @Nullable
    private com.facebook.drawee.d.c pvG;
    @Nullable
    private Drawable pvH;
    private boolean pvI;
    private boolean pvJ;
    private boolean pvK;
    private boolean pvL;
    @Nullable
    private String pvM;
    @Nullable
    private com.facebook.datasource.b<T> pvN;
    @Nullable
    private T pvO;
    private final DraweeEventTracker pvA = DraweeEventTracker.eve();
    private boolean pvP = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> euP();

    protected abstract void t(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1022a<INFO> extends e<INFO> {
        private C1022a() {
        }

        public static <INFO> C1022a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C1022a<INFO> c1022a = new C1022a<>();
            c1022a.d(cVar);
            c1022a.d(cVar2);
            return c1022a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.puN = aVar;
        this.pvB = executor;
        M(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str, Object obj) {
        M(str, obj);
        this.pvP = false;
    }

    private synchronized void M(String str, Object obj) {
        this.pvA.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.pvP && this.puN != null) {
            this.puN.b(this);
        }
        this.mIsAttached = false;
        this.pvJ = false;
        evh();
        this.pvL = false;
        if (this.pvC != null) {
            this.pvC.init();
        }
        if (this.pvD != null) {
            this.pvD.init();
            this.pvD.a(this);
        }
        if (this.pvE instanceof C1022a) {
            ((C1022a) this.pvE).evB();
        } else {
            this.pvE = null;
        }
        this.pvF = null;
        if (this.pvG != null) {
            this.pvG.reset();
            this.pvG.u(null);
            this.pvG = null;
        }
        this.pvH = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.puT = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC1021a
    public void release() {
        this.pvA.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.pvC != null) {
            this.pvC.reset();
        }
        if (this.pvD != null) {
            this.pvD.reset();
        }
        if (this.pvG != null) {
            this.pvG.reset();
        }
        evh();
    }

    private void evh() {
        boolean z = this.pvI;
        this.pvI = false;
        this.pvK = false;
        if (this.pvN != null) {
            this.pvN.ath();
            this.pvN = null;
        }
        if (this.mDrawable != null) {
            t(this.mDrawable);
        }
        if (this.pvM != null) {
            this.pvM = null;
        }
        this.mDrawable = null;
        if (this.pvO != null) {
            N("release", this.pvO);
            bh(this.pvO);
            this.pvO = null;
        }
        if (z) {
            evk().hm(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b evi() {
        if (this.pvC == null) {
            this.pvC = new com.facebook.drawee.components.b();
        }
        return this.pvC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a evj() {
        return this.pvD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pvD = aVar;
        if (this.pvD != null) {
            this.pvD.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AW(boolean z) {
        this.pvL = z;
    }

    public void Zz(@Nullable String str) {
        this.pvM = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pvE instanceof C1022a) {
            ((C1022a) this.pvE).d(cVar);
        } else if (this.pvE != null) {
            this.pvE = C1022a.a(this.pvE, cVar);
        } else {
            this.pvE = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pvE instanceof C1022a) {
            ((C1022a) this.pvE).e(cVar);
        } else if (this.pvE == cVar) {
            this.pvE = null;
        }
    }

    protected c<INFO> evk() {
        return this.pvE == null ? b.evA() : this.pvE;
    }

    public void a(@Nullable d dVar) {
        this.pvF = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.pvG;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.pvA.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.pvI) {
            this.puN.b(this);
            release();
        }
        if (this.pvG != null) {
            this.pvG.u(null);
            this.pvG = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.pvG = (com.facebook.drawee.d.c) bVar;
            this.pvG.u(this.pvH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@Nullable Drawable drawable) {
        this.pvH = drawable;
        if (this.pvG != null) {
            this.pvG.u(this.pvH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable evl() {
        return this.pvH;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.pvI ? "request already submitted" : "request needs submit");
        }
        this.pvA.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.pvG);
        this.puN.b(this);
        this.mIsAttached = true;
        if (!this.pvI) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.pvA.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.puN.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pvD == null) {
            return false;
        }
        if (this.pvD.ewq() || evm()) {
            this.pvD.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean evm() {
        return evf();
    }

    private boolean evf() {
        return this.pvK && this.pvC != null && this.pvC.evf();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC1020a
    public boolean evn() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (evf()) {
            this.pvC.evg();
            this.pvG.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T euR = euR();
        if (euR != null) {
            this.pvN = null;
            this.pvI = true;
            this.pvK = false;
            this.pvA.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            evk().f(this.mId, this.puT);
            K(this.mId, euR);
            a(this.mId, this.pvN, euR, 1.0f, true, true);
            return;
        }
        this.pvA.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        evk().f(this.mId, this.puT);
        this.pvG.d(0.0f, true);
        this.pvI = true;
        this.pvK = false;
        this.pvN = euP();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.pvN)));
        }
        final String str = this.mId;
        final boolean eur = this.pvN.eur();
        this.pvN.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, eur);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.eut(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.pvB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            N("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.ath();
            return;
        }
        this.pvA.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.pvO;
            Drawable drawable = this.mDrawable;
            this.pvO = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    N("set_final_result @ onNewResult", t);
                    this.pvN = null;
                    this.pvG.a(bk, 1.0f, z2);
                    evk().a(str, bj(t), evo());
                } else {
                    N("set_intermediate_result @ onNewResult", t);
                    this.pvG.a(bk, f, z2);
                    evk().g(str, (String) bj(t));
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
            bVar.ath();
            return;
        }
        this.pvA.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.pvN = null;
            this.pvK = true;
            if (this.pvL && this.mDrawable != null) {
                this.pvG.a(this.mDrawable, 1.0f, true);
            } else if (evf()) {
                this.pvG.B(th);
            } else {
                this.pvG.A(th);
            }
            evk().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        evk().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.ath();
        } else if (!z) {
            this.pvG.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.pvN == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.pvN && this.pvI;
    }

    private void N(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(prQ, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(prQ, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable evo() {
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
        return f.bb(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.pvI).bo("hasFetchFailed", this.pvK).cj("fetchedImage", bi(this.pvO)).I("events", this.pvA.toString()).toString();
    }

    protected T euR() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(String str, T t) {
    }
}
