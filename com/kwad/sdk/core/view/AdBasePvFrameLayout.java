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
/* loaded from: classes4.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public float f56522b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56523c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56524d;

    /* renamed from: e  reason: collision with root package name */
    public int f56525e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f56526f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver f56527g;

    /* renamed from: h  reason: collision with root package name */
    public ba f56528h;

    /* renamed from: i  reason: collision with root package name */
    public k f56529i;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.a = 500L;
        this.f56522b = 0.1f;
        this.f56524d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 500L;
        this.f56522b = 0.1f;
        this.f56524d = true;
        a();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 500L;
        this.f56522b = 0.1f;
        this.f56524d = true;
        a();
    }

    private void a() {
        this.f56528h = new ba(this);
        this.f56525e = av.o(getContext());
        this.f56524d = l();
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
        if (!this.f56528h.a() || Math.abs(this.f56528h.a.height() - getHeight()) > getHeight() * (1.0f - this.f56522b) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f56528h.a;
        return rect.bottom > 0 && rect.top < this.f56525e;
    }

    private void d() {
        if (this.f56526f == null) {
            this.f56526f = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.c()) {
                        AdBasePvFrameLayout.this.n();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f56527g = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f56526f);
            }
        }
    }

    public boolean l() {
        return true;
    }

    public void m() {
        if (this.f56524d) {
            b();
        }
    }

    public void n() {
        o();
        k kVar = this.f56529i;
        if (kVar != null) {
            kVar.a();
        }
    }

    public void o() {
        try {
            if (this.f56526f != null && this.f56527g != null && this.f56527g.isAlive()) {
                this.f56527g.removeOnScrollChangedListener(this.f56526f);
            }
            this.f56526f = null;
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
        this.f56523c = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (this.f56523c || (i4 | i5) != 0 || (i2 | i3) == 0) {
            z = false;
        } else {
            this.f56523c = true;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (z) {
            m();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f2) {
        this.f56522b = f2;
    }

    public void setVisibleListener(k kVar) {
        this.f56529i = kVar;
    }
}
