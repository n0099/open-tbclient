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
/* loaded from: classes11.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH lJA;
    private boolean lJy = false;
    private boolean lJz = false;
    private boolean mIsVisible = true;
    private com.facebook.drawee.d.a lJB = null;
    private final DraweeEventTracker lGG = DraweeEventTracker.djC();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gl(context);
        return bVar;
    }

    public void gl(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.lGG.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lJz = true;
        dkR();
    }

    public void onDetach() {
        this.lGG.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lJz = false;
        dkR();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dkS()) {
            return this.lJB.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void uU(boolean z) {
        if (this.mIsVisible != z) {
            this.lGG.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            dkR();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void dkm() {
        if (!this.lJy) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lJB)), toString());
            this.lJz = true;
            this.mIsVisible = true;
            dkR();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lJy;
        if (z) {
            dkQ();
        }
        if (dkS()) {
            this.lGG.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lJB.setHierarchy(null);
        }
        this.lJB = aVar;
        if (this.lJB != null) {
            this.lGG.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lJB.setHierarchy(this.lJA);
        } else {
            this.lGG.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dkP();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lJB;
    }

    public void setHierarchy(DH dh) {
        this.lGG.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dkS = dkS();
        a(null);
        this.lJA = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lJA.getTopLevelDrawable();
        uU(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dkS) {
            this.lJB.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lJA);
    }

    public boolean hasHierarchy() {
        return this.lJA != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.lJA == null) {
            return null;
        }
        return this.lJA.getTopLevelDrawable();
    }

    private void dkP() {
        if (!this.lJy) {
            this.lGG.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lJy = true;
            if (this.lJB != null && this.lJB.getHierarchy() != null) {
                this.lJB.onAttach();
            }
        }
    }

    private void dkQ() {
        if (this.lJy) {
            this.lGG.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lJy = false;
            if (dkS()) {
                this.lJB.onDetach();
            }
        }
    }

    private void dkR() {
        if (this.lJz && this.mIsVisible) {
            dkP();
        } else {
            dkQ();
        }
    }

    public String toString() {
        return f.aQ(this).aK("controllerAttached", this.lJy).aK("holderAttached", this.lJz).aK("drawableVisible", this.mIsVisible).x("events", this.lGG.toString()).toString();
    }

    private boolean dkS() {
        return this.lJB != null && this.lJB.getHierarchy() == this.lJA;
    }
}
