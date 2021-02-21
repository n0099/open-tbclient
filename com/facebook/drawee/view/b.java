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
    private DH pEO;
    private boolean pEM = false;
    private boolean pEN = false;
    private boolean esQ = true;
    private com.facebook.drawee.d.a pEP = null;
    private final DraweeEventTracker pBP = DraweeEventTracker.etS();

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
        this.pBP.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.pEN = true;
        evi();
    }

    public void onDetach() {
        this.pBP.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.pEN = false;
        evi();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (evj()) {
            return this.pEP.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void Bp(boolean z) {
        if (this.esQ != z) {
            this.pBP.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.esQ = z;
            evi();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.pEM) {
            com.facebook.common.c.a.c((Class<?>) DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.pEP)), toString());
            this.pEN = true;
            this.esQ = true;
            evi();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.pEM;
        if (z) {
            evh();
        }
        if (evj()) {
            this.pBP.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.pEP.setHierarchy(null);
        }
        this.pEP = aVar;
        if (this.pEP != null) {
            this.pBP.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.pEP.setHierarchy(this.pEO);
        } else {
            this.pBP.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            evg();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pEP;
    }

    public void setHierarchy(DH dh) {
        this.pBP.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean evj = evj();
        a(null);
        this.pEO = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.pEO.getTopLevelDrawable();
        Bp(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (evj) {
            this.pEP.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.pEO);
    }

    public Drawable getTopLevelDrawable() {
        if (this.pEO == null) {
            return null;
        }
        return this.pEO.getTopLevelDrawable();
    }

    private void evg() {
        if (!this.pEM) {
            this.pBP.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.pEM = true;
            if (this.pEP != null && this.pEP.getHierarchy() != null) {
                this.pEP.onAttach();
            }
        }
    }

    private void evh() {
        if (this.pEM) {
            this.pBP.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.pEM = false;
            if (evj()) {
                this.pEP.onDetach();
            }
        }
    }

    private void evi() {
        if (this.pEN && this.esQ) {
            evg();
        } else {
            evh();
        }
    }

    public String toString() {
        return f.bb(this).bo("controllerAttached", this.pEM).bo("holderAttached", this.pEN).bo("drawableVisible", this.esQ).H("events", this.pBP.toString()).toString();
    }

    private boolean evj() {
        return this.pEP != null && this.pEP.getHierarchy() == this.pEO;
    }
}
