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
    private static final Class<?> iiQ = a.class;
    private final com.facebook.drawee.components.a ilT;
    private final DraweeEventTracker imf = DraweeEventTracker.bVH();
    private final Executor imh;
    @Nullable
    private com.facebook.drawee.components.b imi;
    @Nullable
    private com.facebook.drawee.c.a imj;
    @Nullable
    private c<INFO> imk;
    @Nullable
    private d iml;
    @Nullable
    private com.facebook.drawee.d.c imm;
    @Nullable
    private Drawable imn;
    private Object imo;
    private boolean imp;
    private boolean imq;
    private boolean imr;
    private boolean ims;
    @Nullable
    private String imt;
    @Nullable
    private com.facebook.datasource.b<T> imu;
    @Nullable
    private T imv;
    @Nullable
    private Throwable imw;
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
        this.ilT = aVar;
        this.imh = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.imf.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.bUL()) {
            this.imw = new Throwable();
        }
        if (!z && this.ilT != null) {
            this.ilT.b(this);
        }
        this.mIsAttached = false;
        this.imq = false;
        bVK();
        this.ims = false;
        if (this.imi != null) {
            this.imi.init();
        }
        if (this.imj != null) {
            this.imj.init();
            this.imj.a(this);
        }
        if (this.imk instanceof C0361a) {
            ((C0361a) this.imk).bWd();
        } else {
            this.imk = null;
        }
        this.iml = null;
        if (this.imm != null) {
            this.imm.reset();
            this.imm.g(null);
            this.imm = null;
        }
        this.imn = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.imo = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0360a
    public void release() {
        this.imf.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.imi != null) {
            this.imi.reset();
        }
        if (this.imj != null) {
            this.imj.reset();
        }
        if (this.imm != null) {
            this.imm.reset();
        }
        bVK();
    }

    private void bVK() {
        boolean z = this.imp;
        this.imp = false;
        this.imr = false;
        if (this.imu != null) {
            this.imu.bVg();
            this.imu = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.imt != null) {
            this.imt = null;
        }
        this.mDrawable = null;
        if (this.imv != null) {
            q("release", this.imv);
            au(this.imv);
            this.imv = null;
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
        return this.imi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.imi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a bVM() {
        return this.imj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.imj = aVar;
        if (this.imj != null) {
            this.imj.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oW(boolean z) {
        this.ims = z;
    }

    public void zB(@Nullable String str) {
        this.imt = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.imk instanceof C0361a) {
            ((C0361a) this.imk).c(cVar);
        } else if (this.imk != null) {
            this.imk = C0361a.a(this.imk, cVar);
        } else {
            this.imk = cVar;
        }
    }

    protected c<INFO> bVN() {
        return this.imk == null ? b.getNoOpListener() : this.imk;
    }

    public void a(@Nullable d dVar) {
        this.iml = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.imm;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.imf.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.imp) {
            this.ilT.b(this);
            release();
        }
        if (this.imm != null) {
            this.imm.g(null);
            this.imm = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.imm = (com.facebook.drawee.d.c) bVar;
            this.imm.g(this.imn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.imn = drawable;
        if (this.imm != null) {
            this.imm.g(this.imn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable bVO() {
        return this.imn;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.imp ? "request already submitted" : "request needs submit");
        }
        this.imf.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.imm);
        this.ilT.b(this);
        this.mIsAttached = true;
        if (!this.imp) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.imf.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.ilT.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.imj == null) {
            return false;
        }
        if (this.imj.bWT() || bVP()) {
            this.imj.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean bVP() {
        return bVI();
    }

    private boolean bVI() {
        return this.imr && this.imi != null && this.imi.bVI();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0359a
    public boolean bVQ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (bVI()) {
            this.imi.bVJ();
            this.imm.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T bVy = bVy();
        if (bVy != null) {
            this.imu = null;
            this.imp = true;
            this.imr = false;
            this.imf.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            bVN().onSubmit(this.mId, this.imo);
            a(this.mId, this.imu, bVy, 1.0f, true, true);
            return;
        }
        this.imf.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        bVN().onSubmit(this.mId, this.imo);
        this.imm.d(0.0f, true);
        this.imp = true;
        this.imr = false;
        this.imu = bVw();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.imu)));
        }
        final String str = this.mId;
        final boolean bVd = this.imu.bVd();
        this.imu.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.imw != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.imw);
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
        }, this.imh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            q("ignore_old_datasource @ onNewResult", t);
            au(t);
            bVar.bVg();
            return;
        }
        this.imf.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ax = ax(t);
            T t2 = this.imv;
            Drawable drawable = this.mDrawable;
            this.imv = t;
            this.mDrawable = ax;
            try {
                if (z) {
                    q("set_final_result @ onNewResult", t);
                    this.imu = null;
                    this.imm.a(ax, 1.0f, z2);
                    bVN().onFinalImageSet(str, aw(t), bVR());
                } else {
                    q("set_intermediate_result @ onNewResult", t);
                    this.imm.a(ax, f, z2);
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
        this.imf.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.imu = null;
            this.imr = true;
            if (this.ims && this.mDrawable != null) {
                this.imm.a(this.mDrawable, 1.0f, true);
            } else if (bVI()) {
                this.imm.z(th);
            } else {
                this.imm.y(th);
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
            this.imm.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.imu == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.imu && this.imp;
    }

    private void q(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(iiQ, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ay(t), Integer.valueOf(av(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iiQ, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
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
        return f.ao(this).ah("isAttached", this.mIsAttached).ah("isRequestSubmitted", this.imp).ah("hasFetchFailed", this.imr).bg("fetchedImage", av(this.imv)).n("events", this.imf.toString()).toString();
    }

    protected T bVy() {
        return null;
    }
}
