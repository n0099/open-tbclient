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
/* loaded from: classes9.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH mWF;
    private boolean mWD = false;
    private boolean mWE = false;
    private boolean due = true;
    private com.facebook.drawee.d.a mWG = null;
    private final DraweeEventTracker mTt = DraweeEventTracker.dDI();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.fY(context);
        return bVar;
    }

    public void fY(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.mTt.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mWE = true;
        dFb();
    }

    public void onDetach() {
        this.mTt.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mWE = false;
        dFb();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dFc()) {
            return this.mWG.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void xg(boolean z) {
        if (this.due != z) {
            this.mTt.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.due = z;
            dFb();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.mWD) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mWG)), toString());
            this.mWE = true;
            this.due = true;
            dFb();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.mWD;
        if (z) {
            dFa();
        }
        if (dFc()) {
            this.mTt.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mWG.setHierarchy(null);
        }
        this.mWG = aVar;
        if (this.mWG != null) {
            this.mTt.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mWG.setHierarchy(this.mWF);
        } else {
            this.mTt.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dEZ();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mWG;
    }

    public void setHierarchy(DH dh) {
        this.mTt.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dFc = dFc();
        a(null);
        this.mWF = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.mWF.getTopLevelDrawable();
        xg(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dFc) {
            this.mWG.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.mWF);
    }

    public Drawable getTopLevelDrawable() {
        if (this.mWF == null) {
            return null;
        }
        return this.mWF.getTopLevelDrawable();
    }

    private void dEZ() {
        if (!this.mWD) {
            this.mTt.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.mWD = true;
            if (this.mWG != null && this.mWG.getHierarchy() != null) {
                this.mWG.onAttach();
            }
        }
    }

    private void dFa() {
        if (this.mWD) {
            this.mTt.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mWD = false;
            if (dFc()) {
                this.mWG.onDetach();
            }
        }
    }

    private void dFb() {
        if (this.mWE && this.due) {
            dEZ();
        } else {
            dFa();
        }
    }

    public String toString() {
        return f.aO(this).aW("controllerAttached", this.mWD).aW("holderAttached", this.mWE).aW("drawableVisible", this.due).F("events", this.mTt.toString()).toString();
    }

    private boolean dFc() {
        return this.mWG != null && this.mWG.getHierarchy() == this.mWF;
    }
}
