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
    public long f37114a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37115b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37116c;

    /* renamed from: d  reason: collision with root package name */
    public int f37117d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f37118e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f37119f;

    /* renamed from: g  reason: collision with root package name */
    public an f37120g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0453a f37121h;

    /* renamed from: com.kwad.sdk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0453a {
        void a();
    }

    public a(@NonNull Context context) {
        super(context);
        this.f37114a = 500L;
        this.f37116c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37114a = 500L;
        this.f37116c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f37114a = 500L;
        this.f37116c = true;
        b();
    }

    private void b() {
        this.f37120g = new an(this);
        this.f37117d = ah.h(getContext());
        this.f37116c = i();
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
        if (!this.f37120g.a() || Math.abs(this.f37120g.f37040a.height() - getHeight()) > getHeight() * 0.9f || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f37120g.f37040a;
        return rect.bottom > 0 && rect.top < this.f37117d;
    }

    private void e() {
        if (this.f37118e == null) {
            this.f37118e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.a.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (a.this.d()) {
                        a.this.a();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f37119f = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f37118e);
            }
        }
    }

    public void a() {
        k();
        InterfaceC0453a interfaceC0453a = this.f37121h;
        if (interfaceC0453a != null) {
            interfaceC0453a.a();
        }
    }

    public boolean i() {
        return true;
    }

    public void j() {
        if (this.f37116c) {
            c();
        }
    }

    public void k() {
        try {
            if (this.f37118e != null && this.f37119f != null && this.f37119f.isAlive()) {
                this.f37119f.removeOnScrollChangedListener(this.f37118e);
            }
            this.f37118e = null;
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
        this.f37115b = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f37115b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f37115b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            j();
        }
    }

    public void setVisibleListener(InterfaceC0453a interfaceC0453a) {
        this.f37121h = interfaceC0453a;
    }
}
