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
/* loaded from: classes12.dex */
public abstract class a<T, INFO> implements a.InterfaceC0649a, a.InterfaceC0650a, com.facebook.drawee.d.a {
    private static final Class<?> lGr = a.class;
    private Object lJB;
    private final com.facebook.drawee.components.a lJv;
    private final Executor lKk;
    @Nullable
    private com.facebook.drawee.components.b lKl;
    @Nullable
    private com.facebook.drawee.c.a lKm;
    @Nullable
    private c<INFO> lKn;
    @Nullable
    private d lKo;
    @Nullable
    private com.facebook.drawee.d.c lKp;
    @Nullable
    private Drawable lKq;
    private boolean lKr;
    private boolean lKs;
    private boolean lKt;
    private boolean lKu;
    @Nullable
    private String lKv;
    @Nullable
    private com.facebook.datasource.b<T> lKw;
    @Nullable
    private T lKx;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lKj = DraweeEventTracker.dkF();
    private boolean lKy = true;

    protected abstract void aX(@Nullable T t);

    @Nullable
    protected abstract INFO aZ(T t);

    protected abstract Drawable ba(T t);

    protected abstract com.facebook.datasource.b<T> dkq();

    protected abstract void m(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0651a<INFO> extends e<INFO> {
        private C0651a() {
        }

        public static <INFO> C0651a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0651a<INFO> c0651a = new C0651a<>();
            c0651a.d(cVar);
            c0651a.d(cVar2);
            return c0651a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.lJv = aVar;
        this.lKk = executor;
        B(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, Object obj) {
        B(str, obj);
        this.lKy = false;
    }

    private synchronized void B(String str, Object obj) {
        this.lKj.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lKy && this.lJv != null) {
            this.lJv.b(this);
        }
        this.mIsAttached = false;
        this.lKs = false;
        dkI();
        this.lKu = false;
        if (this.lKl != null) {
            this.lKl.init();
        }
        if (this.lKm != null) {
            this.lKm.init();
            this.lKm.a(this);
        }
        if (this.lKn instanceof C0651a) {
            ((C0651a) this.lKn).dlb();
        } else {
            this.lKn = null;
        }
        this.lKo = null;
        if (this.lKp != null) {
            this.lKp.reset();
            this.lKp.n(null);
            this.lKp = null;
        }
        this.lKq = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lJB = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0650a
    public void release() {
        this.lKj.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lKl != null) {
            this.lKl.reset();
        }
        if (this.lKm != null) {
            this.lKm.reset();
        }
        if (this.lKp != null) {
            this.lKp.reset();
        }
        dkI();
    }

    private void dkI() {
        boolean z = this.lKr;
        this.lKr = false;
        this.lKt = false;
        if (this.lKw != null) {
            this.lKw.Mn();
            this.lKw = null;
        }
        if (this.mDrawable != null) {
            m(this.mDrawable);
        }
        if (this.lKv != null) {
            this.lKv = null;
        }
        this.mDrawable = null;
        if (this.lKx != null) {
            C("release", this.lKx);
            aX(this.lKx);
            this.lKx = null;
        }
        if (z) {
            dkL().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dkJ() {
        if (this.lKl == null) {
            this.lKl = new com.facebook.drawee.components.b();
        }
        return this.lKl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dkK() {
        return this.lKm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lKm = aVar;
        if (this.lKm != null) {
            this.lKm.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vb(boolean z) {
        this.lKu = z;
    }

    public void OM(@Nullable String str) {
        this.lKv = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKn instanceof C0651a) {
            ((C0651a) this.lKn).d(cVar);
        } else if (this.lKn != null) {
            this.lKn = C0651a.a(this.lKn, cVar);
        } else {
            this.lKn = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKn instanceof C0651a) {
            ((C0651a) this.lKn).e(cVar);
        } else if (this.lKn == cVar) {
            this.lKn = null;
        }
    }

    protected c<INFO> dkL() {
        return this.lKn == null ? b.getNoOpListener() : this.lKn;
    }

    public void a(@Nullable d dVar) {
        this.lKo = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lKp;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lKj.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lKr) {
            this.lJv.b(this);
            release();
        }
        if (this.lKp != null) {
            this.lKp.n(null);
            this.lKp = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lKp = (com.facebook.drawee.d.c) bVar;
            this.lKp.n(this.lKq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
        this.lKq = drawable;
        if (this.lKp != null) {
            this.lKp.n(this.lKq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dkM() {
        return this.lKq;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lKr ? "request already submitted" : "request needs submit");
        }
        this.lKj.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lKp);
        this.lJv.b(this);
        this.mIsAttached = true;
        if (!this.lKr) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lKj.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lJv.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lKm == null) {
            return false;
        }
        if (this.lKm.dlS() || dkN()) {
            this.lKm.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dkN() {
        return dkG();
    }

    private boolean dkG() {
        return this.lKt && this.lKl != null && this.lKl.dkG();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0649a
    public boolean dkO() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dkG()) {
            this.lKl.dkH();
            this.lKp.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dks = dks();
        if (dks != null) {
            this.lKw = null;
            this.lKr = true;
            this.lKt = false;
            this.lKj.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dkL().onSubmit(this.mId, this.lJB);
            z(this.mId, dks);
            a(this.mId, this.lKw, dks, 1.0f, true, true);
            return;
        }
        this.lKj.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dkL().onSubmit(this.mId, this.lJB);
        this.lKp.c(0.0f, true);
        this.lKr = true;
        this.lKt = false;
        this.lKw = dkq();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lKw)));
        }
        final String str = this.mId;
        final boolean djQ = this.lKw.djQ();
        this.lKw.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, djQ);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.djS(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lKk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            C("ignore_old_datasource @ onNewResult", t);
            aX(t);
            bVar.Mn();
            return;
        }
        this.lKj.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ba = ba(t);
            T t2 = this.lKx;
            Drawable drawable = this.mDrawable;
            this.lKx = t;
            this.mDrawable = ba;
            try {
                if (z) {
                    C("set_final_result @ onNewResult", t);
                    this.lKw = null;
                    this.lKp.a(ba, 1.0f, z2);
                    dkL().onFinalImageSet(str, aZ(t), dkP());
                } else {
                    C("set_intermediate_result @ onNewResult", t);
                    this.lKp.a(ba, f, z2);
                    dkL().onIntermediateImageSet(str, aZ(t));
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
            bVar.Mn();
            return;
        }
        this.lKj.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            h("final_failed @ onFailure", th);
            this.lKw = null;
            this.lKt = true;
            if (this.lKu && this.mDrawable != null) {
                this.lKp.a(this.mDrawable, 1.0f, true);
            } else if (dkG()) {
                this.lKp.B(th);
            } else {
                this.lKp.A(th);
            }
            dkL().onFailure(this.mId, th);
            return;
        }
        h("intermediate_failed @ onFailure", th);
        dkL().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onProgress", null);
            bVar.Mn();
        } else if (!z) {
            this.lKp.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lKw == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lKw && this.lKr;
    }

    private void C(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lGr, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bc(t), Integer.valueOf(aY(t)));
        }
    }

    private void h(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable dkP() {
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
        return f.aQ(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lKr).aK("hasFetchFailed", this.lKt).bI("fetchedImage", aY(this.lKx)).x("events", this.lKj.toString()).toString();
    }

    protected T dks() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, T t) {
    }
}
