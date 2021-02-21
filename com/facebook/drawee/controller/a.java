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
public abstract class a<T, INFO> implements a.InterfaceC1047a, a.InterfaceC1048a, com.facebook.drawee.d.a {
    private static final Class<?> pyc = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final Executor pBQ;
    @Nullable
    private com.facebook.drawee.components.b pBR;
    @Nullable
    private com.facebook.drawee.c.a pBS;
    @Nullable
    private c<INFO> pBT;
    @Nullable
    private d pBU;
    @Nullable
    private com.facebook.drawee.d.c pBV;
    @Nullable
    private Drawable pBW;
    private boolean pBX;
    private boolean pBY;
    private boolean pBZ;
    private final com.facebook.drawee.components.a pBc;
    private Object pBi;
    private boolean pCa;
    @Nullable
    private String pCb;
    @Nullable
    private com.facebook.datasource.b<T> pCc;
    @Nullable
    private T pCd;
    private final DraweeEventTracker pBP = DraweeEventTracker.etS();
    private boolean pCe = true;

    protected abstract void bh(@Nullable T t);

    @Nullable
    protected abstract INFO bj(T t);

    protected abstract Drawable bk(T t);

    protected abstract com.facebook.datasource.b<T> etD();

    protected abstract void t(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1049a<INFO> extends e<INFO> {
        private C1049a() {
        }

        public static <INFO> C1049a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C1049a<INFO> c1049a = new C1049a<>();
            c1049a.d(cVar);
            c1049a.d(cVar2);
            return c1049a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.pBc = aVar;
        this.pBQ = executor;
        L(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(String str, Object obj) {
        L(str, obj);
        this.pCe = false;
    }

    private synchronized void L(String str, Object obj) {
        this.pBP.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.pCe && this.pBc != null) {
            this.pBc.b(this);
        }
        this.mIsAttached = false;
        this.pBY = false;
        etV();
        this.pCa = false;
        if (this.pBR != null) {
            this.pBR.init();
        }
        if (this.pBS != null) {
            this.pBS.init();
            this.pBS.a(this);
        }
        if (this.pBT instanceof C1049a) {
            ((C1049a) this.pBT).eup();
        } else {
            this.pBT = null;
        }
        this.pBU = null;
        if (this.pBV != null) {
            this.pBV.reset();
            this.pBV.u(null);
            this.pBV = null;
        }
        this.pBW = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.pBi = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC1048a
    public void release() {
        this.pBP.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.pBR != null) {
            this.pBR.reset();
        }
        if (this.pBS != null) {
            this.pBS.reset();
        }
        if (this.pBV != null) {
            this.pBV.reset();
        }
        etV();
    }

    private void etV() {
        boolean z = this.pBX;
        this.pBX = false;
        this.pBZ = false;
        if (this.pCc != null) {
            this.pCc.apL();
            this.pCc = null;
        }
        if (this.mDrawable != null) {
            t(this.mDrawable);
        }
        if (this.pCb != null) {
            this.pCb = null;
        }
        this.mDrawable = null;
        if (this.pCd != null) {
            M("release", this.pCd);
            bh(this.pCd);
            this.pCd = null;
        }
        if (z) {
            etY().gy(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b etW() {
        if (this.pBR == null) {
            this.pBR = new com.facebook.drawee.components.b();
        }
        return this.pBR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a etX() {
        return this.pBS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.pBS = aVar;
        if (this.pBS != null) {
            this.pBS.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bl(boolean z) {
        this.pCa = z;
    }

    public void ZE(@Nullable String str) {
        this.pCb = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pBT instanceof C1049a) {
            ((C1049a) this.pBT).d(cVar);
        } else if (this.pBT != null) {
            this.pBT = C1049a.a(this.pBT, cVar);
        } else {
            this.pBT = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.pBT instanceof C1049a) {
            ((C1049a) this.pBT).e(cVar);
        } else if (this.pBT == cVar) {
            this.pBT = null;
        }
    }

    protected c<INFO> etY() {
        return this.pBT == null ? b.euo() : this.pBT;
    }

    public void a(@Nullable d dVar) {
        this.pBU = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.pBV;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.pBP.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.pBX) {
            this.pBc.b(this);
            release();
        }
        if (this.pBV != null) {
            this.pBV.u(null);
            this.pBV = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.pBV = (com.facebook.drawee.d.c) bVar;
            this.pBV.u(this.pBW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@Nullable Drawable drawable) {
        this.pBW = drawable;
        if (this.pBV != null) {
            this.pBV.u(this.pBW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable etZ() {
        return this.pBW;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.pBX ? "request already submitted" : "request needs submit");
        }
        this.pBP.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.pBV);
        this.pBc.b(this);
        this.mIsAttached = true;
        if (!this.pBX) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.pBP.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.pBc.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.pBS == null) {
            return false;
        }
        if (this.pBS.evf() || eua()) {
            this.pBS.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean eua() {
        return etT();
    }

    private boolean etT() {
        return this.pBZ && this.pBR != null && this.pBR.etT();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC1047a
    public boolean eub() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (etT()) {
            this.pBR.etU();
            this.pBV.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T etF = etF();
        if (etF != null) {
            this.pCc = null;
            this.pBX = true;
            this.pBZ = false;
            this.pBP.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            etY().f(this.mId, this.pBi);
            J(this.mId, etF);
            a(this.mId, this.pCc, etF, 1.0f, true, true);
            return;
        }
        this.pBP.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        etY().f(this.mId, this.pBi);
        this.pBV.d(0.0f, true);
        this.pBX = true;
        this.pBZ = false;
        this.pCc = etD();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.pCc)));
        }
        final String str = this.mId;
        final boolean etf = this.pCc.etf();
        this.pCc.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, etf);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.eth(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.pBQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            M("ignore_old_datasource @ onNewResult", t);
            bh(t);
            bVar.apL();
            return;
        }
        this.pBP.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bk = bk(t);
            T t2 = this.pCd;
            Drawable drawable = this.mDrawable;
            this.pCd = t;
            this.mDrawable = bk;
            try {
                if (z) {
                    M("set_final_result @ onNewResult", t);
                    this.pCc = null;
                    this.pBV.a(bk, 1.0f, z2);
                    etY().a(str, bj(t), euc());
                } else {
                    M("set_intermediate_result @ onNewResult", t);
                    this.pBV.a(bk, f, z2);
                    etY().g(str, (String) bj(t));
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
        this.pBP.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.pCc = null;
            this.pBZ = true;
            if (this.pCa && this.mDrawable != null) {
                this.pBV.a(this.mDrawable, 1.0f, true);
            } else if (etT()) {
                this.pBV.A(th);
            } else {
                this.pBV.z(th);
            }
            etY().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        etY().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.apL();
        } else if (!z) {
            this.pBV.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.pCc == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.pCc && this.pBX;
    }

    private void M(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(pyc, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bm(t), Integer.valueOf(bi(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pyc, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable euc() {
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
        return f.bb(this).bo("isAttached", this.mIsAttached).bo("isRequestSubmitted", this.pBX).bo("hasFetchFailed", this.pBZ).cl("fetchedImage", bi(this.pCd)).H("events", this.pBP.toString()).toString();
    }

    protected T etF() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(String str, T t) {
    }
}
