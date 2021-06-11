package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.an;
/* loaded from: classes7.dex */
public class a extends RatioFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public long f37583a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37584b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37585c;

    /* renamed from: d  reason: collision with root package name */
    public int f37586d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f37587e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f37588f;

    /* renamed from: g  reason: collision with root package name */
    public an f37589g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0439a f37590h;

    /* renamed from: com.kwad.sdk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0439a {
        void a();
    }

    public a(@NonNull Context context) {
        super(context);
        this.f37583a = 500L;
        this.f37585c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37583a = 500L;
        this.f37585c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f37583a = 500L;
        this.f37585c = true;
        b();
    }

    private void b() {
        this.f37589g = new an(this);
        this.f37586d = ah.h(getContext());
        this.f37585c = i();
    }

    private void c() {
        if (d()) {
            a();
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        if (!this.f37589g.a() || Math.abs(this.f37589g.f37508a.height() - getHeight()) > getHeight() * 0.9f || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f37589g.f37508a;
        return rect.bottom > 0 && rect.top < this.f37586d;
    }

    private void e() {
        if (this.f37587e == null) {
            this.f37587e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.a.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (a.this.d()) {
                        a.this.a();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f37588f = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f37587e);
            }
        }
    }

    public void a() {
        k();
        InterfaceC0439a interfaceC0439a = this.f37590h;
        if (interfaceC0439a != null) {
            interfaceC0439a.a();
        }
    }

    public boolean i() {
        return true;
    }

    public void j() {
        if (this.f37585c) {
            c();
        }
    }

    public void k() {
        try {
            if (this.f37587e != null && this.f37588f != null && this.f37588f.isAlive()) {
                this.f37588f.removeOnScrollChangedListener(this.f37587e);
            }
            this.f37587e = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public void l() {
        k();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
        this.f37584b = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (this.f37584b || (i4 | i5) != 0 || (i2 | i3) == 0) {
            z = false;
        } else {
            this.f37584b = true;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (z) {
            j();
        }
    }

    public void setVisibleListener(InterfaceC0439a interfaceC0439a) {
        this.f37590h = interfaceC0439a;
    }
}
