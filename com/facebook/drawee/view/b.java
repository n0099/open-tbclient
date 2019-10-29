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
    private DH kfJ;
    private boolean kfH = false;
    private boolean kfI = false;
    private boolean jIq = true;
    private com.facebook.drawee.d.a kfK = null;
    private final DraweeEventTracker kcW = DraweeEventTracker.cDP();

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

    public void cDX() {
        this.kcW.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.kfI = true;
        cFh();
    }

    public void onDetach() {
        this.kcW.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.kfI = false;
        cFh();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cFi()) {
            return this.kfK.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void sh(boolean z) {
        if (this.jIq != z) {
            this.kcW.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jIq = z;
            cFh();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void cEC() {
        if (!this.kfH) {
            com.facebook.common.c.a.e(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kfK)), toString());
            this.kfI = true;
            this.jIq = true;
            cFh();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.kfH;
        if (z) {
            cFg();
        }
        if (cFi()) {
            this.kcW.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.kfK.setHierarchy(null);
        }
        this.kfK = aVar;
        if (this.kfK != null) {
            this.kcW.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.kfK.setHierarchy(this.kfJ);
        } else {
            this.kcW.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cFf();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.kfK;
    }

    public void setHierarchy(DH dh) {
        this.kcW.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cFi = cFi();
        a(null);
        this.kfJ = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.kfJ.getTopLevelDrawable();
        sh(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cFi) {
            this.kfK.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.kfJ);
    }

    public Drawable getTopLevelDrawable() {
        if (this.kfJ == null) {
            return null;
        }
        return this.kfJ.getTopLevelDrawable();
    }

    private void cFf() {
        if (!this.kfH) {
            this.kcW.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.kfH = true;
            if (this.kfK != null && this.kfK.getHierarchy() != null) {
                this.kfK.cDX();
            }
        }
    }

    private void cFg() {
        if (this.kfH) {
            this.kcW.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.kfH = false;
            if (cFi()) {
                this.kfK.onDetach();
            }
        }
    }

    private void cFh() {
        if (this.kfI && this.jIq) {
            cFf();
        } else {
            cFg();
        }
    }

    public String toString() {
        return f.ax(this).az("controllerAttached", this.kfH).az("holderAttached", this.kfI).az("drawableVisible", this.jIq).q("events", this.kcW.toString()).toString();
    }

    private boolean cFi() {
        return this.kfK != null && this.kfK.getHierarchy() == this.kfJ;
    }
}
