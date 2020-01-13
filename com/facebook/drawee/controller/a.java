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
    private static final Class<?> lGm = a.class;
    private final com.facebook.drawee.components.a lJq;
    private Object lJw;
    private final Executor lKf;
    @Nullable
    private com.facebook.drawee.components.b lKg;
    @Nullable
    private com.facebook.drawee.c.a lKh;
    @Nullable
    private c<INFO> lKi;
    @Nullable
    private d lKj;
    @Nullable
    private com.facebook.drawee.d.c lKk;
    @Nullable
    private Drawable lKl;
    private boolean lKm;
    private boolean lKn;
    private boolean lKo;
    private boolean lKp;
    @Nullable
    private String lKq;
    @Nullable
    private com.facebook.datasource.b<T> lKr;
    @Nullable
    private T lKs;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lKe = DraweeEventTracker.dkD();
    private boolean lKt = true;

    protected abstract void aX(@Nullable T t);

    @Nullable
    protected abstract INFO aZ(T t);

    protected abstract Drawable ba(T t);

    protected abstract com.facebook.datasource.b<T> dko();

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
        this.lJq = aVar;
        this.lKf = executor;
        B(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, Object obj) {
        B(str, obj);
        this.lKt = false;
    }

    private synchronized void B(String str, Object obj) {
        this.lKe.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lKt && this.lJq != null) {
            this.lJq.b(this);
        }
        this.mIsAttached = false;
        this.lKn = false;
        dkG();
        this.lKp = false;
        if (this.lKg != null) {
            this.lKg.init();
        }
        if (this.lKh != null) {
            this.lKh.init();
            this.lKh.a(this);
        }
        if (this.lKi instanceof C0651a) {
            ((C0651a) this.lKi).dkZ();
        } else {
            this.lKi = null;
        }
        this.lKj = null;
        if (this.lKk != null) {
            this.lKk.reset();
            this.lKk.n(null);
            this.lKk = null;
        }
        this.lKl = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lJw = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0650a
    public void release() {
        this.lKe.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lKg != null) {
            this.lKg.reset();
        }
        if (this.lKh != null) {
            this.lKh.reset();
        }
        if (this.lKk != null) {
            this.lKk.reset();
        }
        dkG();
    }

    private void dkG() {
        boolean z = this.lKm;
        this.lKm = false;
        this.lKo = false;
        if (this.lKr != null) {
            this.lKr.Mn();
            this.lKr = null;
        }
        if (this.mDrawable != null) {
            m(this.mDrawable);
        }
        if (this.lKq != null) {
            this.lKq = null;
        }
        this.mDrawable = null;
        if (this.lKs != null) {
            C("release", this.lKs);
            aX(this.lKs);
            this.lKs = null;
        }
        if (z) {
            dkJ().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dkH() {
        if (this.lKg == null) {
            this.lKg = new com.facebook.drawee.components.b();
        }
        return this.lKg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dkI() {
        return this.lKh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lKh = aVar;
        if (this.lKh != null) {
            this.lKh.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vb(boolean z) {
        this.lKp = z;
    }

    public void OM(@Nullable String str) {
        this.lKq = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKi instanceof C0651a) {
            ((C0651a) this.lKi).d(cVar);
        } else if (this.lKi != null) {
            this.lKi = C0651a.a(this.lKi, cVar);
        } else {
            this.lKi = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lKi instanceof C0651a) {
            ((C0651a) this.lKi).e(cVar);
        } else if (this.lKi == cVar) {
            this.lKi = null;
        }
    }

    protected c<INFO> dkJ() {
        return this.lKi == null ? b.getNoOpListener() : this.lKi;
    }

    public void a(@Nullable d dVar) {
        this.lKj = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lKk;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lKe.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lKm) {
            this.lJq.b(this);
            release();
        }
        if (this.lKk != null) {
            this.lKk.n(null);
            this.lKk = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lKk = (com.facebook.drawee.d.c) bVar;
            this.lKk.n(this.lKl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
        this.lKl = drawable;
        if (this.lKk != null) {
            this.lKk.n(this.lKl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dkK() {
        return this.lKl;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lKm ? "request already submitted" : "request needs submit");
        }
        this.lKe.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lKk);
        this.lJq.b(this);
        this.mIsAttached = true;
        if (!this.lKm) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lKe.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lJq.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lKh == null) {
            return false;
        }
        if (this.lKh.dlQ() || dkL()) {
            this.lKh.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dkL() {
        return dkE();
    }

    private boolean dkE() {
        return this.lKo && this.lKg != null && this.lKg.dkE();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0649a
    public boolean dkM() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dkE()) {
            this.lKg.dkF();
            this.lKk.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dkq = dkq();
        if (dkq != null) {
            this.lKr = null;
            this.lKm = true;
            this.lKo = false;
            this.lKe.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dkJ().onSubmit(this.mId, this.lJw);
            z(this.mId, dkq);
            a(this.mId, this.lKr, dkq, 1.0f, true, true);
            return;
        }
        this.lKe.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dkJ().onSubmit(this.mId, this.lJw);
        this.lKk.c(0.0f, true);
        this.lKm = true;
        this.lKo = false;
        this.lKr = dko();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lKr)));
        }
        final String str = this.mId;
        final boolean djO = this.lKr.djO();
        this.lKr.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, djO);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.djQ(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lKf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            C("ignore_old_datasource @ onNewResult", t);
            aX(t);
            bVar.Mn();
            return;
        }
        this.lKe.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ba = ba(t);
            T t2 = this.lKs;
            Drawable drawable = this.mDrawable;
            this.lKs = t;
            this.mDrawable = ba;
            try {
                if (z) {
                    C("set_final_result @ onNewResult", t);
                    this.lKr = null;
                    this.lKk.a(ba, 1.0f, z2);
                    dkJ().onFinalImageSet(str, aZ(t), dkN());
                } else {
                    C("set_intermediate_result @ onNewResult", t);
                    this.lKk.a(ba, f, z2);
                    dkJ().onIntermediateImageSet(str, aZ(t));
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
        this.lKe.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            h("final_failed @ onFailure", th);
            this.lKr = null;
            this.lKo = true;
            if (this.lKp && this.mDrawable != null) {
                this.lKk.a(this.mDrawable, 1.0f, true);
            } else if (dkE()) {
                this.lKk.B(th);
            } else {
                this.lKk.A(th);
            }
            dkJ().onFailure(this.mId, th);
            return;
        }
        h("intermediate_failed @ onFailure", th);
        dkJ().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onProgress", null);
            bVar.Mn();
        } else if (!z) {
            this.lKk.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lKr == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lKr && this.lKm;
    }

    private void C(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lGm, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bc(t), Integer.valueOf(aY(t)));
        }
    }

    private void h(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable dkN() {
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
        return f.aQ(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lKm).aK("hasFetchFailed", this.lKo).bI("fetchedImage", aY(this.lKs)).x("events", this.lKe.toString()).toString();
    }

    protected T dkq() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, T t) {
    }
}
