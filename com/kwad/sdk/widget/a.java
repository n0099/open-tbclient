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
/* loaded from: classes6.dex */
public class a extends RatioFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public long f36825a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36826b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36827c;

    /* renamed from: d  reason: collision with root package name */
    public int f36828d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f36829e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f36830f;

    /* renamed from: g  reason: collision with root package name */
    public an f36831g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0439a f36832h;

    /* renamed from: com.kwad.sdk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0439a {
        void a();
    }

    public a(@NonNull Context context) {
        super(context);
        this.f36825a = 500L;
        this.f36827c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36825a = 500L;
        this.f36827c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36825a = 500L;
        this.f36827c = true;
        b();
    }

    private void b() {
        this.f36831g = new an(this);
        this.f36828d = ah.h(getContext());
        this.f36827c = i();
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
        if (!this.f36831g.a() || Math.abs(this.f36831g.f36751a.height() - getHeight()) > getHeight() * 0.9f || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f36831g.f36751a;
        return rect.bottom > 0 && rect.top < this.f36828d;
    }

    private void e() {
        if (this.f36829e == null) {
            this.f36829e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.a.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (a.this.d()) {
                        a.this.a();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f36830f = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f36829e);
            }
        }
    }

    public void a() {
        k();
        InterfaceC0439a interfaceC0439a = this.f36832h;
        if (interfaceC0439a != null) {
            interfaceC0439a.a();
        }
    }

    public boolean i() {
        return true;
    }

    public void j() {
        if (this.f36827c) {
            c();
        }
    }

    public void k() {
        try {
            if (this.f36829e != null && this.f36830f != null && this.f36830f.isAlive()) {
                this.f36830f.removeOnScrollChangedListener(this.f36829e);
            }
            this.f36829e = null;
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
        this.f36826b = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f36826b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f36826b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            j();
        }
    }

    public void setVisibleListener(InterfaceC0439a interfaceC0439a) {
        this.f36832h = interfaceC0439a;
    }
}
