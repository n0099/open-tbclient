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
    private DH lNX;
    private boolean lNV = false;
    private boolean lNW = false;
    private boolean mIsVisible = true;
    private com.facebook.drawee.d.a lNY = null;
    private final DraweeEventTracker lKQ = DraweeEventTracker.dlS();

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
        this.lKQ.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lNW = true;
        dnk();
    }

    public void onDetach() {
        this.lKQ.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lNW = false;
        dnk();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dnl()) {
            return this.lNY.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vk(boolean z) {
        if (this.mIsVisible != z) {
            this.lKQ.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            dnk();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.lNV) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lNY)), toString());
            this.lNW = true;
            this.mIsVisible = true;
            dnk();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lNV;
        if (z) {
            dnj();
        }
        if (dnl()) {
            this.lKQ.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lNY.setHierarchy(null);
        }
        this.lNY = aVar;
        if (this.lNY != null) {
            this.lKQ.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lNY.setHierarchy(this.lNX);
        } else {
            this.lKQ.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dni();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lNY;
    }

    public void setHierarchy(DH dh) {
        this.lKQ.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dnl = dnl();
        a(null);
        this.lNX = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lNX.getTopLevelDrawable();
        vk(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dnl) {
            this.lNY.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lNX);
    }

    public boolean hasHierarchy() {
        return this.lNX != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.lNX == null) {
            return null;
        }
        return this.lNX.getTopLevelDrawable();
    }

    private void dni() {
        if (!this.lNV) {
            this.lKQ.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lNV = true;
            if (this.lNY != null && this.lNY.getHierarchy() != null) {
                this.lNY.onAttach();
            }
        }
    }

    private void dnj() {
        if (this.lNV) {
            this.lKQ.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lNV = false;
            if (dnl()) {
                this.lNY.onDetach();
            }
        }
    }

    private void dnk() {
        if (this.lNW && this.mIsVisible) {
            dni();
        } else {
            dnj();
        }
    }

    public String toString() {
        return f.aS(this).aK("controllerAttached", this.lNV).aK("holderAttached", this.lNW).aK("drawableVisible", this.mIsVisible).x("events", this.lKQ.toString()).toString();
    }

    private boolean dnl() {
        return this.lNY != null && this.lNY.getHierarchy() == this.lNX;
    }
}
