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
    private DH pGT;
    private boolean pGR = false;
    private boolean pGS = false;
    private boolean eus = true;
    private com.facebook.drawee.d.a pGU = null;
    private final DraweeEventTracker pDU = DraweeEventTracker.eub();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.ii(context);
        return bVar;
    }

    public void ii(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.pDU.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.pGS = true;
        evr();
    }

    public void onDetach() {
        this.pDU.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.pGS = false;
        evr();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (evs()) {
            return this.pGU.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void Bn(boolean z) {
        if (this.eus != z) {
            this.pDU.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.eus = z;
            evr();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.pGR) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.pGU)), toString());
            this.pGS = true;
            this.eus = true;
            evr();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.pGR;
        if (z) {
            evq();
        }
        if (evs()) {
            this.pDU.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.pGU.setHierarchy(null);
        }
        this.pGU = aVar;
        if (this.pGU != null) {
            this.pDU.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.pGU.setHierarchy(this.pGT);
        } else {
            this.pDU.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            evp();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pGU;
    }

    public void setHierarchy(DH dh) {
        this.pDU.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean evs = evs();
        a(null);
        this.pGT = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.pGT.getTopLevelDrawable();
        Bn(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (evs) {
            this.pGU.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.pGT);
    }

    public Drawable getTopLevelDrawable() {
        if (this.pGT == null) {
            return null;
        }
        return this.pGT.getTopLevelDrawable();
    }

    private void evp() {
        if (!this.pGR) {
            this.pDU.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.pGR = true;
            if (this.pGU != null && this.pGU.getHierarchy() != null) {
                this.pGU.onAttach();
            }
        }
    }

    private void evq() {
        if (this.pGR) {
            this.pDU.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.pGR = false;
            if (evs()) {
                this.pGU.onDetach();
            }
        }
    }

    private void evr() {
        if (this.pGS && this.eus) {
            evp();
        } else {
            evq();
        }
    }

    public String toString() {
        return f.bd(this).bo("controllerAttached", this.pGR).bo("holderAttached", this.pGS).bo("drawableVisible", this.eus).G("events", this.pDU.toString()).toString();
    }

    private boolean evs() {
        return this.pGU != null && this.pGU.getHierarchy() == this.pGT;
    }
}
