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
public abstract class a<T, INFO> implements a.InterfaceC0450a, a.InterfaceC0451a, com.facebook.drawee.d.a {
    private static final Class<?> jQV = a.class;
    private final com.facebook.drawee.components.a jTU;
    private final DraweeEventTracker jUg = DraweeEventTracker.cCH();
    private final Executor jUh;
    @Nullable
    private com.facebook.drawee.components.b jUi;
    @Nullable
    private com.facebook.drawee.c.a jUj;
    @Nullable
    private c<INFO> jUk;
    @Nullable
    private d jUl;
    @Nullable
    private com.facebook.drawee.d.c jUm;
    @Nullable
    private Drawable jUn;
    private Object jUo;
    private boolean jUp;
    private boolean jUq;
    private boolean jUr;
    private boolean jUs;
    @Nullable
    private String jUt;
    @Nullable
    private com.facebook.datasource.b<T> jUu;
    @Nullable
    private T jUv;
    @Nullable
    private Throwable jUw;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aI(@Nullable T t);

    @Nullable
    protected abstract INFO aK(T t);

    protected abstract Drawable aL(T t);

    protected abstract com.facebook.datasource.b<T> cCw();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0452a<INFO> extends e<INFO> {
        private C0452a() {
        }

        public static <INFO> C0452a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0452a<INFO> c0452a = new C0452a<>();
            c0452a.c(cVar);
            c0452a.c(cVar2);
            return c0452a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.jTU = aVar;
        this.jUh = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.jUg.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cBN()) {
            this.jUw = new Throwable();
        }
        if (!z && this.jTU != null) {
            this.jTU.b(this);
        }
        this.mIsAttached = false;
        this.jUq = false;
        cCK();
        this.jUs = false;
        if (this.jUi != null) {
            this.jUi.init();
        }
        if (this.jUj != null) {
            this.jUj.init();
            this.jUj.a(this);
        }
        if (this.jUk instanceof C0452a) {
            ((C0452a) this.jUk).cDf();
        } else {
            this.jUk = null;
        }
        this.jUl = null;
        if (this.jUm != null) {
            this.jUm.reset();
            this.jUm.g(null);
            this.jUm = null;
        }
        this.jUn = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.jUo = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0451a
    public void release() {
        this.jUg.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.jUi != null) {
            this.jUi.reset();
        }
        if (this.jUj != null) {
            this.jUj.reset();
        }
        if (this.jUm != null) {
            this.jUm.reset();
        }
        cCK();
    }

    private void cCK() {
        boolean z = this.jUp;
        this.jUp = false;
        this.jUr = false;
        if (this.jUu != null) {
            this.jUu.Ab();
            this.jUu = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.jUt != null) {
            this.jUt = null;
        }
        this.mDrawable = null;
        if (this.jUv != null) {
            w("release", this.jUv);
            aI(this.jUv);
            this.jUv = null;
        }
        if (z) {
            cCN().GS(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cCL() {
        return this.jUi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.jUi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cCM() {
        return this.jUj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.jUj = aVar;
        if (this.jUj != null) {
            this.jUj.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sh(boolean z) {
        this.jUs = z;
    }

    public void GR(@Nullable String str) {
        this.jUt = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.jUk instanceof C0452a) {
            ((C0452a) this.jUk).c(cVar);
        } else if (this.jUk != null) {
            this.jUk = C0452a.a(this.jUk, cVar);
        } else {
            this.jUk = cVar;
        }
    }

    protected c<INFO> cCN() {
        return this.jUk == null ? b.cDe() : this.jUk;
    }

    public void a(@Nullable d dVar) {
        this.jUl = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.jUm;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.jUg.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.jUp) {
            this.jTU.b(this);
            release();
        }
        if (this.jUm != null) {
            this.jUm.g(null);
            this.jUm = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.jUm = (com.facebook.drawee.d.c) bVar;
            this.jUm.g(this.jUn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.jUn = drawable;
        if (this.jUm != null) {
            this.jUm.g(this.jUn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cCO() {
        return this.jUn;
    }

    @Override // com.facebook.drawee.d.a
    public void cCP() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.jUp ? "request already submitted" : "request needs submit");
        }
        this.jUg.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.jUm);
        this.jTU.b(this);
        this.mIsAttached = true;
        if (!this.jUp) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.jUg.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.jTU.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.jUj == null) {
            return false;
        }
        if (this.jUj.cDV() || cCQ()) {
            this.jUj.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cCQ() {
        return cCI();
    }

    private boolean cCI() {
        return this.jUr && this.jUi != null && this.jUi.cCI();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0450a
    public boolean cCR() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cCI()) {
            this.jUi.cCJ();
            this.jUm.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cCy = cCy();
        if (cCy != null) {
            this.jUu = null;
            this.jUp = true;
            this.jUr = false;
            this.jUg.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cCN().x(this.mId, this.jUo);
            a(this.mId, this.jUu, cCy, 1.0f, true, true);
            return;
        }
        this.jUg.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cCN().x(this.mId, this.jUo);
        this.jUm.d(0.0f, true);
        this.jUp = true;
        this.jUr = false;
        this.jUu = cCw();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.jUu)));
        }
        final String str = this.mId;
        final boolean cCe = this.jUu.cCe();
        this.jUu.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.jUw != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.jUw);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cCe);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cCg(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.jUh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            w("ignore_old_datasource @ onNewResult", t);
            aI(t);
            bVar.Ab();
            return;
        }
        this.jUg.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aL = aL(t);
            T t2 = this.jUv;
            Drawable drawable = this.mDrawable;
            this.jUv = t;
            this.mDrawable = aL;
            try {
                if (z) {
                    w("set_final_result @ onNewResult", t);
                    this.jUu = null;
                    this.jUm.a(aL, 1.0f, z2);
                    cCN().a(str, aK(t), cCS());
                } else {
                    w("set_intermediate_result @ onNewResult", t);
                    this.jUm.a(aL, f, z2);
                    cCN().y(str, aK(t));
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
            bVar.Ab();
            return;
        }
        this.jUg.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.jUu = null;
            this.jUr = true;
            if (this.jUs && this.mDrawable != null) {
                this.jUm.a(this.mDrawable, 1.0f, true);
            } else if (cCI()) {
                this.jUm.z(th);
            } else {
                this.jUm.y(th);
            }
            cCN().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cCN().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.Ab();
        } else if (!z) {
            this.jUm.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.jUu == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.jUu && this.jUp;
    }

    private void w(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jQV, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aM(t), Integer.valueOf(aJ(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQV, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cCS() {
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
        return f.aC(this).aA("isAttached", this.mIsAttached).aA("isRequestSubmitted", this.jUp).aA("hasFetchFailed", this.jUr).bv("fetchedImage", aJ(this.jUv)).t("events", this.jUg.toString()).toString();
    }

    protected T cCy() {
        return null;
    }
}
