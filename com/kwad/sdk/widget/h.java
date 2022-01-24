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
    public final j f58127b;

    /* renamed from: c  reason: collision with root package name */
    public final ba f58128c;

    /* renamed from: d  reason: collision with root package name */
    public final int f58129d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58131f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58132g;

    /* renamed from: i  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f58134i;

    /* renamed from: e  reason: collision with root package name */
    public float f58130e = 0.1f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58133h = true;

    public h(View view, j jVar) {
        this.a = view;
        this.f58127b = jVar;
        this.f58128c = new ba(view);
        this.f58129d = av.o(view.getContext());
    }

    private void d() {
        if (this.f58133h) {
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
        j jVar = this.f58127b;
        if (jVar != null) {
            jVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.f58128c.a() || Math.abs(this.f58128c.a.height() - this.a.getHeight()) > this.a.getHeight() * (1.0f - this.f58130e) || this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f58128c.a;
        return rect.bottom > 0 && rect.top < this.f58129d;
    }

    private void h() {
        if (this.f58134i == null) {
            this.f58134i = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.h.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (h.this.g()) {
                        h.this.f();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f58134i);
            }
        }
    }

    private void i() {
        if (this.f58134i == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.f58134i);
            }
            this.f58134i = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public float a() {
        return this.f58130e;
    }

    public void a(float f2) {
        this.f58130e = f2;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f58132g = false;
        if (this.f58131f || (i4 | i5) != 0 || (i2 | i3) == 0) {
            return;
        }
        this.f58132g = true;
        this.f58131f = true;
    }

    public void a(boolean z) {
        this.f58133h = z;
    }

    public void b() {
        h();
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (this.f58132g) {
            d();
        }
    }

    public void c() {
        i();
        this.f58131f = false;
    }
}
