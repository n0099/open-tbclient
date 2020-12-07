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
    private DH php;
    private boolean phn = false;
    private boolean pho = false;
    private boolean elQ = true;
    private com.facebook.drawee.d.a phq = null;
    private final DraweeEventTracker pes = DraweeEventTracker.erb();

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
        this.pes.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.pho = true;
        esp();
    }

    public void onDetach() {
        this.pes.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.pho = false;
        esp();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (esq()) {
            return this.phq.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void AS(boolean z) {
        if (this.elQ != z) {
            this.pes.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.elQ = z;
            esp();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.phn) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.phq)), toString());
            this.pho = true;
            this.elQ = true;
            esp();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.phn;
        if (z) {
            eso();
        }
        if (esq()) {
            this.pes.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.phq.setHierarchy(null);
        }
        this.phq = aVar;
        if (this.phq != null) {
            this.pes.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.phq.setHierarchy(this.php);
        } else {
            this.pes.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            esn();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.phq;
    }

    public void setHierarchy(DH dh) {
        this.pes.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean esq = esq();
        a(null);
        this.php = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.php.getTopLevelDrawable();
        AS(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (esq) {
            this.phq.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.php);
    }

    public Drawable getTopLevelDrawable() {
        if (this.php == null) {
            return null;
        }
        return this.php.getTopLevelDrawable();
    }

    private void esn() {
        if (!this.phn) {
            this.pes.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.phn = true;
            if (this.phq != null && this.phq.getHierarchy() != null) {
                this.phq.onAttach();
            }
        }
    }

    private void eso() {
        if (this.phn) {
            this.pes.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.phn = false;
            if (esq()) {
                this.phq.onDetach();
            }
        }
    }

    private void esp() {
        if (this.pho && this.elQ) {
            esn();
        } else {
            eso();
        }
    }

    public String toString() {
        return f.ba(this).bo("controllerAttached", this.phn).bo("holderAttached", this.pho).bo("drawableVisible", this.elQ).E("events", this.pes.toString()).toString();
    }

    private boolean esq() {
        return this.phq != null && this.phq.getHierarchy() == this.php;
    }
}
