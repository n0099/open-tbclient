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
    private static final Class<?> jQR = a.class;
    private final com.facebook.drawee.components.a jTQ;
    private final DraweeEventTracker jUc = DraweeEventTracker.cCG();
    private final Executor jUd;
    @Nullable
    private com.facebook.drawee.components.b jUe;
    @Nullable
    private com.facebook.drawee.c.a jUf;
    @Nullable
    private c<INFO> jUg;
    @Nullable
    private d jUh;
    @Nullable
    private com.facebook.drawee.d.c jUi;
    @Nullable
    private Drawable jUj;
    private Object jUk;
    private boolean jUl;
    private boolean jUm;
    private boolean jUn;
    private boolean jUo;
    @Nullable
    private String jUp;
    @Nullable
    private com.facebook.datasource.b<T> jUq;
    @Nullable
    private T jUr;
    @Nullable
    private Throwable jUs;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aI(@Nullable T t);

    @Nullable
    protected abstract INFO aK(T t);

    protected abstract Drawable aL(T t);

    protected abstract com.facebook.datasource.b<T> cCv();

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
        this.jTQ = aVar;
        this.jUd = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.jUc.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cBM()) {
            this.jUs = new Throwable();
        }
        if (!z && this.jTQ != null) {
            this.jTQ.b(this);
        }
        this.mIsAttached = false;
        this.jUm = false;
        cCJ();
        this.jUo = false;
        if (this.jUe != null) {
            this.jUe.init();
        }
        if (this.jUf != null) {
            this.jUf.init();
            this.jUf.a(this);
        }
        if (this.jUg instanceof C0452a) {
            ((C0452a) this.jUg).cDe();
        } else {
            this.jUg = null;
        }
        this.jUh = null;
        if (this.jUi != null) {
            this.jUi.reset();
            this.jUi.g(null);
            this.jUi = null;
        }
        this.jUj = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.jUk = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0451a
    public void release() {
        this.jUc.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.jUe != null) {
            this.jUe.reset();
        }
        if (this.jUf != null) {
            this.jUf.reset();
        }
        if (this.jUi != null) {
            this.jUi.reset();
        }
        cCJ();
    }

    private void cCJ() {
        boolean z = this.jUl;
        this.jUl = false;
        this.jUn = false;
        if (this.jUq != null) {
            this.jUq.Ab();
            this.jUq = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.jUp != null) {
            this.jUp = null;
        }
        this.mDrawable = null;
        if (this.jUr != null) {
            w("release", this.jUr);
            aI(this.jUr);
            this.jUr = null;
        }
        if (z) {
            cCM().GQ(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cCK() {
        return this.jUe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.jUe = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cCL() {
        return this.jUf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.jUf = aVar;
        if (this.jUf != null) {
            this.jUf.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sg(boolean z) {
        this.jUo = z;
    }

    public void GP(@Nullable String str) {
        this.jUp = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.jUg instanceof C0452a) {
            ((C0452a) this.jUg).c(cVar);
        } else if (this.jUg != null) {
            this.jUg = C0452a.a(this.jUg, cVar);
        } else {
            this.jUg = cVar;
        }
    }

    protected c<INFO> cCM() {
        return this.jUg == null ? b.cDd() : this.jUg;
    }

    public void a(@Nullable d dVar) {
        this.jUh = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.jUi;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.jUc.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.jUl) {
            this.jTQ.b(this);
            release();
        }
        if (this.jUi != null) {
            this.jUi.g(null);
            this.jUi = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.jUi = (com.facebook.drawee.d.c) bVar;
            this.jUi.g(this.jUj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.jUj = drawable;
        if (this.jUi != null) {
            this.jUi.g(this.jUj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cCN() {
        return this.jUj;
    }

    @Override // com.facebook.drawee.d.a
    public void cCO() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.jUl ? "request already submitted" : "request needs submit");
        }
        this.jUc.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.jUi);
        this.jTQ.b(this);
        this.mIsAttached = true;
        if (!this.jUl) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.jUc.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.jTQ.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.jUf == null) {
            return false;
        }
        if (this.jUf.cDU() || cCP()) {
            this.jUf.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cCP() {
        return cCH();
    }

    private boolean cCH() {
        return this.jUn && this.jUe != null && this.jUe.cCH();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0450a
    public boolean cCQ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cCH()) {
            this.jUe.cCI();
            this.jUi.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cCx = cCx();
        if (cCx != null) {
            this.jUq = null;
            this.jUl = true;
            this.jUn = false;
            this.jUc.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cCM().x(this.mId, this.jUk);
            a(this.mId, this.jUq, cCx, 1.0f, true, true);
            return;
        }
        this.jUc.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cCM().x(this.mId, this.jUk);
        this.jUi.d(0.0f, true);
        this.jUl = true;
        this.jUn = false;
        this.jUq = cCv();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.jUq)));
        }
        final String str = this.mId;
        final boolean cCd = this.jUq.cCd();
        this.jUq.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.jUs != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.jUs);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cCd);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cCf(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.jUd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            w("ignore_old_datasource @ onNewResult", t);
            aI(t);
            bVar.Ab();
            return;
        }
        this.jUc.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aL = aL(t);
            T t2 = this.jUr;
            Drawable drawable = this.mDrawable;
            this.jUr = t;
            this.mDrawable = aL;
            try {
                if (z) {
                    w("set_final_result @ onNewResult", t);
                    this.jUq = null;
                    this.jUi.a(aL, 1.0f, z2);
                    cCM().a(str, aK(t), cCR());
                } else {
                    w("set_intermediate_result @ onNewResult", t);
                    this.jUi.a(aL, f, z2);
                    cCM().y(str, aK(t));
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
        this.jUc.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.jUq = null;
            this.jUn = true;
            if (this.jUo && this.mDrawable != null) {
                this.jUi.a(this.mDrawable, 1.0f, true);
            } else if (cCH()) {
                this.jUi.z(th);
            } else {
                this.jUi.y(th);
            }
            cCM().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cCM().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.Ab();
        } else if (!z) {
            this.jUi.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.jUq == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.jUq && this.jUl;
    }

    private void w(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jQR, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aM(t), Integer.valueOf(aJ(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jQR, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cCR() {
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
        return f.aC(this).aA("isAttached", this.mIsAttached).aA("isRequestSubmitted", this.jUl).aA("hasFetchFailed", this.jUn).bv("fetchedImage", aJ(this.jUr)).t("events", this.jUc.toString()).toString();
    }

    protected T cCx() {
        return null;
    }
}
