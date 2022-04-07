package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
/* loaded from: classes5.dex */
public class h {
    public final View a;
    public final j b;
    public final ba c;
    public final int d;
    public boolean f;
    public boolean g;
    public ViewTreeObserver.OnScrollChangedListener i;
    public float e = 0.1f;
    public boolean h = true;

    public h(View view2, j jVar) {
        this.a = view2;
        this.b = jVar;
        this.c = new ba(view2);
        this.d = av.o(view2.getContext());
    }

    private void d() {
        if (this.h) {
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
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.c.a() || Math.abs(this.c.a.height() - this.a.getHeight()) > this.a.getHeight() * (1.0f - this.e) || this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return false;
        }
        Rect rect = this.c.a;
        return rect.bottom > 0 && rect.top < this.d;
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
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    public float a() {
        return this.e;
    }

    public void a(float f) {
        this.e = f;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.g = false;
        if (this.f || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.g = true;
        this.f = true;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b() {
        h();
    }

    public void b(int i, int i2, int i3, int i4) {
        if (this.g) {
            d();
        }
    }

    public void c() {
        i();
        this.f = false;
    }
}
