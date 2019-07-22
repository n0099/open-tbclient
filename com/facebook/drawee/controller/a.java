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
public abstract class a<T, INFO> implements a.InterfaceC0449a, a.InterfaceC0450a, com.facebook.drawee.d.a {
    private static final Class<?> jYa = a.class;
    private final com.facebook.drawee.components.a kaY;
    @Nullable
    private Throwable kbA;
    private final DraweeEventTracker kbk = DraweeEventTracker.cFI();
    private final Executor kbl;
    @Nullable
    private com.facebook.drawee.components.b kbm;
    @Nullable
    private com.facebook.drawee.c.a kbn;
    @Nullable
    private c<INFO> kbo;
    @Nullable
    private d kbp;
    @Nullable
    private com.facebook.drawee.d.c kbq;
    @Nullable
    private Drawable kbr;
    private Object kbs;
    private boolean kbt;
    private boolean kbu;
    private boolean kbv;
    private boolean kbw;
    @Nullable
    private String kbx;
    @Nullable
    private com.facebook.datasource.b<T> kby;
    @Nullable
    private T kbz;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aI(@Nullable T t);

    @Nullable
    protected abstract INFO aK(T t);

    protected abstract Drawable aL(T t);

    protected abstract com.facebook.datasource.b<T> cFx();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0451a<INFO> extends e<INFO> {
        private C0451a() {
        }

        public static <INFO> C0451a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0451a<INFO> c0451a = new C0451a<>();
            c0451a.c(cVar);
            c0451a.c(cVar2);
            return c0451a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.kaY = aVar;
        this.kbl = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.kbk.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cEO()) {
            this.kbA = new Throwable();
        }
        if (!z && this.kaY != null) {
            this.kaY.b(this);
        }
        this.mIsAttached = false;
        this.kbu = false;
        cFL();
        this.kbw = false;
        if (this.kbm != null) {
            this.kbm.init();
        }
        if (this.kbn != null) {
            this.kbn.init();
            this.kbn.a(this);
        }
        if (this.kbo instanceof C0451a) {
            ((C0451a) this.kbo).cGg();
        } else {
            this.kbo = null;
        }
        this.kbp = null;
        if (this.kbq != null) {
            this.kbq.reset();
            this.kbq.g(null);
            this.kbq = null;
        }
        this.kbr = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.kbs = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0450a
    public void release() {
        this.kbk.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.kbm != null) {
            this.kbm.reset();
        }
        if (this.kbn != null) {
            this.kbn.reset();
        }
        if (this.kbq != null) {
            this.kbq.reset();
        }
        cFL();
    }

    private void cFL() {
        boolean z = this.kbt;
        this.kbt = false;
        this.kbv = false;
        if (this.kby != null) {
            this.kby.AI();
            this.kby = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.kbx != null) {
            this.kbx = null;
        }
        this.mDrawable = null;
        if (this.kbz != null) {
            w("release", this.kbz);
            aI(this.kbz);
            this.kbz = null;
        }
        if (z) {
            cFO().HM(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cFM() {
        return this.kbm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.kbm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cFN() {
        return this.kbn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.kbn = aVar;
        if (this.kbn != null) {
            this.kbn.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sw(boolean z) {
        this.kbw = z;
    }

    public void HL(@Nullable String str) {
        this.kbx = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.kbo instanceof C0451a) {
            ((C0451a) this.kbo).c(cVar);
        } else if (this.kbo != null) {
            this.kbo = C0451a.a(this.kbo, cVar);
        } else {
            this.kbo = cVar;
        }
    }

    protected c<INFO> cFO() {
        return this.kbo == null ? b.cGf() : this.kbo;
    }

    public void a(@Nullable d dVar) {
        this.kbp = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.kbq;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.kbk.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.kbt) {
            this.kaY.b(this);
            release();
        }
        if (this.kbq != null) {
            this.kbq.g(null);
            this.kbq = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.kbq = (com.facebook.drawee.d.c) bVar;
            this.kbq.g(this.kbr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.kbr = drawable;
        if (this.kbq != null) {
            this.kbq.g(this.kbr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cFP() {
        return this.kbr;
    }

    @Override // com.facebook.drawee.d.a
    public void cFQ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.kbt ? "request already submitted" : "request needs submit");
        }
        this.kbk.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.kbq);
        this.kaY.b(this);
        this.mIsAttached = true;
        if (!this.kbt) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.kbk.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.kaY.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.kbn == null) {
            return false;
        }
        if (this.kbn.cGY() || cFR()) {
            this.kbn.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cFR() {
        return cFJ();
    }

    private boolean cFJ() {
        return this.kbv && this.kbm != null && this.kbm.cFJ();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0449a
    public boolean cFS() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cFJ()) {
            this.kbm.cFK();
            this.kbq.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cFz = cFz();
        if (cFz != null) {
            this.kby = null;
            this.kbt = true;
            this.kbv = false;
            this.kbk.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cFO().x(this.mId, this.kbs);
            a(this.mId, this.kby, cFz, 1.0f, true, true);
            return;
        }
        this.kbk.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cFO().x(this.mId, this.kbs);
        this.kbq.d(0.0f, true);
        this.kbt = true;
        this.kbv = false;
        this.kby = cFx();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.kby)));
        }
        final String str = this.mId;
        final boolean cFf = this.kby.cFf();
        this.kby.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.kbA != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.kbA);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cFf);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cFh(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.kbl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            w("ignore_old_datasource @ onNewResult", t);
            aI(t);
            bVar.AI();
            return;
        }
        this.kbk.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aL = aL(t);
            T t2 = this.kbz;
            Drawable drawable = this.mDrawable;
            this.kbz = t;
            this.mDrawable = aL;
            try {
                if (z) {
                    w("set_final_result @ onNewResult", t);
                    this.kby = null;
                    this.kbq.a(aL, 1.0f, z2);
                    cFO().a(str, aK(t), cFT());
                } else {
                    w("set_intermediate_result @ onNewResult", t);
                    this.kbq.a(aL, f, z2);
                    cFO().y(str, aK(t));
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
        this.kbk.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.kby = null;
            this.kbv = true;
            if (this.kbw && this.mDrawable != null) {
                this.kbq.a(this.mDrawable, 1.0f, true);
            } else if (cFJ()) {
                this.kbq.z(th);
            } else {
                this.kbq.y(th);
            }
            cFO().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        cFO().k(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.AI();
        } else if (!z) {
            this.kbq.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.kby == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.kby && this.kbt;
    }

    private void w(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(jYa, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aM(t), Integer.valueOf(aJ(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYa, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cFT() {
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
        return f.aC(this).aE("isAttached", this.mIsAttached).aE("isRequestSubmitted", this.kbt).aE("hasFetchFailed", this.kbv).bw("fetchedImage", aJ(this.kbz)).t("events", this.kbk.toString()).toString();
    }

    protected T cFz() {
        return null;
    }
}
