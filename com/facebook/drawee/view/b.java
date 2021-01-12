package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.f;
import com.facebook.common.internal.g;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.d.b;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH puf;
    private boolean pud = false;
    private boolean pue = false;
    private boolean eqJ = true;
    private com.facebook.drawee.d.a pug = null;
    private final DraweeEventTracker prf = DraweeEventTracker.ers();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.ig(context);
        return bVar;
    }

    public void ig(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.prf.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.pue = true;
        esI();
    }

    public void onDetach() {
        this.prf.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.pue = false;
        esI();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (esJ()) {
            return this.pug.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void AW(boolean z) {
        if (this.eqJ != z) {
            this.prf.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.eqJ = z;
            esI();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.pud) {
            com.facebook.common.c.a.c((Class<?>) DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.pug)), toString());
            this.pue = true;
            this.eqJ = true;
            esI();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.pud;
        if (z) {
            esH();
        }
        if (esJ()) {
            this.prf.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.pug.setHierarchy(null);
        }
        this.pug = aVar;
        if (this.pug != null) {
            this.prf.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.pug.setHierarchy(this.puf);
        } else {
            this.prf.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            esG();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pug;
    }

    public void setHierarchy(DH dh) {
        this.prf.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean esJ = esJ();
        a(null);
        this.puf = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.puf.getTopLevelDrawable();
        AW(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (esJ) {
            this.pug.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.puf);
    }

    public Drawable getTopLevelDrawable() {
        if (this.puf == null) {
            return null;
        }
        return this.puf.getTopLevelDrawable();
    }

    private void esG() {
        if (!this.pud) {
            this.prf.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.pud = true;
            if (this.pug != null && this.pug.getHierarchy() != null) {
                this.pug.onAttach();
            }
        }
    }

    private void esH() {
        if (this.pud) {
            this.prf.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.pud = false;
            if (esJ()) {
                this.pug.onDetach();
            }
        }
    }

    private void esI() {
        if (this.pue && this.eqJ) {
            esG();
        } else {
            esH();
        }
    }

    public String toString() {
        return f.bb(this).bo("controllerAttached", this.pud).bo("holderAttached", this.pue).bo("drawableVisible", this.eqJ).I("events", this.prf.toString()).toString();
    }

    private boolean esJ() {
        return this.pug != null && this.pug.getHierarchy() == this.puf;
    }
}
