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
/* loaded from: classes15.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH oQR;
    private boolean oQP = false;
    private boolean oQQ = false;
    private boolean egx = true;
    private com.facebook.drawee.d.a oQS = null;
    private final DraweeEventTracker oNH = DraweeEventTracker.elo();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gZ(context);
        return bVar;
    }

    public void gZ(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.oNH.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.oQQ = true;
        emG();
    }

    public void onDetach() {
        this.oNH.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.oQQ = false;
        emG();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (emH()) {
            return this.oQS.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void Ai(boolean z) {
        if (this.egx != z) {
            this.oNH.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.egx = z;
            emG();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.oQP) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.oQS)), toString());
            this.oQQ = true;
            this.egx = true;
            emG();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.oQP;
        if (z) {
            emF();
        }
        if (emH()) {
            this.oNH.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.oQS.setHierarchy(null);
        }
        this.oQS = aVar;
        if (this.oQS != null) {
            this.oNH.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.oQS.setHierarchy(this.oQR);
        } else {
            this.oNH.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            emE();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.oQS;
    }

    public void setHierarchy(DH dh) {
        this.oNH.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean emH = emH();
        a(null);
        this.oQR = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.oQR.getTopLevelDrawable();
        Ai(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (emH) {
            this.oQS.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.oQR);
    }

    public Drawable getTopLevelDrawable() {
        if (this.oQR == null) {
            return null;
        }
        return this.oQR.getTopLevelDrawable();
    }

    private void emE() {
        if (!this.oQP) {
            this.oNH.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.oQP = true;
            if (this.oQS != null && this.oQS.getHierarchy() != null) {
                this.oQS.onAttach();
            }
        }
    }

    private void emF() {
        if (this.oQP) {
            this.oNH.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.oQP = false;
            if (emH()) {
                this.oQS.onDetach();
            }
        }
    }

    private void emG() {
        if (this.oQQ && this.egx) {
            emE();
        } else {
            emF();
        }
    }

    public String toString() {
        return f.aZ(this).bn("controllerAttached", this.oQP).bn("holderAttached", this.oQQ).bn("drawableVisible", this.egx).F("events", this.oNH.toString()).toString();
    }

    private boolean emH() {
        return this.oQS != null && this.oQS.getHierarchy() == this.oQR;
    }
}
