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
    private DH jEM;
    private boolean jEK = false;
    private boolean jEL = false;
    private boolean jgi = true;
    private com.facebook.drawee.d.a jEN = null;
    private final DraweeEventTracker jCa = DraweeEventTracker.cuO();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eM(context);
        return bVar;
    }

    public void eM(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cuW() {
        this.jCa.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jEL = true;
        cwf();
    }

    public void onDetach() {
        this.jCa.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jEL = false;
        cwf();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cwg()) {
            return this.jEN.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void rt(boolean z) {
        if (this.jgi != z) {
            this.jCa.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jgi = z;
            cwf();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jEK) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jEN)), toString());
            this.jEL = true;
            this.jgi = true;
            cwf();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.jEK;
        if (z) {
            cwe();
        }
        if (cwg()) {
            this.jCa.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jEN.setHierarchy(null);
        }
        this.jEN = aVar;
        if (this.jEN != null) {
            this.jCa.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jEN.setHierarchy(this.jEM);
        } else {
            this.jCa.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cwd();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jEN;
    }

    public void setHierarchy(DH dh) {
        this.jCa.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cwg = cwg();
        a(null);
        this.jEM = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jEM.getTopLevelDrawable();
        rt(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cwg) {
            this.jEN.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jEM);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jEM == null) {
            return null;
        }
        return this.jEM.getTopLevelDrawable();
    }

    private void cwd() {
        if (!this.jEK) {
            this.jCa.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jEK = true;
            if (this.jEN != null && this.jEN.getHierarchy() != null) {
                this.jEN.cuW();
            }
        }
    }

    private void cwe() {
        if (this.jEK) {
            this.jCa.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jEK = false;
            if (cwg()) {
                this.jEN.onDetach();
            }
        }
    }

    private void cwf() {
        if (this.jEL && this.jgi) {
            cwd();
        } else {
            cwe();
        }
    }

    public String toString() {
        return f.aE(this).ay("controllerAttached", this.jEK).ay("holderAttached", this.jEL).ay("drawableVisible", this.jgi).q("events", this.jCa.toString()).toString();
    }

    private boolean cwg() {
        return this.jEN != null && this.jEN.getHierarchy() == this.jEM;
    }
}
