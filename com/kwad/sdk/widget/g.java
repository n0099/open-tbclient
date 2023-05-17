package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.bf;
/* loaded from: classes9.dex */
public final class g {
    public final int GD;
    public final bf afk;
    public final i are;
    public boolean arg;
    public boolean arh;
    public ViewTreeObserver.OnScrollChangedListener arj;
    public final View mView;
    public float arf = 0.1f;
    public boolean ari = true;

    public g(View view2, i iVar) {
        this.mView = view2;
        this.are = iVar;
        this.afk = new bf(view2);
        this.GD = com.kwad.sdk.utils.j.getScreenHeight(view2.getContext());
    }

    private void Bx() {
        if (By()) {
            av();
            return;
        }
        wf();
        we();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean By() {
        if (this.afk.AV() && Math.abs(this.afk.apg.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.arf) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.afk.apg;
            if (rect.bottom > 0 && rect.top < this.GD) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        wf();
        i iVar = this.are;
        if (iVar != null) {
            iVar.k(this.mView);
        }
    }

    private void wa() {
        if (this.ari) {
            Bx();
        }
    }

    private void we() {
        if (this.arj == null) {
            this.arj = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.By()) {
                        g.this.av();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.arj);
            }
        }
    }

    private void wf() {
        if (this.arj == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.arj);
            }
            this.arj = null;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public final void Bw() {
        if (this.arh) {
            wa();
        }
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.arh = false;
        if (this.arg || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.arh = true;
        this.arg = true;
    }

    public final void bs(boolean z) {
        this.ari = z;
    }

    public final float getVisiblePercent() {
        return this.arf;
    }

    public final void onAttachedToWindow() {
        we();
    }

    public final void onDetachedFromWindow() {
        wf();
        this.arg = false;
    }

    public final void setVisiblePercent(float f) {
        this.arf = f;
    }
}
