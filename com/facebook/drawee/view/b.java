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
    private DH pyz;
    private boolean pyx = false;
    private boolean pyy = false;
    private boolean evx = true;
    private com.facebook.drawee.d.a pyA = null;
    private final DraweeEventTracker pvA = DraweeEventTracker.eve();

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
        this.pvA.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.pyy = true;
        ewt();
    }

    public void onDetach() {
        this.pvA.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.pyy = false;
        ewt();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (ewu()) {
            return this.pyA.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void Ba(boolean z) {
        if (this.evx != z) {
            this.pvA.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.evx = z;
            ewt();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.pyx) {
            com.facebook.common.c.a.c((Class<?>) DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.pyA)), toString());
            this.pyy = true;
            this.evx = true;
            ewt();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.pyx;
        if (z) {
            ews();
        }
        if (ewu()) {
            this.pvA.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.pyA.setHierarchy(null);
        }
        this.pyA = aVar;
        if (this.pyA != null) {
            this.pvA.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.pyA.setHierarchy(this.pyz);
        } else {
            this.pvA.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            ewr();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pyA;
    }

    public void setHierarchy(DH dh) {
        this.pvA.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean ewu = ewu();
        a(null);
        this.pyz = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.pyz.getTopLevelDrawable();
        Ba(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (ewu) {
            this.pyA.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.pyz);
    }

    public Drawable getTopLevelDrawable() {
        if (this.pyz == null) {
            return null;
        }
        return this.pyz.getTopLevelDrawable();
    }

    private void ewr() {
        if (!this.pyx) {
            this.pvA.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.pyx = true;
            if (this.pyA != null && this.pyA.getHierarchy() != null) {
                this.pyA.onAttach();
            }
        }
    }

    private void ews() {
        if (this.pyx) {
            this.pvA.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.pyx = false;
            if (ewu()) {
                this.pyA.onDetach();
            }
        }
    }

    private void ewt() {
        if (this.pyy && this.evx) {
            ewr();
        } else {
            ews();
        }
    }

    public String toString() {
        return f.bb(this).bo("controllerAttached", this.pyx).bo("holderAttached", this.pyy).bo("drawableVisible", this.evx).I("events", this.pvA.toString()).toString();
    }

    private boolean ewu() {
        return this.pyA != null && this.pyA.getHierarchy() == this.pyz;
    }
}
