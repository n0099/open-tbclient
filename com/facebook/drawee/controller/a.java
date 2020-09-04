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
    private static final Class<?> njM = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a nmP;
    private Object nmV;
    private final Executor nnD;
    @Nullable
    private com.facebook.drawee.components.b nnE;
    @Nullable
    private com.facebook.drawee.c.a nnF;
    @Nullable
    private c<INFO> nnG;
    @Nullable
    private d nnH;
    @Nullable
    private com.facebook.drawee.d.c nnI;
    @Nullable
    private Drawable nnJ;
    private boolean nnK;
    private boolean nnL;
    private boolean nnM;
    private boolean nnN;
    @Nullable
    private String nnO;
    @Nullable
    private com.facebook.datasource.b<T> nnP;
    @Nullable
    private T nnQ;
    private final DraweeEventTracker nnC = DraweeEventTracker.dPS();
    private boolean nnR = true;

    protected abstract void aX(@Nullable T t);

    @Nullable
    protected abstract INFO aZ(T t);

    protected abstract Drawable ba(T t);

    protected abstract com.facebook.datasource.b<T> dPD();

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
        this.nmP = aVar;
        this.nnD = executor;
        I(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, Object obj) {
        I(str, obj);
        this.nnR = false;
    }

    private synchronized void I(String str, Object obj) {
        this.nnC.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.nnR && this.nmP != null) {
            this.nmP.b(this);
        }
        this.mIsAttached = false;
        this.nnL = false;
        dPV();
        this.nnN = false;
        if (this.nnE != null) {
            this.nnE.init();
        }
        if (this.nnF != null) {
            this.nnF.init();
            this.nnF.a(this);
        }
        if (this.nnG instanceof C0867a) {
            ((C0867a) this.nnG).dQp();
        } else {
            this.nnG = null;
        }
        this.nnH = null;
        if (this.nnI != null) {
            this.nnI.reset();
            this.nnI.j(null);
            this.nnI = null;
        }
        this.nnJ = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.nmV = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0866a
    public void release() {
        this.nnC.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.nnE != null) {
            this.nnE.reset();
        }
        if (this.nnF != null) {
            this.nnF.reset();
        }
        if (this.nnI != null) {
            this.nnI.reset();
        }
        dPV();
    }

    private void dPV() {
        boolean z = this.nnK;
        this.nnK = false;
        this.nnM = false;
        if (this.nnP != null) {
            this.nnP.ahA();
            this.nnP = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.nnO != null) {
            this.nnO = null;
        }
        this.mDrawable = null;
        if (this.nnQ != null) {
            J("release", this.nnQ);
            aX(this.nnQ);
            this.nnQ = null;
        }
        if (z) {
            dPY().gw(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dPW() {
        if (this.nnE == null) {
            this.nnE = new com.facebook.drawee.components.b();
        }
        return this.nnE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dPX() {
        return this.nnF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.nnF = aVar;
        if (this.nnF != null) {
            this.nnF.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xU(boolean z) {
        this.nnN = z;
    }

    public void UB(@Nullable String str) {
        this.nnO = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nnG instanceof C0867a) {
            ((C0867a) this.nnG).d(cVar);
        } else if (this.nnG != null) {
            this.nnG = C0867a.a(this.nnG, cVar);
        } else {
            this.nnG = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nnG instanceof C0867a) {
            ((C0867a) this.nnG).e(cVar);
        } else if (this.nnG == cVar) {
            this.nnG = null;
        }
    }

    protected c<INFO> dPY() {
        return this.nnG == null ? b.dQo() : this.nnG;
    }

    public void a(@Nullable d dVar) {
        this.nnH = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.nnI;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.nnC.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.nnK) {
            this.nmP.b(this);
            release();
        }
        if (this.nnI != null) {
            this.nnI.j(null);
            this.nnI = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.nnI = (com.facebook.drawee.d.c) bVar;
            this.nnI.j(this.nnJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.nnJ = drawable;
        if (this.nnI != null) {
            this.nnI.j(this.nnJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dPZ() {
        return this.nnJ;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.nnK ? "request already submitted" : "request needs submit");
        }
        this.nnC.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.nnI);
        this.nmP.b(this);
        this.mIsAttached = true;
        if (!this.nnK) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.nnC.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.nmP.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.nnF == null) {
            return false;
        }
        if (this.nnF.dRe() || dQa()) {
            this.nnF.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dQa() {
        return dPT();
    }

    private boolean dPT() {
        return this.nnM && this.nnE != null && this.nnE.dPT();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0865a
    public boolean dQb() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dPT()) {
            this.nnE.dPU();
            this.nnI.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dPF = dPF();
        if (dPF != null) {
            this.nnP = null;
            this.nnK = true;
            this.nnM = false;
            this.nnC.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dPY().g(this.mId, this.nmV);
            G(this.mId, dPF);
            a(this.mId, this.nnP, dPF, 1.0f, true, true);
            return;
        }
        this.nnC.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dPY().g(this.mId, this.nmV);
        this.nnI.c(0.0f, true);
        this.nnK = true;
        this.nnM = false;
        this.nnP = dPD();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.nnP)));
        }
        final String str = this.mId;
        final boolean dPf = this.nnP.dPf();
        this.nnP.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dPf);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dPh(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.nnD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            J("ignore_old_datasource @ onNewResult", t);
            aX(t);
            bVar.ahA();
            return;
        }
        this.nnC.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ba = ba(t);
            T t2 = this.nnQ;
            Drawable drawable = this.mDrawable;
            this.nnQ = t;
            this.mDrawable = ba;
            try {
                if (z) {
                    J("set_final_result @ onNewResult", t);
                    this.nnP = null;
                    this.nnI.a(ba, 1.0f, z2);
                    dPY().a(str, aZ(t), dQc());
                } else {
                    J("set_intermediate_result @ onNewResult", t);
                    this.nnI.a(ba, f, z2);
                    dPY().h(str, (String) aZ(t));
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
        this.nnC.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.nnP = null;
            this.nnM = true;
            if (this.nnN && this.mDrawable != null) {
                this.nnI.a(this.mDrawable, 1.0f, true);
            } else if (dPT()) {
                this.nnI.C(th);
            } else {
                this.nnI.B(th);
            }
            dPY().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dPY().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.ahA();
        } else if (!z) {
            this.nnI.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.nnP == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.nnP && this.nnK;
    }

    private void J(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(njM, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bc(t), Integer.valueOf(aY(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(njM, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dQc() {
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
        return f.aQ(this).ba("isAttached", this.mIsAttached).ba("isRequestSubmitted", this.nnK).ba("hasFetchFailed", this.nnM).bP("fetchedImage", aY(this.nnQ)).E("events", this.nnC.toString()).toString();
    }

    protected T dPF() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(String str, T t) {
    }
}
