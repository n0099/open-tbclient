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
    private DH msw;
    private boolean msu = false;
    private boolean msv = false;
    private boolean djy = true;
    private com.facebook.drawee.d.a msx = null;
    private final DraweeEventTracker mpj = DraweeEventTracker.dvP();

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
        this.mpj.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.msv = true;
        dxj();
    }

    public void onDetach() {
        this.mpj.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.msv = false;
        dxj();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dxk()) {
            return this.msx.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void wf(boolean z) {
        if (this.djy != z) {
            this.mpj.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.djy = z;
            dxj();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.msu) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.msx)), toString());
            this.msv = true;
            this.djy = true;
            dxj();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.msu;
        if (z) {
            dxi();
        }
        if (dxk()) {
            this.mpj.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.msx.setHierarchy(null);
        }
        this.msx = aVar;
        if (this.msx != null) {
            this.mpj.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.msx.setHierarchy(this.msw);
        } else {
            this.mpj.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dxh();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.msx;
    }

    public void setHierarchy(DH dh) {
        this.mpj.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dxk = dxk();
        a(null);
        this.msw = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.msw.getTopLevelDrawable();
        wf(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dxk) {
            this.msx.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.msw);
    }

    public Drawable getTopLevelDrawable() {
        if (this.msw == null) {
            return null;
        }
        return this.msw.getTopLevelDrawable();
    }

    private void dxh() {
        if (!this.msu) {
            this.mpj.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.msu = true;
            if (this.msx != null && this.msx.getHierarchy() != null) {
                this.msx.onAttach();
            }
        }
    }

    private void dxi() {
        if (this.msu) {
            this.mpj.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.msu = false;
            if (dxk()) {
                this.msx.onDetach();
            }
        }
    }

    private void dxj() {
        if (this.msv && this.djy) {
            dxh();
        } else {
            dxi();
        }
    }

    public String toString() {
        return f.aN(this).aX("controllerAttached", this.msu).aX("holderAttached", this.msv).aX("drawableVisible", this.djy).F("events", this.mpj.toString()).toString();
    }

    private boolean dxk() {
        return this.msx != null && this.msx.getHierarchy() == this.msw;
    }
}
