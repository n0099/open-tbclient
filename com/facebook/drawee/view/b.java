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
    private DH jEt;
    private boolean jEr = false;
    private boolean jEs = false;
    private boolean jfO = true;
    private com.facebook.drawee.d.a jEu = null;
    private final DraweeEventTracker jBH = DraweeEventTracker.cuE();

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

    public void cuM() {
        this.jBH.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.jEs = true;
        cvV();
    }

    public void onDetach() {
        this.jBH.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.jEs = false;
        cvV();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (cvW()) {
            return this.jEu.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void rt(boolean z) {
        if (this.jfO != z) {
            this.jBH.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.jfO = z;
            cvV();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.jEr) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jEu)), toString());
            this.jEs = true;
            this.jfO = true;
            cvV();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.jEr;
        if (z) {
            cvU();
        }
        if (cvW()) {
            this.jBH.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.jEu.setHierarchy(null);
        }
        this.jEu = aVar;
        if (this.jEu != null) {
            this.jBH.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.jEu.setHierarchy(this.jEt);
        } else {
            this.jBH.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            cvT();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jEu;
    }

    public void setHierarchy(DH dh) {
        this.jBH.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean cvW = cvW();
        a(null);
        this.jEt = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.jEt.getTopLevelDrawable();
        rt(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (cvW) {
            this.jEu.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.jEt);
    }

    public Drawable getTopLevelDrawable() {
        if (this.jEt == null) {
            return null;
        }
        return this.jEt.getTopLevelDrawable();
    }

    private void cvT() {
        if (!this.jEr) {
            this.jBH.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.jEr = true;
            if (this.jEu != null && this.jEu.getHierarchy() != null) {
                this.jEu.cuM();
            }
        }
    }

    private void cvU() {
        if (this.jEr) {
            this.jBH.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.jEr = false;
            if (cvW()) {
                this.jEu.onDetach();
            }
        }
    }

    private void cvV() {
        if (this.jEs && this.jfO) {
            cvT();
        } else {
            cvU();
        }
    }

    public String toString() {
        return f.aD(this).ax("controllerAttached", this.jEr).ax("holderAttached", this.jEs).ax("drawableVisible", this.jfO).q("events", this.jBH.toString()).toString();
    }

    private boolean cvW() {
        return this.jEu != null && this.jEu.getHierarchy() == this.jEt;
    }
}
