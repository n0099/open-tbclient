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
    private DH keS;
    private boolean keQ = false;
    private boolean keR = false;
    private boolean jHz = true;
    private com.facebook.drawee.d.a keT = null;
    private final DraweeEventTracker kcf = DraweeEventTracker.cDN();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.es(context);
        return bVar;
    }

    public void es(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void cDV() {
        this.kcf.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.keR = true;
        cFf();
    }

    public void onDetach() {
        this.kcf.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.keR = false;
        cFf();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cFg()) {
            return this.keT.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void sh(boolean z) {
        if (this.jHz != z) {
            this.kcf.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jHz = z;
            cFf();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void cEA() {
        if (!this.keQ) {
            com.facebook.common.c.a.e(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.keT)), toString());
            this.keR = true;
            this.jHz = true;
            cFf();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.keQ;
        if (z) {
            cFe();
        }
        if (cFg()) {
            this.kcf.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.keT.setHierarchy(null);
        }
        this.keT = aVar;
        if (this.keT != null) {
            this.kcf.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.keT.setHierarchy(this.keS);
        } else {
            this.kcf.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cFd();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.keT;
    }

    public void setHierarchy(DH dh) {
        this.kcf.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cFg = cFg();
        a(null);
        this.keS = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.keS.getTopLevelDrawable();
        sh(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cFg) {
            this.keT.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.keS);
    }

    public Drawable getTopLevelDrawable() {
        if (this.keS == null) {
            return null;
        }
        return this.keS.getTopLevelDrawable();
    }

    private void cFd() {
        if (!this.keQ) {
            this.kcf.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.keQ = true;
            if (this.keT != null && this.keT.getHierarchy() != null) {
                this.keT.cDV();
            }
        }
    }

    private void cFe() {
        if (this.keQ) {
            this.kcf.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.keQ = false;
            if (cFg()) {
                this.keT.onDetach();
            }
        }
    }

    private void cFf() {
        if (this.keR && this.jHz) {
            cFd();
        } else {
            cFe();
        }
    }

    public String toString() {
        return f.ax(this).az("controllerAttached", this.keQ).az("holderAttached", this.keR).az("drawableVisible", this.jHz).q("events", this.kcf.toString()).toString();
    }

    private boolean cFg() {
        return this.keT != null && this.keT.getHierarchy() == this.keS;
    }
}
