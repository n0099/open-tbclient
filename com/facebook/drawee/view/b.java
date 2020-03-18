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
/* loaded from: classes13.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH lPQ;
    private boolean lPO = false;
    private boolean lPP = false;
    private boolean mIsVisible = true;
    private com.facebook.drawee.d.a lPR = null;
    private final DraweeEventTracker lMJ = DraweeEventTracker.dms();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gk(context);
        return bVar;
    }

    public void gk(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.lMJ.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lPP = true;
        dnL();
    }

    public void onDetach() {
        this.lMJ.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lPP = false;
        dnL();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dnM()) {
            return this.lPR.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vr(boolean z) {
        if (this.mIsVisible != z) {
            this.lMJ.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            dnL();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.lPO) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lPR)), toString());
            this.lPP = true;
            this.mIsVisible = true;
            dnL();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lPO;
        if (z) {
            dnK();
        }
        if (dnM()) {
            this.lMJ.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lPR.setHierarchy(null);
        }
        this.lPR = aVar;
        if (this.lPR != null) {
            this.lMJ.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lPR.setHierarchy(this.lPQ);
        } else {
            this.lMJ.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dnJ();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lPR;
    }

    public void setHierarchy(DH dh) {
        this.lMJ.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dnM = dnM();
        a(null);
        this.lPQ = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lPQ.getTopLevelDrawable();
        vr(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dnM) {
            this.lPR.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lPQ);
    }

    public boolean hasHierarchy() {
        return this.lPQ != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.lPQ == null) {
            return null;
        }
        return this.lPQ.getTopLevelDrawable();
    }

    private void dnJ() {
        if (!this.lPO) {
            this.lMJ.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lPO = true;
            if (this.lPR != null && this.lPR.getHierarchy() != null) {
                this.lPR.onAttach();
            }
        }
    }

    private void dnK() {
        if (this.lPO) {
            this.lMJ.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lPO = false;
            if (dnM()) {
                this.lPR.onDetach();
            }
        }
    }

    private void dnL() {
        if (this.lPP && this.mIsVisible) {
            dnJ();
        } else {
            dnK();
        }
    }

    public String toString() {
        return f.aS(this).aK("controllerAttached", this.lPO).aK("holderAttached", this.lPP).aK("drawableVisible", this.mIsVisible).x("events", this.lMJ.toString()).toString();
    }

    private boolean dnM() {
        return this.lPR != null && this.lPR.getHierarchy() == this.lPQ;
    }
}
