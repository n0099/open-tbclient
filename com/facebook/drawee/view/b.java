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
    private DH jWM;
    private boolean jWK = false;
    private boolean jWL = false;
    private boolean jyJ = true;
    private com.facebook.drawee.d.a jWN = null;
    private final DraweeEventTracker jUc = DraweeEventTracker.cCG();

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

    public void cCO() {
        this.jUc.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jWL = true;
        cDX();
    }

    public void onDetach() {
        this.jUc.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jWL = false;
        cDX();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cDY()) {
            return this.jWN.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void si(boolean z) {
        if (this.jyJ != z) {
            this.jUc.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jyJ = z;
            cDX();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jWK) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jWN)), toString());
            this.jWL = true;
            this.jyJ = true;
            cDX();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.jWK;
        if (z) {
            cDW();
        }
        if (cDY()) {
            this.jUc.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jWN.setHierarchy(null);
        }
        this.jWN = aVar;
        if (this.jWN != null) {
            this.jUc.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jWN.setHierarchy(this.jWM);
        } else {
            this.jUc.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cDV();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jWN;
    }

    public void setHierarchy(DH dh) {
        this.jUc.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cDY = cDY();
        a(null);
        this.jWM = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jWM.getTopLevelDrawable();
        si(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cDY) {
            this.jWN.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jWM);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jWM == null) {
            return null;
        }
        return this.jWM.getTopLevelDrawable();
    }

    private void cDV() {
        if (!this.jWK) {
            this.jUc.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jWK = true;
            if (this.jWN != null && this.jWN.getHierarchy() != null) {
                this.jWN.cCO();
            }
        }
    }

    private void cDW() {
        if (this.jWK) {
            this.jUc.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jWK = false;
            if (cDY()) {
                this.jWN.onDetach();
            }
        }
    }

    private void cDX() {
        if (this.jWL && this.jyJ) {
            cDV();
        } else {
            cDW();
        }
    }

    public String toString() {
        return f.aC(this).aA("controllerAttached", this.jWK).aA("holderAttached", this.jWL).aA("drawableVisible", this.jyJ).t("events", this.jUc.toString()).toString();
    }

    private boolean cDY() {
        return this.jWN != null && this.jWN.getHierarchy() == this.jWM;
    }
}
