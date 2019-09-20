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
    private DH khy;
    private boolean khw = false;
    private boolean khx = false;
    private boolean jIy = true;
    private com.facebook.drawee.d.a khz = null;
    private final DraweeEventTracker keO = DraweeEventTracker.cGR();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.eD(context);
        return bVar;
    }

    public void eD(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cGZ() {
        this.keO.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.khx = true;
        cIk();
    }

    public void onDetach() {
        this.keO.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.khx = false;
        cIk();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cIl()) {
            return this.khz.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void sC(boolean z) {
        if (this.jIy != z) {
            this.keO.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jIy = z;
            cIk();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void cHE() {
        if (!this.khw) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.khz)), toString());
            this.khx = true;
            this.jIy = true;
            cIk();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.khw;
        if (z) {
            cIj();
        }
        if (cIl()) {
            this.keO.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.khz.setHierarchy(null);
        }
        this.khz = aVar;
        if (this.khz != null) {
            this.keO.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.khz.setHierarchy(this.khy);
        } else {
            this.keO.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cIi();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.khz;
    }

    public void setHierarchy(DH dh) {
        this.keO.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cIl = cIl();
        a(null);
        this.khy = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.khy.getTopLevelDrawable();
        sC(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cIl) {
            this.khz.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.khy);
    }

    public Drawable getTopLevelDrawable() {
        if (this.khy == null) {
            return null;
        }
        return this.khy.getTopLevelDrawable();
    }

    private void cIi() {
        if (!this.khw) {
            this.keO.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.khw = true;
            if (this.khz != null && this.khz.getHierarchy() != null) {
                this.khz.cGZ();
            }
        }
    }

    private void cIj() {
        if (this.khw) {
            this.keO.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.khw = false;
            if (cIl()) {
                this.khz.onDetach();
            }
        }
    }

    private void cIk() {
        if (this.khx && this.jIy) {
            cIi();
        } else {
            cIj();
        }
    }

    public String toString() {
        return f.aC(this).aE("controllerAttached", this.khw).aE("holderAttached", this.khx).aE("drawableVisible", this.jIy).t("events", this.keO.toString()).toString();
    }

    private boolean cIl() {
        return this.khz != null && this.khz.getHierarchy() == this.khy;
    }
}
