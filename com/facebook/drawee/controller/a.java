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
    private static final Class<?> iez = a.class;
    private final com.facebook.drawee.components.a ihC;
    private final DraweeEventTracker ihO = DraweeEventTracker.bUi();
    private final Executor ihP;
    @Nullable
    private com.facebook.drawee.components.b ihQ;
    @Nullable
    private com.facebook.drawee.c.a ihR;
    @Nullable
    private c<INFO> ihS;
    @Nullable
    private d ihT;
    @Nullable
    private com.facebook.drawee.d.c ihU;
    @Nullable
    private Drawable ihV;
    private Object ihW;
    private boolean ihX;
    private boolean ihY;
    private boolean ihZ;
    private boolean iia;
    @Nullable
    private String iib;
    @Nullable
    private com.facebook.datasource.b<T> iic;
    @Nullable
    private T iid;
    @Nullable
    private Throwable iie;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void au(@Nullable T t);

    @Nullable
    protected abstract INFO aw(T t);

    protected abstract Drawable ax(T t);

    protected abstract com.facebook.datasource.b<T> bTX();

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
        this.ihC = aVar;
        this.ihP = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.ihO.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.bTm()) {
            this.iie = new Throwable();
        }
        if (!z && this.ihC != null) {
            this.ihC.b(this);
        }
        this.mIsAttached = false;
        this.ihY = false;
        bUl();
        this.iia = false;
        if (this.ihQ != null) {
            this.ihQ.init();
        }
        if (this.ihR != null) {
            this.ihR.init();
            this.ihR.a(this);
        }
        if (this.ihS instanceof C0362a) {
            ((C0362a) this.ihS).bUE();
        } else {
            this.ihS = null;
        }
        this.ihT = null;
        if (this.ihU != null) {
            this.ihU.reset();
            this.ihU.g(null);
            this.ihU = null;
        }
        this.ihV = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.ihW = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0361a
    public void release() {
        this.ihO.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.ihQ != null) {
            this.ihQ.reset();
        }
        if (this.ihR != null) {
            this.ihR.reset();
        }
        if (this.ihU != null) {
            this.ihU.reset();
        }
        bUl();
    }

    private void bUl() {
        boolean z = this.ihX;
        this.ihX = false;
        this.ihZ = false;
        if (this.iic != null) {
            this.iic.bTH();
            this.iic = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.iib != null) {
            this.iib = null;
        }
        this.mDrawable = null;
        if (this.iid != null) {
            q("release", this.iid);
            au(this.iid);
            this.iid = null;
        }
        if (z) {
            bUo().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b bUm() {
        return this.ihQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.ihQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a bUn() {
        return this.ihR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.ihR = aVar;
        if (this.ihR != null) {
            this.ihR.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oS(boolean z) {
        this.iia = z;
    }

    public void zi(@Nullable String str) {
        this.iib = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.ihS instanceof C0362a) {
            ((C0362a) this.ihS).c(cVar);
        } else if (this.ihS != null) {
            this.ihS = C0362a.a(this.ihS, cVar);
        } else {
            this.ihS = cVar;
        }
    }

    protected c<INFO> bUo() {
        return this.ihS == null ? b.getNoOpListener() : this.ihS;
    }

    public void a(@Nullable d dVar) {
        this.ihT = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.ihU;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.ihO.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.ihX) {
            this.ihC.b(this);
            release();
        }
        if (this.ihU != null) {
            this.ihU.g(null);
            this.ihU = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.ihU = (com.facebook.drawee.d.c) bVar;
            this.ihU.g(this.ihV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.ihV = drawable;
        if (this.ihU != null) {
            this.ihU.g(this.ihV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable bUp() {
        return this.ihV;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.ihX ? "request already submitted" : "request needs submit");
        }
        this.ihO.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.ihU);
        this.ihC.b(this);
        this.mIsAttached = true;
        if (!this.ihX) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.ihO.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.ihC.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.ihR == null) {
            return false;
        }
        if (this.ihR.bVu() || bUq()) {
            this.ihR.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean bUq() {
        return bUj();
    }

    private boolean bUj() {
        return this.ihZ && this.ihQ != null && this.ihQ.bUj();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0360a
    public boolean bUr() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (bUj()) {
            this.ihQ.bUk();
            this.ihU.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T bTZ = bTZ();
        if (bTZ != null) {
            this.iic = null;
            this.ihX = true;
            this.ihZ = false;
            this.ihO.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            bUo().onSubmit(this.mId, this.ihW);
            a(this.mId, this.iic, bTZ, 1.0f, true, true);
            return;
        }
        this.ihO.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        bUo().onSubmit(this.mId, this.ihW);
        this.ihU.d(0.0f, true);
        this.ihX = true;
        this.ihZ = false;
        this.iic = bTX();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.iic)));
        }
        final String str = this.mId;
        final boolean bTE = this.iic.bTE();
        this.iic.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.iie != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.iie);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, bTE);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.bTG(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.ihP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            q("ignore_old_datasource @ onNewResult", t);
            au(t);
            bVar.bTH();
            return;
        }
        this.ihO.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable ax = ax(t);
            T t2 = this.iid;
            Drawable drawable = this.mDrawable;
            this.iid = t;
            this.mDrawable = ax;
            try {
                if (z) {
                    q("set_final_result @ onNewResult", t);
                    this.iic = null;
                    this.ihU.a(ax, 1.0f, z2);
                    bUo().onFinalImageSet(str, aw(t), bUs());
                } else {
                    q("set_intermediate_result @ onNewResult", t);
                    this.ihU.a(ax, f, z2);
                    bUo().onIntermediateImageSet(str, aw(t));
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
            bVar.bTH();
            return;
        }
        this.ihO.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.iic = null;
            this.ihZ = true;
            if (this.iia && this.mDrawable != null) {
                this.ihU.a(this.mDrawable, 1.0f, true);
            } else if (bUj()) {
                this.ihU.z(th);
            } else {
                this.ihU.y(th);
            }
            bUo().onFailure(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        bUo().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.bTH();
        } else if (!z) {
            this.ihU.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.iic == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.iic && this.ihX;
    }

    private void q(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(iez, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ay(t), Integer.valueOf(av(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(iez, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable bUs() {
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
        return f.ao(this).ai("isAttached", this.mIsAttached).ai("isRequestSubmitted", this.ihX).ai("hasFetchFailed", this.ihZ).bf("fetchedImage", av(this.iid)).n("events", this.ihO.toString()).toString();
    }

    protected T bTZ() {
        return null;
    }
}
