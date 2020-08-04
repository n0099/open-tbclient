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
    private static final Class<?> mPz = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a mSF;
    private Object mSL;
    @Nullable
    private d mTA;
    @Nullable
    private com.facebook.drawee.d.c mTB;
    @Nullable
    private Drawable mTC;
    private boolean mTD;
    private boolean mTE;
    private boolean mTF;
    private boolean mTG;
    @Nullable
    private String mTH;
    @Nullable
    private com.facebook.datasource.b<T> mTI;
    @Nullable
    private T mTJ;
    private final Executor mTw;
    @Nullable
    private com.facebook.drawee.components.b mTx;
    @Nullable
    private com.facebook.drawee.c.a mTy;
    @Nullable
    private c<INFO> mTz;
    private final DraweeEventTracker mTv = DraweeEventTracker.dDJ();
    private boolean mTK = true;

    protected abstract void aV(@Nullable T t);

    @Nullable
    protected abstract INFO aX(T t);

    protected abstract Drawable aY(T t);

    protected abstract com.facebook.datasource.b<T> dDu();

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
        this.mSF = aVar;
        this.mTw = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.mTK = false;
    }

    private synchronized void J(String str, Object obj) {
        this.mTv.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mTK && this.mSF != null) {
            this.mSF.b(this);
        }
        this.mIsAttached = false;
        this.mTE = false;
        dDM();
        this.mTG = false;
        if (this.mTx != null) {
            this.mTx.init();
        }
        if (this.mTy != null) {
            this.mTy.init();
            this.mTy.a(this);
        }
        if (this.mTz instanceof C0809a) {
            ((C0809a) this.mTz).dEg();
        } else {
            this.mTz = null;
        }
        this.mTA = null;
        if (this.mTB != null) {
            this.mTB.reset();
            this.mTB.j(null);
            this.mTB = null;
        }
        this.mTC = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mSL = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0808a
    public void release() {
        this.mTv.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.mTx != null) {
            this.mTx.reset();
        }
        if (this.mTy != null) {
            this.mTy.reset();
        }
        if (this.mTB != null) {
            this.mTB.reset();
        }
        dDM();
    }

    private void dDM() {
        boolean z = this.mTD;
        this.mTD = false;
        this.mTF = false;
        if (this.mTI != null) {
            this.mTI.abo();
            this.mTI = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.mTH != null) {
            this.mTH = null;
        }
        this.mDrawable = null;
        if (this.mTJ != null) {
            K("release", this.mTJ);
            aV(this.mTJ);
            this.mTJ = null;
        }
        if (z) {
            dDP().fa(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dDN() {
        if (this.mTx == null) {
            this.mTx = new com.facebook.drawee.components.b();
        }
        return this.mTx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dDO() {
        return this.mTy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.mTy = aVar;
        if (this.mTy != null) {
            this.mTy.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xb(boolean z) {
        this.mTG = z;
    }

    public void Rx(@Nullable String str) {
        this.mTH = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mTz instanceof C0809a) {
            ((C0809a) this.mTz).d(cVar);
        } else if (this.mTz != null) {
            this.mTz = C0809a.a(this.mTz, cVar);
        } else {
            this.mTz = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.mTz instanceof C0809a) {
            ((C0809a) this.mTz).e(cVar);
        } else if (this.mTz == cVar) {
            this.mTz = null;
        }
    }

    protected c<INFO> dDP() {
        return this.mTz == null ? b.dEf() : this.mTz;
    }

    public void a(@Nullable d dVar) {
        this.mTA = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.mTB;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.mTv.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mTD) {
            this.mSF.b(this);
            release();
        }
        if (this.mTB != null) {
            this.mTB.j(null);
            this.mTB = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.mTB = (com.facebook.drawee.d.c) bVar;
            this.mTB.j(this.mTC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.mTC = drawable;
        if (this.mTB != null) {
            this.mTB.j(this.mTC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dDQ() {
        return this.mTC;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mTD ? "request already submitted" : "request needs submit");
        }
        this.mTv.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.mTB);
        this.mSF.b(this);
        this.mIsAttached = true;
        if (!this.mTD) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.mTv.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mSF.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.mTy == null) {
            return false;
        }
        if (this.mTy.dEW() || dDR()) {
            this.mTy.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dDR() {
        return dDK();
    }

    private boolean dDK() {
        return this.mTF && this.mTx != null && this.mTx.dDK();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0807a
    public boolean dDS() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dDK()) {
            this.mTx.dDL();
            this.mTB.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dDw = dDw();
        if (dDw != null) {
            this.mTI = null;
            this.mTD = true;
            this.mTF = false;
            this.mTv.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dDP().g(this.mId, this.mSL);
            H(this.mId, dDw);
            a(this.mId, this.mTI, dDw, 1.0f, true, true);
            return;
        }
        this.mTv.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dDP().g(this.mId, this.mSL);
        this.mTB.c(0.0f, true);
        this.mTD = true;
        this.mTF = false;
        this.mTI = dDu();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mTI)));
        }
        final String str = this.mId;
        final boolean dCW = this.mTI.dCW();
        this.mTI.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dCW);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dCY(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.mTw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            aV(t);
            bVar.abo();
            return;
        }
        this.mTv.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aY = aY(t);
            T t2 = this.mTJ;
            Drawable drawable = this.mDrawable;
            this.mTJ = t;
            this.mDrawable = aY;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.mTI = null;
                    this.mTB.a(aY, 1.0f, z2);
                    dDP().a(str, aX(t), dDT());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.mTB.a(aY, f, z2);
                    dDP().h(str, (String) aX(t));
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
        this.mTv.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.mTI = null;
            this.mTF = true;
            if (this.mTG && this.mDrawable != null) {
                this.mTB.a(this.mDrawable, 1.0f, true);
            } else if (dDK()) {
                this.mTB.D(th);
            } else {
                this.mTB.C(th);
            }
            dDP().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dDP().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.abo();
        } else if (!z) {
            this.mTB.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.mTI == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.mTI && this.mTD;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(mPz, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ba(t), Integer.valueOf(aW(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mPz, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dDT() {
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
        return f.aO(this).aW("isAttached", this.mIsAttached).aW("isRequestSubmitted", this.mTD).aW("hasFetchFailed", this.mTF).bK("fetchedImage", aW(this.mTJ)).F("events", this.mTv.toString()).toString();
    }

    protected T dDw() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
