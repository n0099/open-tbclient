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
/* loaded from: classes14.dex */
public class b<DH extends com.facebook.drawee.d.b> implements t {
    private DH oSu;
    private boolean oSs = false;
    private boolean oSt = false;
    private boolean eeP = true;
    private com.facebook.drawee.d.a oSv = null;
    private final DraweeEventTracker oPl = DraweeEventTracker.elm();

    public static <DH extends com.facebook.drawee.d.b> b<DH> a(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.gX(context);
        return bVar;
    }

    public void gX(Context context) {
    }

    public b(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.oPl.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.oSt = true;
        emE();
    }

    public void onDetach() {
        this.oPl.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.oSt = false;
        emE();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (emF()) {
            return this.oSv.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.facebook.drawee.drawable.t
    public void Ap(boolean z) {
        if (this.eeP != z) {
            this.oPl.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.eeP = z;
            emE();
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (!this.oSs) {
            com.facebook.common.c.a.c(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.oSv)), toString());
            this.oSt = true;
            this.eeP = true;
            emE();
        }
    }

    private void a(@Nullable t tVar) {
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof s) {
            ((s) topLevelDrawable).a(tVar);
        }
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        boolean z = this.oSs;
        if (z) {
            emD();
        }
        if (emF()) {
            this.oPl.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.oSv.setHierarchy(null);
        }
        this.oSv = aVar;
        if (this.oSv != null) {
            this.oPl.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.oSv.setHierarchy(this.oSu);
        } else {
            this.oPl.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            emC();
        }
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.oSv;
    }

    public void setHierarchy(DH dh) {
        this.oPl.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean emF = emF();
        a(null);
        this.oSu = (DH) g.checkNotNull(dh);
        Drawable topLevelDrawable = this.oSu.getTopLevelDrawable();
        Ap(topLevelDrawable == null || topLevelDrawable.isVisible());
        a(this);
        if (emF) {
            this.oSv.setHierarchy(dh);
        }
    }

    public DH getHierarchy() {
        return (DH) g.checkNotNull(this.oSu);
    }

    public Drawable getTopLevelDrawable() {
        if (this.oSu == null) {
            return null;
        }
        return this.oSu.getTopLevelDrawable();
    }

    private void emC() {
        if (!this.oSs) {
            this.oPl.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.oSs = true;
            if (this.oSv != null && this.oSv.getHierarchy() != null) {
                this.oSv.onAttach();
            }
        }
    }

    private void emD() {
        if (this.oSs) {
            this.oPl.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.oSs = false;
            if (emF()) {
                this.oSv.onDetach();
            }
        }
    }

    private void emE() {
        if (this.oSt && this.eeP) {
            emC();
        } else {
            emD();
        }
    }

    public String toString() {
        return f.ba(this).bn("controllerAttached", this.oSs).bn("holderAttached", this.oSt).bn("drawableVisible", this.eeP).F("events", this.oPl.toString()).toString();
    }

    private boolean emF() {
        return this.oSv != null && this.oSv.getHierarchy() == this.oSu;
    }
}
