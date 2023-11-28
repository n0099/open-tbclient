package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;
/* loaded from: classes10.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public long aBF;
    public float aBG;
    public boolean aBH;
    public boolean aBI;
    public ViewTreeObserver.OnScrollChangedListener aBJ;
    public ViewTreeObserver aBK;
    public bp aBL;
    public j cD;
    public int me;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.aBF = 500L;
        this.aBG = 0.1f;
        this.aBI = true;
        init();
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.aBG = f;
    }

    public void setVisibleListener(j jVar) {
        this.cD = jVar;
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBF = 500L;
        this.aBG = 0.1f;
        this.aBI = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBF = 500L;
        this.aBG = 0.1f;
        this.aBI = true;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FA() {
        if (this.aBL.LP() && Math.abs(this.aBL.aPt.height() - getHeight()) <= getHeight() * (1.0f - this.aBG) && getHeight() > 0 && getWidth() > 0) {
            Rect rect = this.aBL.aPt;
            if (rect.bottom > 0 && rect.top < this.me) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void FB() {
        if (this.aBJ == null) {
            this.aBJ = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.FA()) {
                        AdBasePvFrameLayout.this.Fz();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aBK = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aBJ);
            }
        }
    }

    private void FC() {
        try {
            if (this.aBJ != null && this.aBK != null && this.aBK.isAlive()) {
                this.aBK.removeOnScrollChangedListener(this.aBJ);
            }
            this.aBJ = null;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private void Fy() {
        if (FA()) {
            Fz();
        } else {
            FB();
        }
    }

    private void init() {
        this.aBL = new bp(this);
        this.me = k.getScreenHeight(getContext());
        this.aBI = true;
    }

    private void ot() {
        if (this.aBI) {
            Fy();
        }
    }

    public final void Fz() {
        FC();
        j jVar = this.cD;
        if (jVar != null) {
            jVar.ao();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FB();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FC();
        this.aBH = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (!this.aBH && (i3 | i4) == 0 && (i | i2) != 0) {
            this.aBH = true;
        } else {
            z = false;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            ot();
        }
    }
}
