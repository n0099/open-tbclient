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
/* loaded from: classes11.dex */
public abstract class a<T, INFO> implements a.InterfaceC0862a, a.InterfaceC0863a, com.facebook.drawee.d.a {
    private static final Class<?> ntL = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a nwP;
    private Object nwV;
    private final Executor nxD;
    @Nullable
    private com.facebook.drawee.components.b nxE;
    @Nullable
    private com.facebook.drawee.c.a nxF;
    @Nullable
    private c<INFO> nxG;
    @Nullable
    private d nxH;
    @Nullable
    private com.facebook.drawee.d.c nxI;
    @Nullable
    private Drawable nxJ;
    private boolean nxK;
    private boolean nxL;
    private boolean nxM;
    private boolean nxN;
    @Nullable
    private String nxO;
    @Nullable
    private com.facebook.datasource.b<T> nxP;
    @Nullable
    private T nxQ;
    private final DraweeEventTracker nxC = DraweeEventTracker.dTQ();
    private boolean nxR = true;

    protected abstract void aZ(@Nullable T t);

    @Nullable
    protected abstract INFO bb(T t);

    protected abstract Drawable bc(T t);

    protected abstract com.facebook.datasource.b<T> dTB();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0864a<INFO> extends e<INFO> {
        private C0864a() {
        }

        public static <INFO> C0864a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0864a<INFO> c0864a = new C0864a<>();
            c0864a.d(cVar);
            c0864a.d(cVar2);
            return c0864a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.nwP = aVar;
        this.nxD = executor;
        I(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, Object obj) {
        I(str, obj);
        this.nxR = false;
    }

    private synchronized void I(String str, Object obj) {
        this.nxC.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.nxR && this.nwP != null) {
            this.nwP.b(this);
        }
        this.mIsAttached = false;
        this.nxL = false;
        dTT();
        this.nxN = false;
        if (this.nxE != null) {
            this.nxE.init();
        }
        if (this.nxF != null) {
            this.nxF.init();
            this.nxF.a(this);
        }
        if (this.nxG instanceof C0864a) {
            ((C0864a) this.nxG).dUn();
        } else {
            this.nxG = null;
        }
        this.nxH = null;
        if (this.nxI != null) {
            this.nxI.reset();
            this.nxI.j(null);
            this.nxI = null;
        }
        this.nxJ = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.nwV = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0863a
    public void release() {
        this.nxC.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.nxE != null) {
            this.nxE.reset();
        }
        if (this.nxF != null) {
            this.nxF.reset();
        }
        if (this.nxI != null) {
            this.nxI.reset();
        }
        dTT();
    }

    private void dTT() {
        boolean z = this.nxK;
        this.nxK = false;
        this.nxM = false;
        if (this.nxP != null) {
            this.nxP.aik();
            this.nxP = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.nxO != null) {
            this.nxO = null;
        }
        this.mDrawable = null;
        if (this.nxQ != null) {
            J("release", this.nxQ);
            aZ(this.nxQ);
            this.nxQ = null;
        }
        if (z) {
            dTW().gG(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dTU() {
        if (this.nxE == null) {
            this.nxE = new com.facebook.drawee.components.b();
        }
        return this.nxE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dTV() {
        return this.nxF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.nxF = aVar;
        if (this.nxF != null) {
            this.nxF.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yd(boolean z) {
        this.nxN = z;
    }

    public void Vd(@Nullable String str) {
        this.nxO = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nxG instanceof C0864a) {
            ((C0864a) this.nxG).d(cVar);
        } else if (this.nxG != null) {
            this.nxG = C0864a.a(this.nxG, cVar);
        } else {
            this.nxG = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nxG instanceof C0864a) {
            ((C0864a) this.nxG).e(cVar);
        } else if (this.nxG == cVar) {
            this.nxG = null;
        }
    }

    protected c<INFO> dTW() {
        return this.nxG == null ? b.dUm() : this.nxG;
    }

    public void a(@Nullable d dVar) {
        this.nxH = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.nxI;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.nxC.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.nxK) {
            this.nwP.b(this);
            release();
        }
        if (this.nxI != null) {
            this.nxI.j(null);
            this.nxI = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.nxI = (com.facebook.drawee.d.c) bVar;
            this.nxI.j(this.nxJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.nxJ = drawable;
        if (this.nxI != null) {
            this.nxI.j(this.nxJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dTX() {
        return this.nxJ;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.nxK ? "request already submitted" : "request needs submit");
        }
        this.nxC.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.nxI);
        this.nwP.b(this);
        this.mIsAttached = true;
        if (!this.nxK) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.nxC.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.nwP.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.nxF == null) {
            return false;
        }
        if (this.nxF.dVc() || dTY()) {
            this.nxF.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dTY() {
        return dTR();
    }

    private boolean dTR() {
        return this.nxM && this.nxE != null && this.nxE.dTR();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0862a
    public boolean dTZ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dTR()) {
            this.nxE.dTS();
            this.nxI.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dTD = dTD();
        if (dTD != null) {
            this.nxP = null;
            this.nxK = true;
            this.nxM = false;
            this.nxC.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dTW().g(this.mId, this.nwV);
            G(this.mId, dTD);
            a(this.mId, this.nxP, dTD, 1.0f, true, true);
            return;
        }
        this.nxC.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dTW().g(this.mId, this.nwV);
        this.nxI.c(0.0f, true);
        this.nxK = true;
        this.nxM = false;
        this.nxP = dTB();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.nxP)));
        }
        final String str = this.mId;
        final boolean dTd = this.nxP.dTd();
        this.nxP.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dTd);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dTf(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.nxD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            J("ignore_old_datasource @ onNewResult", t);
            aZ(t);
            bVar.aik();
            return;
        }
        this.nxC.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bc = bc(t);
            T t2 = this.nxQ;
            Drawable drawable = this.mDrawable;
            this.nxQ = t;
            this.mDrawable = bc;
            try {
                if (z) {
                    J("set_final_result @ onNewResult", t);
                    this.nxP = null;
                    this.nxI.a(bc, 1.0f, z2);
                    dTW().a(str, bb(t), dUa());
                } else {
                    J("set_intermediate_result @ onNewResult", t);
                    this.nxI.a(bc, f, z2);
                    dTW().h(str, (String) bb(t));
                }
                if (drawable != null && drawable != bc) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    J("release_previous_result @ onNewResult", t2);
                    aZ(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bc) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    J("release_previous_result @ onNewResult", t2);
                    aZ(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            J("drawable_failed @ onNewResult", t);
            aZ(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.aik();
            return;
        }
        this.nxC.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.nxP = null;
            this.nxM = true;
            if (this.nxN && this.mDrawable != null) {
                this.nxI.a(this.mDrawable, 1.0f, true);
            } else if (dTR()) {
                this.nxI.C(th);
            } else {
                this.nxI.B(th);
            }
            dTW().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dTW().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.aik();
        } else if (!z) {
            this.nxI.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.nxP == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.nxP && this.nxK;
    }

    private void J(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(ntL, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, be(t), Integer.valueOf(ba(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ntL, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dUa() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String be(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int ba(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aS(this).bb("isAttached", this.mIsAttached).bb("isRequestSubmitted", this.nxK).bb("hasFetchFailed", this.nxM).bP("fetchedImage", ba(this.nxQ)).E("events", this.nxC.toString()).toString();
    }

    protected T dTD() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(String str, T t) {
    }
}
