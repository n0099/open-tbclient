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
/* loaded from: classes13.dex */
public abstract class a<T, INFO> implements a.InterfaceC0657a, a.InterfaceC0658a, com.facebook.drawee.d.a {
    private static final Class<?> lGY = a.class;
    private final Executor lKR;
    @Nullable
    private com.facebook.drawee.components.b lKS;
    @Nullable
    private com.facebook.drawee.c.a lKT;
    @Nullable
    private c<INFO> lKU;
    @Nullable
    private d lKV;
    @Nullable
    private com.facebook.drawee.d.c lKW;
    @Nullable
    private Drawable lKX;
    private boolean lKY;
    private boolean lKZ;
    private final com.facebook.drawee.components.a lKc;
    private Object lKi;
    private boolean lLa;
    private boolean lLb;
    @Nullable
    private String lLc;
    @Nullable
    private com.facebook.datasource.b<T> lLd;
    @Nullable
    private T lLe;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lKQ = DraweeEventTracker.dlS();
    private boolean lLf = true;

    protected abstract void aZ(@Nullable T t);

    @Nullable
    protected abstract INFO bb(T t);

    protected abstract Drawable bc(T t);

    protected abstract com.facebook.datasource.b<T> dlD();

    protected abstract void m(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0659a<INFO> extends e<INFO> {
        private C0659a() {
        }

        public static <INFO> C0659a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0659a<INFO> c0659a = new C0659a<>();
            c0659a.d(cVar);
            c0659a.d(cVar2);
            return c0659a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.lKc = aVar;
        this.lKR = executor;
        B(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, Object obj) {
        B(str, obj);
        this.lLf = false;
    }

    private synchronized void B(String str, Object obj) {
        this.lKQ.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lLf && this.lKc != null) {
            this.lKc.b(this);
        }
        this.mIsAttached = false;
        this.lKZ = false;
        dlV();
        this.lLb = false;
        if (this.lKS != null) {
            this.lKS.init();
        }
        if (this.lKT != null) {
            this.lKT.init();
            this.lKT.a(this);
        }
        if (this.lKU instanceof C0659a) {
            ((C0659a) this.lKU).dmo();
        } else {
            this.lKU = null;
        }
        this.lKV = null;
        if (this.lKW != null) {
            this.lKW.reset();
            this.lKW.n(null);
            this.lKW = null;
        }
        this.lKX = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lKi = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0658a
    public void release() {
        this.lKQ.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lKS != null) {
            this.lKS.reset();
        }
        if (this.lKT != null) {
            this.lKT.reset();
        }
        if (this.lKW != null) {
            this.lKW.reset();
        }
        dlV();
    }

    private void dlV() {
        boolean z = this.lKY;
        this.lKY = false;
        this.lLa = false;
        if (this.lLd != null) {
            this.lLd.OB();
            this.lLd = null;
        }
        if (this.mDrawable != null) {
            m(this.mDrawable);
        }
        if (this.lLc != null) {
            this.lLc = null;
        }
        this.mDrawable = null;
        if (this.lLe != null) {
            C("release", this.lLe);
            aZ(this.lLe);
            this.lLe = null;
        }
        if (z) {
            dlY().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dlW() {
        if (this.lKS == null) {
            this.lKS = new com.facebook.drawee.components.b();
        }
        return this.lKS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dlX() {
        return this.lKT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lKT = aVar;
        if (this.lKT != null) {
            this.lKT.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vf(boolean z) {
        this.lLb = z;
    }

    public void OZ(@Nullable String str) {
        this.lLc = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKU instanceof C0659a) {
            ((C0659a) this.lKU).d(cVar);
        } else if (this.lKU != null) {
            this.lKU = C0659a.a(this.lKU, cVar);
        } else {
            this.lKU = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKU instanceof C0659a) {
            ((C0659a) this.lKU).e(cVar);
        } else if (this.lKU == cVar) {
            this.lKU = null;
        }
    }

    protected c<INFO> dlY() {
        return this.lKU == null ? b.getNoOpListener() : this.lKU;
    }

    public void a(@Nullable d dVar) {
        this.lKV = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lKW;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lKQ.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lKY) {
            this.lKc.b(this);
            release();
        }
        if (this.lKW != null) {
            this.lKW.n(null);
            this.lKW = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lKW = (com.facebook.drawee.d.c) bVar;
            this.lKW.n(this.lKX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
        this.lKX = drawable;
        if (this.lKW != null) {
            this.lKW.n(this.lKX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dlZ() {
        return this.lKX;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lKY ? "request already submitted" : "request needs submit");
        }
        this.lKQ.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lKW);
        this.lKc.b(this);
        this.mIsAttached = true;
        if (!this.lKY) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lKQ.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lKc.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lKT == null) {
            return false;
        }
        if (this.lKT.dne() || dma()) {
            this.lKT.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dma() {
        return dlT();
    }

    private boolean dlT() {
        return this.lLa && this.lKS != null && this.lKS.dlT();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0657a
    public boolean dmb() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dlT()) {
            this.lKS.dlU();
            this.lKW.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dlF = dlF();
        if (dlF != null) {
            this.lLd = null;
            this.lKY = true;
            this.lLa = false;
            this.lKQ.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dlY().onSubmit(this.mId, this.lKi);
            z(this.mId, dlF);
            a(this.mId, this.lLd, dlF, 1.0f, true, true);
            return;
        }
        this.lKQ.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dlY().onSubmit(this.mId, this.lKi);
        this.lKW.c(0.0f, true);
        this.lKY = true;
        this.lLa = false;
        this.lLd = dlD();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lLd)));
        }
        final String str = this.mId;
        final boolean dld = this.lLd.dld();
        this.lLd.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dld);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dlf(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lKR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            C("ignore_old_datasource @ onNewResult", t);
            aZ(t);
            bVar.OB();
            return;
        }
        this.lKQ.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bc = bc(t);
            T t2 = this.lLe;
            Drawable drawable = this.mDrawable;
            this.lLe = t;
            this.mDrawable = bc;
            try {
                if (z) {
                    C("set_final_result @ onNewResult", t);
                    this.lLd = null;
                    this.lKW.a(bc, 1.0f, z2);
                    dlY().onFinalImageSet(str, bb(t), dmc());
                } else {
                    C("set_intermediate_result @ onNewResult", t);
                    this.lKW.a(bc, f, z2);
                    dlY().onIntermediateImageSet(str, bb(t));
                }
                if (drawable != null && drawable != bc) {
                    m(drawable);
                }
                if (t2 != null && t2 != t) {
                    C("release_previous_result @ onNewResult", t2);
                    aZ(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bc) {
                    m(drawable);
                }
                if (t2 != null && t2 != t) {
                    C("release_previous_result @ onNewResult", t2);
                    aZ(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            C("drawable_failed @ onNewResult", t);
            aZ(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onFailure", th);
            bVar.OB();
            return;
        }
        this.lKQ.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            h("final_failed @ onFailure", th);
            this.lLd = null;
            this.lLa = true;
            if (this.lLb && this.mDrawable != null) {
                this.lKW.a(this.mDrawable, 1.0f, true);
            } else if (dlT()) {
                this.lKW.A(th);
            } else {
                this.lKW.z(th);
            }
            dlY().onFailure(this.mId, th);
            return;
        }
        h("intermediate_failed @ onFailure", th);
        dlY().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onProgress", null);
            bVar.OB();
        } else if (!z) {
            this.lKW.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lLd == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lLd && this.lKY;
    }

    private void C(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lGY, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, be(t), Integer.valueOf(ba(t)));
        }
    }

    private void h(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGY, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable dmc() {
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
        return f.aS(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lKY).aK("hasFetchFailed", this.lLa).bH("fetchedImage", ba(this.lLe)).x("events", this.lKQ.toString()).toString();
    }

    protected T dlF() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, T t) {
    }
}
