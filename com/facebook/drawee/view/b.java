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
    private DH lXn;
    private boolean lXl = false;
    private boolean lXm = false;
    private boolean cYp = true;
    private com.facebook.drawee.d.a lXo = null;
    private final DraweeEventTracker lUc = DraweeEventTracker.dol();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.fO(context);
        return bVar;
    }

    public void fO(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.lUc.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lXm = true;
        dpF();
    }

    public void onDetach() {
        this.lUc.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lXm = false;
        dpF();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dpG()) {
            return this.lXo.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vF(boolean z) {
        if (this.cYp != z) {
            this.lUc.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.cYp = z;
            dpF();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.lXl) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lXo)), toString());
            this.lXm = true;
            this.cYp = true;
            dpF();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lXl;
        if (z) {
            dpE();
        }
        if (dpG()) {
            this.lUc.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lXo.setHierarchy(null);
        }
        this.lXo = aVar;
        if (this.lXo != null) {
            this.lUc.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lXo.setHierarchy(this.lXn);
        } else {
            this.lUc.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dpD();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lXo;
    }

    public void setHierarchy(DH dh) {
        this.lUc.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dpG = dpG();
        a(null);
        this.lXn = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lXn.getTopLevelDrawable();
        vF(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dpG) {
            this.lXo.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lXn);
    }

    public Drawable getTopLevelDrawable() {
        if (this.lXn == null) {
            return null;
        }
        return this.lXn.getTopLevelDrawable();
    }

    private void dpD() {
        if (!this.lXl) {
            this.lUc.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lXl = true;
            if (this.lXo != null && this.lXo.getHierarchy() != null) {
                this.lXo.onAttach();
            }
        }
    }

    private void dpE() {
        if (this.lXl) {
            this.lUc.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lXl = false;
            if (dpG()) {
                this.lXo.onDetach();
            }
        }
    }

    private void dpF() {
        if (this.lXm && this.cYp) {
            dpD();
        } else {
            dpE();
        }
    }

    public String toString() {
        return f.aI(this).aK("controllerAttached", this.lXl).aK("holderAttached", this.lXm).aK("drawableVisible", this.cYp).C("events", this.lUc.toString()).toString();
    }

    private boolean dpG() {
        return this.lXo != null && this.lXo.getHierarchy() == this.lXn;
    }
}
