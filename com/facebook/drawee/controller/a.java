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
public abstract class a<T, INFO> implements a.InterfaceC0561a, a.InterfaceC0562a, com.facebook.drawee.d.a {
    private static final Class<?> jYW = a.class;
    private final com.facebook.drawee.components.a kbT;
    private final DraweeEventTracker kcf = DraweeEventTracker.cDN();
    private final Executor kcg;
    @Nullable
    private com.facebook.drawee.components.b kch;
    @Nullable
    private com.facebook.drawee.c.a kci;
    @Nullable
    private c<INFO> kcj;
    @Nullable
    private d kck;
    @Nullable
    private com.facebook.drawee.d.c kcl;
    @Nullable
    private Drawable kcm;
    private Object kcn;
    private boolean kco;
    private boolean kcp;
    private boolean kcq;
    private boolean kcr;
    @Nullable
    private String kcs;
    @Nullable
    private com.facebook.datasource.b<T> kct;
    @Nullable
    private T kcu;
    @Nullable
    private Throwable kcv;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aD(@Nullable T t);

    @Nullable
    protected abstract INFO aF(T t);

    protected abstract Drawable aG(T t);

    protected abstract com.facebook.datasource.b<T> cDC();

    protected abstract void e(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0563a<INFO> extends e<INFO> {
        private C0563a() {
        }

        public static <INFO> C0563a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0563a<INFO> c0563a = new C0563a<>();
            c0563a.c(cVar);
            c0563a.c(cVar2);
            return c0563a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.kbT = aVar;
        this.kcg = executor;
        a(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str, Object obj) {
        a(str, obj, false);
    }

    private void a(String str, Object obj, boolean z) {
        this.kcf.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cCT()) {
            this.kcv = new Throwable();
        }
        if (!z && this.kbT != null) {
            this.kbT.b(this);
        }
        this.mIsAttached = false;
        this.kcp = false;
        cDQ();
        this.kcr = false;
        if (this.kch != null) {
            this.kch.init();
        }
        if (this.kci != null) {
            this.kci.init();
            this.kci.a(this);
        }
        if (this.kcj instanceof C0563a) {
            ((C0563a) this.kcj).cEl();
        } else {
            this.kcj = null;
        }
        this.kck = null;
        if (this.kcl != null) {
            this.kcl.reset();
            this.kcl.f(null);
            this.kcl = null;
        }
        this.kcm = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.kcn = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0562a
    public void release() {
        this.kcf.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.kch != null) {
            this.kch.reset();
        }
        if (this.kci != null) {
            this.kci.reset();
        }
        if (this.kcl != null) {
            this.kcl.reset();
        }
        cDQ();
    }

    private void cDQ() {
        boolean z = this.kco;
        this.kco = false;
        this.kcq = false;
        if (this.kct != null) {
            this.kct.FI();
            this.kct = null;
        }
        if (this.mDrawable != null) {
            e(this.mDrawable);
        }
        if (this.kcs != null) {
            this.kcs = null;
        }
        this.mDrawable = null;
        if (this.kcu != null) {
            t("release", this.kcu);
            aD(this.kcu);
            this.kcu = null;
        }
        if (z) {
            cDT().GE(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cDR() {
        return this.kch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.kch = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cDS() {
        return this.kci;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.kci = aVar;
        if (this.kci != null) {
            this.kci.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sf(boolean z) {
        this.kcr = z;
    }

    public void GD(@Nullable String str) {
        this.kcs = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.kcj instanceof C0563a) {
            ((C0563a) this.kcj).c(cVar);
        } else if (this.kcj != null) {
            this.kcj = C0563a.a(this.kcj, cVar);
        } else {
            this.kcj = cVar;
        }
    }

    protected c<INFO> cDT() {
        return this.kcj == null ? b.cEk() : this.kcj;
    }

    public void a(@Nullable d dVar) {
        this.kck = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.kcl;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.kcf.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.kco) {
            this.kbT.b(this);
            release();
        }
        if (this.kcl != null) {
            this.kcl.f(null);
            this.kcl = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.kcl = (com.facebook.drawee.d.c) bVar;
            this.kcl.f(this.kcm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@Nullable Drawable drawable) {
        this.kcm = drawable;
        if (this.kcl != null) {
            this.kcl.f(this.kcm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cDU() {
        return this.kcm;
    }

    @Override // com.facebook.drawee.d.a
    public void cDV() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.kco ? "request already submitted" : "request needs submit");
        }
        this.kcf.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.kcl);
        this.kbT.b(this);
        this.mIsAttached = true;
        if (!this.kco) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.kcf.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.kbT.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.kci == null) {
            return false;
        }
        if (this.kci.cFc() || cDW()) {
            this.kci.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cDW() {
        return cDO();
    }

    private boolean cDO() {
        return this.kcq && this.kch != null && this.kch.cDO();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0561a
    public boolean cDX() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cDO()) {
            this.kch.cDP();
            this.kcl.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cDE = cDE();
        if (cDE != null) {
            this.kct = null;
            this.kco = true;
            this.kcq = false;
            this.kcf.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cDT().u(this.mId, this.kcn);
            a(this.mId, this.kct, cDE, 1.0f, true, true);
            return;
        }
        this.kcf.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cDT().u(this.mId, this.kcn);
        this.kcl.d(0.0f, true);
        this.kco = true;
        this.kcq = false;
        this.kct = cDC();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.kct)));
        }
        final String str = this.mId;
        final boolean cDk = this.kct.cDk();
        this.kct.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.kcv != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.kcv);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cDk);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cDm(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.kcg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            t("ignore_old_datasource @ onNewResult", t);
            aD(t);
            bVar.FI();
            return;
        }
        this.kcf.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aG = aG(t);
            T t2 = this.kcu;
            Drawable drawable = this.mDrawable;
            this.kcu = t;
            this.mDrawable = aG;
            try {
                if (z) {
                    t("set_final_result @ onNewResult", t);
                    this.kct = null;
                    this.kcl.a(aG, 1.0f, z2);
                    cDT().a(str, aF(t), cDY());
                } else {
                    t("set_intermediate_result @ onNewResult", t);
                    this.kcl.a(aG, f, z2);
                    cDT().v(str, aF(t));
                }
                if (drawable != null && drawable != aG) {
                    e(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aD(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aG) {
                    e(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aD(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            t("drawable_failed @ onNewResult", t);
            aD(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.FI();
            return;
        }
        this.kcf.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.kct = null;
            this.kcq = true;
            if (this.kcr && this.mDrawable != null) {
                this.kcl.a(this.mDrawable, 1.0f, true);
            } else if (cDO()) {
                this.kcl.z(th);
            } else {
                this.kcl.y(th);
            }
            cDT().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        cDT().l(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.FI();
        } else if (!z) {
            this.kcl.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.kct == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.kct && this.kco;
    }

    private void t(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(jYW, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aH(t), Integer.valueOf(aE(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jYW, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cDY() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aH(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aE(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.ax(this).az("isAttached", this.mIsAttached).az("isRequestSubmitted", this.kco).az("hasFetchFailed", this.kcq).bt("fetchedImage", aE(this.kcu)).q("events", this.kcf.toString()).toString();
    }

    protected T cDE() {
        return null;
    }
}
