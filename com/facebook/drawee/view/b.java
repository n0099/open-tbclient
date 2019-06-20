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
    private DH jWQ;
    private boolean jWO = false;
    private boolean jWP = false;
    private boolean jyN = true;
    private com.facebook.drawee.d.a jWR = null;
    private final DraweeEventTracker jUg = DraweeEventTracker.cCH();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eA(context);
        return bVar;
    }

    public void eA(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cCP() {
        this.jUg.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jWP = true;
        cDY();
    }

    public void onDetach() {
        this.jUg.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jWP = false;
        cDY();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cDZ()) {
            return this.jWR.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void sj(boolean z) {
        if (this.jyN != z) {
            this.jUg.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jyN = z;
            cDY();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jWO) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jWR)), toString());
            this.jWP = true;
            this.jyN = true;
            cDY();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.jWO;
        if (z) {
            cDX();
        }
        if (cDZ()) {
            this.jUg.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jWR.setHierarchy(null);
        }
        this.jWR = aVar;
        if (this.jWR != null) {
            this.jUg.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jWR.setHierarchy(this.jWQ);
        } else {
            this.jUg.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cDW();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jWR;
    }

    public void setHierarchy(DH dh) {
        this.jUg.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cDZ = cDZ();
        a(null);
        this.jWQ = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jWQ.getTopLevelDrawable();
        sj(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cDZ) {
            this.jWR.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jWQ);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jWQ == null) {
            return null;
        }
        return this.jWQ.getTopLevelDrawable();
    }

    private void cDW() {
        if (!this.jWO) {
            this.jUg.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jWO = true;
            if (this.jWR != null && this.jWR.getHierarchy() != null) {
                this.jWR.cCP();
            }
        }
    }

    private void cDX() {
        if (this.jWO) {
            this.jUg.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jWO = false;
            if (cDZ()) {
                this.jWR.onDetach();
            }
        }
    }

    private void cDY() {
        if (this.jWP && this.jyN) {
            cDW();
        } else {
            cDX();
        }
    }

    public String toString() {
        return f.aC(this).aA("controllerAttached", this.jWO).aA("holderAttached", this.jWP).aA("drawableVisible", this.jyN).t("events", this.jUg.toString()).toString();
    }

    private boolean cDZ() {
        return this.jWR != null && this.jWR.getHierarchy() == this.jWQ;
    }
}
