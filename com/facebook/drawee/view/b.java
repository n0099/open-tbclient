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
    private DH pyG;
    private boolean pyE = false;
    private boolean pyF = false;
    private boolean evx = true;
    private com.facebook.drawee.d.a pyH = null;
    private final DraweeEventTracker pvH = DraweeEventTracker.evl();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.ii(context);
        return bVar;
    }

    public void ii(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.pvH.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.pyF = true;
        ewA();
    }

    public void onDetach() {
        this.pvH.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.pyF = false;
        ewA();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (ewB()) {
            return this.pyH.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void Ba(boolean z) {
        if (this.evx != z) {
            this.pvH.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.evx = z;
            ewA();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.pyE) {
            com.facebook.common.c.a.c((Class<?>) DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.pyH)), toString());
            this.pyF = true;
            this.evx = true;
            ewA();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.pyE;
        if (z) {
            ewz();
        }
        if (ewB()) {
            this.pvH.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.pyH.setHierarchy(null);
        }
        this.pyH = aVar;
        if (this.pyH != null) {
            this.pvH.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.pyH.setHierarchy(this.pyG);
        } else {
            this.pvH.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            ewy();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pyH;
    }

    public void setHierarchy(DH dh) {
        this.pvH.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean ewB = ewB();
        a(null);
        this.pyG = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.pyG.getTopLevelDrawable();
        Ba(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (ewB) {
            this.pyH.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.pyG);
    }

    public Drawable getTopLevelDrawable() {
        if (this.pyG == null) {
            return null;
        }
        return this.pyG.getTopLevelDrawable();
    }

    private void ewy() {
        if (!this.pyE) {
            this.pvH.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.pyE = true;
            if (this.pyH != null && this.pyH.getHierarchy() != null) {
                this.pyH.onAttach();
            }
        }
    }

    private void ewz() {
        if (this.pyE) {
            this.pvH.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.pyE = false;
            if (ewB()) {
                this.pyH.onDetach();
            }
        }
    }

    private void ewA() {
        if (this.pyF && this.evx) {
            ewy();
        } else {
            ewz();
        }
    }

    public String toString() {
        return f.bb(this).bo("controllerAttached", this.pyE).bo("holderAttached", this.pyF).bo("drawableVisible", this.evx).I("events", this.pvH.toString()).toString();
    }

    private boolean ewB() {
        return this.pyH != null && this.pyH.getHierarchy() == this.pyG;
    }
}
