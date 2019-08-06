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
public abstract class a<T, INFO> implements a.InterfaceC0455a, a.InterfaceC0456a, com.facebook.drawee.d.a {
    private static final Class<?> jZg = a.class;
    private boolean kcA;
    private boolean kcB;
    private boolean kcC;
    @Nullable
    private String kcD;
    @Nullable
    private com.facebook.datasource.b<T> kcE;
    @Nullable
    private T kcF;
    @Nullable
    private Throwable kcG;
    private final com.facebook.drawee.components.a kce;
    private final DraweeEventTracker kcq = DraweeEventTracker.cGd();
    private final Executor kcr;
    @Nullable
    private com.facebook.drawee.components.b kcs;
    @Nullable
    private com.facebook.drawee.c.a kct;
    @Nullable
    private c<INFO> kcu;
    @Nullable
    private d kcv;
    @Nullable
    private com.facebook.drawee.d.c kcw;
    @Nullable
    private Drawable kcx;
    private Object kcy;
    private boolean kcz;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aI(@Nullable T t);

    @Nullable
    protected abstract INFO aK(T t);

    protected abstract Drawable aL(T t);

    protected abstract com.facebook.datasource.b<T> cFS();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0457a<INFO> extends e<INFO> {
        private C0457a() {
        }

        public static <INFO> C0457a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0457a<INFO> c0457a = new C0457a<>();
            c0457a.c(cVar);
            c0457a.c(cVar2);
            return c0457a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.kce = aVar;
        this.kcr = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.kcq.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cFj()) {
            this.kcG = new Throwable();
        }
        if (!z && this.kce != null) {
            this.kce.b(this);
        }
        this.mIsAttached = false;
        this.kcA = false;
        cGg();
        this.kcC = false;
        if (this.kcs != null) {
            this.kcs.init();
        }
        if (this.kct != null) {
            this.kct.init();
            this.kct.a(this);
        }
        if (this.kcu instanceof C0457a) {
            ((C0457a) this.kcu).cGB();
        } else {
            this.kcu = null;
        }
        this.kcv = null;
        if (this.kcw != null) {
            this.kcw.reset();
            this.kcw.g(null);
            this.kcw = null;
        }
        this.kcx = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.kcy = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0456a
    public void release() {
        this.kcq.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.kcs != null) {
            this.kcs.reset();
        }
        if (this.kct != null) {
            this.kct.reset();
        }
        if (this.kcw != null) {
            this.kcw.reset();
        }
        cGg();
    }

    private void cGg() {
        boolean z = this.kcz;
        this.kcz = false;
        this.kcB = false;
        if (this.kcE != null) {
            this.kcE.AI();
            this.kcE = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.kcD != null) {
            this.kcD = null;
        }
        this.mDrawable = null;
        if (this.kcF != null) {
            w("release", this.kcF);
            aI(this.kcF);
            this.kcF = null;
        }
        if (z) {
            cGj().HN(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cGh() {
        return this.kcs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.kcs = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cGi() {
        return this.kct;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.kct = aVar;
        if (this.kct != null) {
            this.kct.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sx(boolean z) {
        this.kcC = z;
    }

    public void HM(@Nullable String str) {
        this.kcD = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.kcu instanceof C0457a) {
            ((C0457a) this.kcu).c(cVar);
        } else if (this.kcu != null) {
            this.kcu = C0457a.a(this.kcu, cVar);
        } else {
            this.kcu = cVar;
        }
    }

    protected c<INFO> cGj() {
        return this.kcu == null ? b.cGA() : this.kcu;
    }

    public void a(@Nullable d dVar) {
        this.kcv = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.kcw;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.kcq.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.kcz) {
            this.kce.b(this);
            release();
        }
        if (this.kcw != null) {
            this.kcw.g(null);
            this.kcw = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.kcw = (com.facebook.drawee.d.c) bVar;
            this.kcw.g(this.kcx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.kcx = drawable;
        if (this.kcw != null) {
            this.kcw.g(this.kcx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cGk() {
        return this.kcx;
    }

    @Override // com.facebook.drawee.d.a
    public void cGl() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.kcz ? "request already submitted" : "request needs submit");
        }
        this.kcq.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.kcw);
        this.kce.b(this);
        this.mIsAttached = true;
        if (!this.kcz) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.kcq.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.kce.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.kct == null) {
            return false;
        }
        if (this.kct.cHt() || cGm()) {
            this.kct.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cGm() {
        return cGe();
    }

    private boolean cGe() {
        return this.kcB && this.kcs != null && this.kcs.cGe();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0455a
    public boolean cGn() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cGe()) {
            this.kcs.cGf();
            this.kcw.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cFU = cFU();
        if (cFU != null) {
            this.kcE = null;
            this.kcz = true;
            this.kcB = false;
            this.kcq.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cGj().x(this.mId, this.kcy);
            a(this.mId, this.kcE, cFU, 1.0f, true, true);
            return;
        }
        this.kcq.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cGj().x(this.mId, this.kcy);
        this.kcw.d(0.0f, true);
        this.kcz = true;
        this.kcB = false;
        this.kcE = cFS();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.kcE)));
        }
        final String str = this.mId;
        final boolean cFA = this.kcE.cFA();
        this.kcE.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.kcG != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.kcG);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cFA);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cFC(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.kcr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            w("ignore_old_datasource @ onNewResult", t);
            aI(t);
            bVar.AI();
            return;
        }
        this.kcq.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aL = aL(t);
            T t2 = this.kcF;
            Drawable drawable = this.mDrawable;
            this.kcF = t;
            this.mDrawable = aL;
            try {
                if (z) {
                    w("set_final_result @ onNewResult", t);
                    this.kcE = null;
                    this.kcw.a(aL, 1.0f, z2);
                    cGj().a(str, aK(t), cGo());
                } else {
                    w("set_intermediate_result @ onNewResult", t);
                    this.kcw.a(aL, f, z2);
                    cGj().y(str, aK(t));
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
            bVar.AI();
            return;
        }
        this.kcq.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.kcE = null;
            this.kcB = true;
            if (this.kcC && this.mDrawable != null) {
                this.kcw.a(this.mDrawable, 1.0f, true);
            } else if (cGe()) {
                this.kcw.z(th);
            } else {
                this.kcw.y(th);
            }
            cGj().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cGj().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.AI();
        } else if (!z) {
            this.kcw.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.kcE == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.kcE && this.kcz;
    }

    private void w(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jZg, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aM(t), Integer.valueOf(aJ(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZg, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cGo() {
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
        return f.aC(this).aE("isAttached", this.mIsAttached).aE("isRequestSubmitted", this.kcz).aE("hasFetchFailed", this.kcB).bw("fetchedImage", aJ(this.kcF)).t("events", this.kcq.toString()).toString();
    }

    protected T cFU() {
        return null;
    }
}
