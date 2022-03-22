package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
/* loaded from: classes7.dex */
public class h {
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final j f41521b;

    /* renamed from: c  reason: collision with root package name */
    public final ba f41522c;

    /* renamed from: d  reason: collision with root package name */
    public final int f41523d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41525f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41526g;
    public ViewTreeObserver.OnScrollChangedListener i;

    /* renamed from: e  reason: collision with root package name */
    public float f41524e = 0.1f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41527h = true;

    public h(View view, j jVar) {
        this.a = view;
        this.f41521b = jVar;
        this.f41522c = new ba(view);
        this.f41523d = av.o(view.getContext());
    }

    private void d() {
        if (this.f41527h) {
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
        j jVar = this.f41521b;
        if (jVar != null) {
            jVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.f41522c.a() || Math.abs(this.f41522c.a.height() - this.a.getHeight()) > this.a.getHeight() * (1.0f - this.f41524e) || this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f41522c.a;
        return rect.bottom > 0 && rect.top < this.f41523d;
    }

    private void h() {
        if (this.i == null) {
            this.i = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.h.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (h.this.g()) {
                        h.this.f();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.i);
            }
        }
    }

    private void i() {
        if (this.i == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.i);
            }
            this.i = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public float a() {
        return this.f41524e;
    }

    public void a(float f2) {
        this.f41524e = f2;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f41526g = false;
        if (this.f41525f || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.f41526g = true;
        this.f41525f = true;
    }

    public void a(boolean z) {
        this.f41527h = z;
    }

    public void b() {
        h();
    }

    public void b(int i, int i2, int i3, int i4) {
        if (this.f41526g) {
            d();
        }
    }

    public void c() {
        i();
        this.f41525f = false;
    }
}
