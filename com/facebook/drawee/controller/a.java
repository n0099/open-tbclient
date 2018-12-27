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
public abstract class a<T, INFO> implements a.InterfaceC0360a, a.InterfaceC0361a, com.facebook.drawee.d.a {
    private static final Class<?> ihJ = a.class;
    private final com.facebook.drawee.components.a ikM;
    private final DraweeEventTracker ikY = DraweeEventTracker.bUZ();
    private final Executor ikZ;
    @Nullable
    private com.facebook.drawee.components.b ila;
    @Nullable
    private com.facebook.drawee.c.a ilb;
    @Nullable
    private c<INFO> ilc;
    @Nullable
    private d ild;
    @Nullable
    private com.facebook.drawee.d.c ile;
    @Nullable
    private Drawable ilf;
    private Object ilg;
    private boolean ilh;
    private boolean ili;
    private boolean ilj;
    private boolean ilk;
    @Nullable
    private String ill;
    @Nullable
    private com.facebook.datasource.b<T> ilm;
    @Nullable
    private T iln;
    @Nullable
    private Throwable ilo;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void au(@Nullable T t);

    @Nullable
    protected abstract INFO aw(T t);

    protected abstract Drawable ax(T t);

    protected abstract com.facebook.datasource.b<T> bUO();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0362a<INFO> extends e<INFO> {
        private C0362a() {
        }

        public static <INFO> C0362a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0362a<INFO> c0362a = new C0362a<>();
            c0362a.c(cVar);
            c0362a.c(cVar2);
            return c0362a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.ikM = aVar;
        this.ikZ = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.ikY.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.bUd()) {
            this.ilo = new Throwable();
        }
        if (!z && this.ikM != null) {
            this.ikM.b(this);
        }
        this.mIsAttached = false;
        this.ili = false;
        bVc();
        this.ilk = false;
        if (this.ila != null) {
            this.ila.init();
        }
        if (this.ilb != null) {
            this.ilb.init();
            this.ilb.a(this);
        }
        if (this.ilc instanceof C0362a) {
            ((C0362a) this.ilc).bVv();
        } else {
            this.ilc = null;
        }
        this.ild = null;
        if (this.ile != null) {
            this.ile.reset();
            this.ile.g(null);
            this.ile = null;
        }
        this.ilf = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.ilg = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0361a
    public void release() {
        this.ikY.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.ila != null) {
            this.ila.reset();
        }
        if (this.ilb != null) {
            this.ilb.reset();
        }
        if (this.ile != null) {
            this.ile.reset();
        }
        bVc();
    }

    private void bVc() {
        boolean z = this.ilh;
        this.ilh = false;
        this.ilj = false;
        if (this.ilm != null) {
            this.ilm.bUy();
            this.ilm = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.ill != null) {
            this.ill = null;
        }
        this.mDrawable = null;
        if (this.iln != null) {
            q("release", this.iln);
            au(this.iln);
            this.iln = null;
        }
        if (z) {
            bVf().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b bVd() {
        return this.ila;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.ila = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a bVe() {
        return this.ilb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.ilb = aVar;
        if (this.ilb != null) {
            this.ilb.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oV(boolean z) {
        this.ilk = z;
    }

    public void zl(@Nullable String str) {
        this.ill = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.ilc instanceof C0362a) {
            ((C0362a) this.ilc).c(cVar);
        } else if (this.ilc != null) {
            this.ilc = C0362a.a(this.ilc, cVar);
        } else {
            this.ilc = cVar;
        }
    }

    protected c<INFO> bVf() {
        return this.ilc == null ? b.getNoOpListener() : this.ilc;
    }

    public void a(@Nullable d dVar) {
        this.ild = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.ile;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.ikY.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.ilh) {
            this.ikM.b(this);
            release();
        }
        if (this.ile != null) {
            this.ile.g(null);
            this.ile = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.ile = (com.facebook.drawee.d.c) bVar;
            this.ile.g(this.ilf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.ilf = drawable;
        if (this.ile != null) {
            this.ile.g(this.ilf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable bVg() {
        return this.ilf;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.ilh ? "request already submitted" : "request needs submit");
        }
        this.ikY.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.ile);
        this.ikM.b(this);
        this.mIsAttached = true;
        if (!this.ilh) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.ikY.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.ikM.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.ilb == null) {
            return false;
        }
        if (this.ilb.bWl() || bVh()) {
            this.ilb.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean bVh() {
        return bVa();
    }

    private boolean bVa() {
        return this.ilj && this.ila != null && this.ila.bVa();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0360a
    public boolean bVi() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (bVa()) {
            this.ila.bVb();
            this.ile.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T bUQ = bUQ();
        if (bUQ != null) {
            this.ilm = null;
            this.ilh = true;
            this.ilj = false;
            this.ikY.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            bVf().onSubmit(this.mId, this.ilg);
            a(this.mId, this.ilm, bUQ, 1.0f, true, true);
            return;
        }
        this.ikY.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        bVf().onSubmit(this.mId, this.ilg);
        this.ile.d(0.0f, true);
        this.ilh = true;
        this.ilj = false;
        this.ilm = bUO();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.ilm)));
        }
        final String str = this.mId;
        final boolean bUv = this.ilm.bUv();
        this.ilm.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.ilo != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.ilo);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, bUv);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.bUx(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.ikZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            q("ignore_old_datasource @ onNewResult", t);
            au(t);
            bVar.bUy();
            return;
        }
        this.ikY.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ax = ax(t);
            T t2 = this.iln;
            Drawable drawable = this.mDrawable;
            this.iln = t;
            this.mDrawable = ax;
            try {
                if (z) {
                    q("set_final_result @ onNewResult", t);
                    this.ilm = null;
                    this.ile.a(ax, 1.0f, z2);
                    bVf().onFinalImageSet(str, aw(t), bVj());
                } else {
                    q("set_intermediate_result @ onNewResult", t);
                    this.ile.a(ax, f, z2);
                    bVf().onIntermediateImageSet(str, aw(t));
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
            bVar.bUy();
            return;
        }
        this.ikY.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.ilm = null;
            this.ilj = true;
            if (this.ilk && this.mDrawable != null) {
                this.ile.a(this.mDrawable, 1.0f, true);
            } else if (bVa()) {
                this.ile.z(th);
            } else {
                this.ile.y(th);
            }
            bVf().onFailure(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        bVf().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.bUy();
        } else if (!z) {
            this.ile.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.ilm == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.ilm && this.ilh;
    }

    private void q(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(ihJ, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ay(t), Integer.valueOf(av(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(ihJ, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable bVj() {
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
        return f.ao(this).ai("isAttached", this.mIsAttached).ai("isRequestSubmitted", this.ilh).ai("hasFetchFailed", this.ilj).bg("fetchedImage", av(this.iln)).n("events", this.ikY.toString()).toString();
    }

    protected T bUQ() {
        return null;
    }
}
