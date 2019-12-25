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
public abstract class a<T, INFO> implements a.InterfaceC0644a, a.InterfaceC0645a, com.facebook.drawee.d.a {
    private static final Class<?> lCO = a.class;
    private final com.facebook.drawee.components.a lFS;
    private Object lFY;
    private final Executor lGH;
    @Nullable
    private com.facebook.drawee.components.b lGI;
    @Nullable
    private com.facebook.drawee.c.a lGJ;
    @Nullable
    private c<INFO> lGK;
    @Nullable
    private d lGL;
    @Nullable
    private com.facebook.drawee.d.c lGM;
    @Nullable
    private Drawable lGN;
    private boolean lGO;
    private boolean lGP;
    private boolean lGQ;
    private boolean lGR;
    @Nullable
    private String lGS;
    @Nullable
    private com.facebook.datasource.b<T> lGT;
    @Nullable
    private T lGU;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lGG = DraweeEventTracker.djC();
    private boolean lGV = true;

    protected abstract void aX(@Nullable T t);

    @Nullable
    protected abstract INFO aZ(T t);

    protected abstract Drawable ba(T t);

    protected abstract com.facebook.datasource.b<T> djn();

    protected abstract void m(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0646a<INFO> extends e<INFO> {
        private C0646a() {
        }

        public static <INFO> C0646a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0646a<INFO> c0646a = new C0646a<>();
            c0646a.d(cVar);
            c0646a.d(cVar2);
            return c0646a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.lFS = aVar;
        this.lGH = executor;
        B(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, Object obj) {
        B(str, obj);
        this.lGV = false;
    }

    private synchronized void B(String str, Object obj) {
        this.lGG.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lGV && this.lFS != null) {
            this.lFS.b(this);
        }
        this.mIsAttached = false;
        this.lGP = false;
        djF();
        this.lGR = false;
        if (this.lGI != null) {
            this.lGI.init();
        }
        if (this.lGJ != null) {
            this.lGJ.init();
            this.lGJ.a(this);
        }
        if (this.lGK instanceof C0646a) {
            ((C0646a) this.lGK).djY();
        } else {
            this.lGK = null;
        }
        this.lGL = null;
        if (this.lGM != null) {
            this.lGM.reset();
            this.lGM.n(null);
            this.lGM = null;
        }
        this.lGN = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lFY = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0645a
    public void release() {
        this.lGG.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lGI != null) {
            this.lGI.reset();
        }
        if (this.lGJ != null) {
            this.lGJ.reset();
        }
        if (this.lGM != null) {
            this.lGM.reset();
        }
        djF();
    }

    private void djF() {
        boolean z = this.lGO;
        this.lGO = false;
        this.lGQ = false;
        if (this.lGT != null) {
            this.lGT.LR();
            this.lGT = null;
        }
        if (this.mDrawable != null) {
            m(this.mDrawable);
        }
        if (this.lGS != null) {
            this.lGS = null;
        }
        this.mDrawable = null;
        if (this.lGU != null) {
            C("release", this.lGU);
            aX(this.lGU);
            this.lGU = null;
        }
        if (z) {
            djI().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b djG() {
        if (this.lGI == null) {
            this.lGI = new com.facebook.drawee.components.b();
        }
        return this.lGI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a djH() {
        return this.lGJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lGJ = aVar;
        if (this.lGJ != null) {
            this.lGJ.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uQ(boolean z) {
        this.lGR = z;
    }

    public void OC(@Nullable String str) {
        this.lGS = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lGK instanceof C0646a) {
            ((C0646a) this.lGK).d(cVar);
        } else if (this.lGK != null) {
            this.lGK = C0646a.a(this.lGK, cVar);
        } else {
            this.lGK = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lGK instanceof C0646a) {
            ((C0646a) this.lGK).e(cVar);
        } else if (this.lGK == cVar) {
            this.lGK = null;
        }
    }

    protected c<INFO> djI() {
        return this.lGK == null ? b.getNoOpListener() : this.lGK;
    }

    public void a(@Nullable d dVar) {
        this.lGL = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lGM;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lGG.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lGO) {
            this.lFS.b(this);
            release();
        }
        if (this.lGM != null) {
            this.lGM.n(null);
            this.lGM = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lGM = (com.facebook.drawee.d.c) bVar;
            this.lGM.n(this.lGN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
        this.lGN = drawable;
        if (this.lGM != null) {
            this.lGM.n(this.lGN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable djJ() {
        return this.lGN;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lGO ? "request already submitted" : "request needs submit");
        }
        this.lGG.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lGM);
        this.lFS.b(this);
        this.mIsAttached = true;
        if (!this.lGO) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lGG.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lFS.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lGJ == null) {
            return false;
        }
        if (this.lGJ.dkO() || djK()) {
            this.lGJ.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean djK() {
        return djD();
    }

    private boolean djD() {
        return this.lGQ && this.lGI != null && this.lGI.djD();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0644a
    public boolean djL() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (djD()) {
            this.lGI.djE();
            this.lGM.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T djp = djp();
        if (djp != null) {
            this.lGT = null;
            this.lGO = true;
            this.lGQ = false;
            this.lGG.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            djI().onSubmit(this.mId, this.lFY);
            z(this.mId, djp);
            a(this.mId, this.lGT, djp, 1.0f, true, true);
            return;
        }
        this.lGG.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        djI().onSubmit(this.mId, this.lFY);
        this.lGM.c(0.0f, true);
        this.lGO = true;
        this.lGQ = false;
        this.lGT = djn();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lGT)));
        }
        final String str = this.mId;
        final boolean diN = this.lGT.diN();
        this.lGT.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, diN);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.diP(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lGH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            C("ignore_old_datasource @ onNewResult", t);
            aX(t);
            bVar.LR();
            return;
        }
        this.lGG.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ba = ba(t);
            T t2 = this.lGU;
            Drawable drawable = this.mDrawable;
            this.lGU = t;
            this.mDrawable = ba;
            try {
                if (z) {
                    C("set_final_result @ onNewResult", t);
                    this.lGT = null;
                    this.lGM.a(ba, 1.0f, z2);
                    djI().onFinalImageSet(str, aZ(t), djM());
                } else {
                    C("set_intermediate_result @ onNewResult", t);
                    this.lGM.a(ba, f, z2);
                    djI().onIntermediateImageSet(str, aZ(t));
                }
                if (drawable != null && drawable != ba) {
                    m(drawable);
                }
                if (t2 != null && t2 != t) {
                    C("release_previous_result @ onNewResult", t2);
                    aX(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != ba) {
                    m(drawable);
                }
                if (t2 != null && t2 != t) {
                    C("release_previous_result @ onNewResult", t2);
                    aX(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            C("drawable_failed @ onNewResult", t);
            aX(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onFailure", th);
            bVar.LR();
            return;
        }
        this.lGG.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            h("final_failed @ onFailure", th);
            this.lGT = null;
            this.lGQ = true;
            if (this.lGR && this.mDrawable != null) {
                this.lGM.a(this.mDrawable, 1.0f, true);
            } else if (djD()) {
                this.lGM.B(th);
            } else {
                this.lGM.A(th);
            }
            djI().onFailure(this.mId, th);
            return;
        }
        h("intermediate_failed @ onFailure", th);
        djI().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onProgress", null);
            bVar.LR();
        } else if (!z) {
            this.lGM.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lGT == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lGT && this.lGO;
    }

    private void C(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lCO, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bc(t), Integer.valueOf(aY(t)));
        }
    }

    private void h(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable djM() {
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
        return f.aQ(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lGO).aK("hasFetchFailed", this.lGQ).bH("fetchedImage", aY(this.lGU)).x("events", this.lGG.toString()).toString();
    }

    protected T djp() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, T t) {
    }
}
