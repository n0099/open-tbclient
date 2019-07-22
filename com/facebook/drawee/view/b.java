package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.f;
import com.facebook.common.internal.g;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.d.b;
import com.facebook.drawee.drawable.q;
import com.facebook.drawee.drawable.r;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<DH extends com.facebook.drawee.d.b> implements r {
    private DH kdU;
    private boolean kdS = false;
    private boolean kdT = false;
    private boolean jEW = true;
    private com.facebook.drawee.d.a kdV = null;
    private final DraweeEventTracker kbk = DraweeEventTracker.cFI();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eB(context);
        return bVar;
    }

    public void eB(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cFQ() {
        this.kbk.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.kdT = true;
        cHb();
    }

    public void onDetach() {
        this.kbk.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.kdT = false;
        cHb();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cHc()) {
            return this.kdV.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void sy(boolean z) {
        if (this.jEW != z) {
            this.kbk.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jEW = z;
            cHb();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void cGv() {
        if (!this.kdS) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kdV)), toString());
            this.kdT = true;
            this.jEW = true;
            cHb();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.kdS;
        if (z) {
            cHa();
        }
        if (cHc()) {
            this.kbk.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.kdV.setHierarchy(null);
        }
        this.kdV = aVar;
        if (this.kdV != null) {
            this.kbk.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.kdV.setHierarchy(this.kdU);
        } else {
            this.kbk.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cGZ();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.kdV;
    }

    public void setHierarchy(DH dh) {
        this.kbk.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cHc = cHc();
        a(null);
        this.kdU = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.kdU.getTopLevelDrawable();
        sy(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cHc) {
            this.kdV.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.kdU);
    }

    public Drawable getTopLevelDrawable() {
        if (this.kdU == null) {
            return null;
        }
        return this.kdU.getTopLevelDrawable();
    }

    private void cGZ() {
        if (!this.kdS) {
            this.kbk.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.kdS = true;
            if (this.kdV != null && this.kdV.getHierarchy() != null) {
                this.kdV.cFQ();
            }
        }
    }

    private void cHa() {
        if (this.kdS) {
            this.kbk.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.kdS = false;
            if (cHc()) {
                this.kdV.onDetach();
            }
        }
    }

    private void cHb() {
        if (this.kdT && this.jEW) {
            cGZ();
        } else {
            cHa();
        }
    }

    public String toString() {
        return f.aC(this).aE("controllerAttached", this.kdS).aE("holderAttached", this.kdT).aE("drawableVisible", this.jEW).t("events", this.kbk.toString()).toString();
    }

    private boolean cHc() {
        return this.kdV != null && this.kdV.getHierarchy() == this.kdU;
    }
}
