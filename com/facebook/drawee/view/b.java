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
    private DH jDZ;
    private boolean jDX = false;
    private boolean jDY = false;
    private boolean jfP = true;
    private com.facebook.drawee.d.a jEa = null;
    private final DraweeEventTracker jBn = DraweeEventTracker.cuK();

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
        this.jBn.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jDY = true;
        cwb();
    }

    public void onDetach() {
        this.jBn.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jDY = false;
        cwb();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cwc()) {
            return this.jEa.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void rt(boolean z) {
        if (this.jfP != z) {
            this.jBn.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jfP = z;
            cwb();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jDX) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jEa)), toString());
            this.jDY = true;
            this.jfP = true;
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
        boolean z = this.jDX;
        if (z) {
            cwa();
        }
        if (cwc()) {
            this.jBn.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jEa.setHierarchy(null);
        }
        this.jEa = aVar;
        if (this.jEa != null) {
            this.jBn.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jEa.setHierarchy(this.jDZ);
        } else {
            this.jBn.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cvZ();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jEa;
    }

    public void setHierarchy(DH dh) {
        this.jBn.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cwc = cwc();
        a(null);
        this.jDZ = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jDZ.getTopLevelDrawable();
        rt(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cwc) {
            this.jEa.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jDZ);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jDZ == null) {
            return null;
        }
        return this.jDZ.getTopLevelDrawable();
    }

    private void cvZ() {
        if (!this.jDX) {
            this.jBn.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jDX = true;
            if (this.jEa != null && this.jEa.getHierarchy() != null) {
                this.jEa.cuS();
            }
        }
    }

    private void cwa() {
        if (this.jDX) {
            this.jBn.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jDX = false;
            if (cwc()) {
                this.jEa.onDetach();
            }
        }
    }

    private void cwb() {
        if (this.jDY && this.jfP) {
            cvZ();
        } else {
            cwa();
        }
    }

    public String toString() {
        return f.aA(this).ay("controllerAttached", this.jDX).ay("holderAttached", this.jDY).ay("drawableVisible", this.jfP).q("events", this.jBn.toString()).toString();
    }

    private boolean cwc() {
        return this.jEa != null && this.jEa.getHierarchy() == this.jDZ;
    }
}
