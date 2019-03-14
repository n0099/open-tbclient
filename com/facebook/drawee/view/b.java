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
    private DH jEE;
    private boolean jEC = false;
    private boolean jED = false;
    private boolean jga = true;
    private com.facebook.drawee.d.a jEF = null;
    private final DraweeEventTracker jBS = DraweeEventTracker.cuR();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eL(context);
        return bVar;
    }

    public void eL(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cuZ() {
        this.jBS.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jED = true;
        cwi();
    }

    public void onDetach() {
        this.jBS.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jED = false;
        cwi();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cwj()) {
            return this.jEF.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void rt(boolean z) {
        if (this.jga != z) {
            this.jBS.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jga = z;
            cwi();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jEC) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jEF)), toString());
            this.jED = true;
            this.jga = true;
            cwi();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.jEC;
        if (z) {
            cwh();
        }
        if (cwj()) {
            this.jBS.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jEF.setHierarchy(null);
        }
        this.jEF = aVar;
        if (this.jEF != null) {
            this.jBS.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jEF.setHierarchy(this.jEE);
        } else {
            this.jBS.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cwg();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jEF;
    }

    public void setHierarchy(DH dh) {
        this.jBS.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cwj = cwj();
        a(null);
        this.jEE = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jEE.getTopLevelDrawable();
        rt(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cwj) {
            this.jEF.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jEE);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jEE == null) {
            return null;
        }
        return this.jEE.getTopLevelDrawable();
    }

    private void cwg() {
        if (!this.jEC) {
            this.jBS.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jEC = true;
            if (this.jEF != null && this.jEF.getHierarchy() != null) {
                this.jEF.cuZ();
            }
        }
    }

    private void cwh() {
        if (this.jEC) {
            this.jBS.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jEC = false;
            if (cwj()) {
                this.jEF.onDetach();
            }
        }
    }

    private void cwi() {
        if (this.jED && this.jga) {
            cwg();
        } else {
            cwh();
        }
    }

    public String toString() {
        return f.aE(this).ay("controllerAttached", this.jEC).ay("holderAttached", this.jED).ay("drawableVisible", this.jga).q("events", this.jBS.toString()).toString();
    }

    private boolean cwj() {
        return this.jEF != null && this.jEF.getHierarchy() == this.jEE;
    }
}
