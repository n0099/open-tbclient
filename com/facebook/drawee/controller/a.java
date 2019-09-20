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
public abstract class a<T, INFO> implements a.InterfaceC0466a, a.InterfaceC0467a, com.facebook.drawee.d.a {
    private static final Class<?> kbD = a.class;
    private final com.facebook.drawee.components.a keC;
    private final DraweeEventTracker keO = DraweeEventTracker.cGR();
    private final Executor keP;
    @Nullable
    private com.facebook.drawee.components.b keQ;
    @Nullable
    private com.facebook.drawee.c.a keR;
    @Nullable
    private c<INFO> keS;
    @Nullable
    private d keT;
    @Nullable
    private com.facebook.drawee.d.c keU;
    @Nullable
    private Drawable keV;
    private Object keW;
    private boolean keX;
    private boolean keY;
    private boolean keZ;
    private boolean kfa;
    @Nullable
    private String kfb;
    @Nullable
    private com.facebook.datasource.b<T> kfc;
    @Nullable
    private T kfd;
    @Nullable
    private Throwable kfe;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aI(@Nullable T t);

    @Nullable
    protected abstract INFO aK(T t);

    protected abstract Drawable aL(T t);

    protected abstract com.facebook.datasource.b<T> cGG();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0468a<INFO> extends e<INFO> {
        private C0468a() {
        }

        public static <INFO> C0468a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0468a<INFO> c0468a = new C0468a<>();
            c0468a.c(cVar);
            c0468a.c(cVar2);
            return c0468a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.keC = aVar;
        this.keP = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.keO.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cFX()) {
            this.kfe = new Throwable();
        }
        if (!z && this.keC != null) {
            this.keC.b(this);
        }
        this.mIsAttached = false;
        this.keY = false;
        cGU();
        this.kfa = false;
        if (this.keQ != null) {
            this.keQ.init();
        }
        if (this.keR != null) {
            this.keR.init();
            this.keR.a(this);
        }
        if (this.keS instanceof C0468a) {
            ((C0468a) this.keS).cHp();
        } else {
            this.keS = null;
        }
        this.keT = null;
        if (this.keU != null) {
            this.keU.reset();
            this.keU.g(null);
            this.keU = null;
        }
        this.keV = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.keW = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0467a
    public void release() {
        this.keO.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.keQ != null) {
            this.keQ.reset();
        }
        if (this.keR != null) {
            this.keR.reset();
        }
        if (this.keU != null) {
            this.keU.reset();
        }
        cGU();
    }

    private void cGU() {
        boolean z = this.keX;
        this.keX = false;
        this.keZ = false;
        if (this.kfc != null) {
            this.kfc.AM();
            this.kfc = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.kfb != null) {
            this.kfb = null;
        }
        this.mDrawable = null;
        if (this.kfd != null) {
            w("release", this.kfd);
            aI(this.kfd);
            this.kfd = null;
        }
        if (z) {
            cGX().In(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cGV() {
        return this.keQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.keQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cGW() {
        return this.keR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.keR = aVar;
        if (this.keR != null) {
            this.keR.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sA(boolean z) {
        this.kfa = z;
    }

    public void Im(@Nullable String str) {
        this.kfb = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.keS instanceof C0468a) {
            ((C0468a) this.keS).c(cVar);
        } else if (this.keS != null) {
            this.keS = C0468a.a(this.keS, cVar);
        } else {
            this.keS = cVar;
        }
    }

    protected c<INFO> cGX() {
        return this.keS == null ? b.cHo() : this.keS;
    }

    public void a(@Nullable d dVar) {
        this.keT = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.keU;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.keO.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.keX) {
            this.keC.b(this);
            release();
        }
        if (this.keU != null) {
            this.keU.g(null);
            this.keU = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.keU = (com.facebook.drawee.d.c) bVar;
            this.keU.g(this.keV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.keV = drawable;
        if (this.keU != null) {
            this.keU.g(this.keV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cGY() {
        return this.keV;
    }

    @Override // com.facebook.drawee.d.a
    public void cGZ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.keX ? "request already submitted" : "request needs submit");
        }
        this.keO.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.keU);
        this.keC.b(this);
        this.mIsAttached = true;
        if (!this.keX) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.keO.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.keC.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.keR == null) {
            return false;
        }
        if (this.keR.cIh() || cHa()) {
            this.keR.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cHa() {
        return cGS();
    }

    private boolean cGS() {
        return this.keZ && this.keQ != null && this.keQ.cGS();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0466a
    public boolean cHb() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cGS()) {
            this.keQ.cGT();
            this.keU.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cGI = cGI();
        if (cGI != null) {
            this.kfc = null;
            this.keX = true;
            this.keZ = false;
            this.keO.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cGX().x(this.mId, this.keW);
            a(this.mId, this.kfc, cGI, 1.0f, true, true);
            return;
        }
        this.keO.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cGX().x(this.mId, this.keW);
        this.keU.d(0.0f, true);
        this.keX = true;
        this.keZ = false;
        this.kfc = cGG();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.kfc)));
        }
        final String str = this.mId;
        final boolean cGo = this.kfc.cGo();
        this.kfc.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.kfe != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.kfe);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cGo);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cGq(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.keP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            w("ignore_old_datasource @ onNewResult", t);
            aI(t);
            bVar.AM();
            return;
        }
        this.keO.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aL = aL(t);
            T t2 = this.kfd;
            Drawable drawable = this.mDrawable;
            this.kfd = t;
            this.mDrawable = aL;
            try {
                if (z) {
                    w("set_final_result @ onNewResult", t);
                    this.kfc = null;
                    this.keU.a(aL, 1.0f, z2);
                    cGX().a(str, aK(t), cHc());
                } else {
                    w("set_intermediate_result @ onNewResult", t);
                    this.keU.a(aL, f, z2);
                    cGX().y(str, aK(t));
                }
                if (drawable != null && drawable != aL) {
                    f(drawable);
                }
                if (t2 != null && t2 != t) {
                    w("release_previous_result @ onNewResult", t2);
                    aI(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aL) {
                    f(drawable);
                }
                if (t2 != null && t2 != t) {
                    w("release_previous_result @ onNewResult", t2);
                    aI(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            w("drawable_failed @ onNewResult", t);
            aI(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onFailure", th);
            bVar.AM();
            return;
        }
        this.keO.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.kfc = null;
            this.keZ = true;
            if (this.kfa && this.mDrawable != null) {
                this.keU.a(this.mDrawable, 1.0f, true);
            } else if (cGS()) {
                this.keU.z(th);
            } else {
                this.keU.y(th);
            }
            cGX().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cGX().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.AM();
        } else if (!z) {
            this.keU.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.kfc == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.kfc && this.keX;
    }

    private void w(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(kbD, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aM(t), Integer.valueOf(aJ(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(kbD, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cHc() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aM(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aJ(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aC(this).aE("isAttached", this.mIsAttached).aE("isRequestSubmitted", this.keX).aE("hasFetchFailed", this.keZ).by("fetchedImage", aJ(this.kfd)).t("events", this.keO.toString()).toString();
    }

    protected T cGI() {
        return null;
    }
}
