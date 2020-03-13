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
    private DH lOk;
    private boolean lOi = false;
    private boolean lOj = false;
    private boolean mIsVisible = true;
    private com.facebook.drawee.d.a lOl = null;
    private final DraweeEventTracker lLd = DraweeEventTracker.dlV();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gl(context);
        return bVar;
    }

    public void gl(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.lLd.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.lOj = true;
        dnn();
    }

    public void onDetach() {
        this.lLd.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.lOj = false;
        dnn();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (dno()) {
            return this.lOl.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void vk(boolean z) {
        if (this.mIsVisible != z) {
            this.lLd.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            dnn();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.lOi) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lOl)), toString());
            this.lOj = true;
            this.mIsVisible = true;
            dnn();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.lOi;
        if (z) {
            dnm();
        }
        if (dno()) {
            this.lLd.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.lOl.setHierarchy(null);
        }
        this.lOl = aVar;
        if (this.lOl != null) {
            this.lLd.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.lOl.setHierarchy(this.lOk);
        } else {
            this.lLd.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            dnl();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lOl;
    }

    public void setHierarchy(DH dh) {
        this.lLd.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean dno = dno();
        a(null);
        this.lOk = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.lOk.getTopLevelDrawable();
        vk(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (dno) {
            this.lOl.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.lOk);
    }

    public boolean hasHierarchy() {
        return this.lOk != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.lOk == null) {
            return null;
        }
        return this.lOk.getTopLevelDrawable();
    }

    private void dnl() {
        if (!this.lOi) {
            this.lLd.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.lOi = true;
            if (this.lOl != null && this.lOl.getHierarchy() != null) {
                this.lOl.onAttach();
            }
        }
    }

    private void dnm() {
        if (this.lOi) {
            this.lLd.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.lOi = false;
            if (dno()) {
                this.lOl.onDetach();
            }
        }
    }

    private void dnn() {
        if (this.lOj && this.mIsVisible) {
            dnl();
        } else {
            dnm();
        }
    }

    public String toString() {
        return f.aS(this).aK("controllerAttached", this.lOi).aK("holderAttached", this.lOj).aK("drawableVisible", this.mIsVisible).x("events", this.lLd.toString()).toString();
    }

    private boolean dno() {
        return this.lOl != null && this.lOl.getHierarchy() == this.lOk;
    }
}
