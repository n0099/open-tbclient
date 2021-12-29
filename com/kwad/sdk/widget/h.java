package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
/* loaded from: classes3.dex */
public class h {
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final j f60372b;

    /* renamed from: c  reason: collision with root package name */
    public final ba f60373c;

    /* renamed from: d  reason: collision with root package name */
    public final int f60374d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60376f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60377g;

    /* renamed from: i  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f60379i;

    /* renamed from: e  reason: collision with root package name */
    public float f60375e = 0.1f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60378h = true;

    public h(View view, j jVar) {
        this.a = view;
        this.f60372b = jVar;
        this.f60373c = new ba(view);
        this.f60374d = av.o(view.getContext());
    }

    private void d() {
        if (this.f60378h) {
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
        j jVar = this.f60372b;
        if (jVar != null) {
            jVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.f60373c.a() || Math.abs(this.f60373c.a.height() - this.a.getHeight()) > this.a.getHeight() * (1.0f - this.f60375e) || this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f60373c.a;
        return rect.bottom > 0 && rect.top < this.f60374d;
    }

    private void h() {
        if (this.f60379i == null) {
            this.f60379i = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.h.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (h.this.g()) {
                        h.this.f();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f60379i);
            }
        }
    }

    private void i() {
        if (this.f60379i == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.f60379i);
            }
            this.f60379i = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public float a() {
        return this.f60375e;
    }

    public void a(float f2) {
        this.f60375e = f2;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f60377g = false;
        if (this.f60376f || (i4 | i5) != 0 || (i2 | i3) == 0) {
            return;
        }
        this.f60377g = true;
        this.f60376f = true;
    }

    public void a(boolean z) {
        this.f60378h = z;
    }

    public void b() {
        h();
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (this.f60377g) {
            d();
        }
    }

    public void c() {
        i();
        this.f60376f = false;
    }
}
