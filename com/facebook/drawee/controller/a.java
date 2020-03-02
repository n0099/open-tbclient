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
    private static final Class<?> lHa = a.class;
    private final Executor lKT;
    @Nullable
    private com.facebook.drawee.components.b lKU;
    @Nullable
    private com.facebook.drawee.c.a lKV;
    @Nullable
    private c<INFO> lKW;
    @Nullable
    private d lKX;
    @Nullable
    private com.facebook.drawee.d.c lKY;
    @Nullable
    private Drawable lKZ;
    private final com.facebook.drawee.components.a lKe;
    private Object lKk;
    private boolean lLa;
    private boolean lLb;
    private boolean lLc;
    private boolean lLd;
    @Nullable
    private String lLe;
    @Nullable
    private com.facebook.datasource.b<T> lLf;
    @Nullable
    private T lLg;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lKS = DraweeEventTracker.dlU();
    private boolean lLh = true;

    protected abstract void aZ(@Nullable T t);

    @Nullable
    protected abstract INFO bb(T t);

    protected abstract Drawable bc(T t);

    protected abstract com.facebook.datasource.b<T> dlF();

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
        this.lKe = aVar;
        this.lKT = executor;
        B(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, Object obj) {
        B(str, obj);
        this.lLh = false;
    }

    private synchronized void B(String str, Object obj) {
        this.lKS.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lLh && this.lKe != null) {
            this.lKe.b(this);
        }
        this.mIsAttached = false;
        this.lLb = false;
        dlX();
        this.lLd = false;
        if (this.lKU != null) {
            this.lKU.init();
        }
        if (this.lKV != null) {
            this.lKV.init();
            this.lKV.a(this);
        }
        if (this.lKW instanceof C0659a) {
            ((C0659a) this.lKW).dmq();
        } else {
            this.lKW = null;
        }
        this.lKX = null;
        if (this.lKY != null) {
            this.lKY.reset();
            this.lKY.n(null);
            this.lKY = null;
        }
        this.lKZ = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lKk = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0658a
    public void release() {
        this.lKS.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lKU != null) {
            this.lKU.reset();
        }
        if (this.lKV != null) {
            this.lKV.reset();
        }
        if (this.lKY != null) {
            this.lKY.reset();
        }
        dlX();
    }

    private void dlX() {
        boolean z = this.lLa;
        this.lLa = false;
        this.lLc = false;
        if (this.lLf != null) {
            this.lLf.OD();
            this.lLf = null;
        }
        if (this.mDrawable != null) {
            m(this.mDrawable);
        }
        if (this.lLe != null) {
            this.lLe = null;
        }
        this.mDrawable = null;
        if (this.lLg != null) {
            C("release", this.lLg);
            aZ(this.lLg);
            this.lLg = null;
        }
        if (z) {
            dma().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dlY() {
        if (this.lKU == null) {
            this.lKU = new com.facebook.drawee.components.b();
        }
        return this.lKU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dlZ() {
        return this.lKV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lKV = aVar;
        if (this.lKV != null) {
            this.lKV.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vf(boolean z) {
        this.lLd = z;
    }

    public void OZ(@Nullable String str) {
        this.lLe = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKW instanceof C0659a) {
            ((C0659a) this.lKW).d(cVar);
        } else if (this.lKW != null) {
            this.lKW = C0659a.a(this.lKW, cVar);
        } else {
            this.lKW = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKW instanceof C0659a) {
            ((C0659a) this.lKW).e(cVar);
        } else if (this.lKW == cVar) {
            this.lKW = null;
        }
    }

    protected c<INFO> dma() {
        return this.lKW == null ? b.getNoOpListener() : this.lKW;
    }

    public void a(@Nullable d dVar) {
        this.lKX = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lKY;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lKS.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lLa) {
            this.lKe.b(this);
            release();
        }
        if (this.lKY != null) {
            this.lKY.n(null);
            this.lKY = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lKY = (com.facebook.drawee.d.c) bVar;
            this.lKY.n(this.lKZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
        this.lKZ = drawable;
        if (this.lKY != null) {
            this.lKY.n(this.lKZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dmb() {
        return this.lKZ;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lLa ? "request already submitted" : "request needs submit");
        }
        this.lKS.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lKY);
        this.lKe.b(this);
        this.mIsAttached = true;
        if (!this.lLa) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lKS.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lKe.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lKV == null) {
            return false;
        }
        if (this.lKV.dng() || dmc()) {
            this.lKV.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dmc() {
        return dlV();
    }

    private boolean dlV() {
        return this.lLc && this.lKU != null && this.lKU.dlV();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0657a
    public boolean dmd() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dlV()) {
            this.lKU.dlW();
            this.lKY.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dlH = dlH();
        if (dlH != null) {
            this.lLf = null;
            this.lLa = true;
            this.lLc = false;
            this.lKS.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dma().onSubmit(this.mId, this.lKk);
            z(this.mId, dlH);
            a(this.mId, this.lLf, dlH, 1.0f, true, true);
            return;
        }
        this.lKS.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dma().onSubmit(this.mId, this.lKk);
        this.lKY.c(0.0f, true);
        this.lLa = true;
        this.lLc = false;
        this.lLf = dlF();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lLf)));
        }
        final String str = this.mId;
        final boolean dlf = this.lLf.dlf();
        this.lLf.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dlf);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dlh(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lKT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            C("ignore_old_datasource @ onNewResult", t);
            aZ(t);
            bVar.OD();
            return;
        }
        this.lKS.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bc = bc(t);
            T t2 = this.lLg;
            Drawable drawable = this.mDrawable;
            this.lLg = t;
            this.mDrawable = bc;
            try {
                if (z) {
                    C("set_final_result @ onNewResult", t);
                    this.lLf = null;
                    this.lKY.a(bc, 1.0f, z2);
                    dma().onFinalImageSet(str, bb(t), dme());
                } else {
                    C("set_intermediate_result @ onNewResult", t);
                    this.lKY.a(bc, f, z2);
                    dma().onIntermediateImageSet(str, bb(t));
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
            bVar.OD();
            return;
        }
        this.lKS.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            h("final_failed @ onFailure", th);
            this.lLf = null;
            this.lLc = true;
            if (this.lLd && this.mDrawable != null) {
                this.lKY.a(this.mDrawable, 1.0f, true);
            } else if (dlV()) {
                this.lKY.A(th);
            } else {
                this.lKY.z(th);
            }
            dma().onFailure(this.mId, th);
            return;
        }
        h("intermediate_failed @ onFailure", th);
        dma().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onProgress", null);
            bVar.OD();
        } else if (!z) {
            this.lKY.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lLf == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lLf && this.lLa;
    }

    private void C(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lHa, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, be(t), Integer.valueOf(ba(t)));
        }
    }

    private void h(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHa, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable dme() {
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
        return f.aS(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lLa).aK("hasFetchFailed", this.lLc).bH("fetchedImage", ba(this.lLg)).x("events", this.lKS.toString()).toString();
    }

    protected T dlH() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, T t) {
    }
}
