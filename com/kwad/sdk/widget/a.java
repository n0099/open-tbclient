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
/* loaded from: classes7.dex */
public class a extends RatioFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public long f37681a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37682b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37683c;

    /* renamed from: d  reason: collision with root package name */
    public int f37684d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f37685e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f37686f;

    /* renamed from: g  reason: collision with root package name */
    public an f37687g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC0442a f37688h;

    /* renamed from: com.kwad.sdk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0442a {
        void a();
    }

    public a(@NonNull Context context) {
        super(context);
        this.f37681a = 500L;
        this.f37683c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37681a = 500L;
        this.f37683c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f37681a = 500L;
        this.f37683c = true;
        b();
    }

    private void b() {
        this.f37687g = new an(this);
        this.f37684d = ah.h(getContext());
        this.f37683c = i();
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
        if (!this.f37687g.a() || Math.abs(this.f37687g.f37606a.height() - getHeight()) > getHeight() * 0.9f || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f37687g.f37606a;
        return rect.bottom > 0 && rect.top < this.f37684d;
    }

    private void e() {
        if (this.f37685e == null) {
            this.f37685e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.a.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (a.this.d()) {
                        a.this.a();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f37686f = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f37685e);
            }
        }
    }

    public void a() {
        k();
        InterfaceC0442a interfaceC0442a = this.f37688h;
        if (interfaceC0442a != null) {
            interfaceC0442a.a();
        }
    }

    public boolean i() {
        return true;
    }

    public void j() {
        if (this.f37683c) {
            c();
        }
    }

    public void k() {
        try {
            if (this.f37685e != null && this.f37686f != null && this.f37686f.isAlive()) {
                this.f37686f.removeOnScrollChangedListener(this.f37685e);
            }
            this.f37685e = null;
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
        this.f37682b = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (this.f37682b || (i4 | i5) != 0 || (i2 | i3) == 0) {
            z = false;
        } else {
            this.f37682b = true;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (z) {
            j();
        }
    }

    public void setVisibleListener(InterfaceC0442a interfaceC0442a) {
        this.f37688h = interfaceC0442a;
    }
}
