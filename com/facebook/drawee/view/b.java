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
    private DH pEo;
    private boolean pEm = false;
    private boolean pEn = false;
    private boolean esQ = true;
    private com.facebook.drawee.d.a pEp = null;
    private final DraweeEventTracker pBp = DraweeEventTracker.etK();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.ij(context);
        return bVar;
    }

    public void ij(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.pBp.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.pEn = true;
        eva();
    }

    public void onDetach() {
        this.pBp.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.pEn = false;
        eva();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (evb()) {
            return this.pEp.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void Bp(boolean z) {
        if (this.esQ != z) {
            this.pBp.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.esQ = z;
            eva();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.pEm) {
            com.facebook.common.c.a.c((Class<?>) DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.pEp)), toString());
            this.pEn = true;
            this.esQ = true;
            eva();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.pEm;
        if (z) {
            euZ();
        }
        if (evb()) {
            this.pBp.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.pEp.setHierarchy(null);
        }
        this.pEp = aVar;
        if (this.pEp != null) {
            this.pBp.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.pEp.setHierarchy(this.pEo);
        } else {
            this.pBp.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            euY();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pEp;
    }

    public void setHierarchy(DH dh) {
        this.pBp.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean evb = evb();
        a(null);
        this.pEo = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.pEo.getTopLevelDrawable();
        Bp(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (evb) {
            this.pEp.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.pEo);
    }

    public Drawable getTopLevelDrawable() {
        if (this.pEo == null) {
            return null;
        }
        return this.pEo.getTopLevelDrawable();
    }

    private void euY() {
        if (!this.pEm) {
            this.pBp.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.pEm = true;
            if (this.pEp != null && this.pEp.getHierarchy() != null) {
                this.pEp.onAttach();
            }
        }
    }

    private void euZ() {
        if (this.pEm) {
            this.pBp.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.pEm = false;
            if (evb()) {
                this.pEp.onDetach();
            }
        }
    }

    private void eva() {
        if (this.pEn && this.esQ) {
            euY();
        } else {
            euZ();
        }
    }

    public String toString() {
        return f.bb(this).bo("controllerAttached", this.pEm).bo("holderAttached", this.pEn).bo("drawableVisible", this.esQ).H("events", this.pBp.toString()).toString();
    }

    private boolean evb() {
        return this.pEp != null && this.pEp.getHierarchy() == this.pEo;
    }
}
