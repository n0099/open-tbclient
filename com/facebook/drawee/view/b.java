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
    private DH inL;
    private boolean inJ = false;
    private boolean inK = false;
    private boolean hOu = true;
    private com.facebook.drawee.d.a inM = null;
    private final DraweeEventTracker ikY = DraweeEventTracker.bUZ();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.dr(context);
        return bVar;
    }

    public void dr(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.ikY.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.inK = true;
        bWo();
    }

    public void onDetach() {
        this.ikY.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.inK = false;
        bWo();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (bWp()) {
            return this.inM.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void oY(boolean z) {
        if (this.hOu != z) {
            this.ikY.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.hOu = z;
            bWo();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.inJ) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.inM)), toString());
            this.inK = true;
            this.hOu = true;
            bWo();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.inJ;
        if (z) {
            bWn();
        }
        if (bWp()) {
            this.ikY.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.inM.setHierarchy(null);
        }
        this.inM = aVar;
        if (this.inM != null) {
            this.ikY.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.inM.setHierarchy(this.inL);
        } else {
            this.ikY.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            bWm();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.inM;
    }

    public void setHierarchy(DH dh) {
        this.ikY.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean bWp = bWp();
        a(null);
        this.inL = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.inL.getTopLevelDrawable();
        oY(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (bWp) {
            this.inM.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.inL);
    }

    public boolean hasHierarchy() {
        return this.inL != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.inL == null) {
            return null;
        }
        return this.inL.getTopLevelDrawable();
    }

    private void bWm() {
        if (!this.inJ) {
            this.ikY.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.inJ = true;
            if (this.inM != null && this.inM.getHierarchy() != null) {
                this.inM.onAttach();
            }
        }
    }

    private void bWn() {
        if (this.inJ) {
            this.ikY.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.inJ = false;
            if (bWp()) {
                this.inM.onDetach();
            }
        }
    }

    private void bWo() {
        if (this.inK && this.hOu) {
            bWm();
        } else {
            bWn();
        }
    }

    public String toString() {
        return f.ao(this).ai("controllerAttached", this.inJ).ai("holderAttached", this.inK).ai("drawableVisible", this.hOu).n("events", this.ikY.toString()).toString();
    }

    private boolean bWp() {
        return this.inM != null && this.inM.getHierarchy() == this.inL;
    }
}
