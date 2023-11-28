package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.k;
/* loaded from: classes10.dex */
public final class g {
    public final bp aBL;
    public final i aRo;
    public boolean aRq;
    public boolean aRr;
    public ViewTreeObserver.OnScrollChangedListener aRt;
    public final View mView;
    public final int me;
    public float aRp = 0.1f;
    public boolean aRs = true;

    public g(View view2, i iVar) {
        this.mView = view2;
        this.aRo = iVar;
        this.aBL = new bp(view2);
        this.me = k.getScreenHeight(view2.getContext());
    }

    private void FB() {
        if (this.aRt == null) {
            this.aRt = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (!g.this.Ms()) {
                        return;
                    }
                    g.this.ao();
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aRt);
            }
        }
    }

    private void FC() {
        if (this.aRt == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aRt);
            }
            this.aRt = null;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private void Mr() {
        if (Ms()) {
            ao();
            return;
        }
        FC();
        FB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        FC();
        i iVar = this.aRo;
        if (iVar != null) {
            iVar.A(this.mView);
        }
    }

    private void ot() {
        if (this.aRs) {
            Mr();
        }
    }

    public final void Mq() {
        if (this.aRr) {
            ot();
        }
    }

    public final float getVisiblePercent() {
        return this.aRp;
    }

    public final void onAttachedToWindow() {
        FB();
    }

    public final void onDetachedFromWindow() {
        FC();
        this.aRq = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ms() {
        if (this.aBL.LP() && Math.abs(this.aBL.aPt.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.aRp) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.aBL.aPt;
            if (rect.bottom > 0 && rect.top < this.me) {
                return true;
            }
        }
        return false;
    }

    public final void cb(boolean z) {
        this.aRs = z;
    }

    public final void setVisiblePercent(float f) {
        this.aRp = f;
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.aRr = false;
        if (!this.aRq && (i3 | i4) == 0 && (i | i2) != 0) {
            this.aRr = true;
            this.aRq = true;
        }
    }
}
