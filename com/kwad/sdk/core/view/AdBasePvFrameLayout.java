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
/* loaded from: classes3.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public float f58518b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58519c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58520d;

    /* renamed from: e  reason: collision with root package name */
    public int f58521e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f58522f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver f58523g;

    /* renamed from: h  reason: collision with root package name */
    public ba f58524h;

    /* renamed from: i  reason: collision with root package name */
    public k f58525i;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.a = 500L;
        this.f58518b = 0.1f;
        this.f58520d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 500L;
        this.f58518b = 0.1f;
        this.f58520d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 500L;
        this.f58518b = 0.1f;
        this.f58520d = true;
        a();
    }

    private void a() {
        this.f58524h = new ba(this);
        this.f58521e = av.o(getContext());
        this.f58520d = l();
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
        if (!this.f58524h.a() || Math.abs(this.f58524h.a.height() - getHeight()) > getHeight() * (1.0f - this.f58518b) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f58524h.a;
        return rect.bottom > 0 && rect.top < this.f58521e;
    }

    private void d() {
        if (this.f58522f == null) {
            this.f58522f = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.c()) {
                        AdBasePvFrameLayout.this.n();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f58523g = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f58522f);
            }
        }
    }

    public boolean l() {
        return true;
    }

    public void m() {
        if (this.f58520d) {
            b();
        }
    }

    public void n() {
        o();
        k kVar = this.f58525i;
        if (kVar != null) {
            kVar.a();
        }
    }

    public void o() {
        try {
            if (this.f58522f != null && this.f58523g != null && this.f58523g.isAlive()) {
                this.f58523g.removeOnScrollChangedListener(this.f58522f);
            }
            this.f58522f = null;
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
        this.f58519c = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (this.f58519c || (i4 | i5) != 0 || (i2 | i3) == 0) {
            z = false;
        } else {
            this.f58519c = true;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (z) {
            m();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f2) {
        this.f58518b = f2;
    }

    public void setVisibleListener(k kVar) {
        this.f58525i = kVar;
    }
}
