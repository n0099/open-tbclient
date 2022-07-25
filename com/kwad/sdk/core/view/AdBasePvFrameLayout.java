package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.widget.j;
/* loaded from: classes5.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public int GD;
    public long afe;
    public float aff;
    public boolean afg;
    public boolean afh;
    public ViewTreeObserver.OnScrollChangedListener afi;
    public ViewTreeObserver afj;
    public bf afk;
    public j bx;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.afe = 500L;
        this.aff = 0.1f;
        this.afh = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afe = 500L;
        this.aff = 0.1f;
        this.afh = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afe = 500L;
        this.aff = 0.1f;
        this.afh = true;
        init();
    }

    private void init() {
        this.afk = new bf(this);
        this.GD = com.kwad.sdk.utils.j.getScreenHeight(getContext());
        this.afh = true;
    }

    private void wa() {
        if (this.afh) {
            wb();
        }
    }

    private void wb() {
        if (wd()) {
            wc();
        } else {
            we();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wd() {
        if (!this.afk.AV() || Math.abs(this.afk.apg.height() - getHeight()) > getHeight() * (1.0f - this.aff) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.afk.apg;
        return rect.bottom > 0 && rect.top < this.GD;
    }

    private void we() {
        if (this.afi == null) {
            this.afi = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.wd()) {
                        AdBasePvFrameLayout.this.wc();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.afj = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.afi);
            }
        }
    }

    private void wf() {
        try {
            if (this.afi != null && this.afj != null && this.afj.isAlive()) {
                this.afj.removeOnScrollChangedListener(this.afi);
            }
            this.afi = null;
        } catch (Exception e) {
            b.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        we();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        wf();
        this.afg = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.afg || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.afg = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            wa();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.aff = f;
    }

    public void setVisibleListener(j jVar) {
        this.bx = jVar;
    }

    public final void wc() {
        wf();
        j jVar = this.bx;
        if (jVar != null) {
            jVar.av();
        }
    }
}
