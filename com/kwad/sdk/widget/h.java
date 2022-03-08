package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
/* loaded from: classes8.dex */
public class h {
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final j f56644b;

    /* renamed from: c  reason: collision with root package name */
    public final ba f56645c;

    /* renamed from: d  reason: collision with root package name */
    public final int f56646d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56648f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56649g;

    /* renamed from: i  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f56651i;

    /* renamed from: e  reason: collision with root package name */
    public float f56647e = 0.1f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56650h = true;

    public h(View view, j jVar) {
        this.a = view;
        this.f56644b = jVar;
        this.f56645c = new ba(view);
        this.f56646d = av.o(view.getContext());
    }

    private void d() {
        if (this.f56650h) {
            e();
        }
    }

    private void e() {
        if (g()) {
            f();
            return;
        }
        i();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        i();
        j jVar = this.f56644b;
        if (jVar != null) {
            jVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.f56645c.a() || Math.abs(this.f56645c.a.height() - this.a.getHeight()) > this.a.getHeight() * (1.0f - this.f56647e) || this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f56645c.a;
        return rect.bottom > 0 && rect.top < this.f56646d;
    }

    private void h() {
        if (this.f56651i == null) {
            this.f56651i = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.h.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (h.this.g()) {
                        h.this.f();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f56651i);
            }
        }
    }

    private void i() {
        if (this.f56651i == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.f56651i);
            }
            this.f56651i = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public float a() {
        return this.f56647e;
    }

    public void a(float f2) {
        this.f56647e = f2;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f56649g = false;
        if (this.f56648f || (i4 | i5) != 0 || (i2 | i3) == 0) {
            return;
        }
        this.f56649g = true;
        this.f56648f = true;
    }

    public void a(boolean z) {
        this.f56650h = z;
    }

    public void b() {
        h();
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (this.f56649g) {
            d();
        }
    }

    public void c() {
        i();
        this.f56648f = false;
    }
}
