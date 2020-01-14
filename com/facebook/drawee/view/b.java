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
    private DH lNq;
    private boolean lNo = false;
    private boolean lNp = false;
    private boolean mIsVisible = true;
    private com.facebook.drawee.d.a lNr = null;
    private final DraweeEventTracker lKj = DraweeEventTracker.dkF();

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
        this.lKj.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lNp = true;
        dlY();
    }

    public void onDetach() {
        this.lKj.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lNp = false;
        dlY();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dlZ()) {
            return this.lNr.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vg(boolean z) {
        if (this.mIsVisible != z) {
            this.lKj.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            dlY();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void dlp() {
        if (!this.lNo) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lNr)), toString());
            this.lNp = true;
            this.mIsVisible = true;
            dlY();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lNo;
        if (z) {
            dlX();
        }
        if (dlZ()) {
            this.lKj.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lNr.setHierarchy(null);
        }
        this.lNr = aVar;
        if (this.lNr != null) {
            this.lKj.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lNr.setHierarchy(this.lNq);
        } else {
            this.lKj.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dlW();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lNr;
    }

    public void setHierarchy(DH dh) {
        this.lKj.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dlZ = dlZ();
        a(null);
        this.lNq = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lNq.getTopLevelDrawable();
        vg(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dlZ) {
            this.lNr.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lNq);
    }

    public boolean hasHierarchy() {
        return this.lNq != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.lNq == null) {
            return null;
        }
        return this.lNq.getTopLevelDrawable();
    }

    private void dlW() {
        if (!this.lNo) {
            this.lKj.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lNo = true;
            if (this.lNr != null && this.lNr.getHierarchy() != null) {
                this.lNr.onAttach();
            }
        }
    }

    private void dlX() {
        if (this.lNo) {
            this.lKj.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lNo = false;
            if (dlZ()) {
                this.lNr.onDetach();
            }
        }
    }

    private void dlY() {
        if (this.lNp && this.mIsVisible) {
            dlW();
        } else {
            dlX();
        }
    }

    public String toString() {
        return f.aQ(this).aK("controllerAttached", this.lNo).aK("holderAttached", this.lNp).aK("drawableVisible", this.mIsVisible).x("events", this.lKj.toString()).toString();
    }

    private boolean dlZ() {
        return this.lNr != null && this.lNr.getHierarchy() == this.lNq;
    }
}
