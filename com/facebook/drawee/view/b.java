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
    private DH ikz;
    private boolean ikx = false;
    private boolean iky = false;
    private boolean hLj = true;
    private com.facebook.drawee.d.a ikA = null;
    private final DraweeEventTracker ihO = DraweeEventTracker.bUj();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.dr(context);
        return bVar;
    }

    public void dr(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.ihO.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.iky = true;
        bVy();
    }

    public void onDetach() {
        this.ihO.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.iky = false;
        bVy();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (bVz()) {
            return this.ikA.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void oV(boolean z) {
        if (this.hLj != z) {
            this.ihO.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.hLj = z;
            bVy();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.ikx) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ikA)), toString());
            this.iky = true;
            this.hLj = true;
            bVy();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.ikx;
        if (z) {
            bVx();
        }
        if (bVz()) {
            this.ihO.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.ikA.setHierarchy(null);
        }
        this.ikA = aVar;
        if (this.ikA != null) {
            this.ihO.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.ikA.setHierarchy(this.ikz);
        } else {
            this.ihO.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            bVw();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.ikA;
    }

    public void setHierarchy(DH dh) {
        this.ihO.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean bVz = bVz();
        a(null);
        this.ikz = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.ikz.getTopLevelDrawable();
        oV(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (bVz) {
            this.ikA.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.ikz);
    }

    public boolean hasHierarchy() {
        return this.ikz != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.ikz == null) {
            return null;
        }
        return this.ikz.getTopLevelDrawable();
    }

    private void bVw() {
        if (!this.ikx) {
            this.ihO.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.ikx = true;
            if (this.ikA != null && this.ikA.getHierarchy() != null) {
                this.ikA.onAttach();
            }
        }
    }

    private void bVx() {
        if (this.ikx) {
            this.ihO.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.ikx = false;
            if (bVz()) {
                this.ikA.onDetach();
            }
        }
    }

    private void bVy() {
        if (this.iky && this.hLj) {
            bVw();
        } else {
            bVx();
        }
    }

    public String toString() {
        return f.ao(this).ai("controllerAttached", this.ikx).ai("holderAttached", this.iky).ai("drawableVisible", this.hLj).n("events", this.ihO.toString()).toString();
    }

    private boolean bVz() {
        return this.ikA != null && this.ikA.getHierarchy() == this.ikz;
    }
}
