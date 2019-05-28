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
    private DH jWN;
    private boolean jWL = false;
    private boolean jWM = false;
    private boolean jyK = true;
    private com.facebook.drawee.d.a jWO = null;
    private final DraweeEventTracker jUd = DraweeEventTracker.cCI();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eA(context);
        return bVar;
    }

    public void eA(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cCQ() {
        this.jUd.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jWM = true;
        cDZ();
    }

    public void onDetach() {
        this.jUd.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jWM = false;
        cDZ();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cEa()) {
            return this.jWO.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void si(boolean z) {
        if (this.jyK != z) {
            this.jUd.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jyK = z;
            cDZ();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jWL) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jWO)), toString());
            this.jWM = true;
            this.jyK = true;
            cDZ();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.jWL;
        if (z) {
            cDY();
        }
        if (cEa()) {
            this.jUd.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jWO.setHierarchy(null);
        }
        this.jWO = aVar;
        if (this.jWO != null) {
            this.jUd.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jWO.setHierarchy(this.jWN);
        } else {
            this.jUd.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cDX();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jWO;
    }

    public void setHierarchy(DH dh) {
        this.jUd.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cEa = cEa();
        a(null);
        this.jWN = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jWN.getTopLevelDrawable();
        si(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cEa) {
            this.jWO.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jWN);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jWN == null) {
            return null;
        }
        return this.jWN.getTopLevelDrawable();
    }

    private void cDX() {
        if (!this.jWL) {
            this.jUd.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jWL = true;
            if (this.jWO != null && this.jWO.getHierarchy() != null) {
                this.jWO.cCQ();
            }
        }
    }

    private void cDY() {
        if (this.jWL) {
            this.jUd.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jWL = false;
            if (cEa()) {
                this.jWO.onDetach();
            }
        }
    }

    private void cDZ() {
        if (this.jWM && this.jyK) {
            cDX();
        } else {
            cDY();
        }
    }

    public String toString() {
        return f.aC(this).aA("controllerAttached", this.jWL).aA("holderAttached", this.jWM).aA("drawableVisible", this.jyK).t("events", this.jUd.toString()).toString();
    }

    private boolean cEa() {
        return this.jWO != null && this.jWO.getHierarchy() == this.jWN;
    }
}
