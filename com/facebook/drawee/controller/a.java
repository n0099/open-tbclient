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
    private static final Class<?> lHl = a.class;
    private final com.facebook.drawee.components.a lKp;
    private Object lKv;
    private final Executor lLe;
    @Nullable
    private com.facebook.drawee.components.b lLf;
    @Nullable
    private com.facebook.drawee.c.a lLg;
    @Nullable
    private c<INFO> lLh;
    @Nullable
    private d lLi;
    @Nullable
    private com.facebook.drawee.d.c lLj;
    @Nullable
    private Drawable lLk;
    private boolean lLl;
    private boolean lLm;
    private boolean lLn;
    private boolean lLo;
    @Nullable
    private String lLp;
    @Nullable
    private com.facebook.datasource.b<T> lLq;
    @Nullable
    private T lLr;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lLd = DraweeEventTracker.dlV();
    private boolean lLs = true;

    protected abstract void aZ(@Nullable T t);

    @Nullable
    protected abstract INFO bb(T t);

    protected abstract Drawable bc(T t);

    protected abstract com.facebook.datasource.b<T> dlG();

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
        this.lKp = aVar;
        this.lLe = executor;
        B(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, Object obj) {
        B(str, obj);
        this.lLs = false;
    }

    private synchronized void B(String str, Object obj) {
        this.lLd.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lLs && this.lKp != null) {
            this.lKp.b(this);
        }
        this.mIsAttached = false;
        this.lLm = false;
        dlY();
        this.lLo = false;
        if (this.lLf != null) {
            this.lLf.init();
        }
        if (this.lLg != null) {
            this.lLg.init();
            this.lLg.a(this);
        }
        if (this.lLh instanceof C0659a) {
            ((C0659a) this.lLh).dmr();
        } else {
            this.lLh = null;
        }
        this.lLi = null;
        if (this.lLj != null) {
            this.lLj.reset();
            this.lLj.n(null);
            this.lLj = null;
        }
        this.lLk = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lKv = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0658a
    public void release() {
        this.lLd.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lLf != null) {
            this.lLf.reset();
        }
        if (this.lLg != null) {
            this.lLg.reset();
        }
        if (this.lLj != null) {
            this.lLj.reset();
        }
        dlY();
    }

    private void dlY() {
        boolean z = this.lLl;
        this.lLl = false;
        this.lLn = false;
        if (this.lLq != null) {
            this.lLq.OD();
            this.lLq = null;
        }
        if (this.mDrawable != null) {
            m(this.mDrawable);
        }
        if (this.lLp != null) {
            this.lLp = null;
        }
        this.mDrawable = null;
        if (this.lLr != null) {
            C("release", this.lLr);
            aZ(this.lLr);
            this.lLr = null;
        }
        if (z) {
            dmb().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dlZ() {
        if (this.lLf == null) {
            this.lLf = new com.facebook.drawee.components.b();
        }
        return this.lLf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dma() {
        return this.lLg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lLg = aVar;
        if (this.lLg != null) {
            this.lLg.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vf(boolean z) {
        this.lLo = z;
    }

    public void Pa(@Nullable String str) {
        this.lLp = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lLh instanceof C0659a) {
            ((C0659a) this.lLh).d(cVar);
        } else if (this.lLh != null) {
            this.lLh = C0659a.a(this.lLh, cVar);
        } else {
            this.lLh = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lLh instanceof C0659a) {
            ((C0659a) this.lLh).e(cVar);
        } else if (this.lLh == cVar) {
            this.lLh = null;
        }
    }

    protected c<INFO> dmb() {
        return this.lLh == null ? b.getNoOpListener() : this.lLh;
    }

    public void a(@Nullable d dVar) {
        this.lLi = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lLj;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lLd.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lLl) {
            this.lKp.b(this);
            release();
        }
        if (this.lLj != null) {
            this.lLj.n(null);
            this.lLj = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lLj = (com.facebook.drawee.d.c) bVar;
            this.lLj.n(this.lLk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
        this.lLk = drawable;
        if (this.lLj != null) {
            this.lLj.n(this.lLk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dmc() {
        return this.lLk;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lLl ? "request already submitted" : "request needs submit");
        }
        this.lLd.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lLj);
        this.lKp.b(this);
        this.mIsAttached = true;
        if (!this.lLl) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lLd.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lKp.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lLg == null) {
            return false;
        }
        if (this.lLg.dnh() || dmd()) {
            this.lLg.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dmd() {
        return dlW();
    }

    private boolean dlW() {
        return this.lLn && this.lLf != null && this.lLf.dlW();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0657a
    public boolean dme() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dlW()) {
            this.lLf.dlX();
            this.lLj.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dlI = dlI();
        if (dlI != null) {
            this.lLq = null;
            this.lLl = true;
            this.lLn = false;
            this.lLd.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dmb().onSubmit(this.mId, this.lKv);
            z(this.mId, dlI);
            a(this.mId, this.lLq, dlI, 1.0f, true, true);
            return;
        }
        this.lLd.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dmb().onSubmit(this.mId, this.lKv);
        this.lLj.c(0.0f, true);
        this.lLl = true;
        this.lLn = false;
        this.lLq = dlG();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lLq)));
        }
        final String str = this.mId;
        final boolean dlg = this.lLq.dlg();
        this.lLq.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dlg);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dli(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lLe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            C("ignore_old_datasource @ onNewResult", t);
            aZ(t);
            bVar.OD();
            return;
        }
        this.lLd.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bc = bc(t);
            T t2 = this.lLr;
            Drawable drawable = this.mDrawable;
            this.lLr = t;
            this.mDrawable = bc;
            try {
                if (z) {
                    C("set_final_result @ onNewResult", t);
                    this.lLq = null;
                    this.lLj.a(bc, 1.0f, z2);
                    dmb().onFinalImageSet(str, bb(t), dmf());
                } else {
                    C("set_intermediate_result @ onNewResult", t);
                    this.lLj.a(bc, f, z2);
                    dmb().onIntermediateImageSet(str, bb(t));
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
        this.lLd.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            h("final_failed @ onFailure", th);
            this.lLq = null;
            this.lLn = true;
            if (this.lLo && this.mDrawable != null) {
                this.lLj.a(this.mDrawable, 1.0f, true);
            } else if (dlW()) {
                this.lLj.A(th);
            } else {
                this.lLj.z(th);
            }
            dmb().onFailure(this.mId, th);
            return;
        }
        h("intermediate_failed @ onFailure", th);
        dmb().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            h("ignore_old_datasource @ onProgress", null);
            bVar.OD();
        } else if (!z) {
            this.lLj.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lLq == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lLq && this.lLl;
    }

    private void C(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lHl, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, be(t), Integer.valueOf(ba(t)));
        }
    }

    private void h(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lHl, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable dmf() {
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
        return f.aS(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lLl).aK("hasFetchFailed", this.lLn).bH("fetchedImage", ba(this.lLr)).x("events", this.lLd.toString()).toString();
    }

    protected T dlI() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, T t) {
    }
}
