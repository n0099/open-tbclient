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
    private DH pug;
    private boolean pue = false;
    private boolean puf = false;
    private boolean eqJ = true;
    private com.facebook.drawee.d.a puh = null;
    private final DraweeEventTracker prg = DraweeEventTracker.ers();

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
        this.prg.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.puf = true;
        esI();
    }

    public void onDetach() {
        this.prg.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.puf = false;
        esI();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (esJ()) {
            return this.puh.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void AW(boolean z) {
        if (this.eqJ != z) {
            this.prg.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.eqJ = z;
            esI();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.pue) {
            com.facebook.common.c.a.c((Class<?>) DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.puh)), toString());
            this.puf = true;
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
        boolean z = this.pue;
        if (z) {
            esH();
        }
        if (esJ()) {
            this.prg.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.puh.setHierarchy(null);
        }
        this.puh = aVar;
        if (this.puh != null) {
            this.prg.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.puh.setHierarchy(this.pug);
        } else {
            this.prg.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            esG();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.puh;
    }

    public void setHierarchy(DH dh) {
        this.prg.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean esJ = esJ();
        a(null);
        this.pug = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.pug.getTopLevelDrawable();
        AW(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (esJ) {
            this.puh.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.pug);
    }

    public Drawable getTopLevelDrawable() {
        if (this.pug == null) {
            return null;
        }
        return this.pug.getTopLevelDrawable();
    }

    private void esG() {
        if (!this.pue) {
            this.prg.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.pue = true;
            if (this.puh != null && this.puh.getHierarchy() != null) {
                this.puh.onAttach();
            }
        }
    }

    private void esH() {
        if (this.pue) {
            this.prg.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.pue = false;
            if (esJ()) {
                this.puh.onDetach();
            }
        }
    }

    private void esI() {
        if (this.puf && this.eqJ) {
            esG();
        } else {
            esH();
        }
    }

    public String toString() {
        return f.bb(this).bo("controllerAttached", this.pue).bo("holderAttached", this.puf).bo("drawableVisible", this.eqJ).I("events", this.prg.toString()).toString();
    }

    private boolean esJ() {
        return this.puh != null && this.puh.getHierarchy() == this.pug;
    }
}
