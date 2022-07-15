package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.j;
/* loaded from: classes5.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public long a;
    public float b;
    public boolean c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnScrollChangedListener f;
    public ViewTreeObserver g;
    public bb h;
    public j i;

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
        this.h = new bb(this);
        this.e = com.kwad.sdk.utils.j.c(getContext());
        this.d = true;
    }

    private void b() {
        if (this.d) {
            c();
        }
    }

    private void c() {
        if (d()) {
            j();
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        if (!this.h.a() || Math.abs(this.h.a.height() - getHeight()) > getHeight() * (1.0f - this.b) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.h.a;
        return rect.bottom > 0 && rect.top < this.e;
    }

    private void e() {
        if (this.f == null) {
            this.f = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.d()) {
                        AdBasePvFrameLayout.this.j();
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

    private void f() {
        try {
            if (this.f != null && this.g != null && this.g.isAlive()) {
                this.g.removeOnScrollChangedListener(this.f);
            }
            this.f = null;
        } catch (Exception e) {
            b.a(e);
        }
    }

    public final void j() {
        f();
        j jVar = this.i;
        if (jVar != null) {
            jVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
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
            b();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.b = f;
    }

    public void setVisibleListener(j jVar) {
        this.i = jVar;
    }
}
