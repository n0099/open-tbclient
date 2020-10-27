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
/* loaded from: classes15.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH oHy;
    private boolean oHw = false;
    private boolean oHx = false;
    private boolean eaF = true;
    private com.facebook.drawee.d.a oHz = null;
    private final DraweeEventTracker oEo = DraweeEventTracker.ehz();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gZ(context);
        return bVar;
    }

    public void gZ(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.oEo.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.oHx = true;
        eiR();
    }

    public void onDetach() {
        this.oEo.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.oHx = false;
        eiR();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (eiS()) {
            return this.oHz.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void zX(boolean z) {
        if (this.eaF != z) {
            this.oEo.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.eaF = z;
            eiR();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.oHw) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.oHz)), toString());
            this.oHx = true;
            this.eaF = true;
            eiR();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.oHw;
        if (z) {
            eiQ();
        }
        if (eiS()) {
            this.oEo.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.oHz.setHierarchy(null);
        }
        this.oHz = aVar;
        if (this.oHz != null) {
            this.oEo.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.oHz.setHierarchy(this.oHy);
        } else {
            this.oEo.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            eiP();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.oHz;
    }

    public void setHierarchy(DH dh) {
        this.oEo.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean eiS = eiS();
        a(null);
        this.oHy = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.oHy.getTopLevelDrawable();
        zX(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (eiS) {
            this.oHz.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.oHy);
    }

    public Drawable getTopLevelDrawable() {
        if (this.oHy == null) {
            return null;
        }
        return this.oHy.getTopLevelDrawable();
    }

    private void eiP() {
        if (!this.oHw) {
            this.oEo.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.oHw = true;
            if (this.oHz != null && this.oHz.getHierarchy() != null) {
                this.oHz.onAttach();
            }
        }
    }

    private void eiQ() {
        if (this.oHw) {
            this.oEo.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.oHw = false;
            if (eiS()) {
                this.oHz.onDetach();
            }
        }
    }

    private void eiR() {
        if (this.oHx && this.eaF) {
            eiP();
        } else {
            eiQ();
        }
    }

    public String toString() {
        return f.aZ(this).bl("controllerAttached", this.oHw).bl("holderAttached", this.oHx).bl("drawableVisible", this.eaF).F("events", this.oEo.toString()).toString();
    }

    private boolean eiS() {
        return this.oHz != null && this.oHz.getHierarchy() == this.oHy;
    }
}
