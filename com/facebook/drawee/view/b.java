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
    private DH lXr;
    private boolean lXp = false;
    private boolean lXq = false;
    private boolean cYu = true;
    private com.facebook.drawee.d.a lXs = null;
    private final DraweeEventTracker lUg = DraweeEventTracker.doj();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.fC(context);
        return bVar;
    }

    public void fC(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.lUg.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lXq = true;
        dpD();
    }

    public void onDetach() {
        this.lUg.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lXq = false;
        dpD();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dpE()) {
            return this.lXs.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vF(boolean z) {
        if (this.cYu != z) {
            this.lUg.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.cYu = z;
            dpD();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.lXp) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lXs)), toString());
            this.lXq = true;
            this.cYu = true;
            dpD();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lXp;
        if (z) {
            dpC();
        }
        if (dpE()) {
            this.lUg.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lXs.setHierarchy(null);
        }
        this.lXs = aVar;
        if (this.lXs != null) {
            this.lUg.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lXs.setHierarchy(this.lXr);
        } else {
            this.lUg.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dpB();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lXs;
    }

    public void setHierarchy(DH dh) {
        this.lUg.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dpE = dpE();
        a(null);
        this.lXr = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lXr.getTopLevelDrawable();
        vF(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dpE) {
            this.lXs.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lXr);
    }

    public Drawable getTopLevelDrawable() {
        if (this.lXr == null) {
            return null;
        }
        return this.lXr.getTopLevelDrawable();
    }

    private void dpB() {
        if (!this.lXp) {
            this.lUg.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lXp = true;
            if (this.lXs != null && this.lXs.getHierarchy() != null) {
                this.lXs.onAttach();
            }
        }
    }

    private void dpC() {
        if (this.lXp) {
            this.lUg.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lXp = false;
            if (dpE()) {
                this.lXs.onDetach();
            }
        }
    }

    private void dpD() {
        if (this.lXq && this.cYu) {
            dpB();
        } else {
            dpC();
        }
    }

    public String toString() {
        return f.aJ(this).aK("controllerAttached", this.lXp).aK("holderAttached", this.lXq).aK("drawableVisible", this.cYu).C("events", this.lUg.toString()).toString();
    }

    private boolean dpE() {
        return this.lXs != null && this.lXs.getHierarchy() == this.lXr;
    }
}
