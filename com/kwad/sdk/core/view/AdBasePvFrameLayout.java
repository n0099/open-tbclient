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
/* loaded from: classes7.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public float f39967b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39968c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39969d;

    /* renamed from: e  reason: collision with root package name */
    public int f39970e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f39971f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver f39972g;

    /* renamed from: h  reason: collision with root package name */
    public ba f39973h;
    public k i;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.a = 500L;
        this.f39967b = 0.1f;
        this.f39969d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 500L;
        this.f39967b = 0.1f;
        this.f39969d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 500L;
        this.f39967b = 0.1f;
        this.f39969d = true;
        a();
    }

    private void a() {
        this.f39973h = new ba(this);
        this.f39970e = av.o(getContext());
        this.f39969d = l();
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
        if (!this.f39973h.a() || Math.abs(this.f39973h.a.height() - getHeight()) > getHeight() * (1.0f - this.f39967b) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f39973h.a;
        return rect.bottom > 0 && rect.top < this.f39970e;
    }

    private void d() {
        if (this.f39971f == null) {
            this.f39971f = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.c()) {
                        AdBasePvFrameLayout.this.n();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f39972g = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f39971f);
            }
        }
    }

    public boolean l() {
        return true;
    }

    public void m() {
        if (this.f39969d) {
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
            if (this.f39971f != null && this.f39972g != null && this.f39972g.isAlive()) {
                this.f39972g.removeOnScrollChangedListener(this.f39971f);
            }
            this.f39971f = null;
        } catch (Exception e2) {
            a.a(e2);
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
        this.f39968c = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f39968c || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f39968c = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            m();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f2) {
        this.f39967b = f2;
    }

    public void setVisibleListener(k kVar) {
        this.i = kVar;
    }
}
