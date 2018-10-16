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
    private DH ibB;
    private boolean ibz = false;
    private boolean ibA = false;
    private boolean hCm = true;
    private com.facebook.drawee.d.a ibC = null;
    private final DraweeEventTracker hYQ = DraweeEventTracker.bSI();

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
        this.hYQ.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.ibA = true;
        bTX();
    }

    public void onDetach() {
        this.hYQ.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.ibA = false;
        bTX();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (bTY()) {
            return this.ibC.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void oF(boolean z) {
        if (this.hCm != z) {
            this.hYQ.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.hCm = z;
            bTX();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.ibz) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ibC)), toString());
            this.ibA = true;
            this.hCm = true;
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
        boolean z = this.ibz;
        if (z) {
            bTW();
        }
        if (bTY()) {
            this.hYQ.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.ibC.setHierarchy(null);
        }
        this.ibC = aVar;
        if (this.ibC != null) {
            this.hYQ.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.ibC.setHierarchy(this.ibB);
        } else {
            this.hYQ.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            bTV();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.ibC;
    }

    public void setHierarchy(DH dh) {
        this.hYQ.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean bTY = bTY();
        a(null);
        this.ibB = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.ibB.getTopLevelDrawable();
        oF(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (bTY) {
            this.ibC.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.ibB);
    }

    public boolean hasHierarchy() {
        return this.ibB != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.ibB == null) {
            return null;
        }
        return this.ibB.getTopLevelDrawable();
    }

    private void bTV() {
        if (!this.ibz) {
            this.hYQ.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.ibz = true;
            if (this.ibC != null && this.ibC.getHierarchy() != null) {
                this.ibC.onAttach();
            }
        }
    }

    private void bTW() {
        if (this.ibz) {
            this.hYQ.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.ibz = false;
            if (bTY()) {
                this.ibC.onDetach();
            }
        }
    }

    private void bTX() {
        if (this.ibA && this.hCm) {
            bTV();
        } else {
            bTW();
        }
    }

    public String toString() {
        return f.ao(this).ag("controllerAttached", this.ibz).ag("holderAttached", this.ibA).ag("drawableVisible", this.hCm).n("events", this.hYQ.toString()).toString();
    }

    private boolean bTY() {
        return this.ibC != null && this.ibC.getHierarchy() == this.ibB;
    }
}
