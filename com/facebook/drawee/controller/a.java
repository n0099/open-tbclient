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
public abstract class a<T, INFO> implements a.InterfaceC0701a, a.InterfaceC0702a, com.facebook.drawee.d.a {
    private static final Class<?> lQm = a.class;
    private final com.facebook.drawee.components.a lTp;
    private Object lTv;
    private final Executor lUd;
    @Nullable
    private com.facebook.drawee.components.b lUe;
    @Nullable
    private com.facebook.drawee.c.a lUf;
    @Nullable
    private c<INFO> lUg;
    @Nullable
    private d lUh;
    @Nullable
    private com.facebook.drawee.d.c lUi;
    @Nullable
    private Drawable lUj;
    private boolean lUk;
    private boolean lUl;
    private boolean lUm;
    private boolean lUn;
    @Nullable
    private String lUo;
    @Nullable
    private com.facebook.datasource.b<T> lUp;
    @Nullable
    private T lUq;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lUc = DraweeEventTracker.dol();
    private boolean lUr = true;

    protected abstract void aP(@Nullable T t);

    @Nullable
    protected abstract INFO aR(T t);

    protected abstract Drawable aS(T t);

    protected abstract com.facebook.datasource.b<T> dnW();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0703a<INFO> extends e<INFO> {
        private C0703a() {
        }

        public static <INFO> C0703a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0703a<INFO> c0703a = new C0703a<>();
            c0703a.d(cVar);
            c0703a.d(cVar2);
            return c0703a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.lTp = aVar;
        this.lUd = executor;
        G(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(String str, Object obj) {
        G(str, obj);
        this.lUr = false;
    }

    private synchronized void G(String str, Object obj) {
        this.lUc.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lUr && this.lTp != null) {
            this.lTp.b(this);
        }
        this.mIsAttached = false;
        this.lUl = false;
        doo();
        this.lUn = false;
        if (this.lUe != null) {
            this.lUe.init();
        }
        if (this.lUf != null) {
            this.lUf.init();
            this.lUf.a(this);
        }
        if (this.lUg instanceof C0703a) {
            ((C0703a) this.lUg).doI();
        } else {
            this.lUg = null;
        }
        this.lUh = null;
        if (this.lUi != null) {
            this.lUi.reset();
            this.lUi.j(null);
            this.lUi = null;
        }
        this.lUj = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lTv = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0702a
    public void release() {
        this.lUc.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lUe != null) {
            this.lUe.reset();
        }
        if (this.lUf != null) {
            this.lUf.reset();
        }
        if (this.lUi != null) {
            this.lUi.reset();
        }
        doo();
    }

    private void doo() {
        boolean z = this.lUk;
        this.lUk = false;
        this.lUm = false;
        if (this.lUp != null) {
            this.lUp.Wv();
            this.lUp = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.lUo != null) {
            this.lUo = null;
        }
        this.mDrawable = null;
        if (this.lUq != null) {
            H("release", this.lUq);
            aP(this.lUq);
            this.lUq = null;
        }
        if (z) {
            dor().el(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dop() {
        if (this.lUe == null) {
            this.lUe = new com.facebook.drawee.components.b();
        }
        return this.lUe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a doq() {
        return this.lUf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lUf = aVar;
        if (this.lUf != null) {
            this.lUf.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vA(boolean z) {
        this.lUn = z;
    }

    public void Oh(@Nullable String str) {
        this.lUo = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lUg instanceof C0703a) {
            ((C0703a) this.lUg).d(cVar);
        } else if (this.lUg != null) {
            this.lUg = C0703a.a(this.lUg, cVar);
        } else {
            this.lUg = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lUg instanceof C0703a) {
            ((C0703a) this.lUg).e(cVar);
        } else if (this.lUg == cVar) {
            this.lUg = null;
        }
    }

    protected c<INFO> dor() {
        return this.lUg == null ? b.doH() : this.lUg;
    }

    public void a(@Nullable d dVar) {
        this.lUh = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lUi;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lUc.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lUk) {
            this.lTp.b(this);
            release();
        }
        if (this.lUi != null) {
            this.lUi.j(null);
            this.lUi = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lUi = (com.facebook.drawee.d.c) bVar;
            this.lUi.j(this.lUj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.lUj = drawable;
        if (this.lUi != null) {
            this.lUi.j(this.lUj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dos() {
        return this.lUj;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lUk ? "request already submitted" : "request needs submit");
        }
        this.lUc.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lUi);
        this.lTp.b(this);
        this.mIsAttached = true;
        if (!this.lUk) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lUc.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lTp.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lUf == null) {
            return false;
        }
        if (this.lUf.dpz() || dot()) {
            this.lUf.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dot() {
        return dom();
    }

    private boolean dom() {
        return this.lUm && this.lUe != null && this.lUe.dom();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0701a
    public boolean dou() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dom()) {
            this.lUe.don();
            this.lUi.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dnY = dnY();
        if (dnY != null) {
            this.lUp = null;
            this.lUk = true;
            this.lUm = false;
            this.lUc.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dor().g(this.mId, this.lTv);
            E(this.mId, dnY);
            a(this.mId, this.lUp, dnY, 1.0f, true, true);
            return;
        }
        this.lUc.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dor().g(this.mId, this.lTv);
        this.lUi.c(0.0f, true);
        this.lUk = true;
        this.lUm = false;
        this.lUp = dnW();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lUp)));
        }
        final String str = this.mId;
        final boolean dny = this.lUp.dny();
        this.lUp.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dny);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dnA(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lUd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            H("ignore_old_datasource @ onNewResult", t);
            aP(t);
            bVar.Wv();
            return;
        }
        this.lUc.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aS = aS(t);
            T t2 = this.lUq;
            Drawable drawable = this.mDrawable;
            this.lUq = t;
            this.mDrawable = aS;
            try {
                if (z) {
                    H("set_final_result @ onNewResult", t);
                    this.lUp = null;
                    this.lUi.a(aS, 1.0f, z2);
                    dor().a(str, aR(t), dov());
                } else {
                    H("set_intermediate_result @ onNewResult", t);
                    this.lUi.a(aS, f, z2);
                    dor().h(str, (String) aR(t));
                }
                if (drawable != null && drawable != aS) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    H("release_previous_result @ onNewResult", t2);
                    aP(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aS) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    H("release_previous_result @ onNewResult", t2);
                    aP(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            H("drawable_failed @ onNewResult", t);
            aP(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.Wv();
            return;
        }
        this.lUc.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.lUp = null;
            this.lUm = true;
            if (this.lUn && this.mDrawable != null) {
                this.lUi.a(this.mDrawable, 1.0f, true);
            } else if (dom()) {
                this.lUi.E(th);
            } else {
                this.lUi.D(th);
            }
            dor().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dor().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.Wv();
        } else if (!z) {
            this.lUi.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lUp == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lUp && this.lUk;
    }

    private void H(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lQm, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aU(t), Integer.valueOf(aQ(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQm, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dov() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aU(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aQ(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aI(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lUk).aK("hasFetchFailed", this.lUm).bM("fetchedImage", aQ(this.lUq)).C("events", this.lUc.toString()).toString();
    }

    protected T dnY() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(String str, T t) {
    }
}
