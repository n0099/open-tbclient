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
public abstract class a<T, INFO> implements a.InterfaceC0722a, a.InterfaceC0723a, com.facebook.drawee.d.a {
    private static final Class<?> lQq = a.class;
    private final com.facebook.drawee.components.a lTt;
    private Object lTz;
    private final Executor lUh;
    @Nullable
    private com.facebook.drawee.components.b lUi;
    @Nullable
    private com.facebook.drawee.c.a lUj;
    @Nullable
    private c<INFO> lUk;
    @Nullable
    private d lUl;
    @Nullable
    private com.facebook.drawee.d.c lUm;
    @Nullable
    private Drawable lUn;
    private boolean lUo;
    private boolean lUp;
    private boolean lUq;
    private boolean lUr;
    @Nullable
    private String lUs;
    @Nullable
    private com.facebook.datasource.b<T> lUt;
    @Nullable
    private T lUu;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final DraweeEventTracker lUg = DraweeEventTracker.doi();
    private boolean lUv = true;

    protected abstract void aQ(@Nullable T t);

    @Nullable
    protected abstract INFO aS(T t);

    protected abstract Drawable aT(T t);

    protected abstract com.facebook.datasource.b<T> dnT();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0724a<INFO> extends e<INFO> {
        private C0724a() {
        }

        public static <INFO> C0724a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0724a<INFO> c0724a = new C0724a<>();
            c0724a.d(cVar);
            c0724a.d(cVar2);
            return c0724a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.lTt = aVar;
        this.lUh = executor;
        G(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(String str, Object obj) {
        G(str, obj);
        this.lUv = false;
    }

    private synchronized void G(String str, Object obj) {
        this.lUg.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.lUv && this.lTt != null) {
            this.lTt.b(this);
        }
        this.mIsAttached = false;
        this.lUp = false;
        dol();
        this.lUr = false;
        if (this.lUi != null) {
            this.lUi.init();
        }
        if (this.lUj != null) {
            this.lUj.init();
            this.lUj.a(this);
        }
        if (this.lUk instanceof C0724a) {
            ((C0724a) this.lUk).doF();
        } else {
            this.lUk = null;
        }
        this.lUl = null;
        if (this.lUm != null) {
            this.lUm.reset();
            this.lUm.j(null);
            this.lUm = null;
        }
        this.lUn = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.lTz = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0723a
    public void release() {
        this.lUg.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.lUi != null) {
            this.lUi.reset();
        }
        if (this.lUj != null) {
            this.lUj.reset();
        }
        if (this.lUm != null) {
            this.lUm.reset();
        }
        dol();
    }

    private void dol() {
        boolean z = this.lUo;
        this.lUo = false;
        this.lUq = false;
        if (this.lUt != null) {
            this.lUt.Wu();
            this.lUt = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.lUs != null) {
            this.lUs = null;
        }
        this.mDrawable = null;
        if (this.lUu != null) {
            H("release", this.lUu);
            aQ(this.lUu);
            this.lUu = null;
        }
        if (z) {
            doo().el(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dom() {
        if (this.lUi == null) {
            this.lUi = new com.facebook.drawee.components.b();
        }
        return this.lUi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a don() {
        return this.lUj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.lUj = aVar;
        if (this.lUj != null) {
            this.lUj.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vA(boolean z) {
        this.lUr = z;
    }

    public void Ok(@Nullable String str) {
        this.lUs = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lUk instanceof C0724a) {
            ((C0724a) this.lUk).d(cVar);
        } else if (this.lUk != null) {
            this.lUk = C0724a.a(this.lUk, cVar);
        } else {
            this.lUk = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.lUk instanceof C0724a) {
            ((C0724a) this.lUk).e(cVar);
        } else if (this.lUk == cVar) {
            this.lUk = null;
        }
    }

    protected c<INFO> doo() {
        return this.lUk == null ? b.doE() : this.lUk;
    }

    public void a(@Nullable d dVar) {
        this.lUl = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.lUm;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.lUg.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.lUo) {
            this.lTt.b(this);
            release();
        }
        if (this.lUm != null) {
            this.lUm.j(null);
            this.lUm = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.lUm = (com.facebook.drawee.d.c) bVar;
            this.lUm.j(this.lUn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.lUn = drawable;
        if (this.lUm != null) {
            this.lUm.j(this.lUn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dop() {
        return this.lUn;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.lUo ? "request already submitted" : "request needs submit");
        }
        this.lUg.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.lUm);
        this.lTt.b(this);
        this.mIsAttached = true;
        if (!this.lUo) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.lUg.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.lTt.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.lUj == null) {
            return false;
        }
        if (this.lUj.dpw() || doq()) {
            this.lUj.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean doq() {
        return doj();
    }

    private boolean doj() {
        return this.lUq && this.lUi != null && this.lUi.doj();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0722a
    public boolean dor() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (doj()) {
            this.lUi.dok();
            this.lUm.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dnV = dnV();
        if (dnV != null) {
            this.lUt = null;
            this.lUo = true;
            this.lUq = false;
            this.lUg.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            doo().g(this.mId, this.lTz);
            E(this.mId, dnV);
            a(this.mId, this.lUt, dnV, 1.0f, true, true);
            return;
        }
        this.lUg.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        doo().g(this.mId, this.lTz);
        this.lUm.c(0.0f, true);
        this.lUo = true;
        this.lUq = false;
        this.lUt = dnT();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.lUt)));
        }
        final String str = this.mId;
        final boolean dnv = this.lUt.dnv();
        this.lUt.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dnv);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dnx(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.lUh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            H("ignore_old_datasource @ onNewResult", t);
            aQ(t);
            bVar.Wu();
            return;
        }
        this.lUg.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aT = aT(t);
            T t2 = this.lUu;
            Drawable drawable = this.mDrawable;
            this.lUu = t;
            this.mDrawable = aT;
            try {
                if (z) {
                    H("set_final_result @ onNewResult", t);
                    this.lUt = null;
                    this.lUm.a(aT, 1.0f, z2);
                    doo().a(str, aS(t), dos());
                } else {
                    H("set_intermediate_result @ onNewResult", t);
                    this.lUm.a(aT, f, z2);
                    doo().h(str, aS(t));
                }
                if (drawable != null && drawable != aT) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    H("release_previous_result @ onNewResult", t2);
                    aQ(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aT) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    H("release_previous_result @ onNewResult", t2);
                    aQ(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            H("drawable_failed @ onNewResult", t);
            aQ(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onFailure", th);
            bVar.Wu();
            return;
        }
        this.lUg.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            j("final_failed @ onFailure", th);
            this.lUt = null;
            this.lUq = true;
            if (this.lUr && this.mDrawable != null) {
                this.lUm.a(this.mDrawable, 1.0f, true);
            } else if (doj()) {
                this.lUm.E(th);
            } else {
                this.lUm.D(th);
            }
            doo().g(this.mId, th);
            return;
        }
        j("intermediate_failed @ onFailure", th);
        doo().f(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            j("ignore_old_datasource @ onProgress", null);
            bVar.Wu();
        } else if (!z) {
            this.lUm.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.lUt == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.lUt && this.lUo;
    }

    private void H(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(lQq, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aV(t), Integer.valueOf(aR(t)));
        }
    }

    private void j(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lQq, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dos() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aV(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aR(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aJ(this).aK("isAttached", this.mIsAttached).aK("isRequestSubmitted", this.lUo).aK("hasFetchFailed", this.lUq).bM("fetchedImage", aR(this.lUu)).C("events", this.lUg.toString()).toString();
    }

    protected T dnV() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(String str, T t) {
    }
}
