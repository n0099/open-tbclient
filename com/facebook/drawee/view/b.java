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
/* loaded from: classes4.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH nqx;
    private boolean nqv = false;
    private boolean nqw = false;
    private boolean dEd = true;
    private com.facebook.drawee.d.a nqy = null;
    private final DraweeEventTracker nnk = DraweeEventTracker.dPJ();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gr(context);
        return bVar;
    }

    public void gr(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.nnk.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.nqw = true;
        dRb();
    }

    public void onDetach() {
        this.nnk.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.nqw = false;
        dRb();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dRc()) {
            return this.nqy.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void xX(boolean z) {
        if (this.dEd != z) {
            this.nnk.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.dEd = z;
            dRb();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.nqv) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.nqy)), toString());
            this.nqw = true;
            this.dEd = true;
            dRb();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.nqv;
        if (z) {
            dRa();
        }
        if (dRc()) {
            this.nnk.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.nqy.setHierarchy(null);
        }
        this.nqy = aVar;
        if (this.nqy != null) {
            this.nnk.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.nqy.setHierarchy(this.nqx);
        } else {
            this.nnk.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dQZ();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nqy;
    }

    public void setHierarchy(DH dh) {
        this.nnk.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dRc = dRc();
        a(null);
        this.nqx = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.nqx.getTopLevelDrawable();
        xX(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dRc) {
            this.nqy.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.nqx);
    }

    public Drawable getTopLevelDrawable() {
        if (this.nqx == null) {
            return null;
        }
        return this.nqx.getTopLevelDrawable();
    }

    private void dQZ() {
        if (!this.nqv) {
            this.nnk.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.nqv = true;
            if (this.nqy != null && this.nqy.getHierarchy() != null) {
                this.nqy.onAttach();
            }
        }
    }

    private void dRa() {
        if (this.nqv) {
            this.nnk.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.nqv = false;
            if (dRc()) {
                this.nqy.onDetach();
            }
        }
    }

    private void dRb() {
        if (this.nqw && this.dEd) {
            dQZ();
        } else {
            dRa();
        }
    }

    public String toString() {
        return f.aQ(this).ba("controllerAttached", this.nqv).ba("holderAttached", this.nqw).ba("drawableVisible", this.dEd).E("events", this.nnk.toString()).toString();
    }

    private boolean dRc() {
        return this.nqy != null && this.nqy.getHierarchy() == this.nqx;
    }
}
