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
    private DH ibC;
    private boolean ibA = false;
    private boolean ibB = false;
    private boolean hCn = true;
    private com.facebook.drawee.d.a ibD = null;
    private final DraweeEventTracker hYR = DraweeEventTracker.bSI();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.ds(context);
        return bVar;
    }

    public void ds(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.hYR.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.ibB = true;
        bTX();
    }

    public void onDetach() {
        this.hYR.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.ibB = false;
        bTX();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (bTY()) {
            return this.ibD.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void oF(boolean z) {
        if (this.hCn != z) {
            this.hYR.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.hCn = z;
            bTX();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.ibA) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ibD)), toString());
            this.ibB = true;
            this.hCn = true;
            bTX();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.ibA;
        if (z) {
            bTW();
        }
        if (bTY()) {
            this.hYR.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.ibD.setHierarchy(null);
        }
        this.ibD = aVar;
        if (this.ibD != null) {
            this.hYR.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.ibD.setHierarchy(this.ibC);
        } else {
            this.hYR.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            bTV();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.ibD;
    }

    public void setHierarchy(DH dh) {
        this.hYR.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean bTY = bTY();
        a(null);
        this.ibC = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.ibC.getTopLevelDrawable();
        oF(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (bTY) {
            this.ibD.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.ibC);
    }

    public boolean hasHierarchy() {
        return this.ibC != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.ibC == null) {
            return null;
        }
        return this.ibC.getTopLevelDrawable();
    }

    private void bTV() {
        if (!this.ibA) {
            this.hYR.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.ibA = true;
            if (this.ibD != null && this.ibD.getHierarchy() != null) {
                this.ibD.onAttach();
            }
        }
    }

    private void bTW() {
        if (this.ibA) {
            this.hYR.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.ibA = false;
            if (bTY()) {
                this.ibD.onDetach();
            }
        }
    }

    private void bTX() {
        if (this.ibB && this.hCn) {
            bTV();
        } else {
            bTW();
        }
    }

    public String toString() {
        return f.ao(this).ag("controllerAttached", this.ibA).ag("holderAttached", this.ibB).ag("drawableVisible", this.hCn).n("events", this.hYR.toString()).toString();
    }

    private boolean bTY() {
        return this.ibD != null && this.ibD.getHierarchy() == this.ibC;
    }
}
