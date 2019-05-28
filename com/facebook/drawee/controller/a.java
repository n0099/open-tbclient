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
    private static final Class<?> jQS = a.class;
    private final com.facebook.drawee.components.a jTR;
    private final DraweeEventTracker jUd = DraweeEventTracker.cCI();
    private final Executor jUe;
    @Nullable
    private com.facebook.drawee.components.b jUf;
    @Nullable
    private com.facebook.drawee.c.a jUg;
    @Nullable
    private c<INFO> jUh;
    @Nullable
    private d jUi;
    @Nullable
    private com.facebook.drawee.d.c jUj;
    @Nullable
    private Drawable jUk;
    private Object jUl;
    private boolean jUm;
    private boolean jUn;
    private boolean jUo;
    private boolean jUp;
    @Nullable
    private String jUq;
    @Nullable
    private com.facebook.datasource.b<T> jUr;
    @Nullable
    private T jUs;
    @Nullable
    private Throwable jUt;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aI(@Nullable T t);

    @Nullable
    protected abstract INFO aK(T t);

    protected abstract Drawable aL(T t);

    protected abstract com.facebook.datasource.b<T> cCx();

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
        this.jTR = aVar;
        this.jUe = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.jUd.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cBO()) {
            this.jUt = new Throwable();
        }
        if (!z && this.jTR != null) {
            this.jTR.b(this);
        }
        this.mIsAttached = false;
        this.jUn = false;
        cCL();
        this.jUp = false;
        if (this.jUf != null) {
            this.jUf.init();
        }
        if (this.jUg != null) {
            this.jUg.init();
            this.jUg.a(this);
        }
        if (this.jUh instanceof C0452a) {
            ((C0452a) this.jUh).cDg();
        } else {
            this.jUh = null;
        }
        this.jUi = null;
        if (this.jUj != null) {
            this.jUj.reset();
            this.jUj.g(null);
            this.jUj = null;
        }
        this.jUk = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.jUl = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0451a
    public void release() {
        this.jUd.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.jUf != null) {
            this.jUf.reset();
        }
        if (this.jUg != null) {
            this.jUg.reset();
        }
        if (this.jUj != null) {
            this.jUj.reset();
        }
        cCL();
    }

    private void cCL() {
        boolean z = this.jUm;
        this.jUm = false;
        this.jUo = false;
        if (this.jUr != null) {
            this.jUr.Ab();
            this.jUr = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.jUq != null) {
            this.jUq = null;
        }
        this.mDrawable = null;
        if (this.jUs != null) {
            w("release", this.jUs);
            aI(this.jUs);
            this.jUs = null;
        }
        if (z) {
            cCO().GQ(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cCM() {
        return this.jUf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.jUf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cCN() {
        return this.jUg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.jUg = aVar;
        if (this.jUg != null) {
            this.jUg.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sg(boolean z) {
        this.jUp = z;
    }

    public void GP(@Nullable String str) {
        this.jUq = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.jUh instanceof C0452a) {
            ((C0452a) this.jUh).c(cVar);
        } else if (this.jUh != null) {
            this.jUh = C0452a.a(this.jUh, cVar);
        } else {
            this.jUh = cVar;
        }
    }

    protected c<INFO> cCO() {
        return this.jUh == null ? b.cDf() : this.jUh;
    }

    public void a(@Nullable d dVar) {
        this.jUi = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.jUj;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.jUd.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.jUm) {
            this.jTR.b(this);
            release();
        }
        if (this.jUj != null) {
            this.jUj.g(null);
            this.jUj = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.jUj = (com.facebook.drawee.d.c) bVar;
            this.jUj.g(this.jUk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.jUk = drawable;
        if (this.jUj != null) {
            this.jUj.g(this.jUk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cCP() {
        return this.jUk;
    }

    @Override // com.facebook.drawee.d.a
    public void cCQ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.jUm ? "request already submitted" : "request needs submit");
        }
        this.jUd.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.jUj);
        this.jTR.b(this);
        this.mIsAttached = true;
        if (!this.jUm) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.jUd.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.jTR.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.jUg == null) {
            return false;
        }
        if (this.jUg.cDW() || cCR()) {
            this.jUg.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cCR() {
        return cCJ();
    }

    private boolean cCJ() {
        return this.jUo && this.jUf != null && this.jUf.cCJ();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0450a
    public boolean cCS() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cCJ()) {
            this.jUf.cCK();
            this.jUj.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cCz = cCz();
        if (cCz != null) {
            this.jUr = null;
            this.jUm = true;
            this.jUo = false;
            this.jUd.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cCO().x(this.mId, this.jUl);
            a(this.mId, this.jUr, cCz, 1.0f, true, true);
            return;
        }
        this.jUd.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cCO().x(this.mId, this.jUl);
        this.jUj.d(0.0f, true);
        this.jUm = true;
        this.jUo = false;
        this.jUr = cCx();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.jUr)));
        }
        final String str = this.mId;
        final boolean cCf = this.jUr.cCf();
        this.jUr.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.jUt != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.jUt);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cCf);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cCh(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.jUe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            w("ignore_old_datasource @ onNewResult", t);
            aI(t);
            bVar.Ab();
            return;
        }
        this.jUd.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aL = aL(t);
            T t2 = this.jUs;
            Drawable drawable = this.mDrawable;
            this.jUs = t;
            this.mDrawable = aL;
            try {
                if (z) {
                    w("set_final_result @ onNewResult", t);
                    this.jUr = null;
                    this.jUj.a(aL, 1.0f, z2);
                    cCO().a(str, aK(t), cCT());
                } else {
                    w("set_intermediate_result @ onNewResult", t);
                    this.jUj.a(aL, f, z2);
                    cCO().y(str, aK(t));
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
        this.jUd.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.jUr = null;
            this.jUo = true;
            if (this.jUp && this.mDrawable != null) {
                this.jUj.a(this.mDrawable, 1.0f, true);
            } else if (cCJ()) {
                this.jUj.z(th);
            } else {
                this.jUj.y(th);
            }
            cCO().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cCO().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.Ab();
        } else if (!z) {
            this.jUj.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.jUr == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.jUr && this.jUm;
    }

    private void w(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jQS, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aM(t), Integer.valueOf(aJ(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQS, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cCT() {
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
        return f.aC(this).aA("isAttached", this.mIsAttached).aA("isRequestSubmitted", this.jUm).aA("hasFetchFailed", this.jUo).bv("fetchedImage", aJ(this.jUs)).t("events", this.jUd.toString()).toString();
    }

    protected T cCz() {
        return null;
    }
}
