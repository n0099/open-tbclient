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
/* loaded from: classes13.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH mOt;
    private boolean mOr = false;
    private boolean mOs = false;
    private boolean doj = true;
    private com.facebook.drawee.d.a mOu = null;
    private final DraweeEventTracker mLi = DraweeEventTracker.dAs();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.fV(context);
        return bVar;
    }

    public void fV(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.mLi.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mOs = true;
        dBL();
    }

    public void onDetach() {
        this.mLi.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mOs = false;
        dBL();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dBM()) {
            return this.mOu.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void wB(boolean z) {
        if (this.doj != z) {
            this.mLi.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.doj = z;
            dBL();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.mOr) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mOu)), toString());
            this.mOs = true;
            this.doj = true;
            dBL();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.mOr;
        if (z) {
            dBK();
        }
        if (dBM()) {
            this.mLi.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mOu.setHierarchy(null);
        }
        this.mOu = aVar;
        if (this.mOu != null) {
            this.mLi.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mOu.setHierarchy(this.mOt);
        } else {
            this.mLi.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dBJ();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mOu;
    }

    public void setHierarchy(DH dh) {
        this.mLi.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dBM = dBM();
        a(null);
        this.mOt = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.mOt.getTopLevelDrawable();
        wB(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dBM) {
            this.mOu.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.mOt);
    }

    public Drawable getTopLevelDrawable() {
        if (this.mOt == null) {
            return null;
        }
        return this.mOt.getTopLevelDrawable();
    }

    private void dBJ() {
        if (!this.mOr) {
            this.mLi.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.mOr = true;
            if (this.mOu != null && this.mOu.getHierarchy() != null) {
                this.mOu.onAttach();
            }
        }
    }

    private void dBK() {
        if (this.mOr) {
            this.mLi.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mOr = false;
            if (dBM()) {
                this.mOu.onDetach();
            }
        }
    }

    private void dBL() {
        if (this.mOs && this.doj) {
            dBJ();
        } else {
            dBK();
        }
    }

    public String toString() {
        return f.aO(this).aZ("controllerAttached", this.mOr).aZ("holderAttached", this.mOs).aZ("drawableVisible", this.doj).F("events", this.mLi.toString()).toString();
    }

    private boolean dBM() {
        return this.mOu != null && this.mOu.getHierarchy() == this.mOt;
    }
}
