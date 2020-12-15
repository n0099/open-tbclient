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
/* loaded from: classes8.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH phr;
    private boolean php = false;
    private boolean phq = false;
    private boolean elQ = true;
    private com.facebook.drawee.d.a phs = null;
    private final DraweeEventTracker peu = DraweeEventTracker.erc();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.hG(context);
        return bVar;
    }

    public void hG(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.peu.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.phq = true;
        esq();
    }

    public void onDetach() {
        this.peu.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.phq = false;
        esq();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (esr()) {
            return this.phs.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void AS(boolean z) {
        if (this.elQ != z) {
            this.peu.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.elQ = z;
            esq();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.php) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.phs)), toString());
            this.phq = true;
            this.elQ = true;
            esq();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.php;
        if (z) {
            esp();
        }
        if (esr()) {
            this.peu.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.phs.setHierarchy(null);
        }
        this.phs = aVar;
        if (this.phs != null) {
            this.peu.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.phs.setHierarchy(this.phr);
        } else {
            this.peu.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            eso();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.phs;
    }

    public void setHierarchy(DH dh) {
        this.peu.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean esr = esr();
        a(null);
        this.phr = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.phr.getTopLevelDrawable();
        AS(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (esr) {
            this.phs.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.phr);
    }

    public Drawable getTopLevelDrawable() {
        if (this.phr == null) {
            return null;
        }
        return this.phr.getTopLevelDrawable();
    }

    private void eso() {
        if (!this.php) {
            this.peu.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.php = true;
            if (this.phs != null && this.phs.getHierarchy() != null) {
                this.phs.onAttach();
            }
        }
    }

    private void esp() {
        if (this.php) {
            this.peu.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.php = false;
            if (esr()) {
                this.phs.onDetach();
            }
        }
    }

    private void esq() {
        if (this.phq && this.elQ) {
            eso();
        } else {
            esp();
        }
    }

    public String toString() {
        return f.ba(this).bo("controllerAttached", this.php).bo("holderAttached", this.phq).bo("drawableVisible", this.elQ).E("events", this.peu.toString()).toString();
    }

    private boolean esr() {
        return this.phs != null && this.phs.getHierarchy() == this.phr;
    }
}
