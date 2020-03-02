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
    private DH lNZ;
    private boolean lNX = false;
    private boolean lNY = false;
    private boolean mIsVisible = true;
    private com.facebook.drawee.d.a lOa = null;
    private final DraweeEventTracker lKS = DraweeEventTracker.dlU();

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
        this.lKS.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lNY = true;
        dnm();
    }

    public void onDetach() {
        this.lKS.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lNY = false;
        dnm();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dnn()) {
            return this.lOa.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vk(boolean z) {
        if (this.mIsVisible != z) {
            this.lKS.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            dnm();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.lNX) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lOa)), toString());
            this.lNY = true;
            this.mIsVisible = true;
            dnm();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lNX;
        if (z) {
            dnl();
        }
        if (dnn()) {
            this.lKS.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lOa.setHierarchy(null);
        }
        this.lOa = aVar;
        if (this.lOa != null) {
            this.lKS.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lOa.setHierarchy(this.lNZ);
        } else {
            this.lKS.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dnk();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lOa;
    }

    public void setHierarchy(DH dh) {
        this.lKS.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dnn = dnn();
        a(null);
        this.lNZ = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lNZ.getTopLevelDrawable();
        vk(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dnn) {
            this.lOa.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lNZ);
    }

    public boolean hasHierarchy() {
        return this.lNZ != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.lNZ == null) {
            return null;
        }
        return this.lNZ.getTopLevelDrawable();
    }

    private void dnk() {
        if (!this.lNX) {
            this.lKS.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lNX = true;
            if (this.lOa != null && this.lOa.getHierarchy() != null) {
                this.lOa.onAttach();
            }
        }
    }

    private void dnl() {
        if (this.lNX) {
            this.lKS.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lNX = false;
            if (dnn()) {
                this.lOa.onDetach();
            }
        }
    }

    private void dnm() {
        if (this.lNY && this.mIsVisible) {
            dnk();
        } else {
            dnl();
        }
    }

    public String toString() {
        return f.aS(this).aK("controllerAttached", this.lNX).aK("holderAttached", this.lNY).aK("drawableVisible", this.mIsVisible).x("events", this.lKS.toString()).toString();
    }

    private boolean dnn() {
        return this.lOa != null && this.lOa.getHierarchy() == this.lNZ;
    }
}
