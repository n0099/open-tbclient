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
public abstract class a<T, INFO> implements a.InterfaceC0346a, a.InterfaceC0347a, com.facebook.drawee.d.a {
    private static final Class<?> hXm = a.class;
    private final DraweeEventTracker iaB = DraweeEventTracker.bSd();
    private final Executor iaC;
    @Nullable
    private com.facebook.drawee.components.b iaD;
    @Nullable
    private com.facebook.drawee.c.a iaE;
    @Nullable
    private c<INFO> iaF;
    @Nullable
    private d iaG;
    @Nullable
    private com.facebook.drawee.d.c iaH;
    @Nullable
    private Drawable iaI;
    private Object iaJ;
    private boolean iaK;
    private boolean iaL;
    private boolean iaM;
    private boolean iaN;
    @Nullable
    private String iaO;
    @Nullable
    private com.facebook.datasource.b<T> iaP;
    @Nullable
    private T iaQ;
    @Nullable
    private Throwable iaR;
    private final com.facebook.drawee.components.a iap;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void at(@Nullable T t);

    @Nullable
    protected abstract INFO av(T t);

    protected abstract Drawable aw(T t);

    protected abstract com.facebook.datasource.b<T> bRS();

    protected abstract void f(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0348a<INFO> extends e<INFO> {
        private C0348a() {
        }

        public static <INFO> C0348a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0348a<INFO> c0348a = new C0348a<>();
            c0348a.c(cVar);
            c0348a.c(cVar2);
            return c0348a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.iap = aVar;
        this.iaC = executor;
        b(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, Object obj) {
        b(str, obj, false);
    }

    private void b(String str, Object obj, boolean z) {
        this.iaB.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.bRh()) {
            this.iaR = new Throwable();
        }
        if (!z && this.iap != null) {
            this.iap.b(this);
        }
        this.mIsAttached = false;
        this.iaL = false;
        bSg();
        this.iaN = false;
        if (this.iaD != null) {
            this.iaD.init();
        }
        if (this.iaE != null) {
            this.iaE.init();
            this.iaE.a(this);
        }
        if (this.iaF instanceof C0348a) {
            ((C0348a) this.iaF).bSz();
        } else {
            this.iaF = null;
        }
        this.iaG = null;
        if (this.iaH != null) {
            this.iaH.reset();
            this.iaH.g(null);
            this.iaH = null;
        }
        this.iaI = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.iaJ = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0347a
    public void release() {
        this.iaB.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.iaD != null) {
            this.iaD.reset();
        }
        if (this.iaE != null) {
            this.iaE.reset();
        }
        if (this.iaH != null) {
            this.iaH.reset();
        }
        bSg();
    }

    private void bSg() {
        boolean z = this.iaK;
        this.iaK = false;
        this.iaM = false;
        if (this.iaP != null) {
            this.iaP.bRC();
            this.iaP = null;
        }
        if (this.mDrawable != null) {
            f(this.mDrawable);
        }
        if (this.iaO != null) {
            this.iaO = null;
        }
        this.mDrawable = null;
        if (this.iaQ != null) {
            q("release", this.iaQ);
            at(this.iaQ);
            this.iaQ = null;
        }
        if (z) {
            bSj().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b bSh() {
        return this.iaD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.iaD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a bSi() {
        return this.iaE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.iaE = aVar;
        if (this.iaE != null) {
            this.iaE.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ(boolean z) {
        this.iaN = z;
    }

    public void yF(@Nullable String str) {
        this.iaO = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.iaF instanceof C0348a) {
            ((C0348a) this.iaF).c(cVar);
        } else if (this.iaF != null) {
            this.iaF = C0348a.a(this.iaF, cVar);
        } else {
            this.iaF = cVar;
        }
    }

    protected c<INFO> bSj() {
        return this.iaF == null ? b.getNoOpListener() : this.iaF;
    }

    public void a(@Nullable d dVar) {
        this.iaG = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.iaH;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.iaB.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.iaK) {
            this.iap.b(this);
            release();
        }
        if (this.iaH != null) {
            this.iaH.g(null);
            this.iaH = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.iaH = (com.facebook.drawee.d.c) bVar;
            this.iaH.g(this.iaI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@Nullable Drawable drawable) {
        this.iaI = drawable;
        if (this.iaH != null) {
            this.iaH.g(this.iaI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable bSk() {
        return this.iaI;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.iaK ? "request already submitted" : "request needs submit");
        }
        this.iaB.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.iaH);
        this.iap.b(this);
        this.mIsAttached = true;
        if (!this.iaK) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.iaB.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.iap.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.iaE == null) {
            return false;
        }
        if (this.iaE.bTp() || bSl()) {
            this.iaE.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean bSl() {
        return bSe();
    }

    private boolean bSe() {
        return this.iaM && this.iaD != null && this.iaD.bSe();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0346a
    public boolean bSm() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (bSe()) {
            this.iaD.bSf();
            this.iaH.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T bRU = bRU();
        if (bRU != null) {
            this.iaP = null;
            this.iaK = true;
            this.iaM = false;
            this.iaB.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            bSj().onSubmit(this.mId, this.iaJ);
            a(this.mId, this.iaP, bRU, 1.0f, true, true);
            return;
        }
        this.iaB.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        bSj().onSubmit(this.mId, this.iaJ);
        this.iaH.d(0.0f, true);
        this.iaK = true;
        this.iaM = false;
        this.iaP = bRS();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.iaP)));
        }
        final String str = this.mId;
        final boolean bRz = this.iaP.bRz();
        this.iaP.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void onNewResultImpl(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.iaR != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).s(a.this.iaR);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, bRz);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void onFailureImpl(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.bRB(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onProgressUpdate(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.iaC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            q("ignore_old_datasource @ onNewResult", t);
            at(t);
            bVar.bRC();
            return;
        }
        this.iaB.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aw = aw(t);
            T t2 = this.iaQ;
            Drawable drawable = this.mDrawable;
            this.iaQ = t;
            this.mDrawable = aw;
            try {
                if (z) {
                    q("set_final_result @ onNewResult", t);
                    this.iaP = null;
                    this.iaH.a(aw, 1.0f, z2);
                    bSj().onFinalImageSet(str, av(t), bSn());
                } else {
                    q("set_intermediate_result @ onNewResult", t);
                    this.iaH.a(aw, f, z2);
                    bSj().onIntermediateImageSet(str, av(t));
                }
                if (drawable != null && drawable != aw) {
                    f(drawable);
                }
                if (t2 != null && t2 != t) {
                    q("release_previous_result @ onNewResult", t2);
                    at(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aw) {
                    f(drawable);
                }
                if (t2 != null && t2 != t) {
                    q("release_previous_result @ onNewResult", t2);
                    at(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            q("drawable_failed @ onNewResult", t);
            at(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.bRC();
            return;
        }
        this.iaB.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.iaP = null;
            this.iaM = true;
            if (this.iaN && this.mDrawable != null) {
                this.iaH.a(this.mDrawable, 1.0f, true);
            } else if (bSe()) {
                this.iaH.z(th);
            } else {
                this.iaH.y(th);
            }
            bSj().onFailure(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        bSj().onIntermediateImageFailed(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.bRC();
        } else if (!z) {
            this.iaH.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.iaP == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.iaP && this.iaK;
    }

    private void q(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(hXm, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, ax(t), Integer.valueOf(au(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(hXm, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable bSn() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String ax(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int au(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.an(this).ag("isAttached", this.mIsAttached).ag("isRequestSubmitted", this.iaK).ag("hasFetchFailed", this.iaM).be("fetchedImage", au(this.iaQ)).n("events", this.iaB.toString()).toString();
    }

    protected T bRU() {
        return null;
    }
}
