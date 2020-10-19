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
/* loaded from: classes15.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH nQg;
    private boolean nQe = false;
    private boolean nQf = false;
    private boolean dSj = true;
    private com.facebook.drawee.d.a nQh = null;
    private final DraweeEventTracker nMV = DraweeEventTracker.dXB();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gF(context);
        return bVar;
    }

    public void gF(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.nMV.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.nQf = true;
        dYT();
    }

    public void onDetach() {
        this.nMV.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.nQf = false;
        dYT();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dYU()) {
            return this.nQh.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void yP(boolean z) {
        if (this.dSj != z) {
            this.nMV.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.dSj = z;
            dYT();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.nQe) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.nQh)), toString());
            this.nQf = true;
            this.dSj = true;
            dYT();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.nQe;
        if (z) {
            dYS();
        }
        if (dYU()) {
            this.nMV.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.nQh.setHierarchy(null);
        }
        this.nQh = aVar;
        if (this.nQh != null) {
            this.nMV.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.nQh.setHierarchy(this.nQg);
        } else {
            this.nMV.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dYR();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nQh;
    }

    public void setHierarchy(DH dh) {
        this.nMV.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dYU = dYU();
        a(null);
        this.nQg = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.nQg.getTopLevelDrawable();
        yP(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dYU) {
            this.nQh.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.nQg);
    }

    public Drawable getTopLevelDrawable() {
        if (this.nQg == null) {
            return null;
        }
        return this.nQg.getTopLevelDrawable();
    }

    private void dYR() {
        if (!this.nQe) {
            this.nMV.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.nQe = true;
            if (this.nQh != null && this.nQh.getHierarchy() != null) {
                this.nQh.onAttach();
            }
        }
    }

    private void dYS() {
        if (this.nQe) {
            this.nMV.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.nQe = false;
            if (dYU()) {
                this.nQh.onDetach();
            }
        }
    }

    private void dYT() {
        if (this.nQf && this.dSj) {
            dYR();
        } else {
            dYS();
        }
    }

    public String toString() {
        return f.aV(this).bf("controllerAttached", this.nQe).bf("holderAttached", this.nQf).bf("drawableVisible", this.dSj).F("events", this.nMV.toString()).toString();
    }

    private boolean dYU() {
        return this.nQh != null && this.nQh.getHierarchy() == this.nQg;
    }
}
