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
public abstract class a<T, INFO> implements a.InterfaceC0359a, a.InterfaceC0360a, com.facebook.drawee.d.a {
    private static final Class<?> iiR = a.class;
    private final com.facebook.drawee.components.a ilU;
    private final DraweeEventTracker imh = DraweeEventTracker.bVH();
    private final Executor imi;
    @Nullable
    private com.facebook.drawee.components.b imj;
    @Nullable
    private com.facebook.drawee.c.a imk;
    @Nullable
    private c<INFO> iml;
    @Nullable
    private d imm;
    @Nullable
    private com.facebook.drawee.d.c imn;
    @Nullable
    private Drawable imo;
    private Object imp;
    private boolean imq;
    private boolean imr;
    private boolean ims;
    private boolean imt;
    @Nullable
    private String imu;
    @Nullable
    private com.facebook.datasource.b<T> imv;
    @Nullable
    private T imw;
    @Nullable
    private Throwable imx;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void au(@Nullable T t);

    @Nullable
    protected abstract INFO aw(T t);

    protected abstract Drawable ax(T t);

    protected abstract com.facebook.datasource.b<T> bVw();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0361a<INFO> extends e<INFO> {
        private C0361a() {
        }

        public static <INFO> C0361a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0361a<INFO> c0361a = new C0361a<>();
            c0361a.c(cVar);
            c0361a.c(cVar2);
            return c0361a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.ilU = aVar;
        this.imi = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.imh.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.bUL()) {
            this.imx = new Throwable();
        }
        if (!z && this.ilU != null) {
            this.ilU.b(this);
        }
        this.mIsAttached = false;
        this.imr = false;
        bVK();
        this.imt = false;
        if (this.imj != null) {
            this.imj.init();
        }
        if (this.imk != null) {
            this.imk.init();
            this.imk.a(this);
        }
        if (this.iml instanceof C0361a) {
            ((C0361a) this.iml).bWd();
        } else {
            this.iml = null;
        }
        this.imm = null;
        if (this.imn != null) {
            this.imn.reset();
            this.imn.g(null);
            this.imn = null;
        }
        this.imo = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.imp = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0360a
    public void release() {
        this.imh.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.imj != null) {
            this.imj.reset();
        }
        if (this.imk != null) {
            this.imk.reset();
        }
        if (this.imn != null) {
            this.imn.reset();
        }
        bVK();
    }

    private void bVK() {
        boolean z = this.imq;
        this.imq = false;
        this.ims = false;
        if (this.imv != null) {
            this.imv.bVg();
            this.imv = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.imu != null) {
            this.imu = null;
        }
        this.mDrawable = null;
        if (this.imw != null) {
            q("release", this.imw);
            au(this.imw);
            this.imw = null;
        }
        if (z) {
            bVN().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b bVL() {
        return this.imj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.imj = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a bVM() {
        return this.imk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.imk = aVar;
        if (this.imk != null) {
            this.imk.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oW(boolean z) {
        this.imt = z;
    }

    public void zB(@Nullable String str) {
        this.imu = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.iml instanceof C0361a) {
            ((C0361a) this.iml).c(cVar);
        } else if (this.iml != null) {
            this.iml = C0361a.a(this.iml, cVar);
        } else {
            this.iml = cVar;
        }
    }

    protected c<INFO> bVN() {
        return this.iml == null ? b.getNoOpListener() : this.iml;
    }

    public void a(@Nullable d dVar) {
        this.imm = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.imn;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.imh.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.imq) {
            this.ilU.b(this);
            release();
        }
        if (this.imn != null) {
            this.imn.g(null);
            this.imn = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.imn = (com.facebook.drawee.d.c) bVar;
            this.imn.g(this.imo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.imo = drawable;
        if (this.imn != null) {
            this.imn.g(this.imo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable bVO() {
        return this.imo;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.imq ? "request already submitted" : "request needs submit");
        }
        this.imh.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.imn);
        this.ilU.b(this);
        this.mIsAttached = true;
        if (!this.imq) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.imh.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.ilU.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.imk == null) {
            return false;
        }
        if (this.imk.bWT() || bVP()) {
            this.imk.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean bVP() {
        return bVI();
    }

    private boolean bVI() {
        return this.ims && this.imj != null && this.imj.bVI();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0359a
    public boolean bVQ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (bVI()) {
            this.imj.bVJ();
            this.imn.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T bVy = bVy();
        if (bVy != null) {
            this.imv = null;
            this.imq = true;
            this.ims = false;
            this.imh.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            bVN().onSubmit(this.mId, this.imp);
            a(this.mId, this.imv, bVy, 1.0f, true, true);
            return;
        }
        this.imh.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        bVN().onSubmit(this.mId, this.imp);
        this.imn.d(0.0f, true);
        this.imq = true;
        this.ims = false;
        this.imv = bVw();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.imv)));
        }
        final String str = this.mId;
        final boolean bVd = this.imv.bVd();
        this.imv.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.imx != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.imx);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, bVd);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.bVf(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.imi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            q("ignore_old_datasource @ onNewResult", t);
            au(t);
            bVar.bVg();
            return;
        }
        this.imh.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ax = ax(t);
            T t2 = this.imw;
            Drawable drawable = this.mDrawable;
            this.imw = t;
            this.mDrawable = ax;
            try {
                if (z) {
                    q("set_final_result @ onNewResult", t);
                    this.imv = null;
                    this.imn.a(ax, 1.0f, z2);
                    bVN().onFinalImageSet(str, aw(t), bVR());
                } else {
                    q("set_intermediate_result @ onNewResult", t);
                    this.imn.a(ax, f, z2);
                    bVN().onIntermediateImageSet(str, aw(t));
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
            bVar.bVg();
            return;
        }
        this.imh.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.imv = null;
            this.ims = true;
            if (this.imt && this.mDrawable != null) {
                this.imn.a(this.mDrawable, 1.0f, true);
            } else if (bVI()) {
                this.imn.z(th);
            } else {
                this.imn.y(th);
            }
            bVN().onFailure(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        bVN().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.bVg();
        } else if (!z) {
            this.imn.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.imv == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.imv && this.imq;
    }

    private void q(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(iiR, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ay(t), Integer.valueOf(av(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiR, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable bVR() {
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
        return f.ao(this).ah("isAttached", this.mIsAttached).ah("isRequestSubmitted", this.imq).ah("hasFetchFailed", this.ims).bg("fetchedImage", av(this.imw)).n("events", this.imh.toString()).toString();
    }

    protected T bVy() {
        return null;
    }
}
