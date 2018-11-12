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
    private DH idn;
    private boolean idk = false;
    private boolean idm = false;
    private boolean hDX = true;
    private com.facebook.drawee.d.a ido = null;
    private final DraweeEventTracker iaB = DraweeEventTracker.bSd();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.dn(context);
        return bVar;
    }

    public void dn(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.iaB.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.idm = true;
        bTs();
    }

    public void onDetach() {
        this.iaB.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.idm = false;
        bTs();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (bTt()) {
            return this.ido.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.r
    public void oT(boolean z) {
        if (this.hDX != z) {
            this.iaB.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.hDX = z;
            bTs();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void onDraw() {
        if (!this.idk) {
            com.facebook.common.c.a.f(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ido)), toString());
            this.idm = true;
            this.hDX = true;
            bTs();
        }
    }

    private void a(@Nullable r rVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof q) {
            ((q) topLevelDrawable).a(rVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.idk;
        if (z) {
            bTr();
        }
        if (bTt()) {
            this.iaB.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.ido.setHierarchy(null);
        }
        this.ido = aVar;
        if (this.ido != null) {
            this.iaB.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.ido.setHierarchy(this.idn);
        } else {
            this.iaB.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            bTq();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.ido;
    }

    public void setHierarchy(DH dh) {
        this.iaB.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean bTt = bTt();
        a(null);
        this.idn = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.idn.getTopLevelDrawable();
        oT(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (bTt) {
            this.ido.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.idn);
    }

    public boolean hasHierarchy() {
        return this.idn != null;
    }

    public Drawable getTopLevelDrawable() {
        if (this.idn == null) {
            return null;
        }
        return this.idn.getTopLevelDrawable();
    }

    private void bTq() {
        if (!this.idk) {
            this.iaB.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.idk = true;
            if (this.ido != null && this.ido.getHierarchy() != null) {
                this.ido.onAttach();
            }
        }
    }

    private void bTr() {
        if (this.idk) {
            this.iaB.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.idk = false;
            if (bTt()) {
                this.ido.onDetach();
            }
        }
    }

    private void bTs() {
        if (this.idm && this.hDX) {
            bTq();
        } else {
            bTr();
        }
    }

    public String toString() {
        return f.an(this).ag("controllerAttached", this.idk).ag("holderAttached", this.idm).ag("drawableVisible", this.hDX).n("events", this.iaB.toString()).toString();
    }

    private boolean bTt() {
        return this.ido != null && this.ido.getHierarchy() == this.idn;
    }
}
