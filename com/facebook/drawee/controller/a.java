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
public abstract class a<T, INFO> implements a.InterfaceC0658a, a.InterfaceC0659a, com.facebook.drawee.d.a {
    private static final Class<?> lIR = a.class;
    private final com.facebook.drawee.components.a lLV;
    private final Executor lMK;
    @Nullable
    private com.facebook.drawee.components.b lML;
    @Nullable
    private com.facebook.drawee.c.a lMM;
    @Nullable
    private c<INFO> lMN;
    @Nullable
    private d lMO;
    @Nullable
    private com.facebook.drawee.d.c lMP;
    @Nullable
    private Drawable lMQ;
    private boolean lMR;
    private boolean lMS;
    private boolean lMT;
    private boolean lMU;
    @Nullable
    private String lMV;
    @Nullable
    private com.facebook.datasource.b<T> lMW;
    @Nullable
    private T lMX;
    private Object lMb;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lMJ = DraweeEventTracker.dms();
    private boolean lMY = true;

    protected abstract void aZ(@Nullable T t);

    @Nullable
    protected abstract INFO bb(T t);

    protected abstract Drawable bc(T t);

    protected abstract com.facebook.datasource.b<T> dmd();

    protected abstract void m(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0660a<INFO> extends e<INFO> {
        private C0660a() {
        }

        public static <INFO> C0660a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0660a<INFO> c0660a = new C0660a<>();
            c0660a.d(cVar);
            c0660a.d(cVar2);
            return c0660a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.lLV = aVar;
        this.lMK = executor;
        B(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, Object obj) {
        B(str, obj);
        this.lMY = false;
    }

    private synchronized void B(String str, Object obj) {
        this.lMJ.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lMY && this.lLV != null) {
            this.lLV.b(this);
        }
        this.mIsAttached = false;
        this.lMS = false;
        dmv();
        this.lMU = false;
        if (this.lML != null) {
            this.lML.init();
        }
        if (this.lMM != null) {
            this.lMM.init();
            this.lMM.a(this);
        }
        if (this.lMN instanceof C0660a) {
            ((C0660a) this.lMN).dmO();
        } else {
            this.lMN = null;
        }
        this.lMO = null;
        if (this.lMP != null) {
            this.lMP.reset();
            this.lMP.n(null);
            this.lMP = null;
        }
        this.lMQ = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lMb = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0659a
    public void release() {
        this.lMJ.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lML != null) {
            this.lML.reset();
        }
        if (this.lMM != null) {
            this.lMM.reset();
        }
        if (this.lMP != null) {
            this.lMP.reset();
        }
        dmv();
    }

    private void dmv() {
        boolean z = this.lMR;
        this.lMR = false;
        this.lMT = false;
        if (this.lMW != null) {
            this.lMW.OG();
            this.lMW = null;
        }
        if (this.mDrawable != null) {
            m(this.mDrawable);
        }
        if (this.lMV != null) {
            this.lMV = null;
        }
        this.mDrawable = null;
        if (this.lMX != null) {
            C("release", this.lMX);
            aZ(this.lMX);
            this.lMX = null;
        }
        if (z) {
            dmy().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dmw() {
        if (this.lML == null) {
            this.lML = new com.facebook.drawee.components.b();
        }
        return this.lML;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dmx() {
        return this.lMM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lMM = aVar;
        if (this.lMM != null) {
            this.lMM.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vm(boolean z) {
        this.lMU = z;
    }

    public void OZ(@Nullable String str) {
        this.lMV = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lMN instanceof C0660a) {
            ((C0660a) this.lMN).d(cVar);
        } else if (this.lMN != null) {
            this.lMN = C0660a.a(this.lMN, cVar);
        } else {
            this.lMN = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lMN instanceof C0660a) {
            ((C0660a) this.lMN).e(cVar);
        } else if (this.lMN == cVar) {
            this.lMN = null;
        }
    }

    protected c<INFO> dmy() {
        return this.lMN == null ? b.getNoOpListener() : this.lMN;
    }

    public void a(@Nullable d dVar) {
        this.lMO = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lMP;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lMJ.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lMR) {
            this.lLV.b(this);
            release();
        }
        if (this.lMP != null) {
            this.lMP.n(null);
            this.lMP = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lMP = (com.facebook.drawee.d.c) bVar;
            this.lMP.n(this.lMQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
        this.lMQ = drawable;
        if (this.lMP != null) {
            this.lMP.n(this.lMQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dmz() {
        return this.lMQ;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lMR ? "request already submitted" : "request needs submit");
        }
        this.lMJ.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lMP);
        this.lLV.b(this);
        this.mIsAttached = true;
        if (!this.lMR) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lMJ.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lLV.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lMM == null) {
            return false;
        }
        if (this.lMM.dnF() || dmA()) {
            this.lMM.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dmA() {
        return dmt();
    }

    private boolean dmt() {
        return this.lMT && this.lML != null && this.lML.dmt();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0658a
    public boolean dmB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dmt()) {
            this.lML.dmu();
            this.lMP.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dmf = dmf();
        if (dmf != null) {
            this.lMW = null;
            this.lMR = true;
            this.lMT = false;
            this.lMJ.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dmy().onSubmit(this.mId, this.lMb);
            z(this.mId, dmf);
            a(this.mId, this.lMW, dmf, 1.0f, true, true);
            return;
        }
        this.lMJ.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dmy().onSubmit(this.mId, this.lMb);
        this.lMP.c(0.0f, true);
        this.lMR = true;
        this.lMT = false;
        this.lMW = dmd();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lMW)));
        }
        final String str = this.mId;
        final boolean dlD = this.lMW.dlD();
        this.lMW.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dlD);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dlF(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lMK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            C("ignore_old_datasource @ onNewResult", t);
            aZ(t);
            bVar.OG();
            return;
        }
        this.lMJ.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bc = bc(t);
            T t2 = this.lMX;
            Drawable drawable = this.mDrawable;
            this.lMX = t;
            this.mDrawable = bc;
            try {
                if (z) {
                    C("set_final_result @ onNewResult", t);
                    this.lMW = null;
                    this.lMP.a(bc, 1.0f, z2);
                    dmy().onFinalImageSet(str, bb(t), dmC());
                } else {
                    C("set_intermediate_result @ onNewResult", t);
                    this.lMP.a(bc, f, z2);
                    dmy().onIntermediateImageSet(str, bb(t));
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
            bVar.OG();
            return;
        }
        this.lMJ.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            h("final_failed @ onFailure", th);
            this.lMW = null;
            this.lMT = true;
            if (this.lMU && this.mDrawable != null) {
                this.lMP.a(this.mDrawable, 1.0f, true);
            } else if (dmt()) {
                this.lMP.A(th);
            } else {
                this.lMP.z(th);
            }
            dmy().onFailure(this.mId, th);
            return;
        }
        h("intermediate_failed @ onFailure", th);
        dmy().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onProgress", null);
            bVar.OG();
        } else if (!z) {
            this.lMP.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lMW == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lMW && this.lMR;
    }

    private void C(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lIR, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, be(t), Integer.valueOf(ba(t)));
        }
    }

    private void h(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lIR, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable dmC() {
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
        return f.aS(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lMR).aK("hasFetchFailed", this.lMT).bH("fetchedImage", ba(this.lMX)).x("events", this.lMJ.toString()).toString();
    }

    protected T dmf() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, T t) {
    }
}
