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
/* loaded from: classes14.dex */
public abstract class a<T, INFO> implements a.InterfaceC0974a, a.InterfaceC0975a, com.facebook.drawee.d.a {
    private static final Class<?> oLv = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private Object oOE;
    private final com.facebook.drawee.components.a oOy;
    private final Executor oPm;
    @Nullable
    private com.facebook.drawee.components.b oPn;
    @Nullable
    private com.facebook.drawee.c.a oPo;
    @Nullable
    private c<INFO> oPp;
    @Nullable
    private d oPq;
    @Nullable
    private com.facebook.drawee.d.c oPr;
    @Nullable
    private Drawable oPs;
    private boolean oPt;
    private boolean oPu;
    private boolean oPv;
    private boolean oPw;
    @Nullable
    private String oPx;
    @Nullable
    private com.facebook.datasource.b<T> oPy;
    @Nullable
    private T oPz;
    private final DraweeEventTracker oPl = DraweeEventTracker.elm();
    private boolean oPA = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> ekX();

    protected abstract void o(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0976a<INFO> extends e<INFO> {
        private C0976a() {
        }

        public static <INFO> C0976a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0976a<INFO> c0976a = new C0976a<>();
            c0976a.d(cVar);
            c0976a.d(cVar2);
            return c0976a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.oOy = aVar;
        this.oPm = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.oPA = false;
    }

    private synchronized void J(String str, Object obj) {
        this.oPl.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.oPA && this.oOy != null) {
            this.oOy.b(this);
        }
        this.mIsAttached = false;
        this.oPu = false;
        elp();
        this.oPw = false;
        if (this.oPn != null) {
            this.oPn.init();
        }
        if (this.oPo != null) {
            this.oPo.init();
            this.oPo.a(this);
        }
        if (this.oPp instanceof C0976a) {
            ((C0976a) this.oPp).elJ();
        } else {
            this.oPp = null;
        }
        this.oPq = null;
        if (this.oPr != null) {
            this.oPr.reset();
            this.oPr.p(null);
            this.oPr = null;
        }
        this.oPs = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.oOE = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0975a
    public void release() {
        this.oPl.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.oPn != null) {
            this.oPn.reset();
        }
        if (this.oPo != null) {
            this.oPo.reset();
        }
        if (this.oPr != null) {
            this.oPr.reset();
        }
        elp();
    }

    private void elp() {
        boolean z = this.oPt;
        this.oPt = false;
        this.oPv = false;
        if (this.oPy != null) {
            this.oPy.aoH();
            this.oPy = null;
        }
        if (this.mDrawable != null) {
            o(this.mDrawable);
        }
        if (this.oPx != null) {
            this.oPx = null;
        }
        this.mDrawable = null;
        if (this.oPz != null) {
            K("release", this.oPz);
            bh(this.oPz);
            this.oPz = null;
        }
        if (z) {
            els().hg(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b elq() {
        if (this.oPn == null) {
            this.oPn = new com.facebook.drawee.components.b();
        }
        return this.oPn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a elr() {
        return this.oPo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.oPo = aVar;
        if (this.oPo != null) {
            this.oPo.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ak(boolean z) {
        this.oPw = z;
    }

    public void XT(@Nullable String str) {
        this.oPx = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.oPp instanceof C0976a) {
            ((C0976a) this.oPp).d(cVar);
        } else if (this.oPp != null) {
            this.oPp = C0976a.a(this.oPp, cVar);
        } else {
            this.oPp = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.oPp instanceof C0976a) {
            ((C0976a) this.oPp).e(cVar);
        } else if (this.oPp == cVar) {
            this.oPp = null;
        }
    }

    protected c<INFO> els() {
        return this.oPp == null ? b.elI() : this.oPp;
    }

    public void a(@Nullable d dVar) {
        this.oPq = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.oPr;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.oPl.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.oPt) {
            this.oOy.b(this);
            release();
        }
        if (this.oPr != null) {
            this.oPr.p(null);
            this.oPr = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.oPr = (com.facebook.drawee.d.c) bVar;
            this.oPr.p(this.oPs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@Nullable Drawable drawable) {
        this.oPs = drawable;
        if (this.oPr != null) {
            this.oPr.p(this.oPs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable elt() {
        return this.oPs;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.oPt ? "request already submitted" : "request needs submit");
        }
        this.oPl.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.oPr);
        this.oOy.b(this);
        this.mIsAttached = true;
        if (!this.oPt) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.oPl.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.oOy.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.oPo == null) {
            return false;
        }
        if (this.oPo.emy() || elu()) {
            this.oPo.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean elu() {
        return eln();
    }

    private boolean eln() {
        return this.oPv && this.oPn != null && this.oPn.eln();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0974a
    public boolean elv() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (eln()) {
            this.oPn.elo();
            this.oPr.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T ekZ = ekZ();
        if (ekZ != null) {
            this.oPy = null;
            this.oPt = true;
            this.oPv = false;
            this.oPl.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            els().g(this.mId, this.oOE);
            H(this.mId, ekZ);
            a(this.mId, this.oPy, ekZ, 1.0f, true, true);
            return;
        }
        this.oPl.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        els().g(this.mId, this.oOE);
        this.oPr.c(0.0f, true);
        this.oPt = true;
        this.oPv = false;
        this.oPy = ekX();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.oPy)));
        }
        final String str = this.mId;
        final boolean ekz = this.oPy.ekz();
        this.oPy.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, ekz);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.ekB(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.oPm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.aoH();
            return;
        }
        this.oPl.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.oPz;
            Drawable drawable = this.mDrawable;
            this.oPz = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.oPy = null;
                    this.oPr.a(bk, 1.0f, z2);
                    els().a(str, bj(t), elw());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.oPr.a(bk, f, z2);
                    els().h(str, (String) bj(t));
                }
                if (drawable != null && drawable != bk) {
                    o(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bk) {
                    o(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            bh(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.aoH();
            return;
        }
        this.oPl.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.oPy = null;
            this.oPv = true;
            if (this.oPw && this.mDrawable != null) {
                this.oPr.a(this.mDrawable, 1.0f, true);
            } else if (eln()) {
                this.oPr.C(th);
            } else {
                this.oPr.B(th);
            }
            els().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        els().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.aoH();
        } else if (!z) {
            this.oPr.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.oPy == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.oPy && this.oPt;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(oLv, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable elw() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String bm(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int bi(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.ba(this).bn("isAttached", this.mIsAttached).bn("isRequestSubmitted", this.oPt).bn("hasFetchFailed", this.oPv).bV("fetchedImage", bi(this.oPz)).F("events", this.oPl.toString()).toString();
    }

    protected T ekZ() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
