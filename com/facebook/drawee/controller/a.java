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
public abstract class a<T, INFO> implements a.InterfaceC0561a, a.InterfaceC0562a, com.facebook.drawee.d.a {
    private static final Class<?> jZN = a.class;
    private final com.facebook.drawee.components.a kcK;
    private final DraweeEventTracker kcW = DraweeEventTracker.cDP();
    private final Executor kcX;
    @Nullable
    private com.facebook.drawee.components.b kcY;
    @Nullable
    private com.facebook.drawee.c.a kcZ;
    @Nullable
    private c<INFO> kda;
    @Nullable
    private d kdb;
    @Nullable
    private com.facebook.drawee.d.c kdc;
    @Nullable
    private Drawable kdd;
    private Object kde;
    private boolean kdf;
    private boolean kdg;
    private boolean kdh;
    private boolean kdi;
    @Nullable
    private String kdj;
    @Nullable
    private com.facebook.datasource.b<T> kdk;
    @Nullable
    private T kdl;
    @Nullable
    private Throwable kdm;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;

    protected abstract void aD(@Nullable T t);

    @Nullable
    protected abstract INFO aF(T t);

    protected abstract Drawable aG(T t);

    protected abstract com.facebook.datasource.b<T> cDE();

    protected abstract void d(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0563a<INFO> extends e<INFO> {
        private C0563a() {
        }

        public static <INFO> C0563a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0563a<INFO> c0563a = new C0563a<>();
            c0563a.c(cVar);
            c0563a.c(cVar2);
            return c0563a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.kcK = aVar;
        this.kcX = executor;
        a(str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str, Object obj) {
        a(str, obj, false);
    }

    private void a(String str, Object obj, boolean z) {
        this.kcW.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (com.facebook.common.references.a.cCV()) {
            this.kdm = new Throwable();
        }
        if (!z && this.kcK != null) {
            this.kcK.b(this);
        }
        this.mIsAttached = false;
        this.kdg = false;
        cDS();
        this.kdi = false;
        if (this.kcY != null) {
            this.kcY.init();
        }
        if (this.kcZ != null) {
            this.kcZ.init();
            this.kcZ.a(this);
        }
        if (this.kda instanceof C0563a) {
            ((C0563a) this.kda).cEn();
        } else {
            this.kda = null;
        }
        this.kdb = null;
        if (this.kdc != null) {
            this.kdc.reset();
            this.kdc.e(null);
            this.kdc = null;
        }
        this.kdd = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.kde = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0562a
    public void release() {
        this.kcW.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.kcY != null) {
            this.kcY.reset();
        }
        if (this.kcZ != null) {
            this.kcZ.reset();
        }
        if (this.kdc != null) {
            this.kdc.reset();
        }
        cDS();
    }

    private void cDS() {
        boolean z = this.kdf;
        this.kdf = false;
        this.kdh = false;
        if (this.kdk != null) {
            this.kdk.FH();
            this.kdk = null;
        }
        if (this.mDrawable != null) {
            d(this.mDrawable);
        }
        if (this.kdj != null) {
            this.kdj = null;
        }
        this.mDrawable = null;
        if (this.kdl != null) {
            t("release", this.kdl);
            aD(this.kdl);
            this.kdl = null;
        }
        if (z) {
            cDV().GE(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.components.b cDT() {
        return this.kcY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.components.b bVar) {
        this.kcY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a cDU() {
        return this.kcZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.kcZ = aVar;
        if (this.kcZ != null) {
            this.kcZ.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sf(boolean z) {
        this.kdi = z;
    }

    public void GD(@Nullable String str) {
        this.kdj = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.kda instanceof C0563a) {
            ((C0563a) this.kda).c(cVar);
        } else if (this.kda != null) {
            this.kda = C0563a.a(this.kda, cVar);
        } else {
            this.kda = cVar;
        }
    }

    protected c<INFO> cDV() {
        return this.kda == null ? b.cEm() : this.kda;
    }

    public void a(@Nullable d dVar) {
        this.kdb = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.kdc;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.kcW.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.kdf) {
            this.kcK.b(this);
            release();
        }
        if (this.kdc != null) {
            this.kdc.e(null);
            this.kdc = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.kdc = (com.facebook.drawee.d.c) bVar;
            this.kdc.e(this.kdd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@Nullable Drawable drawable) {
        this.kdd = drawable;
        if (this.kdc != null) {
            this.kdc.e(this.kdd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable cDW() {
        return this.kdd;
    }

    @Override // com.facebook.drawee.d.a
    public void cDX() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.kdf ? "request already submitted" : "request needs submit");
        }
        this.kcW.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.kdc);
        this.kcK.b(this);
        this.mIsAttached = true;
        if (!this.kdf) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.kcW.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.kcK.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.kcZ == null) {
            return false;
        }
        if (this.kcZ.cFe() || cDY()) {
            this.kcZ.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean cDY() {
        return cDQ();
    }

    private boolean cDQ() {
        return this.kdh && this.kcY != null && this.kcY.cDQ();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0561a
    public boolean cDZ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (cDQ()) {
            this.kcY.cDR();
            this.kdc.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T cDG = cDG();
        if (cDG != null) {
            this.kdk = null;
            this.kdf = true;
            this.kdh = false;
            this.kcW.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            cDV().u(this.mId, this.kde);
            a(this.mId, this.kdk, cDG, 1.0f, true, true);
            return;
        }
        this.kcW.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        cDV().u(this.mId, this.kde);
        this.kdc.d(0.0f, true);
        this.kdf = true;
        this.kdh = false;
        this.kdk = cDE();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.kdk)));
        }
        final String str = this.mId;
        final boolean cDm = this.kdk.cDm();
        this.kdk.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (a.this.kdm != null && (result instanceof com.facebook.common.references.a)) {
                    ((com.facebook.common.references.a) result).r(a.this.kdm);
                }
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, cDm);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.cDo(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.kcX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            t("ignore_old_datasource @ onNewResult", t);
            aD(t);
            bVar.FH();
            return;
        }
        this.kcW.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aG = aG(t);
            T t2 = this.kdl;
            Drawable drawable = this.mDrawable;
            this.kdl = t;
            this.mDrawable = aG;
            try {
                if (z) {
                    t("set_final_result @ onNewResult", t);
                    this.kdk = null;
                    this.kdc.a(aG, 1.0f, z2);
                    cDV().a(str, aF(t), cEa());
                } else {
                    t("set_intermediate_result @ onNewResult", t);
                    this.kdc.a(aG, f, z2);
                    cDV().v(str, aF(t));
                }
                if (drawable != null && drawable != aG) {
                    d(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aD(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aG) {
                    d(drawable);
                }
                if (t2 != null && t2 != t) {
                    t("release_previous_result @ onNewResult", t2);
                    aD(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            t("drawable_failed @ onNewResult", t);
            aD(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.FH();
            return;
        }
        this.kcW.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.kdk = null;
            this.kdh = true;
            if (this.kdi && this.mDrawable != null) {
                this.kdc.a(this.mDrawable, 1.0f, true);
            } else if (cDQ()) {
                this.kdc.y(th);
            } else {
                this.kdc.x(th);
            }
            cDV().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        cDV().l(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.FH();
        } else if (!z) {
            this.kdc.d(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.kdk == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.kdk && this.kdf;
    }

    private void t(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(jZN, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aH(t), Integer.valueOf(aE(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(jZN, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Nullable
    public Animatable cEa() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aH(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aE(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.ax(this).az("isAttached", this.mIsAttached).az("isRequestSubmitted", this.kdf).az("hasFetchFailed", this.kdh).bt("fetchedImage", aE(this.kdl)).q("events", this.kcW.toString()).toString();
    }

    protected T cDG() {
        return null;
    }
}
