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
    public long f37209a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37210b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37211c;

    /* renamed from: d  reason: collision with root package name */
    public int f37212d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f37213e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f37214f;

    /* renamed from: g  reason: collision with root package name */
    public an f37215g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0456a f37216h;

    /* renamed from: com.kwad.sdk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0456a {
        void a();
    }

    public a(@NonNull Context context) {
        super(context);
        this.f37209a = 500L;
        this.f37211c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37209a = 500L;
        this.f37211c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f37209a = 500L;
        this.f37211c = true;
        b();
    }

    private void b() {
        this.f37215g = new an(this);
        this.f37212d = ah.h(getContext());
        this.f37211c = i();
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
        if (!this.f37215g.a() || Math.abs(this.f37215g.f37135a.height() - getHeight()) > getHeight() * 0.9f || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f37215g.f37135a;
        return rect.bottom > 0 && rect.top < this.f37212d;
    }

    private void e() {
        if (this.f37213e == null) {
            this.f37213e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.a.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (a.this.d()) {
                        a.this.a();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f37214f = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f37213e);
            }
        }
    }

    public void a() {
        k();
        InterfaceC0456a interfaceC0456a = this.f37216h;
        if (interfaceC0456a != null) {
            interfaceC0456a.a();
        }
    }

    public boolean i() {
        return true;
    }

    public void j() {
        if (this.f37211c) {
            c();
        }
    }

    public void k() {
        try {
            if (this.f37213e != null && this.f37214f != null && this.f37214f.isAlive()) {
                this.f37214f.removeOnScrollChangedListener(this.f37213e);
            }
            this.f37213e = null;
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
        this.f37210b = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f37210b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f37210b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            j();
        }
    }

    public void setVisibleListener(InterfaceC0456a interfaceC0456a) {
        this.f37216h = interfaceC0456a;
    }
}
