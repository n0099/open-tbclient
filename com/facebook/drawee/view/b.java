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
/* loaded from: classes12.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH lNl;
    private boolean lNj = false;
    private boolean lNk = false;
    private boolean mIsVisible = true;
    private com.facebook.drawee.d.a lNm = null;
    private final DraweeEventTracker lKe = DraweeEventTracker.dkD();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gm(context);
        return bVar;
    }

    public void gm(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.lKe.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lNk = true;
        dlW();
    }

    public void onDetach() {
        this.lKe.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lNk = false;
        dlW();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dlX()) {
            return this.lNm.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vg(boolean z) {
        if (this.mIsVisible != z) {
            this.lKe.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            dlW();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void dln() {
        if (!this.lNj) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lNm)), toString());
            this.lNk = true;
            this.mIsVisible = true;
            dlW();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lNj;
        if (z) {
            dlV();
        }
        if (dlX()) {
            this.lKe.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lNm.setHierarchy(null);
        }
        this.lNm = aVar;
        if (this.lNm != null) {
            this.lKe.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lNm.setHierarchy(this.lNl);
        } else {
            this.lKe.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dlU();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lNm;
    }

    public void setHierarchy(DH dh) {
        this.lKe.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dlX = dlX();
        a(null);
        this.lNl = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lNl.getTopLevelDrawable();
        vg(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dlX) {
            this.lNm.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lNl);
    }

    public boolean hasHierarchy() {
        return this.lNl != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.lNl == null) {
            return null;
        }
        return this.lNl.getTopLevelDrawable();
    }

    private void dlU() {
        if (!this.lNj) {
            this.lKe.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lNj = true;
            if (this.lNm != null && this.lNm.getHierarchy() != null) {
                this.lNm.onAttach();
            }
        }
    }

    private void dlV() {
        if (this.lNj) {
            this.lKe.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lNj = false;
            if (dlX()) {
                this.lNm.onDetach();
            }
        }
    }

    private void dlW() {
        if (this.lNk && this.mIsVisible) {
            dlU();
        } else {
            dlV();
        }
    }

    public String toString() {
        return f.aQ(this).aK("controllerAttached", this.lNj).aK("holderAttached", this.lNk).aK("drawableVisible", this.mIsVisible).x("events", this.lKe.toString()).toString();
    }

    private boolean dlX() {
        return this.lNm != null && this.lNm.getHierarchy() == this.lNl;
    }
}
