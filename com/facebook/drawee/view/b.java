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
    private DH mWH;
    private boolean mWF = false;
    private boolean mWG = false;
    private boolean due = true;
    private com.facebook.drawee.d.a mWI = null;
    private final DraweeEventTracker mTv = DraweeEventTracker.dDJ();

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
        this.mTv.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mWG = true;
        dFc();
    }

    public void onDetach() {
        this.mTv.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mWG = false;
        dFc();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dFd()) {
            return this.mWI.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void xg(boolean z) {
        if (this.due != z) {
            this.mTv.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.due = z;
            dFc();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.mWF) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mWI)), toString());
            this.mWG = true;
            this.due = true;
            dFc();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.mWF;
        if (z) {
            dFb();
        }
        if (dFd()) {
            this.mTv.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mWI.setHierarchy(null);
        }
        this.mWI = aVar;
        if (this.mWI != null) {
            this.mTv.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mWI.setHierarchy(this.mWH);
        } else {
            this.mTv.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dFa();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mWI;
    }

    public void setHierarchy(DH dh) {
        this.mTv.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dFd = dFd();
        a(null);
        this.mWH = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.mWH.getTopLevelDrawable();
        xg(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dFd) {
            this.mWI.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.mWH);
    }

    public Drawable getTopLevelDrawable() {
        if (this.mWH == null) {
            return null;
        }
        return this.mWH.getTopLevelDrawable();
    }

    private void dFa() {
        if (!this.mWF) {
            this.mTv.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.mWF = true;
            if (this.mWI != null && this.mWI.getHierarchy() != null) {
                this.mWI.onAttach();
            }
        }
    }

    private void dFb() {
        if (this.mWF) {
            this.mTv.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mWF = false;
            if (dFd()) {
                this.mWI.onDetach();
            }
        }
    }

    private void dFc() {
        if (this.mWG && this.due) {
            dFa();
        } else {
            dFb();
        }
    }

    public String toString() {
        return f.aO(this).aW("controllerAttached", this.mWF).aW("holderAttached", this.mWG).aW("drawableVisible", this.due).F("events", this.mTv.toString()).toString();
    }

    private boolean dFd() {
        return this.mWI != null && this.mWI.getHierarchy() == this.mWH;
    }
}
