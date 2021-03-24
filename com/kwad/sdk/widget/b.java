package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.feed.widget.base.b {

    /* renamed from: a  reason: collision with root package name */
    public long f36833a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36834b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36835c;

    /* renamed from: d  reason: collision with root package name */
    public int f36836d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f36837e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f36838f;

    /* renamed from: g  reason: collision with root package name */
    public an f36839g;

    public b(@NonNull Context context) {
        super(context);
        this.f36833a = 500L;
        this.f36835c = true;
        b();
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36833a = 500L;
        this.f36835c = true;
        b();
    }

    private void b() {
        this.f36839g = new an(this);
        this.f36836d = ah.h(getContext());
        this.f36835c = d();
    }

    private void c() {
        if (g()) {
            a();
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.f36839g.a() || Math.abs(this.f36839g.f36750a.height() - getHeight()) > getHeight() * 0.9f || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f36839g.f36750a;
        return rect.bottom > 0 && rect.top < this.f36836d;
    }

    private void h() {
        if (this.f36837e == null) {
            this.f36837e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.b.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (b.this.g()) {
                        b.this.a();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f36838f = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f36837e);
            }
        }
    }

    public void a() {
        f();
    }

    public boolean d() {
        return true;
    }

    public void e() {
        if (this.f36835c) {
            c();
        }
    }

    public void f() {
        try {
            if (this.f36837e == null || this.f36838f == null) {
                return;
            }
            this.f36838f.removeOnScrollChangedListener(this.f36837e);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
        this.f36834b = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f36834b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f36834b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            e();
        }
    }
}
