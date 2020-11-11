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
public abstract class a<T, INFO> implements a.InterfaceC0971a, a.InterfaceC0972a, com.facebook.drawee.d.a {
    private static final Class<?> oJR = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final com.facebook.drawee.components.a oMU;
    private final Executor oNI;
    @Nullable
    private com.facebook.drawee.components.b oNJ;
    @Nullable
    private com.facebook.drawee.c.a oNK;
    @Nullable
    private c<INFO> oNL;
    @Nullable
    private d oNM;
    @Nullable
    private com.facebook.drawee.d.c oNN;
    @Nullable
    private Drawable oNO;
    private boolean oNP;
    private boolean oNQ;
    private boolean oNR;
    private boolean oNS;
    @Nullable
    private String oNT;
    @Nullable
    private com.facebook.datasource.b<T> oNU;
    @Nullable
    private T oNV;
    private Object oNa;
    private final DraweeEventTracker oNH = DraweeEventTracker.elo();
    private boolean oNW = true;

    protected abstract void bg(@Nullable T t);

    @Nullable
    protected abstract INFO bi(T t);

    protected abstract Drawable bj(T t);

    protected abstract com.facebook.datasource.b<T> ekZ();

    protected abstract void n(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0973a<INFO> extends e<INFO> {
        private C0973a() {
        }

        public static <INFO> C0973a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0973a<INFO> c0973a = new C0973a<>();
            c0973a.d(cVar);
            c0973a.d(cVar2);
            return c0973a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.oMU = aVar;
        this.oNI = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.oNW = false;
    }

    private synchronized void J(String str, Object obj) {
        this.oNH.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.oNW && this.oMU != null) {
            this.oMU.b(this);
        }
        this.mIsAttached = false;
        this.oNQ = false;
        elr();
        this.oNS = false;
        if (this.oNJ != null) {
            this.oNJ.init();
        }
        if (this.oNK != null) {
            this.oNK.init();
            this.oNK.a(this);
        }
        if (this.oNL instanceof C0973a) {
            ((C0973a) this.oNL).elL();
        } else {
            this.oNL = null;
        }
        this.oNM = null;
        if (this.oNN != null) {
            this.oNN.reset();
            this.oNN.o(null);
            this.oNN = null;
        }
        this.oNO = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.oNa = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0972a
    public void release() {
        this.oNH.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.oNJ != null) {
            this.oNJ.reset();
        }
        if (this.oNK != null) {
            this.oNK.reset();
        }
        if (this.oNN != null) {
            this.oNN.reset();
        }
        elr();
    }

    private void elr() {
        boolean z = this.oNP;
        this.oNP = false;
        this.oNR = false;
        if (this.oNU != null) {
            this.oNU.apq();
            this.oNU = null;
        }
        if (this.mDrawable != null) {
            n(this.mDrawable);
        }
        if (this.oNT != null) {
            this.oNT = null;
        }
        this.mDrawable = null;
        if (this.oNV != null) {
            K("release", this.oNV);
            bg(this.oNV);
            this.oNV = null;
        }
        if (z) {
            elu().hm(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b els() {
        if (this.oNJ == null) {
            this.oNJ = new com.facebook.drawee.components.b();
        }
        return this.oNJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a elt() {
        return this.oNK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.oNK = aVar;
        if (this.oNK != null) {
            this.oNK.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ad(boolean z) {
        this.oNS = z;
    }

    public void Yi(@Nullable String str) {
        this.oNT = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.oNL instanceof C0973a) {
            ((C0973a) this.oNL).d(cVar);
        } else if (this.oNL != null) {
            this.oNL = C0973a.a(this.oNL, cVar);
        } else {
            this.oNL = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.oNL instanceof C0973a) {
            ((C0973a) this.oNL).e(cVar);
        } else if (this.oNL == cVar) {
            this.oNL = null;
        }
    }

    protected c<INFO> elu() {
        return this.oNL == null ? b.elK() : this.oNL;
    }

    public void a(@Nullable d dVar) {
        this.oNM = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.oNN;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.oNH.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.oNP) {
            this.oMU.b(this);
            release();
        }
        if (this.oNN != null) {
            this.oNN.o(null);
            this.oNN = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.oNN = (com.facebook.drawee.d.c) bVar;
            this.oNN.o(this.oNO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(@Nullable Drawable drawable) {
        this.oNO = drawable;
        if (this.oNN != null) {
            this.oNN.o(this.oNO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable elv() {
        return this.oNO;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.oNP ? "request already submitted" : "request needs submit");
        }
        this.oNH.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.oNN);
        this.oMU.b(this);
        this.mIsAttached = true;
        if (!this.oNP) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.oNH.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.oMU.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.oNK == null) {
            return false;
        }
        if (this.oNK.emA() || elw()) {
            this.oNK.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean elw() {
        return elp();
    }

    private boolean elp() {
        return this.oNR && this.oNJ != null && this.oNJ.elp();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0971a
    public boolean elx() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (elp()) {
            this.oNJ.elq();
            this.oNN.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T elb = elb();
        if (elb != null) {
            this.oNU = null;
            this.oNP = true;
            this.oNR = false;
            this.oNH.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            elu().g(this.mId, this.oNa);
            H(this.mId, elb);
            a(this.mId, this.oNU, elb, 1.0f, true, true);
            return;
        }
        this.oNH.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        elu().g(this.mId, this.oNa);
        this.oNN.c(0.0f, true);
        this.oNP = true;
        this.oNR = false;
        this.oNU = ekZ();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.oNU)));
        }
        final String str = this.mId;
        final boolean ekB = this.oNU.ekB();
        this.oNU.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, ekB);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.ekD(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.oNI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            bg(t);
            bVar.apq();
            return;
        }
        this.oNH.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bj = bj(t);
            T t2 = this.oNV;
            Drawable drawable = this.mDrawable;
            this.oNV = t;
            this.mDrawable = bj;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.oNU = null;
                    this.oNN.a(bj, 1.0f, z2);
                    elu().a(str, bi(t), ely());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.oNN.a(bj, f, z2);
                    elu().h(str, (String) bi(t));
                }
                if (drawable != null && drawable != bj) {
                    n(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bg(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bj) {
                    n(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bg(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            bg(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.apq();
            return;
        }
        this.oNH.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.oNU = null;
            this.oNR = true;
            if (this.oNS && this.mDrawable != null) {
                this.oNN.a(this.mDrawable, 1.0f, true);
            } else if (elp()) {
                this.oNN.C(th);
            } else {
                this.oNN.B(th);
            }
            elu().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        elu().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.apq();
        } else if (!z) {
            this.oNN.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.oNU == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.oNU && this.oNP;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(oJR, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bl(t), Integer.valueOf(bh(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable ely() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String bl(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int bh(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aZ(this).bn("isAttached", this.mIsAttached).bn("isRequestSubmitted", this.oNP).bn("hasFetchFailed", this.oNR).bW("fetchedImage", bh(this.oNV)).F("events", this.oNH.toString()).toString();
    }

    protected T elb() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
