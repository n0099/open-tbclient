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
    private DH ioT;
    private boolean ioR = false;
    private boolean ioS = false;
    private boolean hPC = true;
    private com.facebook.drawee.d.a ioU = null;
    private final DraweeEventTracker imh = DraweeEventTracker.bVH();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.dr(context);
        return bVar;
    }

    public void dr(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.imh.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.ioS = true;
        bWW();
    }

    public void onDetach() {
        this.imh.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.ioS = false;
        bWW();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (bWX()) {
            return this.ioU.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void oZ(boolean z) {
        if (this.hPC != z) {
            this.imh.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.hPC = z;
            bWW();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.ioR) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ioU)), toString());
            this.ioS = true;
            this.hPC = true;
            bWW();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.ioR;
        if (z) {
            bWV();
        }
        if (bWX()) {
            this.imh.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.ioU.setHierarchy(null);
        }
        this.ioU = aVar;
        if (this.ioU != null) {
            this.imh.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.ioU.setHierarchy(this.ioT);
        } else {
            this.imh.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            bWU();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.ioU;
    }

    public void setHierarchy(DH dh) {
        this.imh.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean bWX = bWX();
        a(null);
        this.ioT = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.ioT.getTopLevelDrawable();
        oZ(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (bWX) {
            this.ioU.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.ioT);
    }

    public boolean hasHierarchy() {
        return this.ioT != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.ioT == null) {
            return null;
        }
        return this.ioT.getTopLevelDrawable();
    }

    private void bWU() {
        if (!this.ioR) {
            this.imh.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.ioR = true;
            if (this.ioU != null && this.ioU.getHierarchy() != null) {
                this.ioU.onAttach();
            }
        }
    }

    private void bWV() {
        if (this.ioR) {
            this.imh.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.ioR = false;
            if (bWX()) {
                this.ioU.onDetach();
            }
        }
    }

    private void bWW() {
        if (this.ioS && this.hPC) {
            bWU();
        } else {
            bWV();
        }
    }

    public String toString() {
        return f.ao(this).ah("controllerAttached", this.ioR).ah("holderAttached", this.ioS).ah("drawableVisible", this.hPC).n("events", this.imh.toString()).toString();
    }

    private boolean bWX() {
        return this.ioU != null && this.ioU.getHierarchy() == this.ioT;
    }
}
