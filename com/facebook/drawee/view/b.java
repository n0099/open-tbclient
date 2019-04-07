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
    private DH jDY;
    private boolean jDW = false;
    private boolean jDX = false;
    private boolean jfO = true;
    private com.facebook.drawee.d.a jDZ = null;
    private final DraweeEventTracker jBm = DraweeEventTracker.cuK();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eK(context);
        return bVar;
    }

    public void eK(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cuS() {
        this.jBm.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jDX = true;
        cwb();
    }

    public void onDetach() {
        this.jBm.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jDX = false;
        cwb();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cwc()) {
            return this.jDZ.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void rt(boolean z) {
        if (this.jfO != z) {
            this.jBm.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jfO = z;
            cwb();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jDW) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jDZ)), toString());
            this.jDX = true;
            this.jfO = true;
            cwb();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.jDW;
        if (z) {
            cwa();
        }
        if (cwc()) {
            this.jBm.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jDZ.setHierarchy(null);
        }
        this.jDZ = aVar;
        if (this.jDZ != null) {
            this.jBm.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jDZ.setHierarchy(this.jDY);
        } else {
            this.jBm.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cvZ();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jDZ;
    }

    public void setHierarchy(DH dh) {
        this.jBm.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cwc = cwc();
        a(null);
        this.jDY = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jDY.getTopLevelDrawable();
        rt(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cwc) {
            this.jDZ.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jDY);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jDY == null) {
            return null;
        }
        return this.jDY.getTopLevelDrawable();
    }

    private void cvZ() {
        if (!this.jDW) {
            this.jBm.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jDW = true;
            if (this.jDZ != null && this.jDZ.getHierarchy() != null) {
                this.jDZ.cuS();
            }
        }
    }

    private void cwa() {
        if (this.jDW) {
            this.jBm.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jDW = false;
            if (cwc()) {
                this.jDZ.onDetach();
            }
        }
    }

    private void cwb() {
        if (this.jDX && this.jfO) {
            cvZ();
        } else {
            cwa();
        }
    }

    public String toString() {
        return f.aA(this).ay("controllerAttached", this.jDW).ay("holderAttached", this.jDX).ay("drawableVisible", this.jfO).q("events", this.jBm.toString()).toString();
    }

    private boolean cwc() {
        return this.jDZ != null && this.jDZ.getHierarchy() == this.jDY;
    }
}
