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
    private DH mrl;
    private boolean mrj = false;
    private boolean mrk = false;
    private boolean djy = true;
    private com.facebook.drawee.d.a mrm = null;
    private final DraweeEventTracker mnY = DraweeEventTracker.dvB();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.fU(context);
        return bVar;
    }

    public void fU(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.mnY.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mrk = true;
        dwV();
    }

    public void onDetach() {
        this.mnY.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mrk = false;
        dwV();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dwW()) {
            return this.mrm.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void wd(boolean z) {
        if (this.djy != z) {
            this.mnY.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.djy = z;
            dwV();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.mrj) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mrm)), toString());
            this.mrk = true;
            this.djy = true;
            dwV();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.mrj;
        if (z) {
            dwU();
        }
        if (dwW()) {
            this.mnY.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mrm.setHierarchy(null);
        }
        this.mrm = aVar;
        if (this.mrm != null) {
            this.mnY.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mrm.setHierarchy(this.mrl);
        } else {
            this.mnY.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dwT();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mrm;
    }

    public void setHierarchy(DH dh) {
        this.mnY.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dwW = dwW();
        a(null);
        this.mrl = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.mrl.getTopLevelDrawable();
        wd(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dwW) {
            this.mrm.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.mrl);
    }

    public Drawable getTopLevelDrawable() {
        if (this.mrl == null) {
            return null;
        }
        return this.mrl.getTopLevelDrawable();
    }

    private void dwT() {
        if (!this.mrj) {
            this.mnY.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.mrj = true;
            if (this.mrm != null && this.mrm.getHierarchy() != null) {
                this.mrm.onAttach();
            }
        }
    }

    private void dwU() {
        if (this.mrj) {
            this.mnY.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mrj = false;
            if (dwW()) {
                this.mrm.onDetach();
            }
        }
    }

    private void dwV() {
        if (this.mrk && this.djy) {
            dwT();
        } else {
            dwU();
        }
    }

    public String toString() {
        return f.aN(this).aX("controllerAttached", this.mrj).aX("holderAttached", this.mrk).aX("drawableVisible", this.djy).F("events", this.mnY.toString()).toString();
    }

    private boolean dwW() {
        return this.mrm != null && this.mrm.getHierarchy() == this.mrl;
    }
}
