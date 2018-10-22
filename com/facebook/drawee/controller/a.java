package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.f;
import com.facebook.common.internal.g;
import com.facebook.drawee.c.a;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.a;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public abstract class a<T, INFO> implements a.InterfaceC0318a, a.InterfaceC0319a, com.facebook.drawee.d.a {
    private static final Class<?> hVC = a.class;
    private final com.facebook.drawee.components.a hYF;
    private final DraweeEventTracker hYR = DraweeEventTracker.bSI();
    private final Executor hYS;
    @Nullable
    private com.facebook.drawee.components.b hYT;
    @Nullable
    private com.facebook.drawee.c.a hYU;
    @Nullable
    private c<INFO> hYV;
    @Nullable
    private d hYW;
    @Nullable
    private com.facebook.drawee.d.c hYX;
    @Nullable
    private Drawable hYY;
    private Object hYZ;
    private boolean hZa;
    private boolean hZb;
    private boolean hZc;
    private boolean hZd;
    @Nullable
    private String hZe;
    @Nullable
    private com.facebook.datasource.b<T> hZf;
    @Nullable
    private T hZg;
    @Nullable
    private Throwable hZh;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void au(@Nullable T t);

    @Nullable
    protected abstract INFO aw(T t);

    protected abstract Drawable ax(T t);

    protected abstract com.facebook.datasource.b<T> bSx();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0320a<INFO> extends e<INFO> {
        private C0320a() {
        }

        public static <INFO> C0320a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0320a<INFO> c0320a = new C0320a<>();
            c0320a.c(cVar);
            c0320a.c(cVar2);
            return c0320a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.hYF = aVar;
        this.hYS = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.hYR.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.bRM()) {
            this.hZh = new Throwable();
        }
        if (!z && this.hYF != null) {
            this.hYF.b(this);
        }
        this.mIsAttached = false;
        this.hZb = false;
        bSL();
        this.hZd = false;
        if (this.hYT != null) {
            this.hYT.init();
        }
        if (this.hYU != null) {
            this.hYU.init();
            this.hYU.a(this);
        }
        if (this.hYV instanceof C0320a) {
            ((C0320a) this.hYV).bTe();
        } else {
            this.hYV = null;
        }
        this.hYW = null;
        if (this.hYX != null) {
            this.hYX.reset();
            this.hYX.g(null);
            this.hYX = null;
        }
        this.hYY = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.hYZ = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0319a
    public void release() {
        this.hYR.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.hYT != null) {
            this.hYT.reset();
        }
        if (this.hYU != null) {
            this.hYU.reset();
        }
        if (this.hYX != null) {
            this.hYX.reset();
        }
        bSL();
    }

    private void bSL() {
        boolean z = this.hZa;
        this.hZa = false;
        this.hZc = false;
        if (this.hZf != null) {
            this.hZf.bSh();
            this.hZf = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.hZe != null) {
            this.hZe = null;
        }
        this.mDrawable = null;
        if (this.hZg != null) {
            q("release", this.hZg);
            au(this.hZg);
            this.hZg = null;
        }
        if (z) {
            bSO().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b bSM() {
        return this.hYT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.hYT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a bSN() {
        return this.hYU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.hYU = aVar;
        if (this.hYU != null) {
            this.hYU.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oC(boolean z) {
        this.hZd = z;
    }

    public void yA(@Nullable String str) {
        this.hZe = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.hYV instanceof C0320a) {
            ((C0320a) this.hYV).c(cVar);
        } else if (this.hYV != null) {
            this.hYV = C0320a.a(this.hYV, cVar);
        } else {
            this.hYV = cVar;
        }
    }

    protected c<INFO> bSO() {
        return this.hYV == null ? b.getNoOpListener() : this.hYV;
    }

    public void a(@Nullable d dVar) {
        this.hYW = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.hYX;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.hYR.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.hZa) {
            this.hYF.b(this);
            release();
        }
        if (this.hYX != null) {
            this.hYX.g(null);
            this.hYX = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.hYX = (com.facebook.drawee.d.c) bVar;
            this.hYX.g(this.hYY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.hYY = drawable;
        if (this.hYX != null) {
            this.hYX.g(this.hYY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable bSP() {
        return this.hYY;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.hZa ? "request already submitted" : "request needs submit");
        }
        this.hYR.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.hYX);
        this.hYF.b(this);
        this.mIsAttached = true;
        if (!this.hZa) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.hYR.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.hYF.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.hYU == null) {
            return false;
        }
        if (this.hYU.bTU() || bSQ()) {
            this.hYU.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean bSQ() {
        return bSJ();
    }

    private boolean bSJ() {
        return this.hZc && this.hYT != null && this.hYT.bSJ();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0318a
    public boolean bSR() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (bSJ()) {
            this.hYT.bSK();
            this.hYX.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T bSz = bSz();
        if (bSz != null) {
            this.hZf = null;
            this.hZa = true;
            this.hZc = false;
            this.hYR.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            bSO().onSubmit(this.mId, this.hYZ);
            a(this.mId, this.hZf, bSz, 1.0f, true, true);
            return;
        }
        this.hYR.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        bSO().onSubmit(this.mId, this.hYZ);
        this.hYX.d(0.0f, true);
        this.hZa = true;
        this.hZc = false;
        this.hZf = bSx();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.hZf)));
        }
        final String str = this.mId;
        final boolean bSe = this.hZf.bSe();
        this.hZf.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.hZh != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.hZh);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, bSe);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.bSg(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.hYS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            q("ignore_old_datasource @ onNewResult", t);
            au(t);
            bVar.bSh();
            return;
        }
        this.hYR.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ax = ax(t);
            T t2 = this.hZg;
            Drawable drawable = this.mDrawable;
            this.hZg = t;
            this.mDrawable = ax;
            try {
                if (z) {
                    q("set_final_result @ onNewResult", t);
                    this.hZf = null;
                    this.hYX.a(ax, 1.0f, z2);
                    bSO().onFinalImageSet(str, aw(t), bSS());
                } else {
                    q("set_intermediate_result @ onNewResult", t);
                    this.hYX.a(ax, f, z2);
                    bSO().onIntermediateImageSet(str, aw(t));
                }
                if (drawable != null && drawable != ax) {
                    f(drawable);
                }
                if (t2 != null && t2 != t) {
                    q("release_previous_result @ onNewResult", t2);
                    au(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != ax) {
                    f(drawable);
                }
                if (t2 != null && t2 != t) {
                    q("release_previous_result @ onNewResult", t2);
                    au(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            q("drawable_failed @ onNewResult", t);
            au(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.bSh();
            return;
        }
        this.hYR.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.hZf = null;
            this.hZc = true;
            if (this.hZd && this.mDrawable != null) {
                this.hYX.a(this.mDrawable, 1.0f, true);
            } else if (bSJ()) {
                this.hYX.z(th);
            } else {
                this.hYX.y(th);
            }
            bSO().onFailure(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        bSO().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.bSh();
        } else if (!z) {
            this.hYX.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.hZf == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.hZf && this.hZa;
    }

    private void q(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(hVC, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ay(t), Integer.valueOf(av(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hVC, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable bSS() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String ay(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int av(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.ao(this).ag("isAttached", this.mIsAttached).ag("isRequestSubmitted", this.hZa).ag("hasFetchFailed", this.hZc).be("fetchedImage", av(this.hZg)).n("events", this.hYR.toString()).toString();
    }

    protected T bSz() {
        return null;
    }
}
