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
    private DH ioS;
    private boolean ioQ = false;
    private boolean ioR = false;
    private boolean hPB = true;
    private com.facebook.drawee.d.a ioT = null;
    private final DraweeEventTracker imf = DraweeEventTracker.bVH();

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
        this.imf.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.ioR = true;
        bWW();
    }

    public void onDetach() {
        this.imf.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.ioR = false;
        bWW();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (bWX()) {
            return this.ioT.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void oZ(boolean z) {
        if (this.hPB != z) {
            this.imf.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.hPB = z;
            bWW();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.ioQ) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ioT)), toString());
            this.ioR = true;
            this.hPB = true;
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
        boolean z = this.ioQ;
        if (z) {
            bWV();
        }
        if (bWX()) {
            this.imf.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.ioT.setHierarchy(null);
        }
        this.ioT = aVar;
        if (this.ioT != null) {
            this.imf.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.ioT.setHierarchy(this.ioS);
        } else {
            this.imf.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            bWU();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.ioT;
    }

    public void setHierarchy(DH dh) {
        this.imf.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean bWX = bWX();
        a(null);
        this.ioS = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.ioS.getTopLevelDrawable();
        oZ(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (bWX) {
            this.ioT.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.ioS);
    }

    public boolean hasHierarchy() {
        return this.ioS != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.ioS == null) {
            return null;
        }
        return this.ioS.getTopLevelDrawable();
    }

    private void bWU() {
        if (!this.ioQ) {
            this.imf.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.ioQ = true;
            if (this.ioT != null && this.ioT.getHierarchy() != null) {
                this.ioT.onAttach();
            }
        }
    }

    private void bWV() {
        if (this.ioQ) {
            this.imf.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.ioQ = false;
            if (bWX()) {
                this.ioT.onDetach();
            }
        }
    }

    private void bWW() {
        if (this.ioR && this.hPB) {
            bWU();
        } else {
            bWV();
        }
    }

    public String toString() {
        return f.ao(this).ah("controllerAttached", this.ioQ).ah("holderAttached", this.ioR).ah("drawableVisible", this.hPB).n("events", this.imf.toString()).toString();
    }

    private boolean bWX() {
        return this.ioT != null && this.ioT.getHierarchy() == this.ioS;
    }
}
