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
    private DH mOw;
    private boolean mOu = false;
    private boolean mOv = false;
    private boolean doj = true;
    private com.facebook.drawee.d.a mOx = null;
    private final DraweeEventTracker mLl = DraweeEventTracker.dAw();

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
        this.mLl.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mOv = true;
        dBP();
    }

    public void onDetach() {
        this.mLl.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mOv = false;
        dBP();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dBQ()) {
            return this.mOx.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void wB(boolean z) {
        if (this.doj != z) {
            this.mLl.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.doj = z;
            dBP();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.mOu) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mOx)), toString());
            this.mOv = true;
            this.doj = true;
            dBP();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.mOu;
        if (z) {
            dBO();
        }
        if (dBQ()) {
            this.mLl.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mOx.setHierarchy(null);
        }
        this.mOx = aVar;
        if (this.mOx != null) {
            this.mLl.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mOx.setHierarchy(this.mOw);
        } else {
            this.mLl.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dBN();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mOx;
    }

    public void setHierarchy(DH dh) {
        this.mLl.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dBQ = dBQ();
        a(null);
        this.mOw = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.mOw.getTopLevelDrawable();
        wB(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dBQ) {
            this.mOx.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.mOw);
    }

    public Drawable getTopLevelDrawable() {
        if (this.mOw == null) {
            return null;
        }
        return this.mOw.getTopLevelDrawable();
    }

    private void dBN() {
        if (!this.mOu) {
            this.mLl.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.mOu = true;
            if (this.mOx != null && this.mOx.getHierarchy() != null) {
                this.mOx.onAttach();
            }
        }
    }

    private void dBO() {
        if (this.mOu) {
            this.mLl.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.mOu = false;
            if (dBQ()) {
                this.mOx.onDetach();
            }
        }
    }

    private void dBP() {
        if (this.mOv && this.doj) {
            dBN();
        } else {
            dBO();
        }
    }

    public String toString() {
        return f.aO(this).aZ("controllerAttached", this.mOu).aZ("holderAttached", this.mOv).aZ("drawableVisible", this.doj).F("events", this.mLl.toString()).toString();
    }

    private boolean dBQ() {
        return this.mOx != null && this.mOx.getHierarchy() == this.mOw;
    }
}
