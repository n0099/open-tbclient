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
/* loaded from: classes4.dex */
public abstract class a<T, INFO> implements a.InterfaceC1062a, a.InterfaceC1063a, com.facebook.drawee.d.a {
    private static final Class<?> pAh = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final Executor pDV;
    @Nullable
    private com.facebook.drawee.components.b pDW;
    @Nullable
    private com.facebook.drawee.c.a pDX;
    @Nullable
    private c<INFO> pDY;
    @Nullable
    private d pDZ;
    private final com.facebook.drawee.components.a pDh;
    private Object pDn;
    @Nullable
    private com.facebook.drawee.d.c pEa;
    @Nullable
    private Drawable pEb;
    private boolean pEc;
    private boolean pEd;
    private boolean pEe;
    private boolean pEf;
    @Nullable
    private String pEg;
    @Nullable
    private com.facebook.datasource.b<T> pEh;
    @Nullable
    private T pEi;
    private final DraweeEventTracker pDU = DraweeEventTracker.eub();
    private boolean pEj = true;

    protected abstract void bj(@Nullable T t);

    @Nullable
    protected abstract INFO bl(T t);

    protected abstract Drawable bm(T t);

    protected abstract com.facebook.datasource.b<T> etM();

    protected abstract void t(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1064a<INFO> extends e<INFO> {
        private C1064a() {
        }

        public static <INFO> C1064a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C1064a<INFO> c1064a = new C1064a<>();
            c1064a.d(cVar);
            c1064a.d(cVar2);
            return c1064a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.pDh = aVar;
        this.pDV = executor;
        K(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(String str, Object obj) {
        K(str, obj);
        this.pEj = false;
    }

    private synchronized void K(String str, Object obj) {
        this.pDU.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.pEj && this.pDh != null) {
            this.pDh.b(this);
        }
        this.mIsAttached = false;
        this.pEd = false;
        eue();
        this.pEf = false;
        if (this.pDW != null) {
            this.pDW.init();
        }
        if (this.pDX != null) {
            this.pDX.init();
            this.pDX.a(this);
        }
        if (this.pDY instanceof C1064a) {
            ((C1064a) this.pDY).euy();
        } else {
            this.pDY = null;
        }
        this.pDZ = null;
        if (this.pEa != null) {
            this.pEa.reset();
            this.pEa.u(null);
            this.pEa = null;
        }
        this.pEb = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pDn = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC1063a
    public void release() {
        this.pDU.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.pDW != null) {
            this.pDW.reset();
        }
        if (this.pDX != null) {
            this.pDX.reset();
        }
        if (this.pEa != null) {
            this.pEa.reset();
        }
        eue();
    }

    private void eue() {
        boolean z = this.pEc;
        this.pEc = false;
        this.pEe = false;
        if (this.pEh != null) {
            this.pEh.apO();
            this.pEh = null;
        }
        if (this.mDrawable != null) {
            t(this.mDrawable);
        }
        if (this.pEg != null) {
            this.pEg = null;
        }
        this.mDrawable = null;
        if (this.pEi != null) {
            L("release", this.pEi);
            bj(this.pEi);
            this.pEi = null;
        }
        if (z) {
            euh().gE(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b euf() {
        if (this.pDW == null) {
            this.pDW = new com.facebook.drawee.components.b();
        }
        return this.pDW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a eug() {
        return this.pDX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pDX = aVar;
        if (this.pDX != null) {
            this.pDX.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bj(boolean z) {
        this.pEf = z;
    }

    public void ZK(@Nullable String str) {
        this.pEg = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pDY instanceof C1064a) {
            ((C1064a) this.pDY).d(cVar);
        } else if (this.pDY != null) {
            this.pDY = C1064a.a(this.pDY, cVar);
        } else {
            this.pDY = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pDY instanceof C1064a) {
            ((C1064a) this.pDY).e(cVar);
        } else if (this.pDY == cVar) {
            this.pDY = null;
        }
    }

    protected c<INFO> euh() {
        return this.pDY == null ? b.eux() : this.pDY;
    }

    public void a(@Nullable d dVar) {
        this.pDZ = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.pEa;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.pDU.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.pEc) {
            this.pDh.b(this);
            release();
        }
        if (this.pEa != null) {
            this.pEa.u(null);
            this.pEa = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.pEa = (com.facebook.drawee.d.c) bVar;
            this.pEa.u(this.pEb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@Nullable Drawable drawable) {
        this.pEb = drawable;
        if (this.pEa != null) {
            this.pEa.u(this.pEb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable eui() {
        return this.pEb;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.pEc ? "request already submitted" : "request needs submit");
        }
        this.pDU.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.pEa);
        this.pDh.b(this);
        this.mIsAttached = true;
        if (!this.pEc) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.pDU.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.pDh.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pDX == null) {
            return false;
        }
        if (this.pDX.evo() || euj()) {
            this.pDX.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean euj() {
        return euc();
    }

    private boolean euc() {
        return this.pEe && this.pDW != null && this.pDW.euc();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC1062a
    public boolean euk() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (euc()) {
            this.pDW.eud();
            this.pEa.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T etO = etO();
        if (etO != null) {
            this.pEh = null;
            this.pEc = true;
            this.pEe = false;
            this.pDU.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            euh().g(this.mId, this.pDn);
            I(this.mId, etO);
            a(this.mId, this.pEh, etO, 1.0f, true, true);
            return;
        }
        this.pDU.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        euh().g(this.mId, this.pDn);
        this.pEa.d(0.0f, true);
        this.pEc = true;
        this.pEe = false;
        this.pEh = etM();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.pEh)));
        }
        final String str = this.mId;
        final boolean eto = this.pEh.eto();
        this.pEh.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, eto);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.etq(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.pDV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            L("ignore_old_datasource @ onNewResult", t);
            bj(t);
            bVar.apO();
            return;
        }
        this.pDU.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bm = bm(t);
            T t2 = this.pEi;
            Drawable drawable = this.mDrawable;
            this.pEi = t;
            this.mDrawable = bm;
            try {
                if (z) {
                    L("set_final_result @ onNewResult", t);
                    this.pEh = null;
                    this.pEa.a(bm, 1.0f, z2);
                    euh().a(str, bl(t), eul());
                } else {
                    L("set_intermediate_result @ onNewResult", t);
                    this.pEa.a(bm, f, z2);
                    euh().h(str, (String) bl(t));
                }
                if (drawable != null && drawable != bm) {
                    t(drawable);
                }
                if (t2 != null && t2 != t) {
                    L("release_previous_result @ onNewResult", t2);
                    bj(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bm) {
                    t(drawable);
                }
                if (t2 != null && t2 != t) {
                    L("release_previous_result @ onNewResult", t2);
                    bj(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            L("drawable_failed @ onNewResult", t);
            bj(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.apO();
            return;
        }
        this.pDU.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.pEh = null;
            this.pEe = true;
            if (this.pEf && this.mDrawable != null) {
                this.pEa.a(this.mDrawable, 1.0f, true);
            } else if (euc()) {
                this.pEa.A(th);
            } else {
                this.pEa.z(th);
            }
            euh().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        euh().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.apO();
        } else if (!z) {
            this.pEa.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.pEh == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.pEh && this.pEc;
    }

    private void L(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(pAh, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bo(t), Integer.valueOf(bk(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable eul() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String bo(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int bk(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.bd(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.pEc).bo("hasFetchFailed", this.pEe).cl("fetchedImage", bk(this.pEi)).G("events", this.pDU.toString()).toString();
    }

    protected T etO() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, T t) {
    }
}
