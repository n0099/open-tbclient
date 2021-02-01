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
/* loaded from: classes15.dex */
public abstract class a<T, INFO> implements a.InterfaceC1045a, a.InterfaceC1046a, com.facebook.drawee.d.a {
    private static final Class<?> pxC = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a pAC;
    private Object pAI;
    private boolean pBA;
    @Nullable
    private String pBB;
    @Nullable
    private com.facebook.datasource.b<T> pBC;
    @Nullable
    private T pBD;
    private final Executor pBq;
    @Nullable
    private com.facebook.drawee.components.b pBr;
    @Nullable
    private com.facebook.drawee.c.a pBs;
    @Nullable
    private c<INFO> pBt;
    @Nullable
    private d pBu;
    @Nullable
    private com.facebook.drawee.d.c pBv;
    @Nullable
    private Drawable pBw;
    private boolean pBx;
    private boolean pBy;
    private boolean pBz;
    private final DraweeEventTracker pBp = DraweeEventTracker.etK();
    private boolean pBE = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> etv();

    protected abstract void t(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1047a<INFO> extends e<INFO> {
        private C1047a() {
        }

        public static <INFO> C1047a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C1047a<INFO> c1047a = new C1047a<>();
            c1047a.d(cVar);
            c1047a.d(cVar2);
            return c1047a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.pAC = aVar;
        this.pBq = executor;
        L(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(String str, Object obj) {
        L(str, obj);
        this.pBE = false;
    }

    private synchronized void L(String str, Object obj) {
        this.pBp.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.pBE && this.pAC != null) {
            this.pAC.b(this);
        }
        this.mIsAttached = false;
        this.pBy = false;
        etN();
        this.pBA = false;
        if (this.pBr != null) {
            this.pBr.init();
        }
        if (this.pBs != null) {
            this.pBs.init();
            this.pBs.a(this);
        }
        if (this.pBt instanceof C1047a) {
            ((C1047a) this.pBt).euh();
        } else {
            this.pBt = null;
        }
        this.pBu = null;
        if (this.pBv != null) {
            this.pBv.reset();
            this.pBv.u(null);
            this.pBv = null;
        }
        this.pBw = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pAI = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC1046a
    public void release() {
        this.pBp.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.pBr != null) {
            this.pBr.reset();
        }
        if (this.pBs != null) {
            this.pBs.reset();
        }
        if (this.pBv != null) {
            this.pBv.reset();
        }
        etN();
    }

    private void etN() {
        boolean z = this.pBx;
        this.pBx = false;
        this.pBz = false;
        if (this.pBC != null) {
            this.pBC.apL();
            this.pBC = null;
        }
        if (this.mDrawable != null) {
            t(this.mDrawable);
        }
        if (this.pBB != null) {
            this.pBB = null;
        }
        this.mDrawable = null;
        if (this.pBD != null) {
            M("release", this.pBD);
            bh(this.pBD);
            this.pBD = null;
        }
        if (z) {
            etQ().gy(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b etO() {
        if (this.pBr == null) {
            this.pBr = new com.facebook.drawee.components.b();
        }
        return this.pBr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a etP() {
        return this.pBs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pBs = aVar;
        if (this.pBs != null) {
            this.pBs.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bl(boolean z) {
        this.pBA = z;
    }

    public void Zs(@Nullable String str) {
        this.pBB = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pBt instanceof C1047a) {
            ((C1047a) this.pBt).d(cVar);
        } else if (this.pBt != null) {
            this.pBt = C1047a.a(this.pBt, cVar);
        } else {
            this.pBt = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pBt instanceof C1047a) {
            ((C1047a) this.pBt).e(cVar);
        } else if (this.pBt == cVar) {
            this.pBt = null;
        }
    }

    protected c<INFO> etQ() {
        return this.pBt == null ? b.eug() : this.pBt;
    }

    public void a(@Nullable d dVar) {
        this.pBu = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.pBv;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.pBp.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.pBx) {
            this.pAC.b(this);
            release();
        }
        if (this.pBv != null) {
            this.pBv.u(null);
            this.pBv = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.pBv = (com.facebook.drawee.d.c) bVar;
            this.pBv.u(this.pBw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@Nullable Drawable drawable) {
        this.pBw = drawable;
        if (this.pBv != null) {
            this.pBv.u(this.pBw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable etR() {
        return this.pBw;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.pBx ? "request already submitted" : "request needs submit");
        }
        this.pBp.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.pBv);
        this.pAC.b(this);
        this.mIsAttached = true;
        if (!this.pBx) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.pBp.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.pAC.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pBs == null) {
            return false;
        }
        if (this.pBs.euX() || etS()) {
            this.pBs.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean etS() {
        return etL();
    }

    private boolean etL() {
        return this.pBz && this.pBr != null && this.pBr.etL();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC1045a
    public boolean etT() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (etL()) {
            this.pBr.etM();
            this.pBv.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T etx = etx();
        if (etx != null) {
            this.pBC = null;
            this.pBx = true;
            this.pBz = false;
            this.pBp.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            etQ().f(this.mId, this.pAI);
            J(this.mId, etx);
            a(this.mId, this.pBC, etx, 1.0f, true, true);
            return;
        }
        this.pBp.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        etQ().f(this.mId, this.pAI);
        this.pBv.d(0.0f, true);
        this.pBx = true;
        this.pBz = false;
        this.pBC = etv();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.pBC)));
        }
        final String str = this.mId;
        final boolean esX = this.pBC.esX();
        this.pBC.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, esX);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.esZ(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.pBq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            M("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.apL();
            return;
        }
        this.pBp.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.pBD;
            Drawable drawable = this.mDrawable;
            this.pBD = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    M("set_final_result @ onNewResult", t);
                    this.pBC = null;
                    this.pBv.a(bk, 1.0f, z2);
                    etQ().a(str, bj(t), etU());
                } else {
                    M("set_intermediate_result @ onNewResult", t);
                    this.pBv.a(bk, f, z2);
                    etQ().g(str, (String) bj(t));
                }
                if (drawable != null && drawable != bk) {
                    t(drawable);
                }
                if (t2 != null && t2 != t) {
                    M("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bk) {
                    t(drawable);
                }
                if (t2 != null && t2 != t) {
                    M("release_previous_result @ onNewResult", t2);
                    bh(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            M("drawable_failed @ onNewResult", t);
            bh(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.apL();
            return;
        }
        this.pBp.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.pBC = null;
            this.pBz = true;
            if (this.pBA && this.mDrawable != null) {
                this.pBv.a(this.mDrawable, 1.0f, true);
            } else if (etL()) {
                this.pBv.A(th);
            } else {
                this.pBv.z(th);
            }
            etQ().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        etQ().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.apL();
        } else if (!z) {
            this.pBv.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.pBC == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.pBC && this.pBx;
    }

    private void M(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(pxC, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pxC, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable etU() {
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
        return f.bb(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.pBx).bo("hasFetchFailed", this.pBz).cl("fetchedImage", bi(this.pBD)).H("events", this.pBp.toString()).toString();
    }

    protected T etx() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(String str, T t) {
    }
}
