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
public abstract class a<T, INFO> implements a.InterfaceC0778a, a.InterfaceC0779a, com.facebook.drawee.d.a {
    private static final Class<?> mls = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private Object moC;
    private final com.facebook.drawee.components.a mow;
    private final Executor mpk;
    @Nullable
    private com.facebook.drawee.components.b mpl;
    @Nullable
    private com.facebook.drawee.c.a mpm;
    @Nullable
    private c<INFO> mpn;
    @Nullable
    private d mpo;
    @Nullable
    private com.facebook.drawee.d.c mpp;
    @Nullable
    private Drawable mpq;
    private boolean mpr;
    private boolean mps;
    private boolean mpt;
    private boolean mpu;
    @Nullable
    private String mpv;
    @Nullable
    private com.facebook.datasource.b<T> mpw;
    @Nullable
    private T mpx;
    private final DraweeEventTracker mpj = DraweeEventTracker.dvP();
    private boolean mpy = true;

    protected abstract void aU(@Nullable T t);

    @Nullable
    protected abstract INFO aW(T t);

    protected abstract Drawable aX(T t);

    protected abstract com.facebook.datasource.b<T> dvA();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0780a<INFO> extends e<INFO> {
        private C0780a() {
        }

        public static <INFO> C0780a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0780a<INFO> c0780a = new C0780a<>();
            c0780a.d(cVar);
            c0780a.d(cVar2);
            return c0780a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.mow = aVar;
        this.mpk = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.mpy = false;
    }

    private synchronized void J(String str, Object obj) {
        this.mpj.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mpy && this.mow != null) {
            this.mow.b(this);
        }
        this.mIsAttached = false;
        this.mps = false;
        dvS();
        this.mpu = false;
        if (this.mpl != null) {
            this.mpl.init();
        }
        if (this.mpm != null) {
            this.mpm.init();
            this.mpm.a(this);
        }
        if (this.mpn instanceof C0780a) {
            ((C0780a) this.mpn).dwm();
        } else {
            this.mpn = null;
        }
        this.mpo = null;
        if (this.mpp != null) {
            this.mpp.reset();
            this.mpp.j(null);
            this.mpp = null;
        }
        this.mpq = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.moC = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0779a
    public void release() {
        this.mpj.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.mpl != null) {
            this.mpl.reset();
        }
        if (this.mpm != null) {
            this.mpm.reset();
        }
        if (this.mpp != null) {
            this.mpp.reset();
        }
        dvS();
    }

    private void dvS() {
        boolean z = this.mpr;
        this.mpr = false;
        this.mpt = false;
        if (this.mpw != null) {
            this.mpw.Zg();
            this.mpw = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.mpv != null) {
            this.mpv = null;
        }
        this.mDrawable = null;
        if (this.mpx != null) {
            K("release", this.mpx);
            aU(this.mpx);
            this.mpx = null;
        }
        if (z) {
            dvV().eV(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dvT() {
        if (this.mpl == null) {
            this.mpl = new com.facebook.drawee.components.b();
        }
        return this.mpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dvU() {
        return this.mpm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.mpm = aVar;
        if (this.mpm != null) {
            this.mpm.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wa(boolean z) {
        this.mpu = z;
    }

    public void PZ(@Nullable String str) {
        this.mpv = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mpn instanceof C0780a) {
            ((C0780a) this.mpn).d(cVar);
        } else if (this.mpn != null) {
            this.mpn = C0780a.a(this.mpn, cVar);
        } else {
            this.mpn = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mpn instanceof C0780a) {
            ((C0780a) this.mpn).e(cVar);
        } else if (this.mpn == cVar) {
            this.mpn = null;
        }
    }

    protected c<INFO> dvV() {
        return this.mpn == null ? b.dwl() : this.mpn;
    }

    public void a(@Nullable d dVar) {
        this.mpo = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.mpp;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.mpj.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mpr) {
            this.mow.b(this);
            release();
        }
        if (this.mpp != null) {
            this.mpp.j(null);
            this.mpp = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.mpp = (com.facebook.drawee.d.c) bVar;
            this.mpp.j(this.mpq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.mpq = drawable;
        if (this.mpp != null) {
            this.mpp.j(this.mpq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dvW() {
        return this.mpq;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mpr ? "request already submitted" : "request needs submit");
        }
        this.mpj.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.mpp);
        this.mow.b(this);
        this.mIsAttached = true;
        if (!this.mpr) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.mpj.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mow.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.mpm == null) {
            return false;
        }
        if (this.mpm.dxd() || dvX()) {
            this.mpm.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dvX() {
        return dvQ();
    }

    private boolean dvQ() {
        return this.mpt && this.mpl != null && this.mpl.dvQ();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0778a
    public boolean dvY() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dvQ()) {
            this.mpl.dvR();
            this.mpp.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dvC = dvC();
        if (dvC != null) {
            this.mpw = null;
            this.mpr = true;
            this.mpt = false;
            this.mpj.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dvV().g(this.mId, this.moC);
            H(this.mId, dvC);
            a(this.mId, this.mpw, dvC, 1.0f, true, true);
            return;
        }
        this.mpj.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dvV().g(this.mId, this.moC);
        this.mpp.c(0.0f, true);
        this.mpr = true;
        this.mpt = false;
        this.mpw = dvA();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mpw)));
        }
        final String str = this.mId;
        final boolean dvc = this.mpw.dvc();
        this.mpw.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dvc);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dve(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.mpk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            aU(t);
            bVar.Zg();
            return;
        }
        this.mpj.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aX = aX(t);
            T t2 = this.mpx;
            Drawable drawable = this.mDrawable;
            this.mpx = t;
            this.mDrawable = aX;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.mpw = null;
                    this.mpp.a(aX, 1.0f, z2);
                    dvV().a(str, aW(t), dvZ());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.mpp.a(aX, f, z2);
                    dvV().h(str, (String) aW(t));
                }
                if (drawable != null && drawable != aX) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aU(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aX) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aU(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            aU(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.Zg();
            return;
        }
        this.mpj.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.mpw = null;
            this.mpt = true;
            if (this.mpu && this.mDrawable != null) {
                this.mpp.a(this.mDrawable, 1.0f, true);
            } else if (dvQ()) {
                this.mpp.E(th);
            } else {
                this.mpp.D(th);
            }
            dvV().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dvV().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.Zg();
        } else if (!z) {
            this.mpp.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.mpw == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.mpw && this.mpr;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(mls, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aZ(t), Integer.valueOf(aV(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dvZ() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aZ(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aV(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aN(this).aX("isAttached", this.mIsAttached).aX("isRequestSubmitted", this.mpr).aX("hasFetchFailed", this.mpt).bN("fetchedImage", aV(this.mpx)).F("events", this.mpj.toString()).toString();
    }

    protected T dvC() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
