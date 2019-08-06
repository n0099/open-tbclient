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
    private DH kfb;
    private boolean keZ = false;
    private boolean kfa = false;
    private boolean jGd = true;
    private com.facebook.drawee.d.a kfc = null;
    private final DraweeEventTracker kcq = DraweeEventTracker.cGd();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eC(context);
        return bVar;
    }

    public void eC(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cGl() {
        this.kcq.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.kfa = true;
        cHw();
    }

    public void onDetach() {
        this.kcq.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.kfa = false;
        cHw();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cHx()) {
            return this.kfc.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void sz(boolean z) {
        if (this.jGd != z) {
            this.kcq.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jGd = z;
            cHw();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void cGQ() {
        if (!this.keZ) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kfc)), toString());
            this.kfa = true;
            this.jGd = true;
            cHw();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.keZ;
        if (z) {
            cHv();
        }
        if (cHx()) {
            this.kcq.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.kfc.setHierarchy(null);
        }
        this.kfc = aVar;
        if (this.kfc != null) {
            this.kcq.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.kfc.setHierarchy(this.kfb);
        } else {
            this.kcq.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cHu();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.kfc;
    }

    public void setHierarchy(DH dh) {
        this.kcq.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cHx = cHx();
        a(null);
        this.kfb = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.kfb.getTopLevelDrawable();
        sz(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cHx) {
            this.kfc.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.kfb);
    }

    public Drawable getTopLevelDrawable() {
        if (this.kfb == null) {
            return null;
        }
        return this.kfb.getTopLevelDrawable();
    }

    private void cHu() {
        if (!this.keZ) {
            this.kcq.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.keZ = true;
            if (this.kfc != null && this.kfc.getHierarchy() != null) {
                this.kfc.cGl();
            }
        }
    }

    private void cHv() {
        if (this.keZ) {
            this.kcq.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.keZ = false;
            if (cHx()) {
                this.kfc.onDetach();
            }
        }
    }

    private void cHw() {
        if (this.kfa && this.jGd) {
            cHu();
        } else {
            cHv();
        }
    }

    public String toString() {
        return f.aC(this).aE("controllerAttached", this.keZ).aE("holderAttached", this.kfa).aE("drawableVisible", this.jGd).t("events", this.kcq.toString()).toString();
    }

    private boolean cHx() {
        return this.kfc != null && this.kfc.getHierarchy() == this.kfb;
    }
}
