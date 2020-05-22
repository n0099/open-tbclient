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
/* loaded from: classes13.dex */
public abstract class a<T, INFO> implements a.InterfaceC0777a, a.InterfaceC0778a, com.facebook.drawee.d.a {
    private static final Class<?> mki = a.class;
    @Nullable
    private Drawable mDrawable;
    private String mId;
    private boolean mIsAttached;
    private final Executor mnZ;
    private final com.facebook.drawee.components.a mnl;
    private Object mnr;
    @Nullable
    private com.facebook.drawee.components.b moa;
    @Nullable
    private com.facebook.drawee.c.a mob;
    @Nullable
    private c<INFO> moc;
    @Nullable
    private d mod;
    @Nullable
    private com.facebook.drawee.d.c moe;
    @Nullable
    private Drawable mof;
    private boolean mog;
    private boolean moh;
    private boolean moi;
    private boolean moj;
    @Nullable
    private String mok;
    @Nullable
    private com.facebook.datasource.b<T> mol;
    @Nullable
    private T mom;
    private final DraweeEventTracker mnY = DraweeEventTracker.dvB();
    private boolean moo = true;

    protected abstract void aU(@Nullable T t);

    @Nullable
    protected abstract INFO aW(T t);

    protected abstract Drawable aX(T t);

    protected abstract com.facebook.datasource.b<T> dvm();

    protected abstract void i(@Nullable Drawable drawable);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0779a<INFO> extends e<INFO> {
        private C0779a() {
        }

        public static <INFO> C0779a<INFO> a(c<? super INFO> cVar, c<? super INFO> cVar2) {
            C0779a<INFO> c0779a = new C0779a<>();
            c0779a.d(cVar);
            c0779a.d(cVar2);
            return c0779a;
        }
    }

    public a(com.facebook.drawee.components.a aVar, Executor executor, String str, Object obj) {
        this.mnl = aVar;
        this.mnZ = executor;
        J(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(String str, Object obj) {
        J(str, obj);
        this.moo = false;
    }

    private synchronized void J(String str, Object obj) {
        this.mnY.a(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.moo && this.mnl != null) {
            this.mnl.b(this);
        }
        this.mIsAttached = false;
        this.moh = false;
        dvE();
        this.moj = false;
        if (this.moa != null) {
            this.moa.init();
        }
        if (this.mob != null) {
            this.mob.init();
            this.mob.a(this);
        }
        if (this.moc instanceof C0779a) {
            ((C0779a) this.moc).dvY();
        } else {
            this.moc = null;
        }
        this.mod = null;
        if (this.moe != null) {
            this.moe.reset();
            this.moe.j(null);
            this.moe = null;
        }
        this.mof = null;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mnr = obj;
    }

    @Override // com.facebook.drawee.components.a.InterfaceC0778a
    public void release() {
        this.mnY.a(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        if (this.moa != null) {
            this.moa.reset();
        }
        if (this.mob != null) {
            this.mob.reset();
        }
        if (this.moe != null) {
            this.moe.reset();
        }
        dvE();
    }

    private void dvE() {
        boolean z = this.mog;
        this.mog = false;
        this.moi = false;
        if (this.mol != null) {
            this.mol.Zg();
            this.mol = null;
        }
        if (this.mDrawable != null) {
            i(this.mDrawable);
        }
        if (this.mok != null) {
            this.mok = null;
        }
        this.mDrawable = null;
        if (this.mom != null) {
            K("release", this.mom);
            aU(this.mom);
            this.mom = null;
        }
        if (z) {
            dvH().eV(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ReturnsOwnership
    public com.facebook.drawee.components.b dvF() {
        if (this.moa == null) {
            this.moa = new com.facebook.drawee.components.b();
        }
        return this.moa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.drawee.c.a dvG() {
        return this.mob;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable com.facebook.drawee.c.a aVar) {
        this.mob = aVar;
        if (this.mob != null) {
            this.mob.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vY(boolean z) {
        this.moj = z;
    }

    public void PY(@Nullable String str) {
        this.mok = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.drawee.controller.c<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.moc instanceof C0779a) {
            ((C0779a) this.moc).d(cVar);
        } else if (this.moc != null) {
            this.moc = C0779a.a(this.moc, cVar);
        } else {
            this.moc = cVar;
        }
    }

    public void b(c<? super INFO> cVar) {
        g.checkNotNull(cVar);
        if (this.moc instanceof C0779a) {
            ((C0779a) this.moc).e(cVar);
        } else if (this.moc == cVar) {
            this.moc = null;
        }
    }

    protected c<INFO> dvH() {
        return this.moc == null ? b.dvX() : this.moc;
    }

    public void a(@Nullable d dVar) {
        this.mod = dVar;
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public com.facebook.drawee.d.b getHierarchy() {
        return this.moe;
    }

    public void setHierarchy(@Nullable com.facebook.drawee.d.b bVar) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, bVar);
        }
        this.mnY.a(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mog) {
            this.mnl.b(this);
            release();
        }
        if (this.moe != null) {
            this.moe.j(null);
            this.moe = null;
        }
        if (bVar != null) {
            g.checkArgument(bVar instanceof com.facebook.drawee.d.c);
            this.moe = (com.facebook.drawee.d.c) bVar;
            this.moe.j(this.mof);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable Drawable drawable) {
        this.mof = drawable;
        if (this.moe != null) {
            this.moe.j(this.mof);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable dvI() {
        return this.mof;
    }

    @Override // com.facebook.drawee.d.a
    public void onAttach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mog ? "request already submitted" : "request needs submit");
        }
        this.mnY.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        g.checkNotNull(this.moe);
        this.mnl.b(this);
        this.mIsAttached = true;
        if (!this.mog) {
            submitRequest();
        }
    }

    @Override // com.facebook.drawee.d.a
    public void onDetach() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.mnY.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mnl.a(this);
    }

    @Override // com.facebook.drawee.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        if (this.mob == null) {
            return false;
        }
        if (this.mob.dwP() || dvJ()) {
            this.mob.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    protected boolean dvJ() {
        return dvC();
    }

    private boolean dvC() {
        return this.moi && this.moa != null && this.moa.dvC();
    }

    @Override // com.facebook.drawee.c.a.InterfaceC0777a
    public boolean dvK() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (dvC()) {
            this.moa.dvD();
            this.moe.reset();
            submitRequest();
            return true;
        }
        return false;
    }

    protected void submitRequest() {
        T dvo = dvo();
        if (dvo != null) {
            this.mol = null;
            this.mog = true;
            this.moi = false;
            this.mnY.a(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            dvH().g(this.mId, this.mnr);
            H(this.mId, dvo);
            a(this.mId, this.mol, dvo, 1.0f, true, true);
            return;
        }
        this.mnY.a(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        dvH().g(this.mId, this.mnr);
        this.moe.c(0.0f, true);
        this.mog = true;
        this.moi = false;
        this.mol = dvm();
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mol)));
        }
        final String str = this.mId;
        final boolean duO = this.mol.duO();
        this.mol.a(new com.facebook.datasource.a<T>() { // from class: com.facebook.drawee.controller.a.1
            @Override // com.facebook.datasource.a
            public void g(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                float progress = bVar.getProgress();
                T result = bVar.getResult();
                if (result != null) {
                    a.this.a(str, bVar, result, progress, isFinished, duO);
                } else if (isFinished) {
                    a.this.a(str, (com.facebook.datasource.b) bVar, (Throwable) new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.a
            public void a(com.facebook.datasource.b<T> bVar) {
                a.this.a(str, (com.facebook.datasource.b) bVar, bVar.duQ(), true);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void f(com.facebook.datasource.b<T> bVar) {
                boolean isFinished = bVar.isFinished();
                a.this.a(str, bVar, bVar.getProgress(), isFinished);
            }
        }, this.mnZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f, boolean z, boolean z2) {
        if (!a(str, bVar)) {
            K("ignore_old_datasource @ onNewResult", t);
            aU(t);
            bVar.Zg();
            return;
        }
        this.mnY.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
        try {
            Drawable aX = aX(t);
            T t2 = this.mom;
            Drawable drawable = this.mDrawable;
            this.mom = t;
            this.mDrawable = aX;
            try {
                if (z) {
                    K("set_final_result @ onNewResult", t);
                    this.mol = null;
                    this.moe.a(aX, 1.0f, z2);
                    dvH().a(str, aW(t), dvL());
                } else {
                    K("set_intermediate_result @ onNewResult", t);
                    this.moe.a(aX, f, z2);
                    dvH().h(str, (String) aW(t));
                }
                if (drawable != null && drawable != aX) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aU(t2);
                }
            } catch (Throwable th) {
                if (drawable != null && drawable != aX) {
                    i(drawable);
                }
                if (t2 != null && t2 != t) {
                    K("release_previous_result @ onNewResult", t2);
                    aU(t2);
                }
                throw th;
            }
        } catch (Exception e) {
            K("drawable_failed @ onNewResult", t);
            aU(t);
            a(str, bVar, e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onFailure", th);
            bVar.Zg();
            return;
        }
        this.mnY.a(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            k("final_failed @ onFailure", th);
            this.mol = null;
            this.moi = true;
            if (this.moj && this.mDrawable != null) {
                this.moe.a(this.mDrawable, 1.0f, true);
            } else if (dvC()) {
                this.moe.E(th);
            } else {
                this.moe.D(th);
            }
            dvH().h(this.mId, th);
            return;
        }
        k("intermediate_failed @ onFailure", th);
        dvH().g(this.mId, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.facebook.datasource.b<T> bVar, float f, boolean z) {
        if (!a(str, bVar)) {
            k("ignore_old_datasource @ onProgress", null);
            bVar.Zg();
        } else if (!z) {
            this.moe.c(f, false);
        }
    }

    private boolean a(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.mol == null) {
            return true;
        }
        return str.equals(this.mId) && bVar == this.mol && this.mog;
    }

    private void K(String str, T t) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.b(mki, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, aZ(t), Integer.valueOf(aV(t)));
        }
    }

    private void k(String str, Throwable th) {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.d.a
    @Nullable
    public Animatable dvL() {
        if (this.mDrawable instanceof Animatable) {
            return (Animatable) this.mDrawable;
        }
        return null;
    }

    protected String aZ(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int aV(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return f.aN(this).aX("isAttached", this.mIsAttached).aX("isRequestSubmitted", this.mog).aX("hasFetchFailed", this.moi).bN("fetchedImage", aV(this.mom)).F("events", this.mnY.toString()).toString();
    }

    protected T dvo() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str, T t) {
    }
}
