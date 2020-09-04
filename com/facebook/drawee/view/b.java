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
/* loaded from: classes4.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH nqP;
    private boolean nqN = false;
    private boolean nqO = false;
    private boolean dEh = true;
    private com.facebook.drawee.d.a nqQ = null;
    private final DraweeEventTracker nnC = DraweeEventTracker.dPS();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gr(context);
        return bVar;
    }

    public void gr(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.nnC.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.nqO = true;
        dRk();
    }

    public void onDetach() {
        this.nnC.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.nqO = false;
        dRk();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dRl()) {
            return this.nqQ.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void xZ(boolean z) {
        if (this.dEh != z) {
            this.nnC.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.dEh = z;
            dRk();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.nqN) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.nqQ)), toString());
            this.nqO = true;
            this.dEh = true;
            dRk();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.nqN;
        if (z) {
            dRj();
        }
        if (dRl()) {
            this.nnC.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.nqQ.setHierarchy(null);
        }
        this.nqQ = aVar;
        if (this.nqQ != null) {
            this.nnC.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.nqQ.setHierarchy(this.nqP);
        } else {
            this.nnC.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dRi();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nqQ;
    }

    public void setHierarchy(DH dh) {
        this.nnC.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dRl = dRl();
        a(null);
        this.nqP = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.nqP.getTopLevelDrawable();
        xZ(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dRl) {
            this.nqQ.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.nqP);
    }

    public Drawable getTopLevelDrawable() {
        if (this.nqP == null) {
            return null;
        }
        return this.nqP.getTopLevelDrawable();
    }

    private void dRi() {
        if (!this.nqN) {
            this.nnC.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.nqN = true;
            if (this.nqQ != null && this.nqQ.getHierarchy() != null) {
                this.nqQ.onAttach();
            }
        }
    }

    private void dRj() {
        if (this.nqN) {
            this.nnC.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.nqN = false;
            if (dRl()) {
                this.nqQ.onDetach();
            }
        }
    }

    private void dRk() {
        if (this.nqO && this.dEh) {
            dRi();
        } else {
            dRj();
        }
    }

    public String toString() {
        return f.aQ(this).ba("controllerAttached", this.nqN).ba("holderAttached", this.nqO).ba("drawableVisible", this.dEh).E("events", this.nnC.toString()).toString();
    }

    private boolean dRl() {
        return this.nqQ != null && this.nqQ.getHierarchy() == this.nqP;
    }
}
