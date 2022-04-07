package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.widget.k;
/* loaded from: classes5.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public long a;
    public float b;
    public boolean c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnScrollChangedListener f;
    public ViewTreeObserver g;
    public ba h;
    public k i;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.a = 500L;
        this.b = 0.1f;
        this.d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 500L;
        this.b = 0.1f;
        this.d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 500L;
        this.b = 0.1f;
        this.d = true;
        a();
    }

    private void a() {
        this.h = new ba(this);
        this.e = av.o(getContext());
        this.d = l();
    }

    private void b() {
        if (c()) {
            n();
        } else {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (!this.h.a() || Math.abs(this.h.a.height() - getHeight()) > getHeight() * (1.0f - this.b) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.h.a;
        return rect.bottom > 0 && rect.top < this.e;
    }

    private void d() {
        if (this.f == null) {
            this.f = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.c()) {
                        AdBasePvFrameLayout.this.n();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.g = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f);
            }
        }
    }

    public boolean l() {
        return true;
    }

    public void m() {
        if (this.d) {
            b();
        }
    }

    public void n() {
        o();
        k kVar = this.i;
        if (kVar != null) {
            kVar.a();
        }
    }

    public void o() {
        try {
            if (this.f != null && this.g != null && this.g.isAlive()) {
                this.g.removeOnScrollChangedListener(this.f);
            }
            this.f = null;
        } catch (Exception e) {
            a.a(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
        this.c = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.c || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.c = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            m();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.b = f;
    }

    public void setVisibleListener(k kVar) {
        this.i = kVar;
    }
}
