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
    public final j f58082b;

    /* renamed from: c  reason: collision with root package name */
    public final ba f58083c;

    /* renamed from: d  reason: collision with root package name */
    public final int f58084d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58086f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58087g;

    /* renamed from: i  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f58089i;

    /* renamed from: e  reason: collision with root package name */
    public float f58085e = 0.1f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58088h = true;

    public h(View view, j jVar) {
        this.a = view;
        this.f58082b = jVar;
        this.f58083c = new ba(view);
        this.f58084d = av.o(view.getContext());
    }

    private void d() {
        if (this.f58088h) {
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
        j jVar = this.f58082b;
        if (jVar != null) {
            jVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.f58083c.a() || Math.abs(this.f58083c.a.height() - this.a.getHeight()) > this.a.getHeight() * (1.0f - this.f58085e) || this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f58083c.a;
        return rect.bottom > 0 && rect.top < this.f58084d;
    }

    private void h() {
        if (this.f58089i == null) {
            this.f58089i = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.h.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (h.this.g()) {
                        h.this.f();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f58089i);
            }
        }
    }

    private void i() {
        if (this.f58089i == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.f58089i);
            }
            this.f58089i = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public float a() {
        return this.f58085e;
    }

    public void a(float f2) {
        this.f58085e = f2;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f58087g = false;
        if (this.f58086f || (i4 | i5) != 0 || (i2 | i3) == 0) {
            return;
        }
        this.f58087g = true;
        this.f58086f = true;
    }

    public void a(boolean z) {
        this.f58088h = z;
    }

    public void b() {
        h();
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (this.f58087g) {
            d();
        }
    }

    public void c() {
        i();
        this.f58086f = false;
    }
}
