package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public final class g {
    public final View a;
    public final i b;
    public final bb c;
    public final int d;
    public boolean f;
    public boolean g;
    public ViewTreeObserver.OnScrollChangedListener i;
    public float e = 0.1f;
    public boolean h = true;

    public g(View view2, i iVar) {
        this.a = view2;
        this.b = iVar;
        this.c = new bb(view2);
        this.d = com.kwad.sdk.utils.j.c(view2.getContext());
    }

    private void e() {
        if (this.h) {
            f();
        }
    }

    private void f() {
        if (h()) {
            g();
            return;
        }
        j();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        j();
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (this.c.a() && Math.abs(this.c.a.height() - this.a.getHeight()) <= this.a.getHeight() * (1.0f - this.e) && this.a.getHeight() > 0 && this.a.getWidth() > 0) {
            Rect rect = this.c.a;
            if (rect.bottom > 0 && rect.top < this.d) {
                return true;
            }
        }
        return false;
    }

    private void i() {
        if (this.i == null) {
            this.i = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.h()) {
                        g.this.g();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.i);
            }
        }
    }

    private void j() {
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
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    public final float a() {
        return this.e;
    }

    public final void a(float f) {
        this.e = f;
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.g = false;
        if (this.f || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.g = true;
        this.f = true;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final void b() {
        if (this.g) {
            e();
        }
    }

    public final void c() {
        i();
    }

    public final void d() {
        j();
        this.f = false;
    }
}
