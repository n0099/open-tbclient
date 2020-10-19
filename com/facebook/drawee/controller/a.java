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
public abstract class a<T, INFO> implements a.InterfaceC0880a, a.InterfaceC0881a, com.facebook.drawee.d.a {
    private static final Class<?> nJf = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final Executor nMW;
    @Nullable
    private com.facebook.drawee.components.b nMX;
    @Nullable
    private com.facebook.drawee.c.a nMY;
    @Nullable
    private c<INFO> nMZ;
    private final com.facebook.drawee.components.a nMi;
    private Object nMo;
    @Nullable
    private d nNa;
    @Nullable
    private com.facebook.drawee.d.c nNb;
    @Nullable
    private Drawable nNc;
    private boolean nNd;
    private boolean nNe;
    private boolean nNf;
    private boolean nNg;
    @Nullable
    private String nNh;
    @Nullable
    private com.facebook.datasource.b<T> nNi;
    @Nullable
    private T nNj;
    private final DraweeEventTracker nMV = DraweeEventTracker.dXB();
    private boolean nNk = true;

    protected abstract void bc(@Nullable T t);

    @Nullable
    protected abstract INFO be(T t);

    protected abstract Drawable bf(T t);

    protected abstract com.facebook.datasource.b<T> dXm();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0882a<INFO> extends e<INFO> {
        private C0882a() {
        }

        public static <INFO> C0882a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0882a<INFO> c0882a = new C0882a<>();
            c0882a.d(cVar);
            c0882a.d(cVar2);
            return c0882a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.nMi = aVar;
        this.nMW = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.nNk = false;
    }

    private synchronized void J(String str, Object obj) {
        this.nMV.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.nNk && this.nMi != null) {
            this.nMi.b(this);
        }
        this.mIsAttached = false;
        this.nNe = false;
        dXE();
        this.nNg = false;
        if (this.nMX != null) {
            this.nMX.init();
        }
        if (this.nMY != null) {
            this.nMY.init();
            this.nMY.a(this);
        }
        if (this.nMZ instanceof C0882a) {
            ((C0882a) this.nMZ).dXY();
        } else {
            this.nMZ = null;
        }
        this.nNa = null;
        if (this.nNb != null) {
            this.nNb.reset();
            this.nNb.j(null);
            this.nNb = null;
        }
        this.nNc = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.nMo = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0881a
    public void release() {
        this.nMV.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.nMX != null) {
            this.nMX.reset();
        }
        if (this.nMY != null) {
            this.nMY.reset();
        }
        if (this.nNb != null) {
            this.nNb.reset();
        }
        dXE();
    }

    private void dXE() {
        boolean z = this.nNd;
        this.nNd = false;
        this.nNf = false;
        if (this.nNi != null) {
            this.nNi.akV();
            this.nNi = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.nNh != null) {
            this.nNh = null;
        }
        this.mDrawable = null;
        if (this.nNj != null) {
            K("release", this.nNj);
            bc(this.nNj);
            this.nNj = null;
        }
        if (z) {
            dXH().gU(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dXF() {
        if (this.nMX == null) {
            this.nMX = new com.facebook.drawee.components.b();
        }
        return this.nMX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dXG() {
        return this.nMY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.nMY = aVar;
        if (this.nMY != null) {
            this.nMY.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yK(boolean z) {
        this.nNg = z;
    }

    public void VR(@Nullable String str) {
        this.nNh = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nMZ instanceof C0882a) {
            ((C0882a) this.nMZ).d(cVar);
        } else if (this.nMZ != null) {
            this.nMZ = C0882a.a(this.nMZ, cVar);
        } else {
            this.nMZ = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.nMZ instanceof C0882a) {
            ((C0882a) this.nMZ).e(cVar);
        } else if (this.nMZ == cVar) {
            this.nMZ = null;
        }
    }

    protected c<INFO> dXH() {
        return this.nMZ == null ? b.dXX() : this.nMZ;
    }

    public void a(@Nullable d dVar) {
        this.nNa = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.nNb;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.nMV.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.nNd) {
            this.nMi.b(this);
            release();
        }
        if (this.nNb != null) {
            this.nNb.j(null);
            this.nNb = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.nNb = (com.facebook.drawee.d.c) bVar;
            this.nNb.j(this.nNc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.nNc = drawable;
        if (this.nNb != null) {
            this.nNb.j(this.nNc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dXI() {
        return this.nNc;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.nNd ? "request already submitted" : "request needs submit");
        }
        this.nMV.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.nNb);
        this.nMi.b(this);
        this.mIsAttached = true;
        if (!this.nNd) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.nMV.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.nMi.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.nMY == null) {
            return false;
        }
        if (this.nMY.dYN() || dXJ()) {
            this.nMY.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dXJ() {
        return dXC();
    }

    private boolean dXC() {
        return this.nNf && this.nMX != null && this.nMX.dXC();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0880a
    public boolean dXK() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dXC()) {
            this.nMX.dXD();
            this.nNb.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dXo = dXo();
        if (dXo != null) {
            this.nNi = null;
            this.nNd = true;
            this.nNf = false;
            this.nMV.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dXH().g(this.mId, this.nMo);
            H(this.mId, dXo);
            a(this.mId, this.nNi, dXo, 1.0f, true, true);
            return;
        }
        this.nMV.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dXH().g(this.mId, this.nMo);
        this.nNb.c(0.0f, true);
        this.nNd = true;
        this.nNf = false;
        this.nNi = dXm();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.nNi)));
        }
        final String str = this.mId;
        final boolean dWO = this.nNi.dWO();
        this.nNi.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, dWO);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.dWQ(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.nMW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            bc(t);
            bVar.akV();
            return;
        }
        this.nMV.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable bf = bf(t);
            T t2 = this.nNj;
            Drawable drawable = this.mDrawable;
            this.nNj = t;
            this.mDrawable = bf;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.nNi = null;
                    this.nNb.a(bf, 1.0f, z2);
                    dXH().a(str, be(t), dXL());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.nNb.a(bf, f, z2);
                    dXH().h(str, (String) be(t));
                }
                if (drawable != null && drawable != bf) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bc(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != bf) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    bc(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            bc(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.akV();
            return;
        }
        this.nMV.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.nNi = null;
            this.nNf = true;
            if (this.nNg && this.mDrawable != null) {
                this.nNb.a(this.mDrawable, 1.0f, true);
            } else if (dXC()) {
                this.nNb.C(th);
            } else {
                this.nNb.B(th);
            }
            dXH().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dXH().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.akV();
        } else if (!z) {
            this.nNb.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.nNi == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.nNi && this.nNd;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(nJf, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, bh(t), Integer.valueOf(bd(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nJf, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dXL() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String bh(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int bd(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aV(this).bf("isAttached", this.mIsAttached).bf("isRequestSubmitted", this.nNd).bf("hasFetchFailed", this.nNf).bQ("fetchedImage", bd(this.nNj)).F("events", this.nMV.toString()).toString();
    }

    protected T dXo() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
