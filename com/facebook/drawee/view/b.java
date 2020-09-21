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
/* loaded from: classes11.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH nAN;
    private boolean nAL = false;
    private boolean nAM = false;
    private boolean dGi = true;
    private com.facebook.drawee.d.a nAO = null;
    private final DraweeEventTracker nxC = DraweeEventTracker.dTQ();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gx(context);
        return bVar;
    }

    public void gx(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.nxC.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.nAM = true;
        dVi();
    }

    public void onDetach() {
        this.nxC.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.nAM = false;
        dVi();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dVj()) {
            return this.nAO.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void yi(boolean z) {
        if (this.dGi != z) {
            this.nxC.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.dGi = z;
            dVi();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.nAL) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.nAO)), toString());
            this.nAM = true;
            this.dGi = true;
            dVi();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.nAL;
        if (z) {
            dVh();
        }
        if (dVj()) {
            this.nxC.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.nAO.setHierarchy(null);
        }
        this.nAO = aVar;
        if (this.nAO != null) {
            this.nxC.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.nAO.setHierarchy(this.nAN);
        } else {
            this.nxC.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dVg();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nAO;
    }

    public void setHierarchy(DH dh) {
        this.nxC.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dVj = dVj();
        a(null);
        this.nAN = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.nAN.getTopLevelDrawable();
        yi(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dVj) {
            this.nAO.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.nAN);
    }

    public Drawable getTopLevelDrawable() {
        if (this.nAN == null) {
            return null;
        }
        return this.nAN.getTopLevelDrawable();
    }

    private void dVg() {
        if (!this.nAL) {
            this.nxC.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.nAL = true;
            if (this.nAO != null && this.nAO.getHierarchy() != null) {
                this.nAO.onAttach();
            }
        }
    }

    private void dVh() {
        if (this.nAL) {
            this.nxC.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.nAL = false;
            if (dVj()) {
                this.nAO.onDetach();
            }
        }
    }

    private void dVi() {
        if (this.nAM && this.dGi) {
            dVg();
        } else {
            dVh();
        }
    }

    public String toString() {
        return f.aS(this).bb("controllerAttached", this.nAL).bb("holderAttached", this.nAM).bb("drawableVisible", this.dGi).E("events", this.nxC.toString()).toString();
    }

    private boolean dVj() {
        return this.nAO != null && this.nAO.getHierarchy() == this.nAN;
    }
}
