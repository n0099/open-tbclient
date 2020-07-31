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
/* loaded from: classes9.dex */
public abstract class a<T, INFO> implements a.InterfaceC0807a, a.InterfaceC0808a, com.facebook.drawee.d.a {
    private static final Class<?> mPx = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a mSD;
    private Object mSJ;
    @Nullable
    private Drawable mTA;
    private boolean mTB;
    private boolean mTC;
    private boolean mTD;
    private boolean mTE;
    @Nullable
    private String mTF;
    @Nullable
    private com.facebook.datasource.b<T> mTG;
    @Nullable
    private T mTH;
    private final Executor mTu;
    @Nullable
    private com.facebook.drawee.components.b mTv;
    @Nullable
    private com.facebook.drawee.c.a mTw;
    @Nullable
    private c<INFO> mTx;
    @Nullable
    private d mTy;
    @Nullable
    private com.facebook.drawee.d.c mTz;
    private final DraweeEventTracker mTt = DraweeEventTracker.dDI();
    private boolean mTI = true;

    protected abstract void aV(@Nullable T t);

    @Nullable
    protected abstract INFO aX(T t);

    protected abstract Drawable aY(T t);

    protected abstract com.facebook.datasource.b<T> dDt();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0809a<INFO> extends e<INFO> {
        private C0809a() {
        }

        public static <INFO> C0809a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0809a<INFO> c0809a = new C0809a<>();
            c0809a.d(cVar);
            c0809a.d(cVar2);
            return c0809a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.mSD = aVar;
        this.mTu = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.mTI = false;
    }

    private synchronized void J(String str, Object obj) {
        this.mTt.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mTI && this.mSD != null) {
            this.mSD.b(this);
        }
        this.mIsAttached = false;
        this.mTC = false;
        dDL();
        this.mTE = false;
        if (this.mTv != null) {
            this.mTv.init();
        }
        if (this.mTw != null) {
            this.mTw.init();
            this.mTw.a(this);
        }
        if (this.mTx instanceof C0809a) {
            ((C0809a) this.mTx).dEf();
        } else {
            this.mTx = null;
        }
        this.mTy = null;
        if (this.mTz != null) {
            this.mTz.reset();
            this.mTz.j(null);
            this.mTz = null;
        }
        this.mTA = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mSJ = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0808a
    public void release() {
        this.mTt.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.mTv != null) {
            this.mTv.reset();
        }
        if (this.mTw != null) {
            this.mTw.reset();
        }
        if (this.mTz != null) {
            this.mTz.reset();
        }
        dDL();
    }

    private void dDL() {
        boolean z = this.mTB;
        this.mTB = false;
        this.mTD = false;
        if (this.mTG != null) {
            this.mTG.abo();
            this.mTG = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.mTF != null) {
            this.mTF = null;
        }
        this.mDrawable = null;
        if (this.mTH != null) {
            K("release", this.mTH);
            aV(this.mTH);
            this.mTH = null;
        }
        if (z) {
            dDO().fa(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dDM() {
        if (this.mTv == null) {
            this.mTv = new com.facebook.drawee.components.b();
        }
        return this.mTv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dDN() {
        return this.mTw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.mTw = aVar;
        if (this.mTw != null) {
            this.mTw.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xb(boolean z) {
        this.mTE = z;
    }

    public void Rx(@Nullable String str) {
        this.mTF = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mTx instanceof C0809a) {
            ((C0809a) this.mTx).d(cVar);
        } else if (this.mTx != null) {
            this.mTx = C0809a.a(this.mTx, cVar);
        } else {
            this.mTx = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mTx instanceof C0809a) {
            ((C0809a) this.mTx).e(cVar);
        } else if (this.mTx == cVar) {
            this.mTx = null;
        }
    }

    protected c<INFO> dDO() {
        return this.mTx == null ? b.dEe() : this.mTx;
    }

    public void a(@Nullable d dVar) {
        this.mTy = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.mTz;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.mTt.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mTB) {
            this.mSD.b(this);
            release();
        }
        if (this.mTz != null) {
            this.mTz.j(null);
            this.mTz = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.mTz = (com.facebook.drawee.d.c) bVar;
            this.mTz.j(this.mTA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.mTA = drawable;
        if (this.mTz != null) {
            this.mTz.j(this.mTA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dDP() {
        return this.mTA;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mTB ? "request already submitted" : "request needs submit");
        }
        this.mTt.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.mTz);
        this.mSD.b(this);
        this.mIsAttached = true;
        if (!this.mTB) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.mTt.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mSD.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.mTw == null) {
            return false;
        }
        if (this.mTw.dEV() || dDQ()) {
            this.mTw.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dDQ() {
        return dDJ();
    }

    private boolean dDJ() {
        return this.mTD && this.mTv != null && this.mTv.dDJ();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0807a
    public boolean dDR() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dDJ()) {
            this.mTv.dDK();
            this.mTz.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dDv = dDv();
        if (dDv != null) {
            this.mTG = null;
            this.mTB = true;
            this.mTD = false;
            this.mTt.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dDO().g(this.mId, this.mSJ);
            H(this.mId, dDv);
            a(this.mId, this.mTG, dDv, 1.0f, true, true);
            return;
        }
        this.mTt.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dDO().g(this.mId, this.mSJ);
        this.mTz.c(0.0f, true);
        this.mTB = true;
        this.mTD = false;
        this.mTG = dDt();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mTG)));
        }
        final String str = this.mId;
        final boolean dCV = this.mTG.dCV();
        this.mTG.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dCV);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dCX(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.mTu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            aV(t);
            bVar.abo();
            return;
        }
        this.mTt.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aY = aY(t);
            T t2 = this.mTH;
            Drawable drawable = this.mDrawable;
            this.mTH = t;
            this.mDrawable = aY;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.mTG = null;
                    this.mTz.a(aY, 1.0f, z2);
                    dDO().a(str, aX(t), dDS());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.mTz.a(aY, f, z2);
                    dDO().h(str, (String) aX(t));
                }
                if (drawable != null && drawable != aY) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aV(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aY) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aV(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            aV(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.abo();
            return;
        }
        this.mTt.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.mTG = null;
            this.mTD = true;
            if (this.mTE && this.mDrawable != null) {
                this.mTz.a(this.mDrawable, 1.0f, true);
            } else if (dDJ()) {
                this.mTz.D(th);
            } else {
                this.mTz.C(th);
            }
            dDO().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dDO().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.abo();
        } else if (!z) {
            this.mTz.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.mTG == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.mTG && this.mTB;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(mPx, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ba(t), Integer.valueOf(aW(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPx, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dDS() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String ba(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aW(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aO(this).aW("isAttached", this.mIsAttached).aW("isRequestSubmitted", this.mTB).aW("hasFetchFailed", this.mTD).bK("fetchedImage", aW(this.mTH)).F("events", this.mTt.toString()).toString();
    }

    protected T dDv() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
